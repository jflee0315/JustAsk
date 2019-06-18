package com.justask.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCommonValidator {

	@Test
	void testFilter() {
		assertEquals("This is nice", CommonValidator.filter("This shit is nice"));
	}
}
