import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame framePrincipal = new JFrame();
        ComponenteFecha componenteFechaNueva = new ComponenteFechaClase();
        ComponenteFecha componenteFechaVieja = new ComponenteFechaClase();
        framePrincipal.add((Component) componenteFechaNueva);
        framePrincipal.add((Component) componenteFechaVieja);
        framePrincipal.setSize(600,600);
        framePrincipal.setVisible(true);
    }
}
