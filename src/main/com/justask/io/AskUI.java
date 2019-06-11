package com.justask.io;

import java.util.List;

/**
 * UI interface for this project
 */
public interface AskUI {
	public void displayHistory(List<String> questions);
	public String requestForQuestion(String hint);
	public void outputAnswer(String answer);
}
