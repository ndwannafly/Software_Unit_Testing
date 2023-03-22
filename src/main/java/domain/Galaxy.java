package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Galaxy {
    private List<ObjectInSpace> objectInSpaceList;
    private int numberOfObjects;

    public Galaxy(){
        this.objectInSpaceList = new ArrayList<>();
        numberOfObjects = 0;
    }

    public void addObject(ObjectInSpace obj){
        this.objectInSpaceList.add(obj);
        this.numberOfObjects++;
    }

    public ObjectInSpace getObject(int index){
        return this.objectInSpaceList.get(index);
    }
    public int getNumberOfObjects() {
        return numberOfObjects;
    }

    public List<ObjectInSpace> getObjectInSpaceList() {
        return objectInSpaceList;
    }

    public void setNumberOfObjects(int numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
    }

    public void setObjectInSpaceList(List<ObjectInSpace> objectInSpaceList) {
        this.objectInSpaceList = objectInSpaceList;
    }

    public void lineUp(List<Integer> orders){
        if (orders.size() != numberOfObjects){
            throw new IllegalArgumentException("orders have amount of numbers not equal to number of objects");
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < orders.size();i++){
            if (set.contains(orders.get(i))){
                throw  new IllegalArgumentException(("duplicate index in the given order"));
            }
            set.add(orders.get(i));
        }
        List<ObjectInSpace> oldList = new ArrayList<>(objectInSpaceList);
        for (int i = 0; i < orders.size(); i++){
            objectInSpaceList.set(i, oldList.get(orders.get(i)));
        }
    }
}