package user;

import java.rmi.RemoteException;

public class SafeEntryimpl extends java.rmi.server.UnicastRemoteObject implements SafeEntry{
	
	public SafeEntryimpl()
	        throws java.rmi.RemoteException {
	        super();
	    }
	
	public String login() throws java.rmi.RemoteException {
		return ("login");
	}
	
	public String logout() throws java.rmi.RemoteException {
		return ("logout");
	}

	public String checkin() throws RemoteException {
		return ("Checkin");
	}

	public String checkout() throws RemoteException {
		return ("Checkout");
	}
}
