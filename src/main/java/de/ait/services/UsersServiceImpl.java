package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

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


    public Integer getAgeOfMostHeight(){

        List<User> users = usersRepository.findAll();
        Map<Double,Integer> userHeight = new HashMap<>();
        for (User user:users){
            userHeight.put(user.getHeight(), user.getAge());
        }
        double maxHeight = Collections.max(userHeight.keySet());
        return userHeight.get(maxHeight);
    }
}
