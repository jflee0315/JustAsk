package com.justask.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestNoAnswerException {

	@Test
	void TestNoAnswerException() {
		NoAnswerException e = new NoAnswerException("question");
		assertEquals("question", e.question);
	}

}
