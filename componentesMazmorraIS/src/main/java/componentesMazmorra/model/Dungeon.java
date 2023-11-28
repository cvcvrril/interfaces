package componentesMazmorra.model;

import componenteMov.domain.Room;

import java.util.List;

public class Dungeon {
    private List<componenteMov.domain.Room> rooms;

    public List<componenteMov.domain.Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
