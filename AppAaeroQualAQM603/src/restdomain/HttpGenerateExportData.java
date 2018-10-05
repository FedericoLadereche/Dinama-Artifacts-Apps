package restdomain;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import commons.PostDataFromParameters;
import commons.ServiceProperties;

/**
 * A utility that generates csv file with given parameters.
 * @author Federico Ladereche Ghiena
 *
 */
public class HttpGenerateExportData {
	
	/**
     * Log in into the application
     * @param fileURL HTTP URL for login
     * @param period time period data
     * @param avgMinutes average minutes (possible values: Raw data, 1, 5, 10, 15, 20, 30, 60{1 hr}, 120{2 hr}, 240{4 hr}, 480{8 hr}, 720{12 hr}, 1440{Daily})
     * @param includeJornal boolean for including journal
	 * @throws IOException
     */
	
	public static int generateDataExportCsv(String dateFrom, String dateTo, String averageMinutes, String includeJournal) throws IOException {
		String urlParameters = "Period="+dateFrom+"+to+"+dateTo+"&AvgMinutes="+averageMinutes+"&IncludeJornal="+includeJournal+"";
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

		String requestUrl = "http://172.30.200.21/ManageData/GenerateExportData";

		HttpURLConnection httpConn = ServiceProperties.commonServiceProperties(requestUrl);
		
		ServiceProperties.generateExportDataProperties(httpConn);

		int responseCode = PostDataFromParameters.servicePostWithParameters(postData, httpConn);
		
		System.out.print(responseCode + ": ");
		return responseCode;
	}
}
