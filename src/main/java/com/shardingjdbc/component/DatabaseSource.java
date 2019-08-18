package com.shardingjdbc.component;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatabaseSource {

    @Autowired
    DataSourceOne dataSourceOne;

    @Autowired
    DataSourceTwo dataSourceTwo;

    @Autowired
    DataSourceThr dataSourceThr;

    @Autowired
    private DatabaseShardingAlgorithm databaseShardingAlgorithm;

    @Autowired
    private DatabaseTableShardingAlgorithm DatabaseTableShardingAlgorithm;

    @Bean
    public DataSource dataSource() throws SQLException {
        return buildDataSource();
    }

    //暂时不考虑主从分离
    private DataSource buildDataSource() throws SQLException {

        //设置从库数据源集合
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put(dataSourceTwo.getDatabase2DatabaseName(), dataSourceTwo.createDataSource());
        dataSourceMap.put(dataSourceThr.getDatabase3DatabaseName(), dataSourceThr.createDataSource());

        //设置默认数据库:默认库+从库
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, dataSourceOne.getDatabase1DatabaseName());

        //分表设置
        TableRule userTableRules = TableRule.builder("user").actualTables(
                Arrays.asList("user_0", "user_1"))
                .dataSourceRule(dataSourceRule).build();

       /* TableRule orderTableRules = TableRule.builder("order").actualTables(
                Arrays.asList("order_0", "order_1"))
                .dataSourceRule(dataSourceRule).build();*/

        //分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(userTableRules))
                .databaseShardingStrategy(new DatabaseShardingStrategy("id", databaseShardingAlgorithm))
                .tableShardingStrategy(new TableShardingStrategy("name", DatabaseTableShardingAlgorithm))
                .build();

        //获取数据源对象
//        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource("masterSlave", database0Config.getDatabaseName()
//                , database0Config.createDataSource(), slaveDataSourceMap, MasterSlaveLoadBalanceStrategyType.getDefaultStrategyType());

        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);


        return dataSource;
    }


    /*@Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }*/


    /*@Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() throws Exception {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }*/

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        factory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] res = resolver.getResources("classpath:mapper/*.xml");
        factory.setMapperLocations(res);
        return factory.getObject();
    }


}
