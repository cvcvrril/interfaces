package componentesMazmorra;


import componenteLoad.dao.mLoad;
import componenteMov.domain.Room;
import componenteTree.mTreeImpl;
import componentesMazmorra.model.Dungeon;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Document doc;
        Element root;
        Room currentRoom;
        mLoad mload= new mLoad();
        JFrame framePrincipal = new JFrame("Mazmorra componentes");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem loadMI = new JMenuItem("Load");
        JMenuItem startMI = new JMenuItem("Start");
        menu.add(loadMI);
        menu.add(startMI);
        menuBar.add(menu);
        framePrincipal.setJMenuBar(menuBar);
        framePrincipal.setVisible(true);
        loadMI.addActionListener(e -> {
           mload.loadXMLFile();
        });
        Dungeon dungeon =
        mTreeImpl mtree= new mTreeImpl();
        mtree.createJTree(mload.getDungeon());
    }
}
