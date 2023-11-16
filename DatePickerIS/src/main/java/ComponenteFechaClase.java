import exception.FechaException;
import exception.FechaImposibleException;
import exception.FechaIncompletaException;
import exception.FechaIncorrectaException;

import javax.swing.*;
import java.time.LocalDate;

public class ComponenteFechaClase extends JPanel implements ComponenteFecha {
    private JComboBox<Integer> dayComboBox = new JComboBox<>();
    private JComboBox<Integer> monthComboBox = new JComboBox<>();
    private JTextField yearTextField = new JTextField(4);

    public ComponenteFechaClase() {
        add(dayComboBox);
        add(monthComboBox);
        add(yearTextField);
        setMonthCombo();
        setDayCombo();
        setYearTextField();
    }

    private void setMonthCombo() {
        for (int i = 0; i < 13; i++) {
            monthComboBox.addItem(i);
        }
    }

    private void setDayCombo() {
        for (int i = 0; i < 32; i++) {
            dayComboBox.addItem(i);
        }
    }

    private void setYearTextField() {
        yearTextField.setText("2023");
    }

    @Override
    public LocalDate getDate() throws FechaException {

        int day = (int) getDayComboBox().getSelectedItem();
        int month = (int) getMonthComboBox().getSelectedItem();
        int year;

        //Incompleto

        if (getDayComboBox().getSelectedItem().equals(0) || getMonthComboBox().getSelectedItem().equals(0) || getYearTextField().getText().isEmpty()) {
            throw new FechaIncompletaException("Ha introducido una fecha incompleta");
        }

        year = Integer.parseInt(getYearTextField().getText());

        //Imposible
        if (month == 2 && day == 29 && !esBisiesto(year)) {
            throw new FechaImposibleException("Ha introducido un 29 de febrero en un año no bisiesto");
        }

        if (year < 0){
            throw new FechaImposibleException("El año introducido no es válido");
        }

        //Incorrecto
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new FechaIncorrectaException("Ha introducido una fecha incorrecta");
        }

        if ((month == 4 || month==2 || month == 6 || month == 9 || month == 11) && day == 31) {
            throw new FechaIncorrectaException("El mes " + month + " no puede tener 31 días");
        }

        return LocalDate.of(year, month, day);
    }

    private boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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
