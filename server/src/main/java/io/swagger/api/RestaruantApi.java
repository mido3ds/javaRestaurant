/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Restaurant;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Api(value = "restaruant", description = "the restaruant API")
public interface RestaruantApi {

    @ApiOperation(value = "Create restaurant", nickname = "createRestaurant", notes = "Should only be carried by restaurant owner, and be logged in", tags={ "restaurant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "not logged in/ not restaurant owner"),
        @ApiResponse(code = 401, message = "invalid data") })
    @RequestMapping(value = "/restaruant",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createRestaurant(@ApiParam(value = "Created restaurant object" ,required=true )  @Valid @RequestBody Restaurant body
);


    @ApiOperation(value = "delete restaurant", nickname = "deleteRestaurant", notes = "This can only be done by the logged in user. and be a restaurant owner", tags={ "restaurant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 401, message = "Not logged in"),
        @ApiResponse(code = 404, message = "Restaurant not found") })
    @RequestMapping(value = "/restaruant",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRestaurant(@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
);


    @ApiOperation(value = "Get restaurant by name or byid", nickname = "getRestaurant", notes = "", response = Restaurant.class, tags={ "restaurant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Restaurant.class),
        @ApiResponse(code = 404, message = "Restaurant not found") })
    @RequestMapping(value = "/restaruant",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Restaurant> getRestaurant(@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
);


    @ApiOperation(value = "Update restaurant", nickname = "updateRestaurant", notes = "This can only be done by the logged in user. and be a restaurant owner", tags={ "restaurant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid Restaurant supplied"),
        @ApiResponse(code = 401, message = "Not logged in"),
        @ApiResponse(code = 404, message = "Restaurant not found") })
    @RequestMapping(value = "/restaruant",
        consumes = { "*/*" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRestaurant(@ApiParam(value = "Updated meal object" ,required=true )  @Valid @RequestBody Restaurant body
,@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
);

}
