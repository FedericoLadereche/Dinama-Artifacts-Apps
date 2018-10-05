package commons;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceProperties {

	public static HttpURLConnection commonServiceProperties(String requestUrl) throws MalformedURLException, IOException {
		URL url = new URL(requestUrl);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setDoOutput(true);
		httpConn.setInstanceFollowRedirects(false);
		httpConn.setRequestProperty("Host", "172.30.200.21");
		httpConn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		httpConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		httpConn.setRequestProperty("Accept-Language", "es-AR,es;q=0.8,en-US;q=0.5,en;q=0.3");
		httpConn.setRequestProperty("Accept-Encoding", "application/gzip");
		httpConn.setRequestProperty("Connection", "keep-alive");
		httpConn.setRequestProperty("Upgrade", "1");
		
		return httpConn;
	}
	
	public static void connectionAndLoginProperties(HttpURLConnection httpConn) throws ProtocolException {
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Referer", "http://172.30.200.21/Account/Login");
		httpConn.setRequestProperty("Cookie",
				"_ga=GA1.1.898747765.1535129430; ASP.NET_SessionId=073D2ECBD4A1C8B8EC65C54D; _gid=GA1.1.1328114437.1537795444; CurrentDownloadAvgMinutes=1440");
	}
	
	public static void generateExportDataProperties(HttpURLConnection httpConn) throws ProtocolException {
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Referer", "http://172.30.200.21/ManageData/DownloadData");
		httpConn.setRequestProperty("Cookie",
				"_ga=GA1.1.898747765.1535129430; ASP.NET_SessionId=073D2ECBD4A1C8B8EC65C54D; _gid=GA1.1.1328114437.1537795444; CurrentDownloadAvgMinutes=1440; .MONOAUTH=4MI6pzELFbBAT3wzvbyeEN/kylcTh3+aIuHSriYdipyisnFtIiaZQmKEaSFpKOIJ9F7sYTUMR2YzngbsRKBaDStlVUa/ie9GoXtEH91tk1ZN4wUBgofYPT3Ktu8jZOBm");
	}
	
	public static void downloadExportDataProperties(HttpURLConnection httpConn) throws ProtocolException {
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("Referer", "http://172.30.200.21/ManageData/DownloadData");
		httpConn.setRequestProperty("Cookie",
				"_ga=GA1.1.898747765.1535129430; ASP.NET_SessionId=073D2ECBD4A1C8B8EC65C54D; _gid=GA1.1.1328114437.1537795444; CurrentDownloadAvgMinutes=1440; .MONOAUTH=4MI6pzELFbBAT3wzvbyeEN/kylcTh3+aIuHSriYdipyisnFtIiaZQmKEaSFpKOIJ9F7sYTUMR2YzngbsRKBaDStlVUa/ie9GoXtEH91tk1ZN4wUBgofYPT3Ktu8jZOBm; _gat=1");
	}
	
}
