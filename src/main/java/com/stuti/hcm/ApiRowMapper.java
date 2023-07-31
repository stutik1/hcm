package com.stuti.hcm;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiRowMapper implements RowMapper<ApiDetails> {
    public ApiDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        ApiDetails apiDetails = new ApiDetails();
        apiDetails.setApiId(rs.getInt("api_id"));
        apiDetails.setClientName(rs.getString("client_name"));
        apiDetails.setApiCallTime(rs.getTimestamp("api_call_time"));
        apiDetails.setIpAddress(rs.getString("ip_address"));
        return apiDetails;
    }
}
