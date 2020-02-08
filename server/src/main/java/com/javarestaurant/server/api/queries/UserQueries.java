package com.javarestaurant.server.api.queries;

import com.javarestaurant.data.rowmapper.UserRowMapper;
import com.javarestaurant.data.model.User;
import com.javarestaurant.server.util.Authentication;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserQueries {
	private static final Logger log = LoggerFactory.getLogger(UserQueries.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	public User getByName(String username) {
		try {
			return jdbcTemplate.queryForObject("SELECT ROWID,* FROM User WHERE username = ?;",
				new String[]{username},
				new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * @param user
	 * @return 0 -> couldn't insert|user exists
	 * otherwise -> success and thats the ROWID of the inserted item
	 */
	public Integer insert(User user) {
		if (!(isValidEmail(user.getEmail()) && isValidUsername(user.getUsername()) &&
			isValidName(user.getFirstname()) && isValidName(user.getLastname()) &&
			isValidPhone(user.getPhone()) && isValidPassword(user.getPassword()))) {
			return 0;
		}

		user.setPassword(Authentication.hash(user.getPassword()));

		try {
			int rows = jdbcTemplate.update("INSERT INTO User VALUES(?, ?, ?, ?, ?, ?);",
				user.getEmail(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getPassword(), user.getPhone());

			if (rows != 1) {
				return 0;
			}
			return getByName(user.getUsername()).getId();
		} catch (DataAccessException e) {
			return null;
		}
	}

	private boolean isValidPassword(String password) {
		return password != null && password.length() > 10;
	}

	private boolean isValidPhone(String phone) {
		Pattern p = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
		Matcher m = p.matcher(phone);
		return (m.find() && m.group().equals(phone));
	}

	private boolean isValidName(String name) {
		return name != null && name.length() > 1;
	}

	private boolean isValidUsername(String username) {
		return username != null && username.length() > 5;
	}

	private boolean isValidEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	public boolean delete(String username) {
		return jdbcTemplate.update("DELETE FROM User WHERE username = ?;", username) == 1;
	}

	public boolean update(String username, User user) {
		ArrayList<String> params = new ArrayList<>();
		ArrayList<Object> values = new ArrayList<>();

		if (user.getEmail() != null) {
			params.add("email = ?");
			values.add(user.getEmail());
		}
		if (user.getFirstname() != null) {
			params.add("firstname = ?");
			values.add(user.getFirstname());
		}
		if (user.getLastname() != null) {
			params.add("lastname = ?");
			values.add(user.getLastname());
		}
		if (user.getPassword() != null) {
			params.add("password = ?");
			values.add(Authentication.hash(user.getPassword()));
		}
		if (user.getPhone() != null) {
			params.add("phone = ?");
			values.add(user.getPhone());
		}
		if (user.getUsername() != null) {
			params.add("username = ?");
			values.add(user.getUsername());
		}
		values.add(username);

		return jdbcTemplate.update(String.format("UPDATE User SET %s WHERE username = ?;",
			String.join(", ", params)), values.toArray()) == 1;
	}
}
