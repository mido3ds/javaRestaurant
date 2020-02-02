package com.javarestaurant.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarestaurant.server.model.User;
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
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class UserApiController implements UserApi {
	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<User>(objectMapper.readValue("{\n  \"addresses\" : [ {\n    \"city\" : \"city\",\n    \"housenumber\" : 6,\n    \"street\" : \"street\",\n    \"id\" : 0\n  }, {\n    \"city\" : \"city\",\n    \"housenumber\" : 6,\n    \"street\" : \"street\",\n    \"id\" : 0\n  } ],\n  \"firstname\" : \"firstname\",\n  \"password\" : \"password\",\n  \"phone\" : \"phone\",\n  \"isRestaurantOwner\" : true,\n  \"ownedRestaurants\" : [ {\n    \"img\" : \"img\",\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"ownerID\" : 5,\n    \"meals\" : [ {\n      \"img\" : \"img\",\n      \"price\" : \"price\",\n      \"name\" : \"name\",\n      \"id\" : 2,\n      \"restaurantID\" : 7\n    }, {\n      \"img\" : \"img\",\n      \"price\" : \"price\",\n      \"name\" : \"name\",\n      \"id\" : 2,\n      \"restaurantID\" : 7\n    } ]\n  }, {\n    \"img\" : \"img\",\n    \"name\" : \"name\",\n    \"id\" : 5,\n    \"ownerID\" : 5,\n    \"meals\" : [ {\n      \"img\" : \"img\",\n      \"price\" : \"price\",\n      \"name\" : \"name\",\n      \"id\" : 2,\n      \"restaurantID\" : 7\n    }, {\n      \"img\" : \"img\",\n      \"price\" : \"price\",\n      \"name\" : \"name\",\n      \"id\" : 2,\n      \"restaurantID\" : 7\n    } ]\n  } ],\n  \"id\" : 1,\n  \"email\" : \"email\",\n  \"lastname\" : \"lastname\",\n  \"username\" : \"username\"\n}", User.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
	}

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

	public ResponseEntity<Void> logoutUser() {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body
		, @ApiParam(value = "name that need to be updated", required = true) @PathVariable("username") String username
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}