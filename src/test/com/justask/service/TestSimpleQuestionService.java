package com.justask.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleQuestionService {

	@Test
	void testIsType() {
		assertTrue(new SimpleQuestionService().isType("simple question"));
	}
	@Test
	void testProvideAnswer() {
		assertNotNull(new SimpleQuestionService().provideAnswer("Some question"));
	}

}
