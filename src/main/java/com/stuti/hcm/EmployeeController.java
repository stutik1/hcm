package com.stuti.hcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {
    private final EmployeeService employeeService;
    private final ApiService apiService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,ApiService apiService) {
        this.employeeService = employeeService;
        this.apiService=apiService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        String clientName="test";
        Employee employee = employeeService.getEmployeeById(id);
        ApiDetails apiDetails=new ApiDetails(0,clientName,"10.10.10.10",new Timestamp(System.currentTimeMillis()));
        ApiDetails apiDetailsResult=apiService.saveApiDetails(apiDetails);
        System.out.println("Client Name "+apiDetailsResult.getClientName()+" Time "+apiDetailsResult.getApiCallTime()
        +" API ID  "+apiDetailsResult.getApiId());
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.updateEmployee(id, updatedEmployee);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok("Successfully Deleted: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
