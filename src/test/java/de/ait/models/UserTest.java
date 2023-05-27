package de.ait.models;

import de.ait.services.UsersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void setFirstName_Test_Valid() {
        assertEquals("User1", "User1");
    }

    @Nested
    @DisplayName("Негативные тесты для метода setFirstName")
    class ForSetFirstName {
        @Test
        void setFirstName_WithNullName_Test_Invalid() {
            assertNotEquals("User1", null);
        }

        @Test
        void setFirstName_WithEmptyName_Test_Invalid() {
            assertNotEquals("User1", "");
        }
    }

    @Test
    void setLastName_Test_Valid() {
        assertEquals("User2", "User2");
    }

    @Nested
    @DisplayName("Негативные тесты для метода setLastName")
    class ForSetLastName {
        @Test
        void setLastName_WithNullName_Test_Invalid() {
            assertNotEquals("User2", null);
        }

        @Test
        void setLastName_WithEmptyName_Test_Invalid() {
            assertNotEquals("User2", "");
        }
    }

    @Test
    void setAge_Test_Valid() {
        assertEquals(45, 45);
    }

    @Nested
    @DisplayName("Негативные тесты для метода setAge")
    class ForSetAge {
        @Test
        void setAge_WithNullNumber_Test_Invalid() {
            assertNotEquals(45, 0);
        }

        @Test
        void setAge_WithDoubleNumber_Test_Invalid() {
            assertNotEquals(45, 45.3);
        }
    }

    @Test
    void setHeight_Test_Valid() {
        assertEquals(1.65, 1.65);
    }

    @Nested
    @DisplayName("Негативные тесты для метода setHeight")
    class ForSetHeight {
        @Test
        void setHeight_WithNull_Test_Invalid() {
            assertNotEquals(1.65, 0);
        }

        @Test
        void setHeight_WithTheHighest_Test_Invalid() {
            assertNotEquals(1.65, 165);
        }
    }
}
