

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordChecker_GFA_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	
	@Test
	public void testIsValidPassword() {
	    try {
	        // Check if the password is valid
	        assertTrue("Expected a valid password, but it failed validation", 
	                   PasswordCheckerUtility.isValidPassword("strongPWD1#"));

	    } catch (Exception e) {
	        // If an exception is thrown, fail the test and display the exception message
	        assertTrue("Unexpected exception thrown: " + e.getMessage(), false);
	    }
	}
	}
