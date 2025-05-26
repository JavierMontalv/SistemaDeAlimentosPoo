import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnGestionar = new JButton("Gestionar alimentos");
        btnGestionar.addActionListener(e -> new VentanaGestion());

        add(btnGestionar, BorderLayout.CENTER);
        setVisible(true);
    }
}
