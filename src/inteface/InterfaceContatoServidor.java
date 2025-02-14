package src.inteface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import src.modelo.Contato;

public interface InterfaceContatoServidor extends Remote {
    void adicionarContato(String name, String email, String phone) throws RemoteException;

    List<Contato> listarContatos() throws RemoteException;
}