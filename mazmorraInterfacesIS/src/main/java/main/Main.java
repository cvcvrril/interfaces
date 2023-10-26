package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame framePrincipal = new JFrame("Prueba");
        JButton botonPrueba = new JButton("Prueba");

        botonPrueba.setBounds(130,100,100, 40);
        framePrincipal.add(botonPrueba);

        framePrincipal.setSize(400,500);
        framePrincipal.setLayout(null);
        framePrincipal.setVisible(true);


    }
}