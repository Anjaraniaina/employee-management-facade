package com.example.prog4.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.prog4.cnapsrepo",
        entityManagerFactoryRef = "employeeEntityManagerCnaps",
        transactionManagerRef = "employeeTransactionManagerCnaps"
)
public class EmployeeCnapsPersistenceConf {

    @Value("${DB_URL_2}")
    private String url;
    @Value("${DB_USERNAME_2}")
    private String username;
    @Value("${DB_PASSWORD_2}")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerCnaps() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource2());
        em.setPackagesToScan(
                "com.example.prog4.cnapsrepo.entity");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    @FlywayDataSource
    public Flyway flyway2() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource2())
                .locations("db/migration2") // Specify the migration scripts location
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }

    @Bean
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager employeeTransactionManagerCnaps() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                employeeEntityManagerCnaps().getObject());
        return transactionManager;
    }
}
