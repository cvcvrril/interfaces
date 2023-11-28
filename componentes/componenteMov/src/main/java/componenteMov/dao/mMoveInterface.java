package componenteMov.dao;

import componenteMov.domain.Room;

import java.util.List;

public interface mMoveInterface {
    void loadRoom(List<Room> room);
    void setRoom(Room room);
}
