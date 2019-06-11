package com.justask.service;

import com.justask.Exception.NoAnswerException;
import com.justask.http.ConnectionUtil;
import com.justask.http.ConnectionUtil.HttpException;

public class SimpleQuestionService implements AnswerService, QuestionTypeJudge{
	private WolframService wolframeService =  new WolframService(ConnectionUtil.getInstance());
	@Override
	public String provideAnswer(String question) {
		String answer;
		try {
			answer = wolframeService.askForAnswer(question);
		} catch(HttpException e) {
			answer = "Sorry, there is a problem connecting to web resources.";
		} catch(NoAnswerException e) {
			answer = "Sorry, please ask something else.";
		}
		return answer;
	}

	@Override
	public boolean isType(String question) {
		// Any thing can be a simple question.
		return true;
	}
}
