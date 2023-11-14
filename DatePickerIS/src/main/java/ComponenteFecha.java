import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDate;

public class ComponenteFecha implements ComponenteFechaInt {
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JTextField yearTextField;
    private Border border;

    public ComponenteFecha(JPanel jPanel) {
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        jPanel.setBorder(border);
    }

    private void setMonthCombo() {
        monthComboBox.addItem("Enero");
        monthComboBox.addItem("Febrero");
        monthComboBox.addItem("Marzo");
        monthComboBox.addItem("Abril");
        monthComboBox.addItem("Mayo");
        monthComboBox.addItem("Junio");
        monthComboBox.addItem("Julio");
        monthComboBox.addItem("Agosto");
        monthComboBox.addItem("Septiembre");
        monthComboBox.addItem("Octubre");
        monthComboBox.addItem("Noviembre");
        monthComboBox.addItem("Diciembre");
    }

    private void setDayCombo(String month, int anyo) {
        if (month.equalsIgnoreCase("enero") || month.equalsIgnoreCase("marzo") || month.equalsIgnoreCase("mayo") ||
                month.equalsIgnoreCase("julio") || month.equalsIgnoreCase("agosto") || month.equalsIgnoreCase("octubre") || month.equalsIgnoreCase("diciembre")) {
            for (int i = 1; i < 31; i++) {
                dayComboBox.addItem(i);
            }
        } else if (month.equalsIgnoreCase("abril") || month.equalsIgnoreCase("junio") || month.equalsIgnoreCase("septiembre") ||
                month.equalsIgnoreCase("noviembre")) {
            for (int i = 1; i < 30; i++) {
                dayComboBox.addItem(i);
            }
        } else if (month.equalsIgnoreCase("febrero")) {
            //InésAquí!!!
            for (int i = 1; i < 28; i++) {
                dayComboBox.addItem(i);
            }
        }
    }

    @Override
    public LocalDate getFecha() throws FechaException {
        return null;
    }

    @Override
    public void setFecha(int anyo, int mes, int dia) {

    }

}
