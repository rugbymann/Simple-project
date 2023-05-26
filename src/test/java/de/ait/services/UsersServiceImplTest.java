package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UsersServiceImplTest {
    private UsersServiceImpl usersService;
    @BeforeEach
    void setUp() {
        this.usersService=new UsersServiceImpl(new UsersRepositoryListImpl());
    }

    @Test
    void getNames_Test_Valid() {
        List<String> actual=usersService.getNames();
        List<String> expected= Arrays.asList("User1","User2","User3");
        assertEquals(expected,actual);
    }
    @Test
    void getNames_Test_Invalid() {
        List<String> actual=usersService.getNames();
        List<String> expected= Arrays.asList("User1","User2");
        assertNotEquals(expected,actual);
    }

    @Test
    void getAgeOfMostHeight_Test_Valid() {

        Integer expected=30;
        Integer actual=usersService.getAgeOfMostHeight();
        assertEquals(expected,actual);
    }
    @Test
    void getAgeOfMostHeight_Test_Invalid() {

        Integer expected=25;
        Integer actual=usersService.getAgeOfMostHeight();
        // assertFalse(expected==actual);
        assertNotEquals(expected,actual);
    }

    @Test
    void getLastNameOfMostAging_Test_Valid(){
        assertEquals("User3", usersService.getLastNameOfMostAging());
    }
    @Test
    void getLastNameOfMostAging_Test_Invalid(){
        assertNotEquals("User1", usersService.getLastNameOfMostAging());
    }
    @Test
    void getAverageAge_Test_Valid(){
        //Double actual = usersService.getAveregeAge();
        //Double expected = 25.0;
        assertEquals(25.0, usersService.getAverageAge());
    }
    @Test
    void getAverageAge_Test_Invalid(){
        //Double actual = usersService.getAveregeAge();
        //Double expected = 25.0;
        assertNotEquals(156.0, usersService.getAverageAge());
    }
    @Test
    void getFirstNameAndLastNameOfLowestHeight_Test_Valid() {
        String expected= "User1 User1";
        assertEquals(expected,usersService.getFirstNameAndLastNameOfLowestHeight());
    }
    @Test
    void getFirstNameAndLastNameOfLowestHeight_Test_Invalid() {
        String expected= "User2 User1";
        assertNotEquals(expected,usersService.getFirstNameAndLastNameOfLowestHeight());
    }
}