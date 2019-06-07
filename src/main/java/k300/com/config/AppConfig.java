package k300.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("k300.com"),
		@ComponentScan("k300.com.service.impl") })
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();
		// Setting JDBC properties
		props.put(org.hibernate.cfg.Environment.DRIVER, env.getProperty("mysql.driver"));
		props.put(org.hibernate.cfg.Environment.URL, env.getProperty("mysql.url"));
		props.put(org.hibernate.cfg.Environment.USER, env.getProperty("mysql.user"));
		props.put(org.hibernate.cfg.Environment.PASS, env.getProperty("mysql.password"));

		// Setting Hibernate properties
		props.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

		// Setting C3P0 properties
		props.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		props.put(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT,
				env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		props.put(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("k300.com.entity");

		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
