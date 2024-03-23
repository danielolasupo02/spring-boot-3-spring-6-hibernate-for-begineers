package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code lOL!
}
