package com.justask.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import validation.CommonValidator;

class TestCommonValidator {

	@Test
	void shouldFilterOutCurseWords() {
		assertEquals("This is nice", CommonValidator.filter("This shit is nice"));
	}

}
