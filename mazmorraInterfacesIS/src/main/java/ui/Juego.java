package ui;

import dao.DAOmazmorra;
import org.w3c.dom.Document;

import javax.swing.*;

import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class Juego {
    JFrame framePrincipal = new JFrame("Prueba");
    JMenuBar menuBar=new JMenuBar();
    JMenu menu=new JMenu("Opciones");
    JMenuItem loadMI=new JMenuItem("Load file");
    JMenuItem startMI=new JMenuItem("Start");
    JPanel treeView=new JPanel();
    JPanel mainView=new JPanel(new BorderLayout());
    JPanel buttonView=new JPanel(new BorderLayout());
    JPanel textView=new JPanel(new BorderLayout());
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
        DAOmazmorra dao = new DAOmazmorra();
        Document doc = dao.parseXML("data/mazmorra.xml");
 //       pruebaTree();
        if (doc != null) {
            treeModel = new DefaultTreeModel(dao.buildTree(doc));
            fileTree.setModel(treeModel);
        }
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
}
