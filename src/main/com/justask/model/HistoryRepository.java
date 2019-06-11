package com.justask.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class HistoryRepository {
	public static void replaceHistory(History h) {
		try {
			 try (FileOutputStream fileOut = new FileOutputStream("history.txt");
			    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
				objectOut.writeObject(h);
			 }
 
		} catch(Exception ex) {
            ex.printStackTrace();
        }
	}
	public static History retrieveHistory() {
		History result = null;
		try {
			try (FileInputStream  fileIn = new FileInputStream("history.txt");
		        ObjectInputStream  ObjectIn = new ObjectInputStream (fileIn);) {
				result = (History) ObjectIn.readObject();
	            ObjectIn.close();
			} 
        } catch(FileNotFoundException e) {
        	return new History();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return result;
	}
	public static void main(String[] args) {
		replaceHistory(new History());
		retrieveHistory();
	}
}
