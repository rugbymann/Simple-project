package de.ait.services;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    Double getAverageAge();

    Integer getAgeOfMostHeight();
    String getFirstNameAndLastNameOfLowestHeight();
}
