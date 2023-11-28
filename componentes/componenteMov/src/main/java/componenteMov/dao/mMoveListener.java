package componenteMov.dao;

import componenteMov.domain.Room;
import org.w3c.dom.NodeList;

public class mMoveListener implements mMoveListenerInterface{
    @Override
    public void roomUpdated(Room room) {
        String destinationRoomId = currentRoom.getDoorDestination(direction);
            room = rooms.get(destinationRoomId);
            textAreaButtons.setText(currentRoom.getDescription());
            enableDirectionButtons(currentRoom);
            movimientosUsuario();
        }

    }
}
