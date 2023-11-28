package Model;

import java.util.List;

public class Dungeon {

    private List<Room> rooms;

    public void setRooms(List<Room> rooms){
        this.rooms = rooms;
    }

    public List<Room> getRooms(){
        return rooms;
    }
}
