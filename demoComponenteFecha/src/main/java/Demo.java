import exception.FechaException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Demo implements ActionListener {
    private final JFrame framePrincipal = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel fechaInicioLabel = new JLabel("Fecha inicio:");
    private final JLabel fechaFinLabel = new JLabel("Fecha fin:");
    private final JButton comprobar = new JButton("Comprobar");
    private final JTextArea textArea = new JTextArea(2, 10);
    private final ComponenteFecha fechaInicio = new ComponenteFechaClase();
    private final ComponenteFecha fechaFin = new ComponenteFechaClase();

    public Demo(){
        prepararPantalla();
    }

    private void prepararPantalla() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        framePrincipal.add(panel, BorderLayout.NORTH);
        panel.add(fechaInicioLabel);
        panel.add(Box.createHorizontalGlue());
        panel.add((Component) fechaInicio);
        panel.add(Box.createHorizontalGlue());
        panel.add(fechaFinLabel);
        panel.add(Box.createHorizontalGlue());
        panel.add((Component) fechaFin);
        panel.add(Box.createHorizontalGlue());
        panel.add(comprobar);
        textArea.setFocusable(false);
        framePrincipal.add(textArea, BorderLayout.SOUTH);
        framePrincipal.setSize(300, 200);
        framePrincipal.setVisible(true);
    }

@Override
    public void actionPerformed(ActionEvent e) {
    try {
        if (fechaInicio.getDate().isBefore(fechaFin.getDate())) {
            textArea.setText("Hay " + fechaInicio.getDate().until(fechaFin.getDate(), ChronoUnit.DAYS) + " dias entre las fechas");
        } else if (fechaInicio.getDate().isAfter(fechaFin.getDate())) {
            textArea.setText("La fecha de inicio es posterior a la de fin");
        }
    } catch (FechaException ex) {
        throw new RuntimeException(ex);
    }
}
}
