package com.dgarbar.footballManager.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
@EnableJpaRepositories(basePackages = "com.dgarbar.footballManager.repo")
public class JpaConfig {

	private String databaseName = "footballManagerDB";
	private String dbUrl = "jdbc:postgresql://localhost:5432/" + databaseName;
	private String containerDbUrl;
	private String username = "root";
	private String password = "root";
	private Integer port = 5432;

	@Profile("h2")
	@Bean
	public DataSource dataSourceH2() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.setName("footballManagerDB")
			.addDefaultScripts()
			.build();
	}

	@Profile("h2")
	@Bean
	public JpaVendorAdapter vendorAdapterH2() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}


	@Profile("PostgreSQLDocker")
	@Bean
	public PostgreSQLContainer postgreSQLContainer() {
		PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>()
			.withDatabaseName(databaseName)
			.withUsername(username)
			.withPassword(password)
			.withExposedPorts(port);

		postgreSQLContainer.start();
		Integer mappedPort = postgreSQLContainer.getMappedPort(port);
		containerDbUrl = dbUrl.replaceFirst("5432", String.valueOf(mappedPort));

		return postgreSQLContainer;

	}

	@Profile("PostgreSQLDocker")
	@Bean
	@DependsOn("postgreSQLContainer")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(containerDbUrl);
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		Resource initSchema = new ClassPathResource("schema.sql");
		Resource dataSchema = new ClassPathResource("data.sql");
		DatabasePopulator initSchemaPopulator = new ResourceDatabasePopulator(initSchema);
		DatabasePopulator dataSchemaPopulator = new ResourceDatabasePopulator(dataSchema);
		DatabasePopulatorUtils.execute(initSchemaPopulator, dataSource);
		DatabasePopulatorUtils.execute(dataSchemaPopulator, dataSource);

//		dataSource.setSchema("schema.sql");
//		dataSource.setSchema("data.sql");
		return dataSource;
	}


	@Profile({"PostgreSQL"})
	@Bean
	public DataSource dataSourcePostgreSql() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(dbUrl);
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		Resource initSchema = new ClassPathResource("schema.sql");
		Resource dataSchema = new ClassPathResource("data.sql");
		DatabasePopulator initSchemaPopulator = new ResourceDatabasePopulator(initSchema);
		DatabasePopulator dataSchemaPopulator = new ResourceDatabasePopulator(dataSchema);
		DatabasePopulatorUtils.execute(initSchemaPopulator, dataSource);
		DatabasePopulatorUtils.execute(dataSchemaPopulator, dataSource);

//		dataSource.setSchema("schema.sql");
//		dataSource.setSchema("data.sql");
		return dataSource;
	}


	@Profile({"PostgreSQL","PostgreSQLDocker"})
	@Bean
	public JpaVendorAdapter vendorAdapterPostgreSQL() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}


	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
		JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan("com.dgarbar.footballManager.model.entity");
		return emf;
	}


}
