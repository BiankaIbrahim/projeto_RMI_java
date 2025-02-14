import java.rmi.Naming;
import java.util.Scanner;

import src.inteface.InterfaceContatoServidor;

public class Excluir {
    public static void main(String[] args) {
        try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Nome do contato a remover: ");
            String nome = scanner.nextLine();
            
            if (contactService.removerContato(nome)) {
                System.out.println("Contato removido!");
            } else {
                System.out.println("Contato não encontrado.");
            }
            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}