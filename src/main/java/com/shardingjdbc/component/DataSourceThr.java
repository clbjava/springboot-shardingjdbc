package com.shardingjdbc.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceThr extends DataSourceConfigs{

    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(getDatabase2DriverClassName());
        dataSource.setUrl(getDatabase2Url());
        dataSource.setUsername(getDatabase2Username());
        dataSource.setPassword(getDatabase2Password());
        return dataSource;
    }


}
