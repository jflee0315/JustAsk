package com.justask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFileUI {
	private static FileUI ui;
	private static String inputFileName = "testinput.txt";
	private static File inputFile;
	private static File outputFile;
	private static String outputFileName = "testoutput.txt";
	private static Scanner scOutput;
	private static PrintWriter inputWriter;
	@BeforeEach
	void setup() {
		// Free up resources before each test
		if (inputWriter != null) {
			inputWriter.close();
		}
		if (scOutput != null) {
			scOutput.close();
		}
		// Remove files before each test
		if (outputFile != null && outputFile.exists()) {
			outputFile.delete();
		}
		if (inputFile != null && inputFile.exists()) {
			inputFile.delete();
		}
		// Create files and references for the test
		try {
			inputFile = new File(inputFileName);
			inputFile.createNewFile();
			// For writing fake user input
			inputWriter = new PrintWriter(new FileWriter(inputFileName));
			ui = new FileUI(new Scanner(inputFile), new PrintWriter(new FileWriter(outputFileName)));
			outputFile = new File(outputFileName);
			// For reading the output of the FileUI instance
			scOutput = new Scanner(outputFile);
		} catch (IOException e) {
			fail("IOException occurs");
			e.printStackTrace();
		}
	}
	@Test
	void shouldOutputCorrectly() {
		String answer = "This is the ultimate answer to your question!";
		ui.outputAnswer(answer);
		assertEquals(answer, scOutput.nextLine());
	}
	@Test
	void shouldProvideAnInput() {
		inputWriter.write("This should appears\nThis should not appears.");
		inputWriter.flush();
		String input = ui.requestForQuestion(null);
		assertEquals(input, "This should appears");
	}

}
