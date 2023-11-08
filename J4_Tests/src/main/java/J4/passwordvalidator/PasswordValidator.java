package J4.passwordvalidator;

    public class PasswordValidator {
        public boolean isPasswordValid(String password) {
            if (password == null) {
                return false;
            }
            if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?|\\\\/]+.*")) {
                return false;
            }
            return true;
        }
    }

