package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.dao.AdminDAOImpl;
import com.app.dao.EmployeeDaoImpl;
import com.app.dao.HrDAOImpl;
import com.app.dao.IAdminDAO;
import com.app.dao.IEmployeeDao;
import com.app.dao.IHrDAO;
import com.app.dao.IMessageDAO;
import com.app.dao.MessageDAOImpl;
import com.app.entity.Address;
import com.app.entity.Admin;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.entity.Hr;
import com.app.entity.Message;

@Configuration
@ComponentScan("com.app")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springempmanagement");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Employee.class, Address.class, Hr.class, Admin.class, Department.class,
				Message.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "iEmployeeDao")
	public IEmployeeDao getEmployeeDao(SessionFactory sessionFactory) {
		return new EmployeeDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "iAdminDAO")
	public IAdminDAO getIAdminDAO(SessionFactory sessionFactory) {
		return new AdminDAOImpl(sessionFactory);
	}

	
	@Autowired
	@Bean(name = "iHrDAO")
	public IHrDAO gethrDAO(SessionFactory sessionFactory) {
		return new HrDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "iMessageDAO")
	public IMessageDAO getIMessageDAO(SessionFactory sessionFactory) {
		return new MessageDAOImpl(sessionFactory);
	}
}
