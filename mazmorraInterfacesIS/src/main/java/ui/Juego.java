package ui;

import common.Constantes;
import dao.DAOmazmorra;
import main.Room;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Juego {
    private final JFrame framePrincipal = new JFrame("Prueba");
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menu = new JMenu("Opciones");
    private final JMenuItem loadMI = new JMenuItem("Load file");
    private final JMenuItem startMI = new JMenuItem("Start");
    private final JPanel treeView = new JPanel();
    private final JPanel mainView = new JPanel(new BorderLayout());
    private final JPanel buttonView = new JPanel(new BorderLayout());
    private final JPanel textView = new JPanel(new BorderLayout());
    private DefaultTreeModel treeModel;
    private final JTree fileTree = new JTree();
    private final JTextArea textArea = new JTextArea();
    private final JTextArea textAreaButtons = new JTextArea(10, 10);
    private final JButton buttonNorth = new JButton("North");
    private final JButton buttonWest = new JButton("West");
    private final JButton buttonSouth = new JButton("South");
    private final JButton buttonEast = new JButton("East");
    Map<String, Room> rooms = new HashMap<>();
    private final DAOmazmorra dao = new DAOmazmorra();
    private Document doc;
    private Element root;
    private Room currentRoom;

    public void JuegoMazmorra() {
        prepararPantalla();
        loadMI.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser("data", FileSystemView.getFileSystemView());
            FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
                    "xml files (*.xml)", "xml");
            if (fileChooser.showOpenDialog(mainView) == JFileChooser.APPROVE_OPTION) {
                fileChooser.setFileFilter(xmlfilter);
            }
            doc = dao.parseXML(String.valueOf(fileChooser.getSelectedFile()));
            if (doc != null) {
                treeModel = new DefaultTreeModel(dao.buildTree(doc));
                fileTree.setModel(treeModel);
            }
        });
        startMI.addActionListener(e -> {
            root = doc.getDocumentElement();
            NodeList roomNodes = root.getElementsByTagName(Constantes.ROOM);
            for (int i = 0; i < roomNodes.getLength(); i++) {
                Element roomElement = (Element) roomNodes.item(i);
                String roomId = roomElement.getAttribute(Constantes.ID);
                String description = roomElement.getElementsByTagName(Constantes.DESCRIPTION).item(0).getTextContent();
                Room room = getRoom(roomId, description, roomElement);
                rooms.put(roomId, room);
            }
            //habitación inicial
            currentRoom = rooms.get(Constantes.INICIO);
            textAreaButtons.setText(currentRoom.getDescription());
            enableDirectionButtons(currentRoom);
        });
        listenDirectionButtons();
    }

    private static Room getRoom(String roomId, String description, Element roomElement) {
        Room room = new Room(roomId, description);
        NodeList doorNodes = roomElement.getElementsByTagName(Constantes.DOOR);
        for (int j = 0; j < doorNodes.getLength(); j++) {
            Element doorElement = (Element) doorNodes.item(j);
            String direction = doorElement.getAttribute(Constantes.NAME);
            String destination = doorElement.getAttribute(Constantes.DEST);
            room.addDoor(direction, destination);
        }
        return room;
    }
    private void enableDirectionButtons(Room room) {
        buttonNorth.setEnabled(room.getDoorDestination(Constantes.NORTE) != null);
        buttonSouth.setEnabled(room.getDoorDestination(Constantes.SUR) != null);
        buttonEast.setEnabled(room.getDoorDestination(Constantes.ESTE) != null);
        buttonWest.setEnabled(room.getDoorDestination(Constantes.OESTE) != null);
    }
    private void listenDirectionButtons(){
        buttonNorth.addActionListener(e -> move(Constantes.NORTE));
        buttonSouth.addActionListener(e -> move(Constantes.SUR));
        buttonEast.addActionListener(e -> move(Constantes.ESTE));
        buttonWest.addActionListener(e -> move(Constantes.OESTE));
    }
    public void move(String direction) {
        String destinationRoomId = currentRoom.getDoorDestination(direction);
        if (destinationRoomId != null) {
            currentRoom = rooms.get(destinationRoomId);
            textAreaButtons.setText(currentRoom.getDescription());
            enableDirectionButtons(currentRoom);
            movimientosUsuario();
        }
    }

    public void prepararPantalla() {
        framePrincipal.setSize(400, 500);
        textArea.setEditable(false);
        textView.add(textArea);
        mainView.add(textView);
        mainView.add(buttonView, BorderLayout.NORTH);
        framePrincipal.add(treeView, BorderLayout.WEST);
        framePrincipal.add(mainView);
        treeView.add(fileTree);
        setMenuOptions();
        setButtonPane();
        framePrincipal.setJMenuBar(menuBar);
        framePrincipal.setVisible(true);
    }

    public void setButtonPane() {
        buttonView.add(buttonNorth, BorderLayout.NORTH);
        buttonView.add(buttonSouth, BorderLayout.SOUTH);
        buttonView.add(textAreaButtons, BorderLayout.CENTER);
        textAreaButtons.setEditable(true);
        buttonView.add(buttonEast, BorderLayout.EAST);
        buttonView.add(buttonWest, BorderLayout.WEST);
    }

    public void setMenuOptions() {
        menu.add(loadMI);
        menu.add(startMI);
        menuBar.add(menu);
    }

    public void movimientosUsuario(){
        textArea.append(currentRoom.getDescription() + System.lineSeparator());
    }
}
