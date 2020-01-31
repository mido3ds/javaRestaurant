package com.javarestaurant.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class Order {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("mealID")
	private Integer mealID = null;

	@JsonProperty("numItems")
	private Integer numItems = null;

	public Order id(Integer id) {
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

	public Order mealID(Integer mealID) {
		this.mealID = mealID;
		return this;
	}

	/**
	 * Get mealID
	 *
	 * @return mealID
	 **/
	@ApiModelProperty(value = "")

	public Integer getMealID() {
		return mealID;
	}

	public void setMealID(Integer mealID) {
		this.mealID = mealID;
	}

	public Order numItems(Integer numItems) {
		this.numItems = numItems;
		return this;
	}

	/**
	 * Get numItems
	 *
	 * @return numItems
	 **/
	@ApiModelProperty(value = "")

	public Integer getNumItems() {
		return numItems;
	}

	public void setNumItems(Integer numItems) {
		this.numItems = numItems;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(this.id, order.id) &&
			Objects.equals(this.mealID, order.mealID) &&
			Objects.equals(this.numItems, order.numItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mealID, numItems);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    mealID: ").append(toIndentedString(mealID)).append("\n");
		sb.append("    numItems: ").append(toIndentedString(numItems)).append("\n");
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
