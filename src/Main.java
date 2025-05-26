import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Opcional: usar el look & feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, seguimos con el look & feel por defecto
        }

        // Arrancar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new LoginFrame();
        });
    }
}
