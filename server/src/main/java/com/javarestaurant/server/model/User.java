package com.javarestaurant.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-29T13:13:37.274Z[GMT]")
public class User {
	@JsonProperty("addresses")
	@Valid
	private List<Address> addresses = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("firstname")
	private String firstname = null;

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("lastname")
	private String lastname = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("phone")
	private String phone = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("isRestaurantOwner")
	private Boolean isRestaurantOwner = null;

	@JsonProperty("ownedRestaurants")
	@Valid
	private List<Restaurant> ownedRestaurants = null;

	static public User getByName(String username, JdbcTemplate jdbcTemplate) {
		try {
			return jdbcTemplate.queryForObject("SELECT ROWID,* FROM User WHERE username = ?;",
				new String[]{username},
				new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * @param user
	 * @param jdbcTemplate
	 * @return 0 -> couldn't insert|user exists
	 * otherwise -> success and thats the ROWID of the inserted item
	 */
	static public Integer insert(User user, JdbcTemplate jdbcTemplate) {
		if (!(isValidEmail(user.email) && isValidUsername(user.username) &&
			isValidName(user.firstname) && isValidName(user.lastname) &&
			isValidPhone(user.phone) && isValidPassword(user.password))) {
			return 0;
		}

		try {
			int rows = jdbcTemplate.update("INSERT INTO User VALUES(?, ?, ?, ?, ?, ?);",
				new Object[]{user.email, user.username, user.firstname, user.lastname, user.password, user.phone});

			if (rows != 1) {
				return 0;
			}
			return getByName(user.username, jdbcTemplate).id;
		} catch (DataAccessException e) {
			return null;
		}
	}

	private static boolean isValidPassword(String password) {
		return password != null && password.length() > 10;
	}

	private static boolean isValidPhone(String phone) {
		Pattern p = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
		Matcher m = p.matcher(phone);
		return (m.find() && m.group().equals(phone));
	}

	private static boolean isValidName(String name) {
		return name != null && name.length() > 1;
	}

	private static boolean isValidUsername(String username) {
		return username != null && username.length() > 5;
	}

	private static boolean isValidEmail(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	public static boolean delete(String username, JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.update("DELETE FROM User WHERE username = ?;", username) == 1;
	}

	public User addresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public User addAddressesItem(Address addressesItem) {
		if (this.addresses == null) {
			this.addresses = new ArrayList<Address>();
		}
		this.addresses.add(addressesItem);
		return this;
	}

	/**
	 * Get addresses
	 *
	 * @return addresses
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 *
	 * @return email
	 **/
	@ApiModelProperty(value = "")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User firstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	/**
	 * Get firstname
	 *
	 * @return firstname
	 **/
	@ApiModelProperty(value = "")

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public User id(Integer id) {
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

	public User lastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	/**
	 * Get lastname
	 *
	 * @return lastname
	 **/
	@ApiModelProperty(value = "")

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 *
	 * @return password
	 **/
	@ApiModelProperty(value = "")

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User phone(String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * Get phone
	 *
	 * @return phone
	 **/
	@ApiModelProperty(value = "")

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 *
	 * @return username
	 **/
	@ApiModelProperty(value = "")

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User isRestaurantOwner(Boolean isRestaurantOwner) {
		this.isRestaurantOwner = isRestaurantOwner;
		return this;
	}

	/**
	 * Get isRestaurantOwner
	 *
	 * @return isRestaurantOwner
	 **/
	@ApiModelProperty(value = "")

	public Boolean isIsRestaurantOwner() {
		return isRestaurantOwner;
	}

	public void setIsRestaurantOwner(Boolean isRestaurantOwner) {
		this.isRestaurantOwner = isRestaurantOwner;
	}

	public User ownedRestaurants(List<Restaurant> ownedRestaurants) {
		this.ownedRestaurants = ownedRestaurants;
		return this;
	}

	public User addOwnedRestaurantsItem(Restaurant ownedRestaurantsItem) {
		if (this.ownedRestaurants == null) {
			this.ownedRestaurants = new ArrayList<Restaurant>();
		}
		this.ownedRestaurants.add(ownedRestaurantsItem);
		return this;
	}

	/**
	 * Get ownedRestaurants
	 *
	 * @return ownedRestaurants
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<Restaurant> getOwnedRestaurants() {
		return ownedRestaurants;
	}

	public void setOwnedRestaurants(List<Restaurant> ownedRestaurants) {
		this.ownedRestaurants = ownedRestaurants;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.addresses, user.addresses) &&
			Objects.equals(this.email, user.email) &&
			Objects.equals(this.firstname, user.firstname) &&
			Objects.equals(this.id, user.id) &&
			Objects.equals(this.lastname, user.lastname) &&
			Objects.equals(this.password, user.password) &&
			Objects.equals(this.phone, user.phone) &&
			Objects.equals(this.username, user.username) &&
			Objects.equals(this.isRestaurantOwner, user.isRestaurantOwner) &&
			Objects.equals(this.ownedRestaurants, user.ownedRestaurants);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresses, email, firstname, id, lastname, password, phone, username, isRestaurantOwner, ownedRestaurants);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    isRestaurantOwner: ").append(toIndentedString(isRestaurantOwner)).append("\n");
		sb.append("    ownedRestaurants: ").append(toIndentedString(ownedRestaurants)).append("\n");
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
