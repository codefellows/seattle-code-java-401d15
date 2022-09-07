# Class 18: Sanitizing User Input, And Many-To-Many Relationships

Today's focus will be on sanitizing user input data and escaping user output data to prevent malicious attacks on web apps. We'll also talk about modeling many-to-many relationships to model more complex data in our applications, like employees and managers in a business.

## Class Outline

- Announcements
- Code review
- Warmup questions
- Lecture
  - Sanitizing user input
    - SQL injection
    - XSS (cross-site scripting)
  - Good security resources
  - `@ManyToMany` data in JPA / Hibernate
- Lab intro
- Code Challenge intro

## Learning Objectives

### Students will be able to

#### Describe and Define

- SQL injection
- Prepared statements
- XSS
- Join tables
- Self-joins

#### Execute

- Create apps with complex many-to-many data relationships
- Identify security concerns with unsanitized user input
- Begin protecting their applications against malicious user input by sanitizing incoming user data, and escaping user data displayed in the app

## Helpful Resources

[The OWASP Top 10 Web Application Security Risks](https://owasp.org/www-project-top-ten/)
