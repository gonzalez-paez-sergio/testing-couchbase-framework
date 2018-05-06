package com.example.testingcouchbaseframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class TestingCouchbaseFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingCouchbaseFrameworkApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> routeAddAmType(AddAmTypeHandler addAmTypeHandler) {

		return 
				
				RouterFunctions.route(RequestPredicates.GET("/URL"), addAmTypeHandler::allOrQuery)
				.andRoute( RequestPredicates.GET("/URL/{id}"), addAmTypeHandler::get)

		;

	}
}
