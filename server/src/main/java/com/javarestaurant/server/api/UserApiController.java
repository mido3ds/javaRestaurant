package com.javarestaurant.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarestaurant.server.model.Address;
import com.javarestaurant.server.model.User;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class UserApiController implements UserApi {
	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	private JdbcTemplate jdbcTemplate;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request, JdbcTemplate jdbcTemplate) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.jdbcTemplate = jdbcTemplate;
	}

	public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body
	) {
		Integer rowid = User.insert(body, jdbcTemplate);
		if (rowid != null && rowid <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		for (Address address : body.getAddresses()) {
			if (!Address.insert(address, rowid, jdbcTemplate)) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username
	) {
		if (!User.delete(username, jdbcTemplate)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			User user = User.getByName(username, jdbcTemplate);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20 add authentication
	public ResponseEntity<String> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username
		, @NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<String>(objectMapper.readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20 add authentication
	public ResponseEntity<Void> logoutUser() {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body
		, @ApiParam(value = "name that need to be updated", required = true) @PathVariable("username") String username
	) {
		if (!User.update(username, body, jdbcTemplate)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
