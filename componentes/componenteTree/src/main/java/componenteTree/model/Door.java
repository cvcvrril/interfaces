package componenteTree.model;

public class Door {

    private String location;
    private String dest;

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setName(String location) {
        this.location = location;
    }

    public String getName() {
        return location;
    }

    public String getDest() {
        return dest;
    }
}
