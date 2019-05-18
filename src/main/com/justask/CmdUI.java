package com.justask;

import java.util.Scanner;

public class CmdUI implements AskUI{
	private Reader reader;
	private Printer printer;
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
@FunctionalInterface
interface Printer {
	public void println(String output);
}
@FunctionalInterface
interface Reader {
	public String readLine();
}