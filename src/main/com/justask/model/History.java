package com.justask.model;

import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class History implements Serializable{
	private static final long serialVersionUID = 1L;
	final public int NUM_HISTORY = 3;
	private Deque<String> questions;
	
	public History() {
		questions = new ArrayDeque<>(NUM_HISTORY);
	}
	
	public void addHistory(String question) {
		if (questions.size() == 3) {
			questions.removeFirst();
		}
		questions.addLast(question);
	}
	
	public List<String> getHistory() {
		return new ArrayList<String>(questions);
	}
}
