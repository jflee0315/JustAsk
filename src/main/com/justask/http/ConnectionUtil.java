package com.justask.http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 
 * Utility for sending http request
 *
 */
public class ConnectionUtil {
	private static ConnectionUtil instance = new ConnectionUtil();
	private ConnectionUtil() {
		
	}
	/**
	 * Singleton
	 * 
	 * @return ConnectionUtil instance
	 */
	public static ConnectionUtil getInstance() {
		return instance;
	}
	/**
	 * Send http get
	 * 
	 * @param url
	 * @return
	 * @throws HttpException
	 */
	public String sendGet(String url) throws HttpException {

		HttpURLConnection con;
		StringBuffer response = new StringBuffer();
		
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			// can't find an answer
			if (responseCode == 501) {
				return null;
			}
			else if (responseCode != 200) {
				throw new HttpException();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch(Exception e) {
			throw new HttpException();
		}
	
		return response.toString();
	}
	public static class HttpException extends Throwable {
		
	}
}
