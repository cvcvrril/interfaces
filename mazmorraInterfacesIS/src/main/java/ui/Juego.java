package ui;

import java.io.File;

import javax.swing.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Juego {

    JFrame framePrincipal = new JFrame("Prueba");
    JButton botonPrueba = new JButton("Prueba");
    File fileXML = new File("data/mazmorra.xml");
    DefaultMutableTreeNode dungeon = new DefaultMutableTreeNode("Dungeon");
    DefaultMutableTreeNode roomR0 = new DefaultMutableTreeNode("room R0");
    DefaultMutableTreeNode roomR1 = new DefaultMutableTreeNode("room R1");
    private DefaultTreeModel treeModel;
    JTree fileTree = new JTree();


    public void Prueba() {


    }

    public void pruebaTree(){

        dungeon.add(roomR0);
        dungeon.add(roomR1);

        fileTree = new JTree(dungeon);
        framePrincipal.add(fileTree);

        framePrincipal.setSize(600,600);
        framePrincipal.setVisible(true);
    }
}
