/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.imie.kitmeal.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
//@PropertySource(value = { "classpath:application.config.properties" })
public class KitmealAppContextConfig {
    
	@Autowired
        private Environment environment;
	
	@Autowired
	@Bean(name = "sessionFactoryKitmeal")
	public SessionFactory getSessionFactoryKitmeal(DataSource dataSourceKitmeal) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSourceKitmeal);
		//essionBuilder.addAnnotatedClasses(IconesByUser.class);
		//sessionBuilder.addProperties(getHibernatePropertiesNewPortal());
		return sessionBuilder.buildSessionFactory();
	}
	
	@Bean(name = "dataSourceKitmeal")
	public DataSource getDataSourceKitmeal() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("com.mysql.jdbc.Driver"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc:mysql://localhost/kitmeal/"));
		dataSource.setUsername(environment.getRequiredProperty("root"));
		dataSource.setPassword(environment.getRequiredProperty(""));
		return dataSource;
	}
	
	private Properties getHibernatePropertiesKitmeal() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("org.hibernate.dialect.MySQLDialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("true"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("true"));
		properties.put("hibernate.connection.pool_size", environment.getRequiredProperty("1"));
		return properties;        
	}
	
	@Autowired
	@Bean(name="txManagerKitmeal")
        public HibernateTransactionManager txManagerKitmeal() {
            return new HibernateTransactionManager(getSessionFactoryKitmeal(getDataSourceKitmeal()));
        }	
	
	
}
