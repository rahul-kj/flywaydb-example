package com.rahul;

import java.util.Date;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MigrateScheduler {
	
	@Autowired
	Flyway flyway;

	@Scheduled(cron = "${cron.interval}")
	public void updateDB() {
		System.out.println("Invoking the scheduler " + new Date());
		flyway.migrate();
	}

}
