package com.justask;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.justask.Exception.NoAnswerException;
import com.justask.handler.JustAskHandler;
import com.justask.io.AskUI;
import com.justask.io.CmdUI;
import com.justask.service.AnswerService;
import com.justask.service.AnswerServiceProvider;
import com.justask.service.HistoryService;
import com.justask.validation.CommonValidator;
/**
 * Entry point for the project
 */
public class JustAsk {
	
	/**
	 * This will be the entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Scanner sc = new Scanner(System.in);
		// Read and write from command line.
		AskUI ui = new CmdUI(()->{return sc.nextLine();}, (s) -> {System.out.println(s);});
		JustAskHandler handler = new JustAskHandler(ui, new AnswerServiceProvider());
		handler.start();
	}	
}
