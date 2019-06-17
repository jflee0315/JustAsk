package com.justask;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.justask.Exception.NoAnswerException;
import com.justask.io.AskUI;
import com.justask.io.CmdUI;
import com.justask.service.AnswerService;
import com.justask.service.AnswerServiceProvider;
import com.justask.service.HistoryService;
import com.justask.validation.CommonValidator;
/**
 * Entry point for the project
 */
public class JustAsk {
	
	/**
	 * This will be the entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Scanner sc = new Scanner(System.in);
		// Read and write from command line.
		AskUI ui = new CmdUI(()->{return sc.nextLine();}, (s) -> {System.out.println(s);});
		ui.displayHistory(HistoryService.getInstance().get());
		String question = ui.requestForQuestion("Please provide a question:");
		question = CommonValidator.filter(question);
		HistoryService.getInstance().add(question);
		AnswerService service = null;
		try {
			service = new AnswerServiceProvider().correspondService(question);
		} catch (NoAnswerException e) {
			ui.outputAnswer("Can't find answer for this question.");
			return;
		}
		ui.outputAnswer(service.provideAnswer(question));
		System.out.print("Ask another question(Y or N)?");
		
	}	
}
