package com.stuti.hcm;

import java.sql.Timestamp;

public class ApiDetails {
    private int apiId;
    private String clientName;
    private String ipAddress;
    private Timestamp apiCallTime;

    public ApiDetails() {
    }

    public ApiDetails(int id, String clientName, String ipAddress, Timestamp apiCallTime) {
        this.apiId = id;
        this.clientName = clientName;
        this.ipAddress = ipAddress;
        this.apiCallTime = apiCallTime;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getApiCallTime() {
        return apiCallTime;
    }

    public void setApiCallTime(Timestamp apiCallTime) {
        this.apiCallTime = apiCallTime;
    }
}
