package componenteMov.dao;

import componenteMov.common.Constantes;
import componenteMov.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class mMove extends JPanel implements mMoveInterface {

    private List<Room> rooms;
    private mMoveListenerInterface listener;
    private final JTextArea textAreaButtons = new JTextArea(10, 20);
    private final JButton buttonNorth = new JButton(Constantes.NORTH);
    private final JButton buttonWest = new JButton(Constantes.WEST);
    private final JButton buttonSouth = new JButton(Constantes.SOUTH);
    private final JButton buttonEast = new JButton(Constantes.EAST);
    private JLabel actualRoomDescription;

    public mMove(LayoutManager layout) {
        super(layout);
        add(buttonNorth, BorderLayout.NORTH);
        add(buttonSouth, BorderLayout.SOUTH);
        textAreaButtons.setEditable(true);
        add(buttonEast, BorderLayout.EAST);
        add(buttonWest, BorderLayout.WEST);
    }

    @Override
    public void loadRoom(List<Room> room) {

    }

    @Override
    public void setRoom(Room room) {

    }
}
