import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);           // Centra la ventana
        setLayout(new BorderLayout(10, 10));   // Margen entre zonas

        // PANEL CENTRAL: campos de usuario y contraseña
        JPanel panelCenter = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelCenter.add(new JLabel("Usuario:"));
        userField = new JTextField();
        panelCenter.add(userField);
        panelCenter.add(new JLabel("Contraseña:"));
        passField = new JPasswordField();
        panelCenter.add(passField);
        add(panelCenter, BorderLayout.CENTER);

        // PANEL INFERIOR: botón de login
        JPanel panelSouth = new JPanel();
        JButton loginButton = new JButton("Ingresar");
        panelSouth.add(loginButton);
        add(panelSouth, BorderLayout.SOUTH);

        // Acción del botón
        loginButton.addActionListener(e -> {
            String user = userField.getText().trim();
            String pass = new String(passField.getPassword()).trim();

            // Validación simple (admin / 1234)
            if (user.equals("admin") && pass.equals("1234")) {
                dispose();               // cierra login
                new MenuPrincipal();     // abre menú principal
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Usuario o contraseña incorrectos",
                        "Error de autenticación",
                        JOptionPane.ERROR_MESSAGE
                );
                passField.setText("");
            }
        });

        setVisible(true);
    }
}
