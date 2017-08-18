/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.config;

import fr.imie.kitmeal.entities.Address;
import fr.imie.kitmeal.entities.Category;
import fr.imie.kitmeal.entities.Unite;
import fr.imie.kitmeal.entities.User;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Laura
 */
@Configuration
@ComponentScan("fr.imie.kitmeal")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource(value = {"classpath:application.config.properties"})
public class KitmealAppContextConfig {

    @Autowired
    private Environment environment;

    @Autowired
    @Bean(name = "sessionFactoryKitmeal")
    public SessionFactory getSessionFactoryKitmeal(DataSource dataSourceKitmeal) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceKitmeal);
        sessionBuilder.addAnnotatedClasses(User.class);
        sessionBuilder.addAnnotatedClasses(Unite.class);
        sessionBuilder.addAnnotatedClasses(Category.class);
        sessionBuilder.addAnnotatedClasses(Address.class);
        sessionBuilder.addProperties(getHibernatePropertiesKitmeal());
        return sessionBuilder.buildSessionFactory();
    }

    @Bean(name = "dataSourceKitmeal")
    public DataSource getDataSourceKitmeal() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("kitmeal.hibernate.connection.driver_class"));
        dataSource.setUrl(environment.getRequiredProperty("kitmeal.hibernate.connection.url"));
        dataSource.setUsername(environment.getRequiredProperty("kitmeal.hibernate.connection.username"));
        dataSource.setPassword(environment.getRequiredProperty("kitmeal.hibernate.connection.password"));
        return dataSource;
    }

    private Properties getHibernatePropertiesKitmeal() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("kitmeal.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("kitmeal.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("kitmeal.hibernate.format_sql"));
        properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("kitmeal.hibernate.connection.pool_size"));
        return properties;
    }

    @Autowired
    @Bean(name = "txManagerKitmeal")
    public HibernateTransactionManager txManagerKitmeal() {
        return new HibernateTransactionManager(getSessionFactoryKitmeal(getDataSourceKitmeal()));
    }

}
