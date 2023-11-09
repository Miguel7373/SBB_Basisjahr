package J4.passwordvalidator;

public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        return password != null && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?|\\\\/]+.*");
    }
}

