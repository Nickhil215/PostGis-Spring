package com.postgresql.postgresql.demo;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PostgresqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlDemoApplication.class, args);
	}
	@Bean
	public JtsModule jtsModule() {
		return new JtsModule();
	}

}
