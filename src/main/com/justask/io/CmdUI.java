package com.justask.io;

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
}