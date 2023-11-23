package componenteTree;

import componenteTree.model.Door;
import componenteTree.model.Dungeon;
import componenteTree.model.Room;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;

public class mTreeImpl extends JTree implements MTree {

    @Override
    public JTree createJTree(Dungeon dungeon) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Mazmorra");
        List<Room> rooms = dungeon.getRooms();
        for (Room room : rooms) {
            DefaultMutableTreeNode roomNode = new DefaultMutableTreeNode("Habitación: " + room.getId());
            rootNode.add(roomNode);
            DefaultMutableTreeNode description = new DefaultMutableTreeNode("Descripción: " + room.getDescription());
            roomNode.add(description);
            List<Door> doors = room.getDoors();
            for (Door door : doors){
                DefaultMutableTreeNode doorNode = new DefaultMutableTreeNode("Puerta: " + door.getName() + ", " + door.getDest());
                roomNode.add(doorNode);
            }
        }

        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        return new JTree(treeModel);
    }
}
