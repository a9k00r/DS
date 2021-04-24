
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.util;


public class HttpURLConnGETResponseParser {

	
	public static void main(String[] args) throws IOException {

        URL url = new URL("https://jsonmock.doselect.com/api/countries/countries/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
		if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject json = new JSONObject(response.toString());
			System.out.println(json.getString("capital"));
			System.out.println(json.getString("population"));  

		} else {
			System.out.println("GET request not worked");
		}

	}
	

}