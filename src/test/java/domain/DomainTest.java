package domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

public class DomainTest {
    private static Galaxy galaxy;
    private static Day today;
    @BeforeEach
    void setUp(){
        today = new Day(Weekday.THURSDAY);
        galaxy = new Galaxy();
    }

    @Test
    @DisplayName("Check day must be one of the weekday")
    void initTodayTest(){
        assertThrows(IllegalArgumentException.class, () -> {today.setWeekday(Weekday.valueOf("someday"));});
    }


    @Test
    @DisplayName("object floated to the sun")
    void objectFloatedToTheSunTest(){
        ObjectInSpace obj = new ObjectInSpace();
        obj.floatToTheSun();
        assertEquals("to the sun", obj.getDirection().getDestination());
    }

    @Test
    @DisplayName("test change object location")
    void testSetLocation(){
        ObjectInSpace obj = new ObjectInSpace();
        obj.setLocation("To the Moon");
    }

    @Test
    @DisplayName("test line up in predetermine order failed if duplicate index")
    void lineupDuplicateTest() {
        for (int i = 0; i < 10; i++){
            Direction direction = new Direction("through the ionosphere");
            Location location = new Location("below the surface of the planet");
            List<Property> propertyList = new ArrayList<>();
            propertyList.add(new Property("yellow massive"));
            propertyList.add(new Property("angular"));
            propertyList.add(new Property("chunky bodies"));
            propertyList.add(new Property("huge as skyscrapers"));
            propertyList.add(new Property("silent as birds"));
            galaxy.addObject(new ObjectInSpace(
                    propertyList, location, direction, i
            ));
        }
        List<Integer> lineUpOrder = new ArrayList<>();
        for (int i = 0 ; i < 9; i++){
            lineUpOrder.add(i);
        }
        lineUpOrder.add(5); // duplicate 5
        assertThrows(IllegalArgumentException.class, () -> {
            galaxy.lineUp(lineUpOrder);
        });
    }
    @Test
    @DisplayName("test line up in predetermine order failed if given order has not correct size")
    void lineupNotEqualSizeTest() {
        for (int i = 0; i < 10; i++){
            Direction direction = new Direction("through the ionosphere");
            Location location = new Location("below the surface of the planet");
            List<Property> propertyList = new ArrayList<>();
            propertyList.add(new Property("yellow massive"));
            propertyList.add(new Property("angular"));
            propertyList.add(new Property("chunky bodies"));
            propertyList.add(new Property("huge as skyscrapers"));
            propertyList.add(new Property("silent as birds"));
            galaxy.addObject(new ObjectInSpace(
                    propertyList, location, direction, i
            ));
        }
        List<Integer> lineUpOrder = new ArrayList<>();
        for (int i = 0 ; i < 9; i++){
            lineUpOrder.add(i);
        }
        assertThrows(IllegalArgumentException.class, () -> {
            galaxy.lineUp(lineUpOrder);
        });
    }

    @Test
    @DisplayName("test line up in predetermine order correct")
    void lineupTest() {
        for (int i = 0; i < 10; i++){
            Direction direction = new Direction("through the ionosphere");
            Location location = new Location("below the surface of the planet");
            List<Property> propertyList = new ArrayList<>();
            propertyList.add(new Property("yellow massive"));
            propertyList.add(new Property("angular"));
            propertyList.add(new Property("chunky bodies"));
            propertyList.add(new Property("huge as skyscrapers"));
            propertyList.add(new Property("silent as birds"));
            galaxy.addObject(new ObjectInSpace(
                    propertyList, location, direction, i
            ));
        }
        List<Integer> lineUpOrder = new ArrayList<>();
        lineUpOrder.add(2);
        lineUpOrder.add(3);
        lineUpOrder.add(5);
        lineUpOrder.add(0);
        lineUpOrder.add(6);
        lineUpOrder.add(1);
        lineUpOrder.add(9);
        lineUpOrder.add(7);
        lineUpOrder.add(8);
        lineUpOrder.add(4);

        galaxy.lineUp(lineUpOrder);
        for(int i = 0; i < galaxy.getNumberOfObjects();i++){
            assertEquals(lineUpOrder.get(i), galaxy.getObject(i).getId());
        }
    }
}
