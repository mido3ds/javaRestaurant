package io.swagger.api;

import io.swagger.model.Restaurant;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
@Controller
public class RestaruantApiController implements RestaruantApi {

    private static final Logger log = LoggerFactory.getLogger(RestaruantApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RestaruantApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createRestaurant(@ApiParam(value = "Created restaurant object" ,required=true )  @Valid @RequestBody Restaurant body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteRestaurant(@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Restaurant> getRestaurant(@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Restaurant>(objectMapper.readValue("{\n  \"img\" : \"img\",\n  \"name\" : \"name\",\n  \"id\" : 5,\n  \"ownerID\" : 5,\n  \"meals\" : [ {\n    \"img\" : \"img\",\n    \"price\" : \"price\",\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"restaurantID\" : 7\n  }, {\n    \"img\" : \"img\",\n    \"price\" : \"price\",\n    \"name\" : \"name\",\n    \"id\" : 2,\n    \"restaurantID\" : 7\n  } ]\n}", Restaurant.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Restaurant>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateRestaurant(@ApiParam(value = "Updated meal object" ,required=true )  @Valid @RequestBody Restaurant body
,@ApiParam(value = "name of restaurant that serves that meal") @Valid @RequestParam(value = "restaurantName", required = false) String restaurantName
,@ApiParam(value = "") @Valid @RequestParam(value = "restaurantID", required = false) Integer restaurantID
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
