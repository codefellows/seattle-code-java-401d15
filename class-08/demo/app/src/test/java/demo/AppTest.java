/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    // Global Scoped variables
    Gson gson;
    @Test void appHasAGreeting() {
        gson = new Gson();
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void UnicornToJsonTest() {
        // arrange
        gson = new Gson();
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Orange");
        Unicorn sut = new Unicorn(7,true,false, colors);
        // Act
        String returnString = gson.toJson(sut);
        String expectedValue = "{\"hornLength\":7,\"doesSparkle\":true,\"canFly\":false,\"colors\":[\"Red\",\"Orange\"]}";
        //Assert
        assertEquals(expectedValue, returnString);
    }
}
