package com.javarestaurant.server.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarestaurant.data.model.Address;
import com.javarestaurant.data.model.User;
import com.javarestaurant.server.api.queries.AddressQueries;
import com.javarestaurant.server.api.UserApi;
import com.javarestaurant.server.api.queries.UserQueries;
import com.javarestaurant.server.util.Authentication;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class UserApiController implements UserApi {
	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	private final AddressQueries addressQueries;
	private final UserQueries userQueries;

	@Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request, AddressQueries addressQueries, UserQueries userQueries) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.addressQueries = addressQueries;
		this.userQueries = userQueries;
	}

	public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body
	) {
		Integer rowid = userQueries.insert(body);
		if (rowid != null && rowid <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		for (Address address : body.getAddresses()) {
			if (!addressQueries.insert(address, rowid)) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username
	) {
		String token = request.getHeader("Authorization");
		String username1 = Authentication.getUsername(token);
		if (!Authentication.isLoggedIn(token) || username1 == null || !username.equals(username1)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		if (!userQueries.delete(username)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			User user = userQueries.getByName(username);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<String> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username
		, @NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			User user = userQueries.getByName(username);

			if (user == null) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

			if (!Authentication.isAuthenticated(password, user.getPassword())) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

			return new ResponseEntity<String>(Authentication.genToken(user), HttpStatus.OK);
		}

		return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> logoutUser() {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body
		, @ApiParam(value = "name that need to be updated", required = true) @PathVariable("username") String username
	) {
		String token = request.getHeader("Authorization");
		String username1 = Authentication.getUsername(token);

		if (!Authentication.isLoggedIn(token) || username1 == null || !username.equals(username1)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		if (!userQueries.update(username, body)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
