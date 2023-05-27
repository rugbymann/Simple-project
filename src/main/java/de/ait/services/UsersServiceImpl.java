package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.io.IOException;
import java.util.*;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }

    @Override
    public String getLastNameOfMostAging() {

        List<User> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (User user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }

        int maxAge = Collections.max(userAge.keySet());

        return userAge.get(maxAge);
    }

    @Override
    public void saveNewUser() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя нового пользователя: ");
        String firstName = scanner.nextLine();
        if (containsNumbers(firstName)) {
            System.out.println("Некорректный ввод. Имя может состоять только из букв.");
            return;

        }

        System.out.print("Введите фамилию нового пользователя: ");
        String lastName = scanner.nextLine();
        if (containsNumbers(lastName)) {
            System.out.println("Некорректная фамилия. Фамилия может состоять только из букв.");
            return;
        }


        System.out.print("Введите возраст нового пользователя: ");
        int age = scanner.nextInt();
        if (age <= 0) {
            System.out.println("Некорректный ввод");
            return;
        }


        System.out.print("Введите рост нового пользователя: ");
        double height = scanner.nextDouble();
        if (height <= 0) {
            System.out.println("Некорректный ввод");
            return;
        }

        User newUser = new User(firstName, lastName, age, height);
        usersRepository.save(newUser);

        System.out.println("Новый пользователь сохранен.");
    }


    @Override
    public Double getAverageAge() {
        List<User> users = usersRepository.findAll();
        int totalAge = 0;
        for (User user : users) {
            totalAge += user.getAge();
        }
        return (double) totalAge / users.size();
    }

    @Override

    public Integer getAgeOfMostHeight() {

        List<User> users = usersRepository.findAll();
        Map<Double, Integer> userHeight = new HashMap<>();
        for (User user : users) {
            userHeight.put(user.getHeight(), user.getAge());
        }
        double maxHeight = Collections.max(userHeight.keySet());
        return userHeight.get(maxHeight);
    }

    @Override
    public String getFirstNameAndLastNameOfLowestHeight() {
        List<User> users = usersRepository.findAll();
        Map<Double, String> userHeight = new HashMap<>();
        for (User user : users) { // пробегаем по всему списку
            userHeight.put(user.getHeight(), user.getFirstName() + " " + user.getLastName()); // добавили пару возраст-фамилия
        }
        double minHeight = Collections.min(userHeight.keySet());

        return userHeight.get(minHeight);
    }

    public static boolean containsNumbers(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
