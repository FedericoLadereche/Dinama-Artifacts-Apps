package commons;

/**
 * A utility that POST request.
 * @author Federico Ladereche Ghiena
 *
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class PostDataFromParameters {
	
	public static int servicePostWithParameters(byte[] postData, HttpURLConnection httpConn) throws IOException {
		try (DataOutputStream wr = new DataOutputStream(httpConn.getOutputStream())) {
			wr.write(postData);
		}

		int responseCode = httpConn.getResponseCode();
		
		return responseCode;
	}

}
