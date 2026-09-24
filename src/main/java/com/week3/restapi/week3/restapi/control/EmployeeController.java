package com.week3.restapi.week3.restapi.control;

import com.week3.restapi.week3.restapi.entity.Employee;
import com.week3.restapi.week3.restapi.service.EmployeeServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceInter employeeService;

    public EmployeeController(EmployeeServiceInter employeeServiceInter) {
        this.employeeService = employeeServiceInter;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeService.create(employee);
        return ResponseEntity.created(URI.create("/employee/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }
}
