package com.example.Java2_14.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydatabase");
        config.setUsername("myuser");
        config.setPassword("mypassword");
        return new HikariDataSource(config);
    }
    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.example.Java2_14");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.hbm2ddl", "update");
        properties.setProperty("hibernate.ddl-auto", "update");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }
    /*
    @Bean
    public PlatformTransactionManager
    platformTransactionManager(LocalSessionFactoryBean factoryBean){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }*/
    @Bean
    public JpaTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
