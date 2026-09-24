package com.week3.restapi.week3.restapi.service;

import com.week3.restapi.week3.restapi.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInter {
    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee create(Employee employee);
    Employee update(int id, Employee employee);
    void deleteById(int id);
}
