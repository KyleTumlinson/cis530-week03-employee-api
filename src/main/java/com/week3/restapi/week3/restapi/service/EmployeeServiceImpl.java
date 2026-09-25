package com.week3.restapi.week3.restapi.service;

import com.week3.restapi.week3.restapi.dao.EmployeeDAO;
import com.week3.restapi.week3.restapi.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInter {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.of(employeeDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found" + id)));
    }

    @Override
    @Transactional
    public Employee update(int id, Employee employee) {
        Employee existing =  employeeDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found" + id));

        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());

        return employeeDAO.save(existing);
    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Employee found =  employeeDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found" + id));
        employeeDAO.delete(found);
    }
}
