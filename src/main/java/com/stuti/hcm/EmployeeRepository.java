package com.stuti.hcm;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
        //TODO: why ???
        String sql = "INSERT INTO employee (first_name, last_name, position) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getPosition()
        );
        return employee;
    }
    public Employee findById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public void update(Employee employee) {
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, position = ? WHERE id = ?";
        int r=jdbcTemplate.update(
                sql,
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getPosition(),
                employee.getId()
        );
        return ;
    }
    public boolean delete(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        int r=jdbcTemplate.update(sql, id);
        if(r==1){
            return true;
        }
        return false;
    }
}
