package de.ait.services;

import java.io.IOException;
import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();
    void saveNewUser() throws IOException;

    Double getAverageAge();

    Integer getAgeOfMostHeight();
    String getFirstNameAndLastNameOfLowestHeight();
}
