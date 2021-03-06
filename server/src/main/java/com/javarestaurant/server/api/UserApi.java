/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javarestaurant.server.api;

import com.javarestaurant.data.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Api(value = "user", description = "the user API")
public interface UserApi {

	@ApiOperation(value = "Create user", nickname = "createUser", notes = "", tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "invlaid username"),
		@ApiResponse(code = 401, message = "invalid password")})
	@RequestMapping(value = "/user",
		consumes = {"application/json"},
		method = RequestMethod.POST)
	ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body
	);


	@ApiOperation(value = "Delete user", nickname = "deleteUser", notes = "This can only be done by the logged in user.", tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "Invalid username supplied"),
		@ApiResponse(code = 404, message = "User not found")})
	@RequestMapping(value = "/user/{username}",
		method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteUser(@ApiParam(value = "The name that needs to be deleted", required = true) @PathVariable("username") String username
	);


	@ApiOperation(value = "Get user by user name", nickname = "getUserByName", notes = "", response = User.class, tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation", response = User.class),
		@ApiResponse(code = 400, message = "Invalid username supplied"),
		@ApiResponse(code = 404, message = "User not found")})
	@RequestMapping(value = "/user/{username}",
		produces = {"application/xml", "application/json"},
		method = RequestMethod.GET)
	ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathVariable("username") String username
	);


	@ApiOperation(value = "Logs user into the system", nickname = "loginUser", notes = "", response = String.class, tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation", response = String.class),
		@ApiResponse(code = 400, message = "Invalid username/password supplied")})
	@RequestMapping(value = "/user/login",
		produces = {"application/xml", "application/json"},
		method = RequestMethod.GET)
	ResponseEntity<String> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username
		, @NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password
	);


	@ApiOperation(value = "Logs out current logged in user session", nickname = "logoutUser", notes = "", tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation")})
	@RequestMapping(value = "/user/logout",
		method = RequestMethod.GET)
	ResponseEntity<Void> logoutUser();


	@ApiOperation(value = "Updated user", nickname = "updateUser", notes = "This can only be done by the logged in user.", tags = {"user",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "Invalid user supplied"),
		@ApiResponse(code = 404, message = "User not found")})
	@RequestMapping(value = "/user/{username}",
		consumes = {"*/*"},
		method = RequestMethod.PUT)
	ResponseEntity<Void> updateUser(@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body
		, @ApiParam(value = "name that need to be updated", required = true) @PathVariable("username") String username
	);

}
