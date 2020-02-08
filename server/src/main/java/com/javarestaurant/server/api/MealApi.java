/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javarestaurant.server.api;

import com.javarestaurant.data.model.Meal;
import com.javarestaurant.data.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Api(value = "meal", description = "the meal API")
public interface MealApi {

	@ApiOperation(value = "Create meal", nickname = "createMeal", notes = "Should only be carried by restaurant owner, and be logged in", tags = {"meal",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "not logged in/ not restaurant owner"),
		@ApiResponse(code = 401, message = "invalid data")})
	@RequestMapping(value = "/meal",
		consumes = {"application/json"},
		method = RequestMethod.POST)
	ResponseEntity<Void> createMeal(@ApiParam(value = "Created meal object", required = true) @Valid @RequestBody Meal body
	);


	@ApiOperation(value = "Create order", nickname = "createOrder", notes = "", tags = {"order",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "not logged in/ not restaurant owner"),
		@ApiResponse(code = 401, message = "invalid data")})
	@RequestMapping(value = "/meal/order",
		consumes = {"application/json"},
		method = RequestMethod.POST)
	ResponseEntity<Void> createOrder(@ApiParam(value = "Created order object", required = true) @Valid @RequestBody Meal body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	);


	@ApiOperation(value = "delete meal", nickname = "deleteMeal", notes = "This can only be done by the logged in user. and be a restaurant owner", tags = {"meal",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "Invalid meal supplied"),
		@ApiResponse(code = 401, message = "Not logged in"),
		@ApiResponse(code = 404, message = "Meal not found")})
	@RequestMapping(value = "/meal",
		method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteMeal(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	);


	@ApiOperation(value = "delete order", nickname = "deleteOrder", notes = "", tags = {"order",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 401, message = "Not logged in"),
		@ApiResponse(code = 404, message = "Meal not found")})
	@RequestMapping(value = "/meal/order",
		method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteOrder(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
		, @ApiParam(value = "ID of order to delete") @Valid @RequestParam(value = "orderID", required = false) Integer orderID
	);


	@ApiOperation(value = "Get meal by {meal name + restaurant name} or {meal id}", nickname = "getMeal", notes = "", response = Meal.class, tags = {"meal",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation", response = Meal.class),
		@ApiResponse(code = 404, message = "Meal not found")})
	@RequestMapping(value = "/meal",
		produces = {"application/xml", "application/json"},
		method = RequestMethod.GET)
	ResponseEntity<Meal> getMeal(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	);


	@ApiOperation(value = "Get order by {meal name + restaurant name} or {meal id}", nickname = "getOrder", notes = "", response = Order.class, tags = {"order",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation", response = Order.class),
		@ApiResponse(code = 404, message = "Order not found")})
	@RequestMapping(value = "/meal/order",
		produces = {"application/xml", "application/json"},
		method = RequestMethod.GET)
	ResponseEntity<Order> getOrder(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	);


	@ApiOperation(value = "Update meal", nickname = "updateMeal", notes = "This can only be done by the logged in user. and be a restaurant owner", tags = {"meal",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "Invalid meal supplied"),
		@ApiResponse(code = 401, message = "Not logged in"),
		@ApiResponse(code = 404, message = "Meal not found")})
	@RequestMapping(value = "/meal",
		consumes = {"*/*"},
		method = RequestMethod.PUT)
	ResponseEntity<Void> updateMeal(@ApiParam(value = "Updated meal object", required = true) @Valid @RequestBody Meal body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	);


	@ApiOperation(value = "Update meal", nickname = "updateOrder", notes = "This can only be done by the logged in user. and be a restaurant owner", tags = {"order",})
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "successful operation"),
		@ApiResponse(code = 400, message = "Invalid meal supplied"),
		@ApiResponse(code = 401, message = "Not logged in"),
		@ApiResponse(code = 404, message = "Meal not found")})
	@RequestMapping(value = "/meal/order",
		consumes = {"*/*"},
		method = RequestMethod.PUT)
	ResponseEntity<Void> updateOrder(@ApiParam(value = "Updated meal object", required = true) @Valid @RequestBody Order body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
		, @ApiParam(value = "ID of order to fetch") @Valid @RequestParam(value = "orderID", required = false) Integer orderID
	);

}
