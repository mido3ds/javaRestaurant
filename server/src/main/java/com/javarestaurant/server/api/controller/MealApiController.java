package com.javarestaurant.server.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarestaurant.data.model.Meal;
import com.javarestaurant.data.model.Order;
import com.javarestaurant.server.api.MealApi;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class MealApiController implements MealApi {
	private static final Logger log = LoggerFactory.getLogger(MealApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public MealApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> createMeal(@ApiParam(value = "Created meal object", required = true) @Valid @RequestBody Meal body
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> createOrder(@ApiParam(value = "Created order object", required = true) @Valid @RequestBody Meal body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> deleteMeal(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> deleteOrder(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
		, @ApiParam(value = "ID of order to delete") @Valid @RequestParam(value = "orderID", required = false) Integer orderID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Meal> getMeal(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Meal>(objectMapper.readValue("{\n  \"img\" : \"img\",\n  \"price\" : \"price\",\n  \"name\" : \"name\",\n  \"id\" : 2,\n  \"restaurantID\" : 7\n}", Meal.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Meal>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Meal>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Order> getOrder(@ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Order>(objectMapper.readValue("{\n  \"mealID\" : 6,\n  \"id\" : 0,\n  \"numItems\" : 1\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> updateMeal(@ApiParam(value = "Updated meal object", required = true) @Valid @RequestBody Meal body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20  
	public ResponseEntity<Void> updateOrder(@ApiParam(value = "Updated meal object", required = true) @Valid @RequestBody Order body
		, @ApiParam(value = "The name that needs to be fetched.") @Valid @RequestParam(value = "mealName", required = false) String mealName
		, @ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
		, @ApiParam(value = "ID of meal to fetch instead of name") @Valid @RequestParam(value = "mealID", required = false) Integer mealID
		, @ApiParam(value = "ID of order to fetch") @Valid @RequestParam(value = "orderID", required = false) Integer orderID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
