import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDate;

public class ComponenteFechaClase extends JPanel implements ComponenteFecha{
    private JComboBox<Integer> dayComboBox = new JComboBox<>();
    private JComboBox<Integer> monthComboBox =new JComboBox<>();
    private JTextField yearTextField=new JTextField(4);

    public ComponenteFechaClase() {
        add(dayComboBox);
        add(monthComboBox);
        add(yearTextField);
        setMonthCombo();
        setDayCombo();
        setYearTextField();
    }
    private void setMonthCombo() {
        for (int i = 1; i < 12; i++) {
            monthComboBox.addItem(i);
        }
    }

    private void setDayCombo() {
            for (int i = 1; i < 31; i++) {
                dayComboBox.addItem(i);
            }
    }

    private void setYearTextField() {
        yearTextField.setText("2023");
    }

    @Override
    public LocalDate getDate() throws FechaException {

        //Incompleto

        if((getDayComboBox() == null) || (getMonthComboBox() == null) || (getYearTextField() == null)){
            throw new FechaIncompletaException("Ha introducido una fecha incompleta");

        }else {

            //Imposible

            if (g) {

            }else {
                //Incorrecto
            }

        }
    }

    public JComboBox<Integer> getDayComboBox() {
        return dayComboBox;
    }

    public JComboBox<Integer> getMonthComboBox() {
        return monthComboBox;
    }

    public JTextField getYearTextField() {
        return yearTextField;
    }

    @Override
    public void setDate(int day, int month, int year) {
    }
}
