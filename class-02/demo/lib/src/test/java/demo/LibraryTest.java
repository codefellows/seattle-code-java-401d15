/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void someLibraryMethodReturnsTrue() {
        // Object instantiation
        //Arrange
        Library classUnderTest = new Library();
        //Act-Assert
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
    @Test void someRandomTest(){
        // sut = system under test
//        Library sut = new Library();
        assertEquals(7,7);
    }
    @Test void thisIsAnEmptyTest(){

    }

    @Test void testReverseArray(){
        // Arrange
        String[] animals = {"Cat", "Dog"};
        // Act
        String[] reversedAnimals = Library.reverse(animals);
        // dog is the first item
        // Cat is the 2nd
        // size is 2

        //Assert
        assertTrue(("Dog" == reversedAnimals[0]));
        assertFalse(("Dog" != reversedAnimals[0]));
        assertEquals("Dog", reversedAnimals[0]);
        assertEquals(animals[1], reversedAnimals[0]);

    }
    @Test void testReverseArrayList(){
        //Arrange
       ArrayList<String> animals = new ArrayList<>();
       animals.add("Cat");
       animals.add("Dog");
       // Act
        ArrayList<String> reversedAnimals = Library.reverse(animals);
        // Dog should be 1st item
        //Cat should be 2nd item
        //Size is 2
        assertEquals(2, reversedAnimals.size());

    }

}
