import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class VentanaGestion extends JFrame {
    private ArrayList<Alimento> alimentos = new ArrayList<>();
    private DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private JList<String> listaAlimentos = new JList<>(modeloLista);

    // Alimentos válidos por categoría
    private static final Map<String, java.util.List<String>> alimentosPorCategoria = new HashMap<>();

    static {
        alimentosPorCategoria.put("Frutas y verduras", java.util.List.of("Manzana", "Aguacate", "Uva", "Tomate"));
        alimentosPorCategoria.put("Grasas", java.util.List.of("Aceite", "Queso", "Chocolate", "Pescado"));
        alimentosPorCategoria.put("Hidratos de carbono", java.util.List.of("Papa", "Pasta", "Pan"));
    }

    public VentanaGestion() {
        setTitle("Gestión de Alimentos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // cierra solo esta ventana

        JTextField campoNombre = new JTextField();
        JComboBox<String> comboCategorias = new JComboBox<>(new String[]{
                "Frutas y verduras", "Grasas", "Hidratos de carbono"
        });
        JButton btnAgregar = new JButton("Agregar alimento");

        // Acción de Agregar
        btnAgregar.addActionListener(e -> {
            String nombre = campoNombre.getText().trim();
            String categoria = (String) comboCategorias.getSelectedItem();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede quedar vacío.");
                return;
            }

            // Validar si el alimento pertenece a la categoría
            try {
                java.util.List<String> alimentosValidos = alimentosPorCategoria.get(categoria);
                boolean pertenece = alimentosValidos.stream()
                        .anyMatch(valido -> valido.equalsIgnoreCase(nombre));

                if (!pertenece) {
                    throw new CategoriaIncorrectaException("El alimento '" + nombre + "' no pertenece a la categoría seleccionada.");
                }
            } catch (CategoriaIncorrectaException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error de categoría",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear instancia según categoría
            Alimento nuevo;
            switch (categoria) {
                case "Frutas y verduras":
                    nuevo = new FrutaVerdura(nombre);
                    break;
                case "Grasas":
                    nuevo = new Grasa(nombre);
                    break;
                default: // Hidratos de carbono
                    nuevo = new HidratoCarbono(nombre);
            }

            alimentos.add(nuevo);
            modeloLista.addElement(nuevo.getNombre() + " - " + nuevo.getCategoria());
            campoNombre.setText("");
        });

        // Layout superior
        JPanel panelTop = new JPanel(new GridLayout(2, 2, 5, 5));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelTop.add(new JLabel("Nombre:"));
        panelTop.add(campoNombre);
        panelTop.add(new JLabel("Categoría:"));
        panelTop.add(comboCategorias);

        add(panelTop, BorderLayout.NORTH);
        add(new JScrollPane(listaAlimentos), BorderLayout.CENTER);

        // Panel de botones (Agregar, Editar, Eliminar, Mostrar Info)
        JPanel panelBotones = new JPanel();
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnMostrarInfo = new JButton("Mostrar Info");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrarInfo);

        add(panelBotones, BorderLayout.SOUTH);

        // Acción de Editar
        btnEditar.addActionListener(e -> {
            int index = listaAlimentos.getSelectedIndex();
            if (index >= 0) {
                Alimento seleccionado = alimentos.get(index);
                if (seleccionado instanceof Editable) {
                    String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:");
                    if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                        ((Editable) seleccionado).editar(nuevoNombre);
                        modeloLista.set(index, seleccionado.getNombre() + " - " + seleccionado.getCategoria());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Este tipo de alimento no se puede editar.");
                }
            }
        });

        // Acción de Eliminar
        btnEliminar.addActionListener(e -> {
            int index = listaAlimentos.getSelectedIndex();
            if (index >= 0) {
                Alimento seleccionado = alimentos.get(index);
                if (seleccionado instanceof Editable) {
                    ((Editable) seleccionado).eliminar();
                    alimentos.remove(index);
                    modeloLista.remove(index);
                } else {
                    JOptionPane.showMessageDialog(this, "Este tipo de alimento no se puede eliminar.");
                }
            }
        });

        // Acción de Mostrar Información
        btnMostrarInfo.addActionListener(e -> {
            int index = listaAlimentos.getSelectedIndex();
            if (index >= 0) {
                Alimento seleccionado = alimentos.get(index);
                seleccionado.mostrarInfo();
            }
        });

        setVisible(true);
    }
}
