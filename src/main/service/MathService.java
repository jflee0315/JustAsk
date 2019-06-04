package service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Pattern;

import http.ConnectionUtil;
import http.ConnectionUtil.HttpException;

public class MathService implements QuestionTypeJudge, AnswerService{
	private ArrayDeque<Character> operators;
	private ArrayList<Double> numbers;
	
	public MathService() {
		operators = new ArrayDeque<>();
		numbers = new ArrayList<>();
	}
	
	@Override
	public boolean isType(String question) {
		 Pattern p = Pattern.compile("^[=?0-9)(*/+-]+$");
		 return p.matcher(question).matches();
	}
	@Override
	public String provideAnswer(String question) {
		question = question.replaceAll("[?=]", "");
		return "Math problem. Not implemented yet.";
	}
}
