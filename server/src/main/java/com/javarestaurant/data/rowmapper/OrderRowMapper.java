package com.javarestaurant.data.rowmapper;

import com.javarestaurant.data.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
	@Override
	public Order mapRow(ResultSet resultSet, int i) throws SQLException {
		Order order = new Order();

		order.setId(resultSet.getInt("ROWID"));
		order.setMealID(resultSet.getInt("mealID"));
		order.setNumItems(resultSet.getInt("numItems"));
		order.setUserID(resultSet.getInt("userID"));

		return order;
	}
}
