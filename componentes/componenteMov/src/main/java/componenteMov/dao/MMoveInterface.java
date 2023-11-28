package componenteMov.dao;

import Model.Room;

import java.util.List;

public interface MMoveInterface {
    void loadRoom(Room room);
    void setRooms(List<Room> room);
}
