package com.justask;

import java.io.IOException;
import java.util.Scanner;

import com.justask.io.FileUI;
/**
 * Entry point for the project
 */
public class JustAsk {
	//This will be the entry point
	public static void main(String[] args) {
//		final Scanner sc = new Scanner(System.in);
//		AskUI ui = new CmdUI(()->{return sc.nextLine();}, (s) -> {System.out.println(s);});
//		ui.requestForQuestion("Please provide a question:");
//		ui.outputAnswer("This is the answer, you are welcome.");
		
		try {
			FileUI fi = new FileUI(FileUI.getDefaultScanner("test.txt"), FileUI.getDefaultWriter("testout.txt"));
			String question = fi.requestForQuestion(null);
			System.out.println(question);
			fi.outputAnswer("The solution to the question: '" + question + "' is 'Not implemented yet'");
		} catch (IOException e) {
			System.out.println("Error accessing the file");
			e.printStackTrace();
		}
		
		
	}

}
