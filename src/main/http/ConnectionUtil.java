package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtil {
	private static ConnectionUtil instance = new ConnectionUtil();
	private ConnectionUtil() {
		
	}
	public static ConnectionUtil getInstance() {
		return instance;
	}
	public String sendGet(String url) throws HttpException {

		HttpURLConnection con;
		StringBuffer response = new StringBuffer();
		
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

			int responseCode = con.getResponseCode();
			if (responseCode != 200) {
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
