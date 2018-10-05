package commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * A utility that downloads a file.
 * 
 * @author Federico Ladereche Ghiena
 *
 */

public class CSVDownloader {
	private static final int BUFFER_SIZE = 4096;
	private static final String FILE_NAME = "AQM6 201712013-324 Data Export.csv";
	
	/**
     * Downloads a file from a URL
     * @param httpConn connection
     * @param saveDir path of the directory to save the file
     * @throws IOException
     */
	public static int downloadCSV(String saveDir, HttpURLConnection httpConn)
			throws IOException, FileNotFoundException {
		// opens input stream from the HTTP connection
		InputStream inputStream = httpConn.getInputStream();
		String saveFilePath = saveDir + File.separator + FILE_NAME;

		// opens an output stream to save into file
		FileOutputStream outputStream = new FileOutputStream(saveFilePath);

		int bytesRead = -1;
		byte[] buffer = new byte[BUFFER_SIZE];
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		outputStream.close();
		inputStream.close();

		int responseCode = httpConn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println(responseCode+ ": File " + FILE_NAME + " downloaded successfully at " + saveDir + " location");
			httpConn.disconnect();
		} else {
			System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		}
		return responseCode;
	}

	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public static String getFILE_NAME() {
		return FILE_NAME;
	}

}
