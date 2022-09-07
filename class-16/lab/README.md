# CodeFellowship Login

## Overview
For most of your remaining labs before the midterm project, you'll create an app called CodeFellowship that allows people learning to code to connect with each other and support each other on their coding journeys.

## Setup
Create a new repo `codefellowship` to hold your work for the last 3 Spring labs. Use the Spring Initializr to set up an app with dependencies on Web, Thymeleaf, JPA, Postgres, and Security (and optionally DevTools for auto refresh of app on building). Remember to do your initial commit on the main branch before creating your feature branch. Also, see the below note about configuring Spring Security.

## Resources
- [Spring Security cheat sheet](../../SpringSecurityCheatSheet.md)

## Feature Tasks
Build an app that allows users to log into `CodeFellowship`.

- The site should have a login page.
    - The login page should have a link to a signup page.
- An `ApplicationUser` should have a `username`, `password` (will be hashed using BCrypt), `firstName`, `lastName`, `dateOfBirth`, `bio`, and any other fields you think are useful.
    - All of these fields must be set at signup. They will not be editable at any other time.
- The site should allow users to create an `ApplicationUser` on the "sign up" page.
    - Your Controller should have an `@Autowired private PasswordEncoder passwordEncoder; ` and use that to run `passwordEncoder.encode(password)` before saving the password into the new user.
- Using the cheat sheet above in "Resources", add the ability for users to log in to your app.
- The site should have a homepage at the root route (`/`) that contains basic information about the site.
    - This page should have links to login and signup if the user is NOT logged in.
    - This page should have a link to logout if the user IS logged in.
- Ensure that users can log out and are redirected to the home page or login page.
- When a user is logged in, the app should display the user's username on every page (probably in the heading).
- Ensure that your homepage, login, and registration routes are accessible to non-logged in users.
- The site should be well-styled and attractive.
- The site should use templates to display its information.
- Ensure that user registration also logs users into your app automatically.

## IMPORTANT: A basic WebSecurityConfig file

To correctly configure Spring Security, please copy-paste this entire code snippet into a file called `WebSecurityConfig.java`:

```java
// TODO: put your package name here

import com.mycode.securedemo.appuser.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .cors().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
            .and()
                .logout();
                .logoutSuccessUrl("/login");
    }
}
```

## Submission Instructions
* Work on a non-master branch and make commits appropriately.
* Ensure that you can run a single Gradle command to launch your server. Include that command, as well as a description of the project and the state of each of the feature tasks, in a README.md file.
* Create a pull request to your master branch with your work for this lab.
* Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.

## Grading Rubric

- 1pt / README
- 1pt / Controllers and routes
- 1pt / Signup and login (and signup automatically logs the user in)
- 1pt / Homepage, login, and registration routes are accessible to non-logged in users
- 1pt / Proper password hashing
- 1pt / Logout
