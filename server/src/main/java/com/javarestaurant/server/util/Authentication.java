package com.javarestaurant.server.util;

import com.javarestaurant.data.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

public class Authentication {
	private static final SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final int EXPIRE_DAYS = 10;
	private static final String LOGGED_IN_SUBJECT = "loggedIn";

	public static boolean isLoggedIn(String token) {
		try {
			token = removeBearer(token);

			String subject = Jwts.parserBuilder().setSigningKey(KEY).build()
				.parseClaimsJws(token)
				.getBody().getSubject();

			return !isTokenExpired(token) && subject != null && subject.equals(LOGGED_IN_SUBJECT);
		} catch (Exception e) {
			return false;
		}
	}

	private static String removeBearer(String token) {
		try {
			return token.split(" ")[1];
		} catch (Exception e) {
			return null;
		}
	}

	public static String getUsername(String token) {
		try {
			token = removeBearer(token);

			return (String) Jwts.parserBuilder().setSigningKey(KEY).build()
				.parseClaimsJws(token)
				.getBody()
				.get("username");
		} catch (Exception e) {
			return "";
		}
	}

	public static boolean isOwner(String token) {
		try {
			token = removeBearer(token);
			return (boolean) Jwts.parserBuilder().setSigningKey(KEY).build()
				.parseClaimsJws(token)
				.getBody()
				.get("role");
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean isTokenExpired(String token) {
		try {
			return Jwts.parserBuilder().setSigningKey(KEY).build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration()
				.before(new Date());
		} catch (Exception e) {
			return true;
		}
	}

	public static String genToken(User user) {
		try {
			return "Bearer " + Jwts.builder()
				.setSubject(LOGGED_IN_SUBJECT)
				.setExpiration(createExpirationDate())
				.claim("username", user.getUsername())
				.claim("role", user.isIsRestaurantOwner())
				.signWith(KEY)
				.compact();
		} catch (Exception e) {
			return null;
		}
	}

	private static Date createExpirationDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR, 24 * Authentication.EXPIRE_DAYS);

		return c.getTime();
	}

	public static boolean isAuthenticated(String givenPassword, String dbPassword) {
		return givenPassword != null && hash(givenPassword).equals(dbPassword);
	}

	public static String hash(String password) {
		return password; // TODO: 8/2/20 implement hashing
	}
}
