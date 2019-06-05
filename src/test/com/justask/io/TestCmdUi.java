package com.justask.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.justask.io.AskUI;
import com.justask.io.CmdUI;
/**
 * 
 * Test CmdUI
 *
 */
class TestCmdUi {
	private static AskUI ui;
	private static String testInput;
	private static String testOutput;
	@BeforeAll
	static void setup() {
		ui = new CmdUI(()->{return testInput;}, (s) -> {testOutput = s;});
	}
	
	@Test
	void shouldOutputCorrectly() {
		String answer = "This is the ultimate answer to your question!";
		ui.outputAnswer(answer);
		assertEquals(answer, testOutput);
	}
	
	@Test
	void shouldProvideAnInput() {
		testInput = "Please provide an question, human!";
		assertEquals(testInput, ui.requestForQuestion(testInput));
	}
}
