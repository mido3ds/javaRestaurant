package com.javarestaurant.server.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantRowMapper implements RowMapper<Restaurant> {
	@Override
	public Restaurant mapRow(ResultSet resultSet, int i) throws SQLException {
		Restaurant restaurant = new Restaurant();

		restaurant.setId(resultSet.getInt("ROWID"));
		restaurant.setImg(resultSet.getString("img"));
		restaurant.setOwnerID(resultSet.getInt("ownerID"));

		return restaurant;
	}
}
