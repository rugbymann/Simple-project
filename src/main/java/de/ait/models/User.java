package de.ait.models;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public User(String firstName, String lastName, int age, double height) {
        // TODO: сделать проверки входных данных
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }


    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName.trim();
        } else {
            throw new IllegalArgumentException("Некорректное имя пользователя.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            throw new IllegalArgumentException("Некорректное имя пользователя.");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <=150) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Некорректный возраст.");
        }
    }

    public void setHeight(double height) {
        if (height >0 && height <=500) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Некорректный рост.");
        }
    }
    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + age + "|" + height;
    }
}
