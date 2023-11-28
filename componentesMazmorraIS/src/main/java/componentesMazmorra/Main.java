package componentesMazmorra;

import Model.Room;
import componenteLoad.dao.MLoad;
import componenteLog.MLogImpl;
import componenteMov.dao.MMove;
import componenteMov.dao.MMoveListener;
import componenteTree.MTreeImpl;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MLoad mload = new MLoad();
        MTreeImpl mTree = new MTreeImpl();
        MLogImpl mLog=new MLogImpl();
        MMoveListener listener = new MMoveListener() {
            @Override
            public void roomUpdated(Room room) {
                mLog.addLogMessage(room.getDescription() + System.lineSeparator());
            }
        };
        MMove mMove= new MMove(listener);
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
        framePrincipal.add(mainView, BorderLayout.EAST);
        mainView.add(mMove, BorderLayout.NORTH);
        mainView.add(mLog, BorderLayout.SOUTH);
        loadMI.addActionListener(e -> {
            mLog.clearLog();
            mload.loadXMLFile();
            mTree.createJTree(mload.getDungeon());
            treeView.add(mTree);
        });
        startMI.addActionListener(e -> {
            Room currentRoom=mload.getDungeon().getRooms().get(0);
            mMove.updateUI();
            mMove.setRooms(mload.getDungeon().getRooms());
            mMove.loadRoom(currentRoom);
            listener.roomUpdated(currentRoom);
        });
        framePrincipal.setVisible(true);
    }

}
