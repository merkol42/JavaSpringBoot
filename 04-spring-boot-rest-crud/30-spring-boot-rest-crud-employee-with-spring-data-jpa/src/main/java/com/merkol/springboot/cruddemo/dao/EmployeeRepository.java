package com.merkol.springboot.cruddemo.dao;

import com.merkol.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    // no need to write any code.. CRUD
}
