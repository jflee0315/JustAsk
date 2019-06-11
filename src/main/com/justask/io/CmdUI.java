package com.justask.io;

import java.util.List;

/**
 * Allows user to ask question and get answer from command line
 */
public class CmdUI implements AskUI{
	private Reader reader;
	private Printer printer;
	/**
	 * inject resources and resolvers
	 * 
	 * @param reader
	 * @param printer
	 */
	public CmdUI(Reader reader, Printer printer) {
		this.reader = reader;
		this.printer = printer;
	}
	@Override
	public String requestForQuestion(String hint) {
		printer.println(hint);
		return reader.readLine();
	}
	@Override
	public void outputAnswer(String answer) {
		printer.println(answer);
	}
	@Override
	public void displayHistory(List<String> questions) {
		if (questions.size() == 0) {
			printer.println("There is no previous question.");
		} else {
			printer.println("Previous questions:");
			for (String q: questions) {
				printer.println("-" + q);
			}
		}	
	}
}