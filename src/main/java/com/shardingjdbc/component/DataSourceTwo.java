package com.shardingjdbc.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceTwo extends DataSourceConfigs{

    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(getDatabase3DriverClassName());
        dataSource.setUrl(getDatabase3Url());
        dataSource.setUsername(getDatabase3Username());
        dataSource.setPassword(getDatabase3Password());
        return dataSource;
    }


}
