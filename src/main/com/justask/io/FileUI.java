package com.justask.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
/**
 * Allows user to ask question and get answer from files
 */
public class FileUI implements AskUI{
	private Scanner sc;
	private PrintWriter writer;
	/**
	 * inject resources
	 * 
	 * @param sc
	 * @param writer
	 */
	public FileUI(Scanner sc, PrintWriter writer) {
		this.sc = sc;
		this.writer = writer;
	}
	/**
	 * Get default scanner
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Scanner getDefaultScanner(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		return sc;
	}
	/**
	 * Get default writer
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
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
	@Override
	public void displayHistory(List<String> questions) {
		for(String q: questions) {
			writer.println(q);
		}
		writer.flush();
	}
}
