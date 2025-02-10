
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PasswordCheckerUtility {

  /**
   * Returns true if valid password. Throws exceptions for invalid passwords. Valid if password is
   * greater than or equal to 6 characters, has at least one digit, has at least on upper-case
   * alphabetic character, has at least on lower-case alphabetic character, and has no more than two
   * of the same character in a row.
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if valid password, set up to return false if an invalid password, but throws an
   *         exception instead.
   * @throws LengthException - thrown if length is less than 6 characters
   * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
   * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
   * @throws NoDigitException - thrown if no digit
   * @throws NoSpecialCharacterException - thrown if no special character
   * @throws InvalidSequenceException - thrown if more than 2 of same character.
   */

  public static boolean isValidPassword(String passwordString)
      throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException,
      NoSpecialCharacterException, InvalidSequenceException {
    return isLongEnough(passwordString) && hasUpperCase(passwordString)
        && hasLowerCase(passwordString) && hasDigit(passwordString)
        && hasSpecialCharacter(passwordString) && hasValidSequence(passwordString);
  }

  /**
   * Return true if length of password is greater than or equal to 6 but less than or equal to 9
   * 
   * @param passwordString - - string to be checked if weak password
   * @return true if length of password is greater than or equal to 6 but less than or equal to 9
 * @throws InvalidSequenceException 
 * @throws NoSpecialCharacterException 
 * @throws NoDigitException 
 * @throws NoLowerAlphaException 
 * @throws NoUpperAlphaException 
 * @throws LengthException 
   */
  public static boolean isWeakPassword(String passwordString) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
    return isValidPassword(passwordString) && (passwordString.length() < 10);
  }

  /**
   * Returns an arraylist of invalid passwords (weak passwords are not considered invalid)
   * 
   * @param passwords - arraylist of passwords to check for validity
   * @return arraylist of invalid passwords. It will not return weak passwords.
   */
  public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

    ArrayList<String> invalidPasswords = new ArrayList<>();
    for (String s : passwords) {
      try {
        isValidPassword(s);
      } catch (Exception ex) {
        invalidPasswords.add(s + " " + ex.getMessage());
      }
    }
    return invalidPasswords;
  }

  /**
   * Returns true if the password length is greater or equal than 6
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if length of password is greater than or equal to 6
 * @throws LengthException 
   */
  private static boolean isLongEnough(String passwordString) throws LengthException {
    if (passwordString.length() >= 6) {
      return true;
    } else {
      throw new LengthException();
    }
  }

  /**
   * Return true if password contains at least one digit and throws exception if not
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if password has at least one digit
 * @throws NoDigitException 
   */
  private static boolean hasDigit(String passwordString) throws NoDigitException {
    for (Character c : passwordString.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    throw new NoDigitException();
  }

  /**
   * Returns true if password has a lowercase character and throws exception if not.
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if password has at least one lowercase alphanumeric character
 * @throws NoLowerAlphaException 
   */
  private static boolean hasLowerCase(String passwordString) throws NoLowerAlphaException {
    for (Character c : passwordString.toCharArray()) {
      if (Character.isLowerCase(c)) {
        return true;
      }
    }
    throw new NoLowerAlphaException();
  }

  /**
   * Return true if password has at least one uppercase character and throws exception if not.
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if password has at least one uppercase alphanumeric character
 * @throws NoUpperAlphaException 
   */
  private static boolean hasUpperCase(String passwordString) throws NoUpperAlphaException {
    for (Character c : passwordString.toCharArray()) {
      if (Character.isUpperCase(c)) {
        return true;
      }
    }
    throw new NoUpperAlphaException();
  }

  /**
   * Return true if password has at least one special character (!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~) 
   * and throws exception if not.
   * 
   * @param passwordString - - string to be checked for validity
   * @return true if password has at least one special character
 * @throws NoSpecialCharacterException 
   */
  private static boolean hasSpecialCharacter(String passwordString) throws NoSpecialCharacterException {
    Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
    Matcher matcher = pattern.matcher(passwordString);
    if (!matcher.find()) {
      throw new NoSpecialCharacterException();
    }
    return true;
  }
  
  /**
   * Return true if password characters do not repeat more than 2 times in a row and throw exception
   * if a sequence of 3 repeated characters are detected.
   * 
   * @param passwordString- - string to be checked for validity
   * @return true if password characters do not repeat more than twice in a row
 * @throws InvalidSequenceException 
   */
  private static boolean hasValidSequence(String passwordString) throws InvalidSequenceException {
    for (int i = 0; i < passwordString.length() - 2; i++) {
      if (passwordString.charAt(i) == passwordString.charAt(i + 1)) {
        if (passwordString.charAt(i + 1) == passwordString.charAt(i + 2)) {
          throw new InvalidSequenceException();
        }
      }
    }
    return true;
  }

public static void comparePasswords(String password, String passwordConfirm) {
	// TODO Auto-generated method stub
	
}

public static BooleanSupplier comparePasswordsWithReturn(String password, String passwordConfirm) {
	// TODO Auto-generated method stub
	return null;
}

public static BooleanSupplier hasUpperAlpha(String string) {
	// TODO Auto-generated method stub
	return null;
}

public static void isValidLength(String password) {
	// TODO Auto-generated method stub
	
}

}



