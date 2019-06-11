package com.justask.service;

import java.net.URLEncoder;

import com.justask.Exception.NoAnswerException;
import com.justask.http.ConnectionUtil;
import com.justask.http.ConnectionUtil.HttpException;

public class WolframService {
	final private static String APP_ID = "KP49EH-QU23L7UU6W";
	final private static String URL = "http://api.wolframalpha.com/v1/result" + "?appid=" + APP_ID;
	private ConnectionUtil connectionUtil = ConnectionUtil.getInstance();
	
	public WolframService(ConnectionUtil c) {
		connectionUtil = c;
	}
	
	public String askForAnswer(String question) throws HttpException, NoAnswerException {
		String parameter = "&input=" + URLEncoder.encode(question);
		String answer = connectionUtil.sendGet(URL+parameter);
		if (answer == null) {
			throw new NoAnswerException(question);
		} else {
			return answer;
		}
	}
}