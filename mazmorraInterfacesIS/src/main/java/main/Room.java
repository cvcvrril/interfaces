package main;

import lombok.Data;

import java.util.HashMap;

@Data
public class Room {
    private final String id;
    private final String description;
    private final HashMap<String, String> doors;

    public Room(String id, String description) {
        this.id = id;
        this.description = description;
        doors = new HashMap<>();
    }

    public void addDoor(String direction, String destination) {
        doors.put(direction, destination);
    }

    public String getDoorDestination(String direction) {
        return doors.get(direction);
    }
}
