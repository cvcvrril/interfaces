package componentesMazmorra;

import Model.Dungeon;
import Model.Room;
import componenteLoad.dao.MLoad;
import componenteLog.MLogImpl;
import componenteMov.dao.MMove;
import componenteMov.dao.MMoveListener;
import componenteTree.MTreeImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Document doc;
        Element root;

        MLoad mload = new MLoad();
        MTreeImpl mTree = new MTreeImpl();
        MMove mMove= new MMove(new BorderLayout());
        MLogImpl mLog=new MLogImpl();
        JFrame framePrincipal = new JFrame("Mazmorra componentes");
        JPanel treeView = new JPanel();
        JPanel mainView = new JPanel(new BorderLayout());
        framePrincipal.setSize(400, 500);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem loadMI = new JMenuItem("Load");
        JMenuItem startMI = new JMenuItem("Start");
        menu.add(loadMI);
        menu.add(startMI);
        menuBar.add(menu);
        framePrincipal.setJMenuBar(menuBar);
        framePrincipal.add(treeView, BorderLayout.WEST);
        framePrincipal.add(mainView);
        mainView.add(mMove,BorderLayout.NORTH);
        mainView.add(mLog, BorderLayout.SOUTH);
        loadMI.addActionListener(e -> {
            mload.loadXMLFile();
            mTree.createJTree(mload.getDungeon());
            treeView.add(mTree);
        });
        startMI.addActionListener(e -> {
            mMove.setRooms(mload.getDungeon().getRooms());
            mMove.getTextAreaButtons().setVisible(true);
            Room currentRoom=mload.getDungeon().getRooms().get(0);
            mMove.loadRoom(currentRoom);
            mLog.addLogMessage(currentRoom.getDescription() + System.lineSeparator());
        });
        framePrincipal.setVisible(true);
    }

}
