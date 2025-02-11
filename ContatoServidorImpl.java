import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ContatoServidorImpl extends UnicastRemoteObject implements InterfaceContatoServidor {
    private List<Contato> contatos;

    public ContatoServidorImpl() throws RemoteException {
        super();
        contatos = new ArrayList<>();
    }

    @Override
    public void adicionarContato(String name, String email, String phone) throws RemoteException {
        contatos.add(new Contato(name, email, phone));
        System.out.println("Contato adicionado: " + name + ", " + email + ", " + phone);
    }

    @Override
    public List<Contato> listarContatos() throws RemoteException {
        return contatos;
    }

}
