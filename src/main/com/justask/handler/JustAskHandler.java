package com.justask.handler;

import com.justask.Exception.NoAnswerException;
import com.justask.io.AskUI;
import com.justask.service.AnswerService;
import com.justask.service.AnswerServiceProvider;
import com.justask.service.HistoryService;
import com.justask.validation.CommonValidator;
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
	}
}
