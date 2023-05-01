public class Main {

    private static final String rightLength = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        try {
            authorization("login", "987!", "987");
            System.out.println("Авторизация успешна!");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Неудача. Попробуйте ещё раз");
        }
    }

    private static void authorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if ((!login.matches(rightLength)) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if ((!password.matches(rightLength)) || password.length() > 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}