package com.shardingjdbc.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceOne extends DataSourceConfigs{

    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(getDatabase1DriverClassName());
        dataSource.setUrl(getDatabase1Url());
        dataSource.setUsername(getDatabase1Username());
        dataSource.setPassword(getDatabase1Password());
        return dataSource;
    }


}
