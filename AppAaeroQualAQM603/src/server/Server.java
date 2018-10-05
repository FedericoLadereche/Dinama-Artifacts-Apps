package server;

import java.io.IOException;

import commons.ProcessClientInput;
import commons.RESTRequest;
import restdomain.HttpConnectionAndLogin;
import restdomain.HttpDownloadExportData;
import restdomain.HttpGenerateExportData;

public class Server implements Runnable {
	private String dateFrom = "";
	private String dateTo = "";
	private String averageTime = "";
	private String includeJornal = "";
	private String saveDir = "";
	volatile boolean keepProcessing = true;
	
	public Server() {}
	
	public void run() {
		initiateClientDialog();
		
		dateFrom = ProcessClientInput.getDateFrom();
		dateTo = ProcessClientInput.getDateTo();
		averageTime = ProcessClientInput.getAverageTime();
		includeJornal = ProcessClientInput.getIncludeJournal();
		saveDir = ProcessClientInput.getFileLocation();
		
//		while (keepProcessing) {
			process();
			stopProcessing();
//		}
	}
	
	void process() {
		Runnable clientHandler = new Runnable() {

			@Override
			public void run() {
				try {
					downloadCSVFile();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			private void downloadCSVFile() throws InterruptedException {
				RESTRequest.makeSuccessiveRequests(dateFrom, dateTo, averageTime, includeJornal, saveDir);
			}
		};
		
		Thread clientRequest = new Thread(clientHandler);
		clientRequest.start();
	}
	
	void initiateClientDialog() {
		ProcessClientInput.processInput();
	}
	
	public void stopProcessing() {
		keepProcessing = false;
	}
}
