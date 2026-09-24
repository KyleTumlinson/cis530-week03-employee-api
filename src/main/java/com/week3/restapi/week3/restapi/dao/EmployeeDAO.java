package com.week3.restapi.week3.restapi.dao;

import com.week3.restapi.week3.restapi.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee save(Employee employee);
    void delete(Employee employee);
}
