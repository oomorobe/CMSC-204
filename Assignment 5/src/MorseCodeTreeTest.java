import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Okeoghene Excel Omorobe
 */

// Unit tests for the MorseCodeTree class
public class MorseCodeTreeTest {

    private MorseCodeTree tree;

    // Set up the MorseCodeTree before each test
    @Before
    public void setUp() {
        tree = new MorseCodeTree();
    }

    // Test fetching letters from Morse code
    @Test
    public void testFetch() {
        assertEquals("e", tree.fetch("."));       // Single dot corresponds to 'e'
        assertEquals("t", tree.fetch("-"));       // Single dash corresponds to 't'
        assertEquals("s", tree.fetch("..."));     // '...' corresponds to 's'
        assertEquals("o", tree.fetch("---"));     // '---' corresponds to 'o'
        assertEquals("z", tree.fetch("--.."));    // '--..' corresponds to 'z'
    }

    // Test converting the Morse code tree to an ArrayList
    @Test
    public void testToArrayList() {
        ArrayList<String> treeList = tree.toArrayList();

        // Check for presence of specific letters
        assertTrue("Tree should contain letter e", treeList.contains("e"));
        assertTrue("Tree should contain letter t", treeList.contains("t"));

        // Ensure at least 26 letters (all letters of the alphabet) are present
        assertTrue("Tree should contain all 26 letters", treeList.size() >= 26);
    }

    // Test that delete operation is not supported
    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteUnsupported() {
        tree.delete("a");
    }

    // Test that update operation is not supported
    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateUnsupported() {
        tree.update();
    }
}
