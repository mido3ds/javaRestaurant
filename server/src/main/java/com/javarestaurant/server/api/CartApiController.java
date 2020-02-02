package com.javarestaurant.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarestaurant.server.model.Order;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class CartApiController implements CartApi {

	private static final Logger log = LoggerFactory.getLogger(CartApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public CartApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	// TODO: 2/2/20
	public ResponseEntity<Void> confirmCart(@ApiParam(value = "") @Valid @RequestParam(value = "addressID", required = false) Integer addressID
	) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20
	public ResponseEntity<Void> deleteCart() {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	// TODO: 2/2/20
	public ResponseEntity<List<Order>> getCart() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Order>>(objectMapper.readValue("[ {\n  \"mealID\" : 6,\n  \"id\" : 0,\n  \"numItems\" : 1\n}, {\n  \"mealID\" : 6,\n  \"id\" : 0,\n  \"numItems\" : 1\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Order>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Order>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
