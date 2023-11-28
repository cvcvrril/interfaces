package componenteMov.dao;

import Model.Room;

import javax.swing.*;
import java.awt.*;

public class MMove extends JPanel implements MMoveInterface {


    private java.util.List<Room> rooms;
    private MMoveListener listener;

    private JButton north;
    private JButton south;
    private JButton west;
    private JButton east;

    private JTextArea actualRoomDescription;

    public MMove(MMoveListener listener) {
        //super();
        this.listener = listener;
        initComponente();
    }

    private void initComponente() {
        actualRoomDescription = new JTextArea("COMENZAR");

        north = new JButton("North");
        north.setEnabled(false);
        south = new JButton("South");
        south.setEnabled(false);
        west = new JButton("West");
        west.setEnabled(false);
        east = new JButton("East");
        east.setEnabled(false);

        setLayout(new BorderLayout());
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(actualRoomDescription, BorderLayout.CENTER);
    }

    @Override
    public void setRooms(java.util.List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void loadRoom(Room room) {
        north.setEnabled(false);
        south.setEnabled(false);
        west.setEnabled(false);
        east.setEnabled(false);

        actualRoomDescription.setText(room.getDescription());

        room.getDoors().forEach(door -> {
            if (door.getName().equalsIgnoreCase("Norte")) {
                north.setEnabled(true);
                north.removeActionListener(north.getActionListeners().length > 0 ? north.getActionListeners()[0] : null);
                north.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase("Norte"))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase("Sur")) {
                south.setEnabled(true);
                south.removeActionListener(south.getActionListeners().length > 0 ? south.getActionListeners()[0] : null);
                south.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase("Sur"))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase("Oeste")) {
                west.setEnabled(true);
                west.removeActionListener(west.getActionListeners().length > 0 ? west.getActionListeners()[0] : null);
                west.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase("Oeste"))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            } else if (door.getName().equalsIgnoreCase("Este")) {
                east.setEnabled(true);
                east.removeActionListener(east.getActionListeners().length > 0 ? east.getActionListeners()[0] : null);
                east.addActionListener(e -> {
                    Room nextRoom = rooms.stream()
                            .filter(r -> r.getId()
                                    .equalsIgnoreCase(room.getDoors().stream().filter(d -> d.getName().equalsIgnoreCase("Este"))
                                            .findFirst().get()
                                            .getDest())
                            ).findFirst().get();
                    listener.roomUpdated(nextRoom);
                    loadRoom(nextRoom);
                });
            }
        });
    }
}