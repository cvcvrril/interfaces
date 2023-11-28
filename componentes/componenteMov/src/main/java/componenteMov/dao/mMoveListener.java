package componenteMov.dao;

import componenteMov.common.Constantes;
import componenteMov.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class mMoveListener implements mMoveListenerInterface {
    private List<String> locations= new ArrayList<>();
    @Override
    public void roomUpdated(Room room) {
        buttonNorth.setEnabled(room.getDoorDestination(Constantes.NORTE) != null);
        buttonSouth.setEnabled(room.getDoorDestination(Constantes.SUR) != null);
        buttonEast.setEnabled(room.getDoorDestination(Constantes.ESTE) != null);
        buttonWest.setEnabled(room.getDoorDestination(Constantes.OESTE) != null);
    }
}
