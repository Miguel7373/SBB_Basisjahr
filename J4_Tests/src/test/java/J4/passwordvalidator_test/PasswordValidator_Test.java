package J4.passwordvalidator_test;

import static org.junit.jupiter.api.Assertions.*;

import J4.passwordvalidator.PasswordValidator;
import org.junit.jupiter.api.Test;

public class PasswordValidator_Test {

    private PasswordValidator uut = new PasswordValidator();

    @Test
    public void testPasswordNull() {
        assertFalse(this.uut.isPasswordValid(null));
    }

    @Test
    public void testPasswordTooShort() {
        assertFalse(this.uut.isPasswordValid("1234567"));
    }
    @Test
    public void testPasswordTooLong() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRSTU"));
    }
    @Test
    public void testPasswordContainsNoSpace() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQR T"));
    }
    @Test
    public void testPasswordContainsNoNumeric() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRST"));
    }
    @Test
    public void testPasswordContainsNoLowercaseChar() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJ0123456789"));
    }
    @Test
    public void testPasswordContainsNoUppercaseChar() {
        assertFalse(this.uut.isPasswordValid("abcdefghij0123456789"));
    }
    @Test
    public void testPasswordContainsNoSpecialChar() {
        assertFalse(this.uut.isPasswordValid("abcdeFGHIJ0123456789"));
    }
    @Test
    public void testPasswordValid() {
        assertTrue(this.uut.isPasswordValid("abcdeFGHIJ01234$*%?+"));
    }
}