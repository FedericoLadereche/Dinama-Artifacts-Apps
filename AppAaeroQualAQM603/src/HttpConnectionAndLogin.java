import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import commons.PostDataFromParameters;
import commons.ServiceProperties;

/**
 * A utility that connects and loggin into AeroQual application.
 * @author Federico Ladereche Ghiena
 *
 */

public class HttpConnectionAndLogin {
	private static String URL_PARAMETERS = "Username=administrator&Password=aqmadmin&RememberMe=false";
	
	/**
     * Log in into the application
     * @param fileURL HTTP URL for login
     * @param userName user name
     * @param password user password
     * @param rememberME boolean for remembering credentials
	 * @throws IOException
     */
	
	public static int logginIntoApplication() throws IOException {
		byte[] postData = URL_PARAMETERS.getBytes(StandardCharsets.UTF_8);

		String requestUrl = "http://172.30.200.21/Account/Login";

		HttpURLConnection httpConn = ServiceProperties.commonServiceProperties(requestUrl);
		
		ServiceProperties.connectionAndLoginProperties(httpConn);

		int responseCode = PostDataFromParameters.servicePostWithParameters(postData, httpConn);

		System.out.println(responseCode);
		return responseCode;
	}
	
	public static String getURL_PARAMETERS() {
		return URL_PARAMETERS;
	}
}
