package com.justask.service;

import java.util.ArrayList;
import java.util.List;

import com.justask.Exception.NoAnswerException;
/**
 * 
 * Provide a service for answering the question.
 *
 */
public class AnswerServiceProvider {
	private List<AnswerService> services;
	public AnswerServiceProvider() {
		services = new ArrayList<>();
		// add all available services here
		services.add(new MathService());
	}
	/**
	 * Provide a service to answer the question. It throws NoAnswerException when no adequate service can be found. 
	 * 
	 * @param question
	 * @return
	 * @throws NoAnswerException
	 */
	public AnswerService correspondService(String question) throws NoAnswerException {
		for (AnswerService service: services) {
			QuestionTypeJudge judge = (QuestionTypeJudge) service;
			if (judge.isType(question))
				return service;
		}
		throw new NoAnswerException(question);
	}
}