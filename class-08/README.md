# Class 8: JSON & External Libraries

Today's focus will be on bringing in external libraries, in this case to parse and write JSON. We'll also spend a bit of time talking about code design.

## Class Outline

- Announcements
- Code review
- Warmup questions
- Lecture
  - Code design
  - The `var` keyword
  - External libraries
  - Gson
  - Writing and reading JSON with Gson
- Lab intro
- Code Challenge intro

## Learning Objectives

### Students will be able to

#### Describe and Define

- The `var` keyword
- Gson
- Serialization / deserialization

#### Execute

- How to bring external libraries into a Java application
- Parsing and writing JSON in Java with Gson
- Using good code design principles
- Avoiding using overcomplicated code design principles

## Helpful Resources

- [The Gson user guide](https://github.com/google/gson/blob/master/UserGuide.md)
- [Serialization/deserialization @ Wikipedia](https://en.wikipedia.org/wiki/Serialization)
- [More about YAGNI](https://github.com/braydie/HowToBeAProgrammer/blob/master/en/2-Intermediate/Personal-Skills/05-How-to-Balance-Brevity-and-Abstraction.md)
- [Style guide for using "var"](https://openjdk.java.net/projects/amber/guides/lvti-style-guide)

## Notes

### Working With Gson

- You can add the dependency for Gson by putting this into your build.gradle:

  ```java
  dependencies {
    compile 'com.google.code.gson:gson:2.8.9'
  }
  ```

  - This may not be up-to-date with the latest version number, so double-check the latest version number [here](https://mvnrepository.com/artifact/com.google.code.gson/gson)

- Here's a sample JSON input you can use to see how Gson works:

  ```json
  {
      "firstName": "John",
      "lastName": "Smith",
      "age": 25,
      "address": {
          "streetAddress": "21 2nd Street",
          "city": "New York",
          "state": "NY",
          "postalCode": 10021
      },
      "phoneNumbers": [
          {
              "type": "home",
              "number": "212 555-1234"
          },
          {
              "type": "fax",
              "number": "646 555-4567"
          }
      ]
  }
  ```

- It corresponds to this Java class:

  ```java
  public class Contact {
    String firstName;
    String lastName;
    int age;
    Address address;
    List<PhoneNumber> phoneNumbers;

    public class Address {
      String streetAddress;
      String city;
      String state;
      String postcalCode;
    }

    public class PhoneNumber {
      String type;
      String number;
    }
  }
  ```
