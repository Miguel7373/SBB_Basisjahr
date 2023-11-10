package J4.passwordvalidator;


public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        return password != null && password.matches("^(?=.*[a-z]+.*)(?=.*[A-Z]+.*)(?=.*\\d+.*)(?=.*\\W.*).{8,22}$");
    }
}





//public class PasswordValidator {
//    public boolean isPasswordValid(String password) {
//        if (password == null) {
//            return false;
//        }
//
//        if (password.length() < 8) {
//            return false;
//        }
//
//        if (password.length() > 20) {
//            return false;
//        }
//
//        if (password.contains(" ")) {
//            return false;
//        }
//
//        if (!password.matches(".*\\d.*")) {
//            return false;
//        }
//
//        if (!password.matches(".*[a-z].*")) {
//            return false;
//        }
//
//        if (!password.matches(".*[A-Z].*")) {
//            return false;
//        }
//
//        if (!password.matches(".*\\W.*")){
//            return false;
//        }
//
//        return true;
//    }
//}