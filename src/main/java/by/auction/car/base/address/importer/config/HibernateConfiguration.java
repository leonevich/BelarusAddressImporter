package by.auction.car.base.address.importer.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.auction.car.base.address.importer")
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name = "localSessionFactory")
    public LocalSessionFactoryBean localSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(localDataSource());
        sessionFactory.setPackagesToScan("by.auction.car.base.address.importer.dao.local");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource localDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment
                .getRequiredProperty("local.jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("local.jdbc.url"));
        dataSource
                .setUsername(environment.getRequiredProperty("local.jdbc.username"));
        dataSource
                .setPassword(environment.getRequiredProperty("local.jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                environment.getRequiredProperty("local.hibernate.dialect"));
        properties.put("hibernate.show_sql",
                environment.getRequiredProperty("local.hibernate.show_sql"));
        properties.put("hibernate.format_sql",
                environment.getRequiredProperty("local.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",
                environment.getRequiredProperty("local.hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager localTransactionManager(@Qualifier("localSessionFactory") SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean(name = "removeSessionFactory")
    public LocalSessionFactoryBean removeSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(removeDataSource());
        sessionFactory.setPackagesToScan("by.auction.car.base.address.importer.dao.remove");
        sessionFactory.setHibernateProperties(removeHibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource removeDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment
                .getRequiredProperty("remove.jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("remove.jdbc.url"));
        dataSource
                .setUsername(environment.getRequiredProperty("remove.jdbc.username"));
        dataSource
                .setPassword(environment.getRequiredProperty("remove.jdbc.password"));
        return dataSource;
    }

    private Properties removeHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                environment.getRequiredProperty("remove.hibernate.dialect"));
        properties.put("hibernate.show_sql",
                environment.getRequiredProperty("remove.hibernate.show_sql"));
        properties.put("hibernate.format_sql",
                environment.getRequiredProperty("remove.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",
                environment.getRequiredProperty("remove.hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager removeTransactionManager(@Qualifier("removeSessionFactory") SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

}
