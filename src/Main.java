import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        String loginInput = null;
        String passwordInput = null;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Добро пожаловать в онлайн библиотеку");
            System.out.println("Выберите соответствующий пункт меню: ");
            System.out.println("1.Войти в личный кабинет");
            System.out.println("2.Если не получается войти хакни систему");
            String input = scanner.nextLine();

            int operation = Integer.parseInt(input);
            switch (operation) {

                case 1: {
                    System.out.println("Введите логин");
                    loginInput = scanner.nextLine();
                    System.out.println("Введите пароль");
                    passwordInput = scanner.nextLine();

                    if ("end".equals(input)) {
                        System.out.println("Программа завершена!");
                        break;
                    }

                    try {
                        User user = getUserByLoginAndPassword(loginInput, passwordInput);
                        validateUser(user);
                    } catch (UserNotFoundException e) {
                        System.out.println("Пользователь " + loginInput + " не найден");

                    } catch (AccessDeniedException e) {
                        System.out.println("Ваш возраст моложе 18 лет. Доступ к системе запрещен");
                    }
                    break;

                }
                case 2: {
                    System.out.println(Arrays.toString(getUsers()));
                    break;

                }


            }
        }
    }

    public static User[] getUsers() {
        User user1 = new User("ivan", "jhon@gmail.com", "pass", 40);
        User user2 = new User("petr", "jhon@gmail.com", "pass", 30);
        User user3 = new User("nikolai", "jhon@gmail.com", "pass", 20);
        User user4 = new User("sergei", "jhon@gmail.com", "pass", 10);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {

        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin())
                    && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("прпрпрпр");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Ваш возраст моложе 18 лет. Доступ к системе запрещен");
        } else {
            getUsers();
            System.out.println("Доступ предоставлен");
        }

    }
}

