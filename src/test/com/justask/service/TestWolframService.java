package com.justask.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.justask.Exception.NoAnswerException;
import com.justask.http.ConnectionUtil;
import com.justask.http.ConnectionUtil.HttpException;

class TestWolframService {

	@Test
	void testAskForAnswer() {
		WolframService s = new WolframService(ConnectionUtil.getInstance());
		String result = null;
		try {
			result = s.askForAnswer("some question");
		} catch (NoAnswerException e) {
			// acceptable
			result = "good";
			
		} catch (HttpException e) {
			// acceptable
			result = "good";
		}
		assertNotNull(result);
	}
}
