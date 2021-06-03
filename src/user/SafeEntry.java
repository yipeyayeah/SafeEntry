package user;

public interface SafeEntry extends java.rmi.Remote {
	public String login() throws java.rmi.RemoteException;
	public String logout() throws java.rmi.RemoteException;
	public String checkin() throws java.rmi.RemoteException;
	public String checkout() throws java.rmi.RemoteException;
}
