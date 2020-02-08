package com.javarestaurant.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Meal
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class Meal {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("restaurantID")
	private Integer restaurantID = null;

	@JsonProperty("img")
	private String img = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("price")
	private String price = null;

	public Meal id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Meal restaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
		return this;
	}

	/**
	 * Get restaurantID
	 *
	 * @return restaurantID
	 **/
	@ApiModelProperty(value = "")

	public Integer getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}

	public Meal img(String img) {
		this.img = img;
		return this;
	}

	/**
	 * Get img
	 *
	 * @return img
	 **/
	@ApiModelProperty(value = "")

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Meal name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 *
	 * @return name
	 **/
	@ApiModelProperty(value = "")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Meal price(String price) {
		this.price = price;
		return this;
	}

	/**
	 * Get price
	 *
	 * @return price
	 **/
	@ApiModelProperty(value = "")

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Meal meal = (Meal) o;
		return Objects.equals(this.id, meal.id) &&
			Objects.equals(this.restaurantID, meal.restaurantID) &&
			Objects.equals(this.img, meal.img) &&
			Objects.equals(this.name, meal.name) &&
			Objects.equals(this.price, meal.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, restaurantID, img, name, price);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Meal {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    restaurantID: ").append(toIndentedString(restaurantID)).append("\n");
		sb.append("    img: ").append(toIndentedString(img)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    price: ").append(toIndentedString(price)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
