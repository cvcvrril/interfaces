package componenteLoad.dao;

import componenteLoad.common.Constantes;
import componenteLoad.model.Door;
import componenteLoad.model.Dungeon;
import componenteLoad.model.Room;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mLoad implements mLoadInterface {
    private Dungeon dungeon;

    @Override
    public void loadXMLFile() {
        Document doc;
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(Constantes.XML_FILES_XML, Constantes.XML);
            fileChooser.setFileFilter(xmlfilter);
            int r = fileChooser.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                File xmlFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();
                NodeList roomNodes = doc.getElementsByTagName(Constantes.ROOM);
                dungeon = new Dungeon();
                List<Room> rooms = new ArrayList<>();
                for (int i = 0; i < roomNodes.getLength(); i++) {
                    Node roomNode = roomNodes.item(i);

                    if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element roomElement = (Element) roomNode;
                        Room room = new Room();
                        room.setId(roomElement.getAttribute(Constantes.ID));
                        room.setDescription(roomElement.getElementsByTagName(Constantes.DESCRIPTION).item(0).getTextContent());
                        List<Door> doors = getDoors(roomElement);
                        room.setDoors(doors);
                        rooms.add(room);
                    }
                }
                dungeon.setRooms(rooms);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            dungeon = null;
        }
    }

    private static List<Door> getDoors(Element roomElement) {
        NodeList doorList = roomElement.getElementsByTagName(Constantes.DOOR);
        List<Door> doors = new ArrayList<>();
        for (int k = 0; k < doorList.getLength(); k++) {
            Node doorNode = doorList.item(k);
            if (doorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element doorElement = (Element) doorNode;
                Door door = new Door();
                door.setName(doorElement.getAttribute(Constantes.NAME));
                door.setDest(doorElement.getAttribute(Constantes.DEST));
                doors.add(door);
            }
        }
        return doors;
    }

    @Override
    public Dungeon getDungeon() {
        return dungeon;
    }
}