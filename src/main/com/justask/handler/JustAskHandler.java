package com.justask.handler;

import com.justask.Exception.NoAnswerException;
import com.justask.io.AskUI;

import service.AnswerServiceProvider;
import service.AnswerService;

public class JustAskHandler {
	private AskUI ui;
	private AnswerServiceProvider serviceProvider;
	public JustAskHandler(AskUI ui, AnswerServiceProvider serviceProvider) {
		this.ui = ui;
		this.serviceProvider = serviceProvider;
	}
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
