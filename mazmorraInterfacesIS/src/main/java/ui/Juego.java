package ui;

import org.w3c.dom.Document;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;

public class Juego {
    JFrame framePrincipal = new JFrame("Prueba");
    JButton botonPrueba = new JButton("Prueba");
    JMenuBar menuBar=new JMenuBar();
    JMenu menu=new JMenu("Opciones");
    JMenuItem loadMI=new JMenuItem("Load file");
    JMenuItem startMI=new JMenuItem("Start");
    JPanel treeView=new JPanel();
    JPanel mainView=new JPanel();
    JPanel buttonView=new JPanel();
    JPanel textView=new JPanel();
    JTree tree=new JTree();
    JTextField textField= new JTextField();
    JTextField textFieldButtons= new JTextField();
    JButton buttonNorth=new JButton("North");
    JButton buttonWest=new JButton("West");
    JButton buttonSouth=new JButton("South");
    JButton buttonEast=new JButton("East");
    public void Prueba() {
        framePrincipal.setSize(400, 500);
        mainView.setSize(200,250);
        //textField.setEditable(false);
        //textView.add(textField);
        //mainView.add(textView,BorderLayout.SOUTH);
        //framePrincipal.add(treeView,BorderLayout.WEST);
        setMenuOptions();
        setButtonPane();
        framePrincipal.add(mainView);
        framePrincipal.setJMenuBar(menuBar);
        framePrincipal.setVisible(true);
    }
    public void setButtonPane(){
        buttonView.add(buttonNorth,BorderLayout.NORTH);
        buttonView.add(buttonSouth,BorderLayout.SOUTH);
        buttonView.add(textFieldButtons,BorderLayout.CENTER);
        textFieldButtons.setEditable(false);
        buttonView.add(buttonEast,BorderLayout.EAST);
        buttonView.add(buttonWest,BorderLayout.WEST);
        mainView.add(buttonView);
    }
    public void setMenuOptions(){
        menu.add(loadMI);
        menu.add(startMI);
        menuBar.add(menu);
    }
}
