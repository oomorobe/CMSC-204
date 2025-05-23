import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
	public Double one = 1.0, two = 2.0, three = 3.0, four = 4.0, five = 5.0, six = 6.0;
	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		 doubleQ = new MyQueue<Double>(5);
		    doubleQ.enqueue(one);
		    doubleQ.enqueue(two);
		    doubleQ.enqueue(three);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() throws Exception {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
		catch (QueueUnderflowException e) {
			assertTrue(true, "This should have caused an QueenUnderflowException");
		}
		catch(Exception e) {
			assertTrue(false, "This should have caused an QueenUnderflowException");
		}
		
			
			
	}
	
	@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		try {
		      assertEquals(one, doubleQ.dequeue());
		      assertEquals(two, doubleQ.dequeue());
		      assertEquals(three, doubleQ.dequeue());
		      // Queue is empty, next statement should cause QueueUnderFlowException
		      doubleQ.dequeue();
		      assertTrue("This should have caused an QueueUnderflowException", false);
		    } catch (QueueUnderflowException e) {
		      assertTrue("This should have caused an QueueUnderflowException", true);
		    } catch (Exception e) {
		      assertTrue("This should have caused an QueueUnderflowException", false);
		    }
	}

	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
		catch (QueueOverflowException e){
			assertTrue(true, "This should have caused an QueueOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
	}

	@Test
	public void testEnqueueStudent() {
		//Use the doubleQ for student tests
		 try {
		      assertEquals(3, doubleQ.size());
		      assertEquals(true, doubleQ.enqueue(four));
		      assertEquals(4, doubleQ.size());
		      assertEquals(true, doubleQ.enqueue(five));
		      assertEquals(5, doubleQ.size());
		      // Queue is full, next statement should cause QueueOverFlowException
		      doubleQ.enqueue(six);
		      assertTrue("This should have caused an QueueOverflowException", false);
		    } catch (QueueOverflowException e) {
		      assertTrue("This should have caused an QueueOverflowException", true);
		    } catch (Exception e) {
		      assertTrue("This should have caused an QueueOverflowException", false);
		    }
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
		assertEquals("1.02.03.0", doubleQ.toString());
	    doubleQ.enqueue(four);
	    assertEquals("1.02.03.04.0", doubleQ.toString());
	    doubleQ.enqueue(five);
	    assertEquals("1.02.03.04.05.0", doubleQ.toString());
	}

	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
