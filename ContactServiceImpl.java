import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl extends UnicastRemoteObject implements ContactService {
    private List<Contact> contacts;

    public ContactServiceImpl() throws RemoteException {
        super();
        contacts = new ArrayList<>();
    }

    @Override
    public void addContact(String name, String email, String phone) throws RemoteException {
        contacts.add(new Contact(name, email, phone));
        System.out.println("Contato adicionado: " + name + ", " + email + ", " + phone);
    }

    @Override
    public List<String> listarContatos() throws RemoteException {
        return contatos;
    }


    private static class Contact {
        private String name;
        private String email;
        private String phone;

        public Contact(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Nome: " + name + ", Email: " + email + ", Telefone: " + phone;
        }
    }
}
