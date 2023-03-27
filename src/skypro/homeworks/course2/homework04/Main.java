package skypro.homeworks.course2.homework04;

public class Main {

    private static final int LENGTH = 20;

    public static void main(String[] args) {
        String login = "java_sk98989ypro"; // должен быть равен или меньше 20 символов; содержит в себе только латинские буквы, цифры и знак подчеркивания
        String password = "D_1hWiKjjP_9"; // должен быть строго меньше 20 символов; содержит в себе только латинские буквы, цифры и знак подчеркивания.
        String confirmPassword = "D_1hWiKjjP_9";
        try {
            boolean result = checkCredentials(login, password, confirmPassword);
            System.out.println(result);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка данных авторизации завершена");
        }
    }

    private static boolean checkCredentials(String login,
                                            String password,
                                            String confirmPassword) throws WrongLoginException, WrongPasswordException {
        return checkLogin(login) && checkPassword(password, confirmPassword);
    }

    private static boolean checkPassword(String password,
                                         String confirmPassword) throws WrongPasswordException {
        if (checkLength(password, LENGTH - 1)) {
            throw new WrongPasswordException("Длина пароля должна быть меньше " + LENGTH + " символов!");
        }
        if (checkSymbols(password)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания!");
        }
        if (checkPasswordConfirmation(password, confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }

        return true;
    }

    private static boolean checkPasswordConfirmation(String password, String confirmPassword) {
        return !password.equals(confirmPassword);
    }

    private static boolean checkLogin(String login) throws WrongLoginException {
        if (checkLength(login, LENGTH)) {
            throw new WrongLoginException("Логин должен содержать не более " + LENGTH + " символов!");
        }
        if (checkSymbols(login)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания!");
        }
        return true;
    }

    private static boolean checkSymbols(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isLatinLetter(ch) && !isDigit(ch) && !isUnderscore(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLatinLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isUnderscore(char c) {
        return (c == '_');
    }

    private static boolean checkLength(String s, int length) {
        return s.length() > length;
    }
}
