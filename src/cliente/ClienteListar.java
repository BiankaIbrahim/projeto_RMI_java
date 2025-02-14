
import java.rmi.Naming;
import java.util.List;

import src.inteface.InterfaceContatoServidor;
import src.modelo.Contato;


public class ClienteListar {
    public static void main(String[] args) {
        try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            List<Contato> contatos = contactService.listarContatos();
            contatos.forEach(c -> System.out.println(c.getName() + " - " + c.getEmail() + " - " + c.getPhone()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}