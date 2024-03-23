package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeDaoJPAImpl implements EmployeeDAO {

    // define field for entity manager
    EntityManager entityManager;



    // set up constructor injection
    @Autowired
    public EmployeDaoJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(theEmployee);
    }


}
