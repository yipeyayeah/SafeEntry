package user;

import java.rmi.Naming;			//Import the rmi naming - so you can lookup remote object
import java.rmi.RemoteException;	//Import the RemoteException class so you can catch it
import java.net.MalformedURLException;	//Import the MalformedURLException class so you can catch it
import java.rmi.NotBoundException;	//Import the NotBoundException class so you can catch it

public class SafeEntryClient {
	
	public static void main(String[] args) {

	      //use localhost if running the server locally or use IP address of the server
	       String reg_host = "localhost";
	       int reg_port = 1099;

	       if (args.length == 1) {
	       	   reg_port = Integer.parseInt(args[0]);
	       } else if (args.length == 2) {
	      	   reg_host = args[0];
	      	   reg_port = Integer.parseInt(args[1]);
	      }

		try {
	        // Create the reference to the remote object through the rmiregistry
			SafeEntry SE = (SafeEntry)
					Naming.lookup("rmi://"+reg_host+"/SafeEntryService");
	        // Now use the reference c to call remote methods
				System.out.println("Test login: " + SE.login());
				System.out.println("Test logout: " + SE.logout());
				System.out.println("Test checkin: " + SE.checkin());
				System.out.println("Test checkout: " + SE.checkout());
				
	      // e.g., call c.add(3, 21) where c is the instance of the remote object
		    
	  }
	  // Catch the exceptions that may occur - rubbish URL, Remote exception
		// Not bound exception or the arithmetic exception that may occur in
		// one of the methods creates an arithmetic error (e.g. divide by zero)
		catch (MalformedURLException murle) {
	            System.out.println();
	            System.out.println("MalformedURLException");
	            System.out.println(murle);
	        }
	        catch (RemoteException re) {
	            System.out.println();
	            System.out.println("RemoteException");
	            System.out.println(re);
	        }
	        catch (NotBoundException nbe) {
	            System.out.println();
	            System.out.println("NotBoundException");
	            System.out.println(nbe);
	        }
	        catch (java.lang.ArithmeticException ae) {
	            System.out.println();
	            System.out.println("java.lang.ArithmeticException");
	            System.out.println(ae);
	        }
	    }
}
