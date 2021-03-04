package com.myclass.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	/* Cấu hình transaction tự động */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory().getObject());
		return manager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3307/crm");
		dataSource.setUsername("root");
		dataSource.setPassword("00000");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.myclass.entity"); // khai báo package chứa các entity
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", true); // hiển thị câu sql trên console
		properties.put("hibernate.format_sql", true); // format câu sql
		bean.setHibernateProperties(properties);
		return bean;
	}
	
}
