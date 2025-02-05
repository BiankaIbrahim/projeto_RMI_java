import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContactService extends Remote {
    void addContact(String name, String email, String phone) throws RemoteException;
}