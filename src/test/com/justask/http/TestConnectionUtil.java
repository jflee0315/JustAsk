package com.justask.http;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.justask.http.ConnectionUtil.HttpException;

class TestConnectionUtil {

	@Test
	void shouldBeSingleton() {
		assertSame(ConnectionUtil.getInstance(), ConnectionUtil.getInstance());
		assertSame(ConnectionUtil.getInstance(), ConnectionUtil.getInstance());
		assertSame(ConnectionUtil.getInstance(), ConnectionUtil.getInstance());
	}
	@Test
	void shouldReceiveResponse() {
		String response = null;
		try {
			response = ConnectionUtil.getInstance().sendGet("https://www.bu.edu/");
		} catch(HttpException e) {
			fail("Some error occurs when sending request to Boston University");
		}
		assertNotEquals(null, response);
		assertNotEquals("", response);
	}
}
