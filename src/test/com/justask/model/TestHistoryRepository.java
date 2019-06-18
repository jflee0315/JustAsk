package com.justask.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class TestHistoryRepository {

	@Test
	void testRetrieveHistory() {
		assertDoesNotThrow(()->HistoryRepository.retrieveHistory());
	}
	@Test
	void testAddHistory() {
		assertDoesNotThrow(()->HistoryRepository.addHistory("This is a unit test data"));
	}
}
