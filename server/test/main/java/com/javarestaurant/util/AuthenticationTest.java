package com.javarestaurant.util;

import com.javarestaurant.data.model.User;
import com.javarestaurant.server.util.Authentication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticationTest {

	private User user;
	private User owner;
	private String userToken;
	private String ownerToken;

	@BeforeEach
	void setUp() {
		user = new User();
		user.setUsername("mahmoudadas");
		user.setIsRestaurantOwner(false);
		userToken = Authentication.genToken(user);

		owner = new User();
		owner.setUsername("someoneelse");
		owner.setIsRestaurantOwner(true);
		ownerToken = Authentication.genToken(owner);
	}

	@Test
	void isLoggedIn() {
		assertFalse(Authentication.isLoggedIn("ayhabal"));

		assertTrue(Authentication.isLoggedIn(userToken));
		assertTrue(Authentication.isLoggedIn(ownerToken));

		assertFalse(Authentication.isLoggedIn("aa"));
	}

	@SuppressWarnings("SimplifiableJUnitAssertion")
	@Test
	void getUsername() {
		assertTrue(Authentication.getUsername(userToken).equals(user.getUsername()));
		assertTrue(Authentication.getUsername(ownerToken).equals(owner.getUsername()));

		assertTrue(Authentication.getUsername("").equals(""));
		assertTrue(Authentication.getUsername("aa").equals(""));

		assertFalse(Authentication.getUsername(ownerToken).equals("sdafsdfa"));
	}

	@Test
	void isOwner() {
		assertTrue(Authentication.isOwner(ownerToken));
		assertFalse(Authentication.isOwner(userToken));
	}

	@Test
	void isAuthenticated() {
		assertTrue(Authentication.isAuthenticated("ayhabal", "ayhabal"));
		assertFalse(Authentication.isAuthenticated("asdfas", "34"));
	}
}
