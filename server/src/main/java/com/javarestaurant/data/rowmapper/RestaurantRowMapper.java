package com.javarestaurant.data.rowmapper;

import com.javarestaurant.data.model.Restaurant;
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
