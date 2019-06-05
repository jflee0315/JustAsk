package com.justask.handler;

import com.justask.Exception.NoAnswerException;
import com.justask.io.AskUI;
import com.justask.service.AnswerService;
import com.justask.service.AnswerServiceProvider;
/**
 * 
 * Main handler for the project
 *
 */
public class JustAskHandler {
	private AskUI ui;
	private AnswerServiceProvider serviceProvider;
	/**
	 * dependency injection
	 * 
	 * @param ui
	 * @param serviceProvider
	 */
	public JustAskHandler(AskUI ui, AnswerServiceProvider serviceProvider) {
		this.ui = ui;
		this.serviceProvider = serviceProvider;
	}
	/**
	 * Starting point
	 */
	public void start() {
		String question = ui.requestForQuestion("What do you want to ask?");
		AnswerService answerService = null;
		try {
			answerService = serviceProvider.correspondService(question);
		} catch (NoAnswerException e) {
			ui.outputAnswer("Sorry, I am not able to answer that question. Please try another question.");
		}
		ui.outputAnswer(answerService.provideAnswer(question));
	}
}
