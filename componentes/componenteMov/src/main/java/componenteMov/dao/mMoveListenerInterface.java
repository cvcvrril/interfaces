package componenteMov.dao;

import componenteMov.domain.Room;

import java.util.EventListener;

public interface mMoveListenerInterface extends EventListener {
    void roomUpdated(Room room);
}
