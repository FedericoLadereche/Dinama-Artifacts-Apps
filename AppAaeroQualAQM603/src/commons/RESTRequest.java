package commons;

import java.io.IOException;

import restdomain.HttpConnectionAndLogin;
import restdomain.HttpDownloadExportData;
import restdomain.HttpGenerateExportData;

public class RESTRequest {

	public static void makeSuccessiveRequests(String dateFrom, String dateTo, String averageTime, String includeJornal, String saveDir) {
		int responseCodeLoggin;
        int responseCodeGenerateCsv;
        int responseDownloadCsv;
        try {
        	responseCodeLoggin = HttpConnectionAndLogin.logginIntoApplication();
        	if(responseCodeLoggin == 200 || responseCodeLoggin == 302)
        	{
        		System.out.println("Connection and login successfully!");
        		responseCodeGenerateCsv = HttpGenerateExportData.generateDataExportCsv(dateFrom, dateTo, averageTime, includeJornal);
        		if(responseCodeGenerateCsv == 200 || responseCodeGenerateCsv == 302)
            	{
        			System.out.println("CSV file successfully generated!");
        			responseDownloadCsv = HttpDownloadExportData.downloadFile(saveDir);
            	}
        	}
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
}
