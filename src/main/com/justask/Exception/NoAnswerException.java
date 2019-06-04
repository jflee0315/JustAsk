package com.justask.Exception;

public class NoAnswerException extends Exception {
	public String question;
	public NoAnswerException(String question) {
		this.question = question;
	}
}
