import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student test file for CourseDBManager.
 * This class contains unit tests that verify the functionality
 * of adding, retrieving, displaying, and reading course data.
 */
public class CourseDBManager_STUDENT_Test {

    // The CourseDBManager being tested
    private CourseDBManagerInterface manager;

    /**
     * Sets up a fresh instance of CourseDBManager before each test.
     */
    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    /**
     * Cleans up after each test by setting the manager to null.
     */
    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    /**
     * Tests adding courses and retrieving them by CRN.
     * Verifies that course data is correctly stored and accessible.
     */
    @Test
    public void testAddAndGet() {
        manager.add("CMSC101", 11111, 3, "SC101", "Dr. A");
        manager.add("CMSC102", 22222, 4, "SC102", "Dr. B");

        CourseDBElement c1 = manager.get(11111);
        CourseDBElement c2 = manager.get(22222);

        // Check that the first course was stored and retrieved correctly
        assertNotNull(c1);
        assertEquals("CMSC101", c1.getID());
        assertEquals(3, c1.getCredits());

        // Check the second course
        assertNotNull(c2);
        assertEquals("SC102", c2.getRoomNum());
    }

    /**
     * Tests the showAll method to verify it returns all added courses.
     */
    @Test
    public void testShowAll() {
        manager.add("CMSC103", 33333, 4, "DL100", "Dr. C");
        manager.add("CMSC104", 44444, 3, "DL200", "Dr. D");

        ArrayList<String> list = manager.showAll();

        // Confirm there are exactly 2 entries
        assertEquals(2, list.size());

        // Verify each course is represented in the list (order may vary)
        assertTrue(list.get(0).contains("CMSC103") || list.get(1).contains("CMSC103"));
        assertTrue(list.get(0).contains("CMSC104") || list.get(1).contains("CMSC104"));
    }

    /**
     * Tests the readFile method to ensure data can be read from a file
     * and stored correctly into the structure.
     */
    @Test
    public void testReadFile() throws Exception {
        // Create a temporary test file with course data
        File testFile = new File("student_test.txt");
        PrintWriter writer = new PrintWriter(testFile);
        writer.println("CMSC201 55555 4 SC301 Prof. X");
        writer.println("CMSC202 66666 3 SC302 Prof. Y");
        writer.close();

        // Read the file and load courses
        manager.readFile(testFile);

        // Verify that the courses were loaded and data is correct
        assertEquals("CMSC201", manager.get(55555).getID());
        assertEquals("SC302", manager.get(66666).getRoomNum());
    }

    /**
     * Tests the behavior when attempting to get a course with a CRN
     * that does not exist in the system.
     */
    @Test
    public void testGetInvalidCRN() {
        manager.add("CMSC203", 77777, 4, "HT100", "Prof. Z");

        // Attempt to retrieve a course that was never added
        CourseDBElement result = manager.get(99999);

        // Expect null result for non-existent CRN
        assertNull(result);
    }
}
