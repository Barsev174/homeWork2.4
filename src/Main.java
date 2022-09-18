import exception.WrongLoginException;
import exception.WrongPasswordException.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login = "java_skypro.go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        System.out.println(checkInputParameter(login, password, confirmPassword));


    }

    public static boolean checkInputParameter(String login, String password, String confirmPassword) {
        try {
            boolean checkSymbolLogin = checkSymbol(login);
            boolean checkLengthLogin = checkLengthLogin(login);
            boolean checkSymbolPassword = checkSymbol(password);
            boolean checkLengthPassword = checkLengthPassword(password);
            boolean checkConfirmPassword = checkConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkSymbol(String str) {
        if (str == null) {
            throw new NullPointerException("Отсутствует параметр");
        }
        if (str.matches("\\w+")) {
            return true;
        }
        System.out.println("Логин и пароль должны содержать в себе только латинские буквы, цифры и знак подчеркивания");
        return false;
    }

    public static boolean checkLengthLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть короче 20 символов");
        }
        return true;
    }

    public static boolean checkLengthPassword(String password) {
        if (password.length() >= 20) {
            System.out.println("Пароль должен быть короче 20 символов");
            return false;
        }
        return true;
    }

    public static boolean checkConfirmPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (confirmPassword.equals(password)) return true;
        throw new WrongPasswordException("Пароль не совпадают");
    }
}
