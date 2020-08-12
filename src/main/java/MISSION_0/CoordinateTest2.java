package MISSION_0;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest2 {
    Coordinate coord;

    @Before
    public void setUp(){
        coord = new Coordinate();
    }

    @Test
    public void normal(){
        coord.extractCoord("(8,10)");
        assertEquals(8,coord.getX());
        assertEquals(10,coord.getY());
    }

    @Test
    public void invalidInput(){
        coord.extractCoord("(8,)");
        assertEquals(-1,coord.getX());
        assertEquals(-1,coord.getY());


        coord.extractCoord("(,10)");
        assertEquals(-1,coord.getX());
        assertEquals(-1,coord.getY());


        coord.extractCoord("(,)");
        assertEquals(-1,coord.getX());
        assertEquals(-1,coord.getY());
    }

    @Test
    public void overRange(){
        coord.extractCoord("(100,0)");
        assertEquals(-1,coord.getX());
        assertEquals(-1,coord.getY());


        coord.extractCoord("(1,100)");
        assertEquals(-1,coord.getX());
        assertEquals(-1,coord.getY());
    }

    @After
    public void cleanUp(){
        coord = null;
    }
}