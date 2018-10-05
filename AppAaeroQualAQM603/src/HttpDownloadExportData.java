import java.io.IOException;
import java.net.HttpURLConnection;

import commons.CSVDownloader;
import commons.ServiceProperties;
 
/**
 * A utility that downloads a file from a URL.
 * @author Federico Ladereche Ghiena
 *
 */
public class HttpDownloadExportData {
   
    private static final String REQUEST_URL = "http://172.30.200.21/ManageData/DownloadExportData";
 
    /**
     * Downloads a file from a URL
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
	public static int downloadFile(String saveDir) throws IOException {

		HttpURLConnection httpConn = ServiceProperties.commonServiceProperties(REQUEST_URL);
		
		ServiceProperties.downloadExportDataProperties(httpConn);
		
		int responseCode = CSVDownloader.downloadCSV(saveDir, httpConn);
		
		System.out.println(responseCode);
		return responseCode;
   }

	public static String getREQUEST_URL() {
		return REQUEST_URL;
	}
}
