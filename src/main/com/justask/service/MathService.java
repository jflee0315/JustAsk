package com.justask.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 * 
 * Service for solving math question
 *
*/
public class MathService implements QuestionTypeJudge, AnswerService{

	/**
	 * Determine if the question is a math question.
	 */
	@Override
	public boolean isType(String question) {
		 Pattern p = Pattern.compile("^[=?0-9)(*/+-]+$");
		 return p.matcher(question).matches();
	}
	
	/**
	 * 
	 * Provide an answer
	 * 
	 */
	@Override
	public String provideAnswer(String question) {
		question = question.replaceAll("[?=]", "");
		return "Math problem. Not implemented yet.";
	}
}
