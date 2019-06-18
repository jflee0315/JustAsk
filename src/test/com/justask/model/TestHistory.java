package com.justask.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHistory {

	@Test
	void testAddHistory() {
		History h = new History();
		h.addHistory("test");
		assertEquals("test", h.getHistory().get(0));
	}
	@Test
	void testGetHistory() {
		History h = new History();
		h.addHistory("test");
		assertEquals("test", h.getHistory().get(0));
	}
}
