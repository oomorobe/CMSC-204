import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the Road class.
 * Tests for road name, weight, source/destination, contains, equality, comparison, and string representation.
 * @author Okeoghene Excel Omorobe
 */
public class Road_STUDENT_Test {
    private Town townA;
    private Town townB;
    private Town townC;
    private Road road1;
    private Road road2;
    private Road road3;

    /**
     * Sets up Town and Road objects for testing.
     */
    @Before
    public void setUp() throws Exception {
        townA = new Town("Clarksburg");
        townB = new Town("Germantown");
        townC = new Town("Olney");

        road1 = new Road(townA, townB, 5, "MD355");
        road2 = new Road(townB, townA, 5, "MD355"); // same road but reversed direction
        road3 = new Road(townA, townC, 8, "MD97");
    }

    /**
     * Tests the getName method.
     */
    @Test
    public void testGetName() {
        assertEquals("MD355", road1.getName());
    }

    /**
     * Tests the getWeight method.
     */
    @Test
    public void testGetWeight() {
        assertEquals(5, road1.getWeight());
    }

    /**
     * Tests that getSource and getDestination return the correct Towns.
     */
    @Test
    public void testGetSourceAndDestination() {
        assertEquals(townA, road1.getSource());
        assertEquals(townB, road1.getDestination());
    }

    /**
     * Tests the contains method to verify if the road includes a specific town.
     */
    @Test
    public void testContains() {
        assertTrue(road1.contains(townA)); // townA is in the road
        assertTrue(road1.contains(townB)); // townB is in the road
        assertFalse(road1.contains(townC)); // townC is not in the road
    }

    /**
     * Tests the equals method, which should consider roads undirected.
     */
    @Test
    public void testEquals() {
        assertTrue(road1.equals(road2)); // same road, reverse direction
        assertFalse(road1.equals(road3)); // different road
    }

    /**
     * Tests the compareTo method which compares roads based on their names.
     */
    @Test
    public void testCompareTo() {
        assertTrue(road1.compareTo(road3) < 0); // "MD355" < "MD97" lexicographically
    }

    /**
     * Tests the toString method for proper formatting and content.
     */
    @Test
    public void testToString() {
        assertTrue(road1.toString().contains("Clarksburg to Germantown")); // check that output is descriptive
    }
}
