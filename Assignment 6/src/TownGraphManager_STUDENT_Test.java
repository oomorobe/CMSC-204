import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * JUnit test class for TownGraphManager.
 * Tests adding towns and roads, retrieving paths, and deleting elements from the graph.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class TownGraphManager_STUDENT_Test {
    private TownGraphManager manager;

    /**
     * Sets up the test environment with 4 towns and 3 connecting roads:
     * Boyds --5--> Poolesville --3--> Darnestown --4--> Potomac
     */
    @Before
    public void setUp() throws Exception {
        manager = new TownGraphManager();

        // Add towns
        manager.addTown("Boyds");
        manager.addTown("Poolesville");
        manager.addTown("Darnestown");
        manager.addTown("Potomac");

        // Add roads between towns
        manager.addRoad("Boyds", "Poolesville", 5, "MD117");
        manager.addRoad("Poolesville", "Darnestown", 3, "MD28");
        manager.addRoad("Darnestown", "Potomac", 4, "MD190");
    }

    /**
     * Test that towns and roads are successfully added and recognized.
     */
    @Test
    public void testAddTownAndRoad() {
        assertTrue(manager.containsTown("Boyds"));
        assertTrue(manager.containsRoadConnection("Boyds", "Poolesville"));
    }

    /**
     * Test getting the name of a road between two towns.
     */
    @Test
    public void testGetRoad() {
        String road = manager.getRoad("Boyds", "Poolesville");
        assertEquals("MD117", road);
    }

    /**
     * Test that all towns are returned in sorted (alphabetical) order.
     */
    @Test
    public void testAllTownsSorted() {
        ArrayList<String> towns = manager.allTowns();
        assertEquals("Boyds", towns.get(0)); // alphabetically first
        assertEquals(4, towns.size()); // total towns
    }

    /**
     * Test that all roads are returned in sorted (alphabetical) order.
     */
    @Test
    public void testAllRoadsSorted() {
        ArrayList<String> roads = manager.allRoads();
        assertEquals("MD117", roads.get(0)); // alphabetically first
        assertEquals(3, roads.size()); // total roads
    }

    /**
     * Test getting the shortest path from Boyds to Potomac.
     * Expected path is:
     * Boyds -> Poolesville -> Darnestown -> Potomac
     */
    @Test
    public void testGetPath() {
        ArrayList<String> path = manager.getPath("Boyds", "Potomac");
        assertEquals(3, path.size());
        assertEquals("Boyds via MD117 to Poolesville 5 mi", path.get(0));
        assertEquals("Poolesville via MD28 to Darnestown 3 mi", path.get(1));
        assertEquals("Darnestown via MD190 to Potomac 4 mi", path.get(2));
    }

    /**
     * Test deleting a road connection and a town, and ensuring they're removed from the graph.
     */
    @Test
    public void testDeleteRoadAndTown() {
        assertTrue(manager.deleteRoadConnection("Darnestown", "Potomac", "MD190"));
        assertFalse(manager.containsRoadConnection("Darnestown", "Potomac")); // should be gone

        assertTrue(manager.deleteTown("Potomac"));
        assertFalse(manager.containsTown("Potomac")); // should no longer exist
    }
}
