package ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class Juego {
    JFrame framePrincipal = new JFrame("Prueba");
    JButton botonPrueba = new JButton("Prueba");
    JMenuBar menuBar=new JMenuBar();
    JMenu menu=new JMenu("Opciones");
    JMenuItem loadMI=new JMenuItem("Load file");
    JMenuItem startMI=new JMenuItem("Start");
    JPanel treeView=new JPanel();
    JPanel mainView=new JPanel(new BorderLayout());
    JPanel buttonView=new JPanel(new BorderLayout());
    JPanel textView=new JPanel(new BorderLayout());
    File fileXML = new File("data/mazmorra.xml");
    DefaultMutableTreeNode dungeon = new DefaultMutableTreeNode("Dungeon");
    DefaultMutableTreeNode roomR0 = new DefaultMutableTreeNode("room R0");
    DefaultMutableTreeNode roomR1 = new DefaultMutableTreeNode("room R1");
    private DefaultTreeModel treeModel;
    JTree fileTree = new JTree();
    JTextArea textArea = new JTextArea();
    JTextArea textAreaButtons = new JTextArea();
    JButton buttonNorth=new JButton("North");
    JButton buttonWest=new JButton("West");
    JButton buttonSouth=new JButton("South");
    JButton buttonEast=new JButton("East");
    public void Prueba() {
        framePrincipal.setSize(400, 500);
        textArea.setEditable(false);
        textView.add(textArea);
        mainView.add(textView);
        mainView.add(buttonView,BorderLayout.NORTH);
        framePrincipal.add(treeView,BorderLayout.WEST);
        framePrincipal.add(mainView);
        treeView.add(fileTree);
        pruebaTree();
        setMenuOptions();
        setButtonPane();
        framePrincipal.setJMenuBar(menuBar);
        framePrincipal.setVisible(true);
    }
    public void setButtonPane(){
        buttonView.add(buttonNorth,BorderLayout.NORTH);
        buttonView.add(buttonSouth,BorderLayout.SOUTH);
        buttonView.add(textAreaButtons,BorderLayout.CENTER);
        textAreaButtons.setEditable(false);
        buttonView.add(buttonEast,BorderLayout.EAST);
        buttonView.add(buttonWest,BorderLayout.WEST);
    }
    public void setMenuOptions(){
        menu.add(loadMI);
        menu.add(startMI);
        menuBar.add(menu);
    }
    public void pruebaTree(){
        dungeon.add(roomR0);
        dungeon.add(roomR1);
        fileTree = new JTree(dungeon);
    }
}
