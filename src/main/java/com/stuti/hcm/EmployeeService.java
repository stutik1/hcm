package com.stuti.hcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long id , Employee updatedEmployee){
        Employee employee = employeeRepository.findById(id);
        if (employee != null){
            employee.setFirst_name(updatedEmployee.getFirst_name());
            employee.setLast_name(updatedEmployee.getLast_name());
            employee.setPosition(updatedEmployee.getPosition());
            employeeRepository.update(employee);
        }
        return employee;
    }

    public boolean deleteEmployee(Long id){
        return employeeRepository.delete(id);

    }
}
