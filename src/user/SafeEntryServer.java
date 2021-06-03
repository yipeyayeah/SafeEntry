package user;

import java.rmi.Naming;

public class SafeEntryServer {
	static int reg_port = 1099;
	static String reg_host = "localhost";
   //SafeEntryServer constructor
   public SafeEntryServer() {

		 try {
		 	//Construct a new CalculatorImpl object and bind it to the local rmiregistry
     		//N.b. it is possible to host multiple objects on a server
			 
			 SafeEntry SE = new SafeEntryimpl();
			 //Naming.rebind("rmi://localhost:" + reg_port + "/SafeEntryService",SE);
			  Naming.rebind("rmi://localhost/SafeEntryService", SE);		

     }
		 catch (Exception e) {
		       System.out.println("Server Error: " + e);
		     }
		   }
   public static void main(String args[]) {
    	//Create the new Calculator server
		 System.setProperty("java.rmi.server.hostname", reg_host);
			if (args.length == 1)
				reg_port = Integer.parseInt(args[0]);
				new SafeEntryServer();
  		}

}
