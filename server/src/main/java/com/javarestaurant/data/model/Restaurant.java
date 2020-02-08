package com.javarestaurant.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Restaurant
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class Restaurant {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("ownerID")
	private Integer ownerID = null;

	@JsonProperty("img")
	private String img = null;

	@JsonProperty("meals")
	@Valid
	private List<Meal> meals = null;

	@JsonProperty("name")
	private String name = null;

	public Restaurant id(Integer id) {
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

	public Restaurant ownerID(Integer ownerID) {
		this.ownerID = ownerID;
		return this;
	}

	/**
	 * Get ownerID
	 *
	 * @return ownerID
	 **/
	@ApiModelProperty(value = "")

	public Integer getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Integer ownerID) {
		this.ownerID = ownerID;
	}

	public Restaurant img(String img) {
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

	public Restaurant meals(List<Meal> meals) {
		this.meals = meals;
		return this;
	}

	public Restaurant addMealsItem(Meal mealsItem) {
		if (this.meals == null) {
			this.meals = new ArrayList<Meal>();
		}
		this.meals.add(mealsItem);
		return this;
	}

	/**
	 * Get meals
	 *
	 * @return meals
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Restaurant name(String name) {
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


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Restaurant restaurant = (Restaurant) o;
		return Objects.equals(this.id, restaurant.id) &&
			Objects.equals(this.ownerID, restaurant.ownerID) &&
			Objects.equals(this.img, restaurant.img) &&
			Objects.equals(this.meals, restaurant.meals) &&
			Objects.equals(this.name, restaurant.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ownerID, img, meals, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Restaurant {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    ownerID: ").append(toIndentedString(ownerID)).append("\n");
		sb.append("    img: ").append(toIndentedString(img)).append("\n");
		sb.append("    meals: ").append(toIndentedString(meals)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
