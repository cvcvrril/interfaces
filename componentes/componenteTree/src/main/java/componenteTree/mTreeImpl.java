package componenteTree;

import componenteTree.model.Dungeon;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class mTreeImpl extends JTree implements MTree {

    @Override
    public JTree createJTree(Dungeon dungeon) {
        JTree tree = new JTree();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(dungeon);
        NodeList roomList = (NodeList) root.children();
        for (int i = 0; i < roomList.getLength(); i++){
            Node roomNode = roomList.item(i);
        }
        treeModel = new DefaultTreeModel();
        tree.setModel();


        return tree;
    }
}
