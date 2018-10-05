package commons;

import java.util.Scanner;

public class ProcessClientInput {
	
	private static String FILE_LOCATION = "";
	private static String DATE_FROM = "";
	private static String DATE_TO = "";
	private static String AVERAGE_TIME = "";
	private static String INCLUDE_JOURNAL = "";
	
	private enum AverageTimeValues {
	    RAW_DATA,
	    ONE_MINUTE,
	    FIVE_MINUTES,
	    TEN_MINUTES,
	    FIFTEEN_MINUTES,
	    TWENTY_MINUTES,
	    THIRTY_MINUTES,
	    ONE_HOUR,
	    TWO_HOURS,
	    FOUR_HOURS,
	    EIGHT_HOURS,
	    TWELVE_HOURS,
	    DAILY,
	}
	
	public static void processInput() {
		Scanner in = new Scanner(System.in);
		
		welcome();
		
		getInputFileLocation(in);
		
		getInputDateFrom(in);
        
		getInputDateTo(in);
        
		getInputAverageTime(in);
		
		getInputIncludeJournal(in);
		
		in.close();
	}

	private static void welcome() {
		System.out.println("WELCOME TO AeroEqualAQM60 REST CSV FILE DOWNLOADER\n");
	}
	
	private static void getInputFileLocation(Scanner in) {
		System.out.print("Please insert .csv file destination: ");
		FILE_LOCATION = in.nextLine();
	}
	
	private static void getInputDateFrom(Scanner in) {
		System.out.println("\nPlease select a date range\n");
		System.out.print("Date from (dd/mm/yyyy): ");
		DATE_FROM = in.nextLine();
	}
	
	private static void getInputDateTo(Scanner in) {
		System.out.print("Date to (dd/mm/yyyy): ");
		DATE_TO = in.nextLine();
	}
	
	private static void getInputAverageTime(Scanner in) {
		System.out.println("\nPlease select a period, choose an option number listed below:\n");
		System.out.println("1->Raw Data 2->1 min 3->5 mins 4->10 mins 5->15 mins 6->20 mins 7->30 mins 8->1 hr 9->2 hrs 10->4 hrs 11->8 hrs 12->12 hrs 13->Daily\n");
		String option = in.nextLine();
		
		assignAverageTime(option);
	}

	private static void assignAverageTime(String option) throws NumberFormatException {
		AverageTimeValues whichValue = AverageTimeValues.values()[Integer.parseInt(option) - 1];
		switch (whichValue) {
		case RAW_DATA:
			AVERAGE_TIME = "Raw Data";
			break;
		case ONE_MINUTE:
			AVERAGE_TIME = "1";
			break;
		case FIVE_MINUTES:
			AVERAGE_TIME = "5";
			break;
		case TEN_MINUTES:
			AVERAGE_TIME = "10";
			break;
		case FIFTEEN_MINUTES:
			AVERAGE_TIME = "15";
			break;
		case TWENTY_MINUTES:
			AVERAGE_TIME = "20";
			break;
		case THIRTY_MINUTES:
			AVERAGE_TIME = "30";
			break;
		case ONE_HOUR:
			AVERAGE_TIME = "60";
			break;
		case TWO_HOURS:
			AVERAGE_TIME = "120";
			break;
		case FOUR_HOURS:
			AVERAGE_TIME = "240";
			break;
		case EIGHT_HOURS:
			AVERAGE_TIME = "480";
			break;
		case TWELVE_HOURS:
			AVERAGE_TIME = "720";
			break;
		case DAILY:
			AVERAGE_TIME = "1440";
			break;
		default:
			break;
		}
	}
	
	private static void getInputIncludeJournal(Scanner in) {
		System.out.println("\nInclude journal?\n");
		System.out.println("1->Yes 2->No\n");
		String includeJournal = in.nextLine();
		
		if(includeJournal.equalsIgnoreCase("1"))
			INCLUDE_JOURNAL = "true";
		else
			INCLUDE_JOURNAL = "false";
	}
	
	public static String getFileLocation() {
		return FILE_LOCATION;
	}

	public static String getDateFrom() {
		return DATE_FROM;
	}

	public static String getDateTo() {
		return DATE_TO;
	}

	public static String getAverageTime() {
		return AVERAGE_TIME;
	}

	public static String getIncludeJournal() {
		return INCLUDE_JOURNAL;
	}

}
