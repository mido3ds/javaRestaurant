package com.javarestaurant.data.rowmapper;

import com.javarestaurant.data.model.Meal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealRowMapper implements RowMapper<Meal> {
	@Override
	public Meal mapRow(ResultSet resultSet, int i) throws SQLException {
		Meal meal = new Meal();

		meal.setId(resultSet.getInt("ROWID"));
		meal.setRestaurantID(resultSet.getInt("restaurantID"));
		meal.setImg(resultSet.getString("img"));
		meal.setName(resultSet.getString("name"));
		meal.setPrice(resultSet.getInt("price") + " EGP");

		return meal;
	}
}
