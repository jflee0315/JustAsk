package com.justask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUI implements AskUI{
	private Scanner sc;
	private PrintWriter writer;
	
	public FileUI(Scanner sc, PrintWriter writer) {
		this.sc = sc;
		this.writer = writer;
	}
	
	public static Scanner getDefaultScanner(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		return sc;
	}
	
	public static PrintWriter getDefaultWriter(String filename) throws IOException{
		PrintWriter pr = new PrintWriter(new FileWriter(filename));
		return pr;
	}

	@Override
	public String requestForQuestion(String hint) {
		if (sc.hasNext()) {
			return sc.nextLine();
		} else {
			return null;
		}
	}

	@Override
	public void outputAnswer(String answer) {
		writer.println(answer);
		writer.flush();
	}

	public void close() {
		sc.close();
		writer.close();
	}
}
