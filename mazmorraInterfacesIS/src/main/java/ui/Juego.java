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
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    JTree fileTree = new JTree();


    public void Prueba() {


    }

    public void pruebaTree(){
        framePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root = new DefaultMutableTreeNode(fileXML);
        treeModel = new DefaultTreeModel(root);

        fileTree = new JTree(root);
        fileTree.setShowsRootHandles(true);

        framePrincipal.setVisible(true);
        framePrincipal.setSize(640, 480);
    }
}
