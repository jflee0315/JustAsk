package com.justask.service;

import java.util.ArrayList;
import java.util.List;

import com.justask.Exception.NoAnswerException;

public class AnswerServiceProvider {
	private List<AnswerService> services;
	public AnswerServiceProvider() {
		services = new ArrayList<>();
		services.add(new MathService());
	}
	public AnswerService correspondService(String question) throws NoAnswerException {
		for (AnswerService service: services) {
			QuestionTypeJudge judge = (QuestionTypeJudge) service;
			if (judge.isType(question))
				return service;
		}
		throw new NoAnswerException(question);
	}
}