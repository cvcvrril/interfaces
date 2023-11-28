package componenteMov.dao;

import componenteMov.common.Constantes;
import componenteMov.domain.Room;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class mMove extends JPanel implements mMoveInterface {
    private List<Room> rooms;
    private mMoveListener listener;
    private final JTextArea textAreaButtons = new JTextArea(10, 20);
    private final JButton buttonNorth = new JButton(Constantes.NORTE);
    private final JButton buttonWest = new JButton(Constantes.OESTE);
    private final JButton buttonSouth = new JButton(Constantes.SUR);
    private final JButton buttonEast = new JButton(Constantes.ESTE);

    public mMove(LayoutManager layout) {
        super(layout);
        this.listener = new mMoveListener();
        botones();

    }

    private void botones() {
        add(buttonNorth, BorderLayout.NORTH);
        add(buttonSouth, BorderLayout.SOUTH);
        textAreaButtons.setEditable(true);
        add(buttonEast, BorderLayout.EAST);
        add(buttonWest, BorderLayout.WEST);
    }

    @Override
    public void loadRoom(Room room) {
        buttonNorth.setEnabled(false);
        buttonSouth.setEnabled(false);
        buttonWest.setEnabled(false);
        buttonEast.setEnabled(false);

        textAreaButtons.setText(room.getDescription());
        room.getDoors().forEach(door -> {
            if (door.getName().equalsIgnoreCase(Constantes.NORTE)) {
                buttonNorth.setEnabled(true);
                buttonNorth.removeActionListener(buttonNorth.getActionListeners().length > 0 ? buttonNorth.getActionListeners()[0] : null);
                buttonNorth.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase(Constantes.NORTE))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase(Constantes.SUR)) {
                buttonSouth.setEnabled(true);
                buttonSouth.removeActionListener(buttonSouth.getActionListeners().length > 0 ? buttonSouth.getActionListeners()[0] : null);
                buttonSouth.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase(Constantes.SUR))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase(Constantes.OESTE)) {
                buttonWest.setEnabled(true);
                buttonWest.removeActionListener(buttonWest.getActionListeners().length > 0 ? buttonWest.getActionListeners()[0] : null);
                buttonWest.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase(Constantes.OESTE))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase(Constantes.ESTE)) {
                buttonEast.setEnabled(true);
                buttonEast.removeActionListener(buttonEast.getActionListeners().length > 0 ? buttonEast.getActionListeners()[0] : null);
                buttonEast.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase(Constantes.ESTE))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            }
        });
    }
    @Override
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
