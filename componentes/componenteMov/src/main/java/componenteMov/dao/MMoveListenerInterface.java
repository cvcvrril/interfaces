package componenteMov.dao;

import Model.Room;

import java.util.EventListener;

public interface MMoveListenerInterface extends EventListener {
    void roomUpdated(Room room);
}
