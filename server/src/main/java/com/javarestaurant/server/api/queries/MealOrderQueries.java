package com.javarestaurant.server.api.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MealOrderQueries {
	@Autowired
	JdbcTemplate jdbcTemplate;
}
