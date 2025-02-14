package cliente;

import java.rmi.Naming;
import java.util.List;
import interfaces.InterfaceContatoServidor;
import modelo.Contato;

public class ClienteListar {
    public static void main(String[] args) {
        try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            List<Contato> contatos = contactService.listarContatos();
            contatos.forEach(c -> System.out.println(c.getNome() + " - " + c.getEmail() + " - " + c.getTelefone()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}