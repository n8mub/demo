package com.tcs.hospitals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.tcs.hospitals")
public class SpringConfig {
	
	@Bean
	public EntityManager getEntityManger() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jcg-JPA");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}

}
