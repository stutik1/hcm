package com.stuti.hcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApiRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ApiRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public ApiDetails save(ApiDetails apiDetails) {
        String apiMetricInsertSql = "INSERT INTO api_matric(client_name, api_call_time , ip_address) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                apiMetricInsertSql,
                apiDetails.getClientName(),
                apiDetails.getApiCallTime(),
                apiDetails.getIpAddress()
        );
        return apiDetails;
    }

    public ApiDetails findAll() {
        String apiMetricInsertSql = "SELECT * FROM api_matric";
        return (ApiDetails) jdbcTemplate.query(apiMetricInsertSql,new ApiRowMapper());
    }

}
