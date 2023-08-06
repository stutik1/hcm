package com.stuti.hcm;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static Logger log = LogManager.getLogger(EmployeeRepository.class);
    private Employee employee;

    @Autowired
    public EmployeeRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
         //StringBuilder sql = new StringBuilder ("INSERT INTO employee (first_name, last_name, position) VALUES (?, ?, ?)");
        StringBuilder sql = new StringBuilder("INSERT INTO employee (first_name, last_name, position) VALUES (:first_name, :last_name, :position)");

        Map<String ,Object> bindParamMap = new HashMap<>();

        bindParamMap.put("first_name", employee.getFirst_name());
        bindParamMap.put("last_name", employee.getLast_name());
        bindParamMap.put("position", employee.getPosition());

        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValues(bindParamMap);

        log.info("SQL :"+sql.toString()+ " BIND VALUE "+bindParamMap);

        int r = jdbcTemplate.update(sql.toString(),namedParameters);
        System.out.println("Result :"+r);
        return employee;
    }

    public Employee findById(Long id) {
        //String sql = "SELECT * FROM employee WHERE id = ?";
        StringBuilder sql = new StringBuilder("SELECT * FROM employee WHERE id = :id");

        Map<String ,Object> bindParamMap = new HashMap<>();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValues(bindParamMap);
        namedParameters.addValue("id", id);
        log.info("SQL :"+sql.toString()+ " BIND VALUE "+namedParameters.getValues());
        Employee employee = jdbcTemplate.queryForObject(sql.toString(), namedParameters, new EmployeeRowMapper());
        log.info("Employee :"+employee.toString());
        return employee;

       //jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public void update(Employee employee) {
        StringBuilder sql = new StringBuilder("UPDATE employee SET ");

        Map<String,Object> bindParamMap=new HashMap<>();
        if(employee.getFirst_name()!=null){
            sql.append("first_name = :first_name,");
            bindParamMap.put("first_name",employee.getFirst_name());
        }
        if(employee.getLast_name()!=null){
            sql.append(" last_name = :last_name,");
            bindParamMap.put("last_name",employee.getLast_name());
        }
        if(employee.getPosition()!=null){
            sql.append(" position = :position");
            bindParamMap.put("position",employee.getPosition());
        }

        if(sql.charAt(sql.length()-1)==','){
         sql.setCharAt(sql.length()-1,' ');
        }
        sql.append(" WHERE id = :empId");
        bindParamMap.put("empId",employee.getId());
        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValues(bindParamMap);

        log.info("SQL :"+sql.toString()+ " BIND VALUE "+bindParamMap);

        int r = jdbcTemplate.update(sql.toString(),namedParameters);
        System.out.println("Result :"+r);
        return;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM employee WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

        int r =jdbcTemplate.update(sql, namedParameters);
        if (r == 1) {
            return true;
        }
        return false;
    }
}
