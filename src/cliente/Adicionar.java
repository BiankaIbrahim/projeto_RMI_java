

import java.rmi.Naming;
import java.util.Scanner;

import src.inteface.InterfaceContatoServidor;


public class Adicionar {
    public static void main(String[] args) {
  
        try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            
            contactService.adicionarContato(nome, email, telefone);
            System.out.println("Contato adicionado!");
            
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
}
}

