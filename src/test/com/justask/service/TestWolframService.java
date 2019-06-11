package com.justask.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.justask.http.ConnectionUtil;

class TestWolframService {

	@Test
	void shouldReturnAnswerWithoutError() {
		WolframService s = new WolframService(ConnectionUtil.getInstance());
		assertDoesNotThrow(()->s.askForAnswer("Some question"));
	}
}
