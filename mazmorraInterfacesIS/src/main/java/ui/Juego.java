package ui;

import javax.swing.*;

public class Juego {

    JFrame framePrincipal = new JFrame("Prueba");
    JButton botonPrueba = new JButton("Prueba");


    public void Prueba() {
        botonPrueba.setBounds(130, 100, 100, 40);
        framePrincipal.add(botonPrueba);

        framePrincipal.setSize(400, 500);
        framePrincipal.setLayout(null);
        framePrincipal.setVisible(true);
    }
}
