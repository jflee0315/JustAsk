package com.justask.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * Test math services
 *
 */
class TestMathService {
	private MathService service;
	@BeforeEach
	void setup() {
		service = new MathService();
	}

	@Test
	void shouldDetermineIfTheQuestionIsMath() {
		QuestionTypeJudge judge = null;
		try {
			judge = (QuestionTypeJudge) service;
		} catch(ClassCastException e) {
			fail("MathService should be a QuestionTypeJudge, but it is not.");
		}
		assertFalse(judge.isType("Not math 123"));
		assertTrue(judge.isType("(1+1)*2+3+(1/2)=?"));
	}
	
	@Test
	void shouldProvideAnAnswer() {
		String answer = service.provideAnswer("1+1");
		assertNotEquals(null, answer);
		assertNotEquals("", answer);
	}

}
