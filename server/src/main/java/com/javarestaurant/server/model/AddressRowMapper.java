package com.javarestaurant.server.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
	@Override
	public Address mapRow(ResultSet resultSet, int i) throws SQLException {
		Address address = new Address();

		address.setId(resultSet.getInt("ROWID"));
		address.setCity(resultSet.getString("city"));
		address.setUserID(resultSet.getInt("userID"));
		address.setStreet(resultSet.getString("street"));
		address.setHousenumber(resultSet.getInt("housenumber"));

		return address;
	}
}
