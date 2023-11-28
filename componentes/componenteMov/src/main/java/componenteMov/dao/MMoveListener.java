package componenteMov.dao;

import Model.Door;
import Model.Room;

import java.util.ArrayList;
import java.util.List;

public class MMoveListener implements MMoveListenerInterface {
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
