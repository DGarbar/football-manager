package com.dgarbar.footballManager.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "com.dgarbar.footballManager.repo")
public class JpaConfig {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.setName("footballManagerDB")
			.addDefaultScripts()
			.build();
	}

	@Bean
	public JpaVendorAdapter vendorAdapter(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}

	@Bean("entityManagerFactory")
	public EntityManagerFactoryInfo entityManagerFactory(JpaVendorAdapter jpaVendorAdapter, DataSource dataSource){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan("com.dgarbar.footballManager.model.entity");
		return emf;
	}
}
