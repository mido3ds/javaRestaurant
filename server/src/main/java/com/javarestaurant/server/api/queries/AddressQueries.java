package com.javarestaurant.server.api.queries;

import com.javarestaurant.data.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AddressQueries {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean insert(Address address, Integer userID) {
		try {
			int rows = jdbcTemplate.update("INSERT INTO Address VALUES(?, ?, ?, ?);",
				userID, address.getCity(), address.getStreet(), address.getHousenumber());
			return rows == 1;
		} catch (DataAccessException e) {
			return false;
		}
	}
}
