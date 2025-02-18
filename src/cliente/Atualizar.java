import java.rmi.Naming;
import java.util.Scanner;
import src.inteface.InterfaceContatoServidor;

public class Atualizar {
    public static void main(String[] args) {
        try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nome do contato a ser atualizado: ");
            String nomeAntigo = scanner.nextLine();

            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();

            System.out.print("Novo email: ");
            String novoEmail = scanner.nextLine();

            System.out.print("Novo telefone: ");
            String novoTelefone = scanner.nextLine();

            if (contactService.atualizarContato(nomeAntigo, novoNome, novoEmail, novoTelefone)) {
                System.out.println("Contato atualizado com sucesso!");
            } else {
                System.out.println("Contato não encontrado.");
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
