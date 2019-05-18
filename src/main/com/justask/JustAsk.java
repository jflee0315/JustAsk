package com.justask;

import java.util.Scanner;

public class JustAsk {
	//This will be the entry point
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		AskUI ui = new CmdUI(()->{return sc.nextLine();}, (s) -> {System.out.println(s);});
		ui.requestForQuestion("Please provide a question:");
		ui.outputAnswer("This is the answer, you are welcome.");
	}

}
