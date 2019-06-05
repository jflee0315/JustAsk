package com.justask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.justask.Exception.NoAnswerException;
/**
 * 
 * Test service provider
 *
 */
class TestAnswerServiceProvider {
	private AnswerServiceProvider provider;
	@BeforeEach
	void setup() {
		provider = new AnswerServiceProvider();
	}
	/**
	 * NoAnswerException or an AnswerService are both acceptable
	 */
	@Test
	void shouldProvideAnswerServiceOrNoAnswerException() {
		AnswerService service = null;
		String question = "Some question";
		try {
			service = provider.correspondService(question);
		}catch (NoAnswerException e) {
			assertEquals(question, e.question);
			return;
		}catch (Exception e) {
			fail("Unexpected exception occurs. " + e.getMessage());
		}
		assertNotEquals(null, service);
	}
}
