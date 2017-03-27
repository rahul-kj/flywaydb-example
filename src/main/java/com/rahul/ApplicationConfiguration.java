package com.rahul;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class ApplicationConfiguration {
	@Value("${database.url}")
	String databaseURL;
	@Value("${database.username}")
	String databaseUserName;
	@Value("${database.password}")
	String databasePassword;
	@Value("${database.file.locations}")
	String databaseFileLocations;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(databaseURL);
		dataSource.setUsername(databaseUserName);
		if (!StringUtils.isEmpty(databasePassword)) {
			dataSource.setPassword(databasePassword);
		}
		return dataSource;
	}

	@Bean
	public Flyway flyway(DataSource dataSource) {
		Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource);
		String locations = databaseFileLocations;
		flyway.setLocations(locations);
		return flyway;
	}
}
