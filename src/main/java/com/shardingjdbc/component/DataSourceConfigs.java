package com.shardingjdbc.component;

import org.springframework.beans.factory.annotation.Value;

public class DataSourceConfigs {

    @Value("${database1.url}")
    private String database1Url;

    @Value("${database1.username}")
    private String database1Username;

    @Value("${database1.password}")
    private String database1Password;

    @Value("${database1.driverClassName}")
    private String database1DriverClassName;

    @Value("${database1.databaseName}")
    private String database1DatabaseName;


    @Value("${database2.url}")
    private String database2Url;

    @Value("${database2.username}")
    private String database2Username;

    @Value("${database2.password}")
    private String database2Password;

    @Value("${database2.driverClassName}")
    private String database2DriverClassName;

    @Value("${database2.databaseName}")
    private String database2DatabaseName;


    @Value("${database3.url}")
    private String database3Url;

    @Value("${database3.username}")
    private String database3Username;

    @Value("${database3.password}")
    private String database3Password;

    @Value("${database3.driverClassName}")
    private String database3DriverClassName;

    @Value("${database3.databaseName}")
    private String database3DatabaseName;


    public String getDatabase1Url() {
        return database1Url;
    }

    public void setDatabase1Url(String database1Url) {
        this.database1Url = database1Url;
    }

    public String getDatabase1Username() {
        return database1Username;
    }

    public void setDatabase1Username(String database1Username) {
        this.database1Username = database1Username;
    }

    public String getDatabase1Password() {
        return database1Password;
    }

    public void setDatabase1Password(String database1Password) {
        this.database1Password = database1Password;
    }

    public String getDatabase1DriverClassName() {
        return database1DriverClassName;
    }

    public void setDatabase1DriverClassName(String database1DriverClassName) {
        this.database1DriverClassName = database1DriverClassName;
    }

    public String getDatabase1DatabaseName() {
        return database1DatabaseName;
    }

    public void setDatabase1DatabaseName(String database1DatabaseName) {
        this.database1DatabaseName = database1DatabaseName;
    }

    public String getDatabase2Url() {
        return database2Url;
    }

    public void setDatabase2Url(String database2Url) {
        this.database2Url = database2Url;
    }

    public String getDatabase2Username() {
        return database2Username;
    }

    public void setDatabase2Username(String database2Username) {
        this.database2Username = database2Username;
    }

    public String getDatabase2Password() {
        return database2Password;
    }

    public void setDatabase2Password(String database2Password) {
        this.database2Password = database2Password;
    }

    public String getDatabase2DriverClassName() {
        return database2DriverClassName;
    }

    public void setDatabase2DriverClassName(String database2DriverClassName) {
        this.database2DriverClassName = database2DriverClassName;
    }

    public String getDatabase2DatabaseName() {
        return database2DatabaseName;
    }

    public void setDatabase2DatabaseName(String database2DatabaseName) {
        this.database2DatabaseName = database2DatabaseName;
    }

    public String getDatabase3Url() {
        return database3Url;
    }

    public void setDatabase3Url(String database3Url) {
        this.database3Url = database3Url;
    }

    public String getDatabase3Username() {
        return database3Username;
    }

    public void setDatabase3Username(String database3Username) {
        this.database3Username = database3Username;
    }

    public String getDatabase3Password() {
        return database3Password;
    }

    public void setDatabase3Password(String database3Password) {
        this.database3Password = database3Password;
    }

    public String getDatabase3DriverClassName() {
        return database3DriverClassName;
    }

    public void setDatabase3DriverClassName(String database3DriverClassName) {
        this.database3DriverClassName = database3DriverClassName;
    }

    public String getDatabase3DatabaseName() {
        return database3DatabaseName;
    }

    public void setDatabase3DatabaseName(String database3DatabaseName) {
        this.database3DatabaseName = database3DatabaseName;
    }
}
