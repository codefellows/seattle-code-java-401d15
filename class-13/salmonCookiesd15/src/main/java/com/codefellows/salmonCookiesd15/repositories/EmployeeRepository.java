package com.codefellows.salmonCookiesd15.repositories;

import com.codefellows.salmonCookiesd15.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // CUSTOM CRUD QUERIES

}
