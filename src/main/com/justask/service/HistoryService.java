package com.justask.service;

import java.util.List;

import com.justask.model.History;
import com.justask.model.HistoryRepository;

public class HistoryService {
	private static HistoryService instance = new HistoryService();
	private History h;
	private HistoryService() {
		h = HistoryRepository.retrieveHistory();
	}
	public static HistoryService getInstance() {
		return instance;
	}
	public void add(String question) {
		h.addHistory(question);
		HistoryRepository.addHistory(question);
	}
	public List<String> get() {
		return h.getHistory();
	}
}
