package com.merkol.springboot.cruddemo.dao;

import com.merkol.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

// default path değiştirme
//@RepositoryRestResource(path = "members") default olarak jparepo employee için sonuna s takısı getirerek path belirler bu örnekte 'employees'
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    // no need to write any code.. CRUD
}
