package com.justask.service;

import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
/**
 * 
 * Service for solving math question
 *
*/
public class MathService implements QuestionTypeJudge, AnswerService{

	/**
	 * Determine if the question is a simple math question.
	 */
	@Override
	public boolean isType(String question) {
		 Pattern p = Pattern.compile("^[=?0-9)(*/+-]+$");
		 return p.matcher(question).matches();
	}
	/**
	 * Provide an answer
	 */
	@Override
	public String provideAnswer(String question) {
		question = question.replaceAll("[?= ]", "");
		return caculateExpression(question);
	}
	private String caculateExpression(String expr) {
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
			return engine.eval(expr).toString();
		} catch (ScriptException e) {
			return "Unable to resolve this math problem";
		}
	}
}
