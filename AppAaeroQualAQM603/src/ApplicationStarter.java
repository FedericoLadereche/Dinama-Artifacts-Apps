
import java.io.IOException;

import server.Server;
 
public class ApplicationStarter {
 
    public static void main(String[] args) {
    	
    	new ApplicationStarter().runServer();
    	String saveDir = "C:\\Users\\federico.ladereche\\Desktop";
        
    }
    
    private void runServer() {
		 Server server = new Server();
		 server.run();
	}
}