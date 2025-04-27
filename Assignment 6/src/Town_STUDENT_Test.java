import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the Town class.
 * Tests getter, equality, comparison, string representation, and hash code.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class Town_STUDENT_Test {
    private Town town1;
    private Town town2;
    private Town town3;

    /**
     * Sets up the test environment by creating Town objects.
     * town1 and town3 have the same name to test equality.
     */
    @Before
    public void setUp() throws Exception {
        town1 = new Town("Frederick");
        town2 = new Town("Rockville");
        town3 = new Town("Frederick"); // same name as town1 for equality test
    }

    /**
     * Test that getName returns the correct name.
     */
    @Test
    public void testGetName() {
        assertEquals("Frederick", town1.getName());
    }

    /**
     * Test the equals method.
     * Two towns with the same name should be equal.
     * Two towns with different names should not be equal.
     */
    @Test
    public void testEquals() {
        assertTrue(town1.equals(town3)); // same name
        assertFalse(town1.equals(town2)); // different name
    }

    /**
     * Test the compareTo method.
     * Should return a negative value if town1 is lexicographically before town2,
     * and 0 if names are equal.
     */
    @Test
    public void testCompareTo() {
        assertTrue(town1.compareTo(town2) < 0); // "Frederick" < "Rockville"
        assertEquals(0, town1.compareTo(town3)); // same name
    }

    /**
     * Test the toString method.
     * Should return the town name.
     */
    @Test
    public void testToString() {
        assertEquals("Frederick", town1.toString());
    }

    /**
     * Test the hashCode method.
     * Towns with the same name should have the same hash code.
     */
    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), town3.hashCode());
    }
}
