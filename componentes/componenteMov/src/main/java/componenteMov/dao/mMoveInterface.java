package componenteMov.dao;

import componenteMov.domain.Room;

import java.util.List;

public interface mMoveInterface {
    void loadRoom(Room room);
    void setRooms(List<Room> room);
}
