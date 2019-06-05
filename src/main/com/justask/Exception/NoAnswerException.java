package com.justask.Exception;
/**
 * Throws when no answer can be provided.
 *
 */
public class NoAnswerException extends Exception {
	public String question;
	/**
	 * Constructor
	 * 
	 * @param question
	 */
	public NoAnswerException(String question) {
		this.question = question;
	}
}
