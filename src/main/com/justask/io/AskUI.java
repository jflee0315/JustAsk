package com.justask.io;
/**
 * UI interface for JustAsk
 */
public interface AskUI {
	public String requestForQuestion(String hint);
	public void outputAnswer(String answer);
}
