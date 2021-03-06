package com.mayank.spring.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableJpaRepositories("com.mayank.spring.repo")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.mayank.spring")
//@PropertySource("classpath:database.properties")
public class AppConfiguration {
	
	//@Autowired
    //private Environment env;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");//com.mysql.jdbc.Driver
	    dataSource.setUrl("jdbc:h2:~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.mayank.spring");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	 @Bean
	    public SpringLiquibase liquibase()  {
	        SpringLiquibase liquibase = new SpringLiquibase();

	        liquibase.setDataSource(dataSource());
	        liquibase.setChangeLog("classpath:db.changelog-master.xml");

	        return liquibase;
	    }//http://www.baeldung.com/liquibase-refactor-schema-of-java-app
	
}
