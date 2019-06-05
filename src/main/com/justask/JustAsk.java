package com.justask;

import java.util.Scanner;

import com.justask.Exception.NoAnswerException;
import com.justask.io.AskUI;
import com.justask.io.CmdUI;
import com.justask.service.AnswerService;
import com.justask.service.AnswerServiceProvider;
/**
 * Entry point for the project
 */
public class JustAsk {
	//This will be the entry point
	public static void main(String[] args) {
		
		final Scanner sc = new Scanner(System.in);
		AskUI ui = new CmdUI(()->{return sc.nextLine();}, (s) -> {System.out.println(s);});
		String question = ui.requestForQuestion("Please provide a question:");
		AnswerService service = null;
		try {
			service = new AnswerServiceProvider().correspondService(question);
		} catch (NoAnswerException e) {
			ui.outputAnswer("Can't find answer for this type of question.");
			return;
		}
		ui.outputAnswer(service.provideAnswer(question));
	}
}
