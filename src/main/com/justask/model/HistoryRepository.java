package com.justask.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {
	final private static SOURCE USE = SOURCE.DB;
	 
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String protocol = "jdbc:derby:justAsk;create=true;";
    private static String tableName = "History";
	private static Connection conn = null;
	
    static {
    	// setup DB
    	try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(protocol);		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
    	// setup table
    	try {
    		Statement stmt = conn.createStatement();
    		stmt.execute("CREATE TABLE History("
    		         + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
    		         + "Question VARCHAR(255))");
    	} catch (SQLException e) {
    		if (!e.getMessage().equals("Table/View 'HISTORY' already exists in Schema 'APP'.")) {
    			e.printStackTrace();
    			System.exit(0);
    		}
    	}
    }
    public static History retrieveHistory() {
    	if (USE == SOURCE.DB) {
    		return retrieveHistoryFromDB();
    	} else if (USE == SOURCE.FILE) {
    		return retrieveHistoryFromFile();
    	} else {
    		System.out.println("Configuration error in HistoryRepository.");
    		System.exit(0);
    		return null;
    	}
    }
    public static void addHistory(String question) {
    	if (USE == SOURCE.DB) {
    		insertHistoryToDB(question);
    	} else if (USE == SOURCE.FILE) {
    		History h = retrieveHistoryFromFile();
    		h.addHistory(question);
    		replaceHistoryInFile(h);
    	}
    }
    
	public static void replaceHistoryInFile(History h) {
		try {
			 try (FileOutputStream fileOut = new FileOutputStream("history.txt");
			    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
				objectOut.writeObject(h);
			 }
 
		} catch(Exception ex) {
            ex.printStackTrace();
        }
	}
	public static History retrieveHistoryFromFile() {
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
	private static void insertHistoryToDB(String question) {
        try(Statement stmt = conn.createStatement();) {
            stmt.execute("insert into History (Question) values ('"+question+"')");
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }   
    }
	private static History retrieveHistoryFromDB() {
		History h = new History();
        try (Statement stmt = conn.createStatement();) {   
            ResultSet result = stmt.executeQuery("select * from History");
            while (result.next()) {
            	h.addHistory(result.getString(2));
            }
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
        return h;
    }
	enum SOURCE{
		DB, FILE
	}
}
