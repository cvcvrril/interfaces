package componenteMov.dao;

import componenteMov.domain.Door;
import componenteMov.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class mMoveListener implements mMoveListenerInterface {
    private List<String> locations= new ArrayList<>();
    @Override
    public void roomUpdated(Room room) {
        for (Door door:room.getDoors()) {
            locations.add(door.getName());
        }
    }
    public List<String> getLocations() {
        return locations;
    }
}
