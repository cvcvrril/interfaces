package Model;

import java.util.List;

public class Room {

    private String id;
    private List<Door> doors;
    private String description;

    public void setId (String id){
        this.id=id;
    }

    public void setDoors(List<Door> doors){
        this.doors = doors;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getId(){
        return id;
    }

    public List<Door> getDoors(){
        return doors;
    }

    public String getDescription(){
        return description;
    }



}
