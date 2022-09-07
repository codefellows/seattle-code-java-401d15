# Class 30: Hash Maps

Today we'll be learning your fifth data structures in Java: hash maps.

## Class Outline

- Announcements
  - Weekly feedback number 6! Please give lots of feedback!
- Code review
- Warmup questions
- Lecture
  - Data structures review
  - Hash maps visual
  - Hash maps code
- Lab intro
- Code Challenge intro

## Learning Objectives

### Students will be able to

#### Describe and Define

- Hash maps / hash tables / dictionaries / key-value stores / etc.
  - Buckets
  - Collisions
  - Separate chaining
  - Open addressing

#### Execute

- Implement hash maps, and a few common operations
- Getting more comfortable with Big O time and additional space complexity

## Helpful Resources

- [If you need a hash map that does not preserve ordering in Java, use HashMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html)
  - Seriously, don't ever depend on this ordering! It has changed between versions of Java in the past and will change between JVMs!
- [If you need a hash map that does preserve ordering in Java but is a bit slower, use LinkedHashMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedHashMap.html)
- [If you need a hash map that does not preserve ordering in Java but can be accessed by multiple threads at once, use ConcurrentHashMap](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html)
- Don't ever use Java's Hashtable or Dictionary!
  - The doc for [Hashtable](https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html) basically says to use HashMap/ConcurrentHashMap instead, and [Dictionary](https://docs.oracle.com/javase/7/docs/api/java/util/Dictionary.html) says it's "obsolete"
