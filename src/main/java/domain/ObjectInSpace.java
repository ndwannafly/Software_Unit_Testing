package domain;

import java.util.List;

public class ObjectInSpace {
    private int id;
    private List<Property> propertyList;
    private Location location;
    private  Direction direction;

    public ObjectInSpace(List<Property> propertyList, Location location, Direction direction, int id){
        this.propertyList = propertyList;
        this.location = location;
        this.direction = direction;
        this.id=id;
    }

     public ObjectInSpace(){

     }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    void floatToTheSun(){
        if (this.getDirection() == null) {
            this.setDirection(new Direction("to the sun"));
        } else {
            this.getDirection().setDestination("to the sun");
        }
     }
    public Direction getDirection() {
        return direction;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }
}
