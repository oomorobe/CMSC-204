
// Imports
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTest {
	// Variables
	GradeBook g1, g2;
	
	@Before
	public void setUp() throws Exception {
		// Initialize Variables
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);	
		
		
		g1.addScore(50);
		g1.addScore(75);
		g2.addScore(10);
		g2.addScore(30);
	
	}

	@After
	public void tearDown() throws Exception {
		g1 = g2 = null;
	}
	
	@Test
	public void testAddScore()
	{
		assertTrue((g1.toString()).equals("50.0 75.0"));
		assertTrue((g2.toString()).equals("10.0 30.0"));
		
		assertEquals(2, g1.getScoresSize());
		assertEquals(2, g2.getScoresSize());
	}
	
	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testSum() {
		equals(125.0 , g1.sum());
		equals(40.0 , g2.sum());
	}

	private void equals(double d, double sum) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testMinimum() {
		equals(50.0 , g1.minimum());
		equals(10.0 , g2.minimum());
	}

	@Test
	public void testFinalScore() {
		assertTrue(75.0 , g1.finalScore());
		assertTrue(30.0 , g2.finalScore());	
	}

	private void assertTrue(double d, double finalScore) {
		// TODO Auto-generated method stub
		
	}

}
