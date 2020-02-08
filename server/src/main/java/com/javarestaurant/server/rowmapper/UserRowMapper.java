package com.javarestaurant.server.rowmapper;

import com.javarestaurant.server.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet resultSet, int i) throws SQLException {
		User user = new User();

		user.setId(resultSet.getInt("ROWID"));
		user.setEmail(resultSet.getString("email"));
		user.setUsername(resultSet.getString("username"));
		user.setFirstname(resultSet.getString("firstname"));
		user.setLastname(resultSet.getString("lastname"));
		user.setPassword(resultSet.getString("hashedPassword"));
		user.setPhone(resultSet.getString("phone"));

		return user;
	}
}
