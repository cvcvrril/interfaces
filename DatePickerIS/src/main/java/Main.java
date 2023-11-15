import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Main app = new Main();
            });
        }
        public Main() {
            setTitle("Swing Application");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 700);
            setLocationRelativeTo(null);
            ComponenteFecha componenteFecha = new ComponenteFechaClase();
            add((Component) componenteFecha);
            setVisible(true);
        }
}
