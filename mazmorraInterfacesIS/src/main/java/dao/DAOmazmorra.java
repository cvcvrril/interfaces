package dao;

import common.Constantes;
import org.w3c.dom.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.*;
import java.io.File;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DAOmazmorra {

    public Document parseXML(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            return dBuilder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DefaultMutableTreeNode buildTree(Document doc) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(Constantes.DUNGEON);
        NodeList roomList = doc.getElementsByTagName(Constantes.ROOM);

        for (int i = 0; i < roomList.getLength(); i++) {
            Node roomNode = roomList.item(i);
            if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                Element roomElement = (Element) roomNode;
                String roomId = roomElement.getAttribute(Constantes.ID);
                DefaultMutableTreeNode room = new DefaultMutableTreeNode(Constantes.ROOM + roomId);
                NodeList doorList = roomElement.getElementsByTagName(Constantes.DOOR);
                for (int j = 0; j < doorList.getLength(); j++) {
                    Node doorNode = doorList.item(j);
                    if (doorNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element doorElement = (Element) doorNode;
                        String doorName = doorElement.getAttribute(Constantes.NAME);
                        String doorDest = doorElement.getAttribute(Constantes.DEST);
                        DefaultMutableTreeNode door = new DefaultMutableTreeNode(doorName + Constantes.FLECHITA + doorDest);
                        room.add(door);
                    }
                }
                NodeList descriptionList = roomElement.getElementsByTagName(Constantes.DESCRIPTION);
                if (descriptionList.getLength() > 0) {
                    Node descriptionNode = descriptionList.item(0);
                    String description = descriptionNode.getTextContent();
                    DefaultMutableTreeNode desc = new DefaultMutableTreeNode(description);
                    room.add(desc);
                }
                root.add(room);
            }
        }
        return root;
    }


}
