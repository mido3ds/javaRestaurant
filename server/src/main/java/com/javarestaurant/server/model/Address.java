package com.javarestaurant.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class Address {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("city")
	private String city = null;

	@JsonProperty("housenumber")
	private Integer housenumber = null;

	@JsonProperty("street")
	private String street = null;

	public Address id(Integer id) {
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

	public Address city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 *
	 * @return city
	 **/
	@ApiModelProperty(value = "")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address housenumber(Integer housenumber) {
		this.housenumber = housenumber;
		return this;
	}

	/**
	 * Get housenumber
	 *
	 * @return housenumber
	 **/
	@ApiModelProperty(value = "")

	public Integer getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(Integer housenumber) {
		this.housenumber = housenumber;
	}

	public Address street(String street) {
		this.street = street;
		return this;
	}

	/**
	 * Get street
	 *
	 * @return street
	 **/
	@ApiModelProperty(value = "")

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(this.id, address.id) &&
			Objects.equals(this.city, address.city) &&
			Objects.equals(this.housenumber, address.housenumber) &&
			Objects.equals(this.street, address.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, city, housenumber, street);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    housenumber: ").append(toIndentedString(housenumber)).append("\n");
		sb.append("    street: ").append(toIndentedString(street)).append("\n");
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
