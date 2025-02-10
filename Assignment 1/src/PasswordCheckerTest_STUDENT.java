
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1;
	String password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"458899Yu%", "MyToolisGR8", "m0rn?ngMEE", "Morpheu$665",
		        "ElCincodeMayo", "februarY29?", "ZYXWVUL", "Caesa&12", "u999v", "camelCharacter1%",
		        "AAAbcd56@", "myFirstName2!"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort(){
		try {
		    // First test: valid password should not throw an exception
		    assertTrue(PasswordCheckerUtility.isValidPassword("MerN1$4"));

		    // Second test: invalid short password should throw LengthException
		    PasswordCheckerUtility.isValidPassword("m4r$");

		    // If no exception is thrown, fail the test
		    assertTrue("Did not throw LengthException", false);

		} catch (LengthException e) {
		    // Expected exception caught
		    assertTrue("Successfully threw a LengthException", true);

		} catch (Exception e) {
		    // If a different exception is thrown, fail the test
		    assertTrue("Threw some other exception besides LengthException", false);
		}
	}
	
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
		    // First test: valid password should not throw an exception
		    assertTrue(PasswordCheckerUtility.isValidPassword("Morning4U$"));

		    // Second test: password without uppercase letter should throw NoUpperAlphaException
		    PasswordCheckerUtility.isValidPassword("43#886$");

		    // If no exception is thrown, fail the test
		    assertTrue("Did not throw NoUpperAlphaException", false);

		} catch (NoUpperAlphaException e) {
		    // Expected exception caught
		    assertTrue("Successfully threw a NoUpperAlphaException", true);

		} catch (Exception e) {
		    // If a different exception is thrown, fail the test
		    assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
		    // First test: valid password should not throw an exception
		    assertTrue(PasswordCheckerUtility.isValidPassword("Morning4U$"));

		    // Second test: password without lowercase letters should throw NoLowerAlphaException
		    PasswordCheckerUtility.isValidPassword("MORNINGUS");

		    // If no exception is thrown, fail the test
		    assertTrue("Did not throw NoLowerAlphaException", false);

		} catch (NoLowerAlphaException e) {
		    // Expected exception caught
		    assertTrue("Successfully threw a NoLowerAlphaException", true);

		} catch (Exception e) {
		    // If a different exception is thrown, fail the test
		    assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
		    // Test if the password is valid
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("Morning4U$"));

		    // Test if the password is weak
		    boolean weakPwd = PasswordCheckerUtility.isWeakPassword("Morn4U$");
		    assertTrue("Weak password check failed", weakPwd);

		} catch (Exception e) {
		    assertTrue("Threw an unexpected exception: " + e.getMessage(), false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
		    // Test if the password is valid
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("Morning4U$"));

		    // Test password with repeated sequence, expecting InvalidSequenceException
		    PasswordCheckerUtility.isValidPassword("Mooorning4U$");

		    // If no exception is thrown, fail the test
		    assertTrue("Did not throw an InvalidSequenceException", false);

		} catch (InvalidSequenceException e) {
		    // Expected exception caught
		    assertTrue("Successfully threw an InvalidSequenceException", true);

		} catch (Exception e) {
		    // If a different exception is thrown, fail the test with message
		    assertTrue("Threw some other exception besides an InvalidSequenceException: " + e.getMessage(), false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
		    // Test a valid password
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("Morning4U$"));

		    // Test password without a digit, expecting NoDigitException
		    PasswordCheckerUtility.isValidPassword("MooorningU");

		    // If no exception is thrown, fail the test
		    assertTrue("Did not throw a NoDigitException", false);

		} catch (NoDigitException e) {
		    // Expected exception caught
		    assertTrue("Successfully threw a NoDigitException", true);

		} catch (Exception e) {
		    // If a different exception is thrown, fail the test with message
		    assertTrue("Threw some other exception besides a NoDigitException: " + e.getMessage(), false);
		}
	}
	@Test
	public void testIsValidPasswordNoSpecialCharacter() {
	    try {
	        // Test a valid password
	        assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("Morning4U$"));

	        // Test password without a special character, expecting NoSpecialCharacterException
	        PasswordCheckerUtility.isValidPassword("Mooorning4U");

	        // If no exception is thrown, fail the test
	        assertTrue("Did not throw a NoSpecialCharacterException", false);

	    } catch (NoSpecialCharacterException e) {
	        // Expected exception caught
	        assertTrue("Successfully threw a NoSpecialCharacterException", true);

	    } catch (Exception e) {
	        // If a different exception is thrown, fail the test with message
	        assertTrue("Threw some other exception besides a NoSpecialCharacterException: " + e.getMessage(), false);
	    }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
		    // Test multiple valid passwords
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("ZZ7mnopqq?"));
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("$ubLiM3Z"));
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("M0oNc#ilD"));
		    assertTrue("Valid password check failed", PasswordCheckerUtility.isValidPassword("(Brew3rs)"));

		} catch (Exception e) {
		    // If any unexpected exception is thrown, fail the test with a message
		    assertTrue("Threw an unexpected exception: " + e.getMessage(), false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
	    ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwords);

	    // Helper method to validate each invalid password result
	    checkInvalidPasswordResult(results.get(0), "MyToolisGR8", "special");
	    checkInvalidPasswordResult(results.get(1), "be42night", "uppercase");
	    checkInvalidPasswordResult(results.get(2), "ElCincodeMayo", "digit");
	    checkInvalidPasswordResult(results.get(3), "ZYXWVUL", "lowercase");
	    checkInvalidPasswordResult(results.get(4), "u999v", "long");
	    checkInvalidPasswordResult(results.get(5), "AAAbcd56@", "same");
	}

	// Helper method to validate password error messages
	private void checkInvalidPasswordResult(String result, String expectedPassword, String expectedMessage) {
	    try (Scanner scan = new Scanner(result)) {
	        assertEquals("Expected password: " + expectedPassword, expectedPassword, scan.next());
	        
	        String nextResults = scan.nextLine().toLowerCase();
	        assertTrue("Expected message to contain: " + expectedMessage, nextResults.contains(expectedMessage));
	    }
	}
	
}
