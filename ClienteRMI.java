import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {

         try {
            InterfaceContatoServidor contactService = (InterfaceContatoServidor) Naming.lookup("rmi://localhost/ContactService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n");
                System.out.println("O que você deseja?");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Listar Contatos");
                System.out.println("3. Atualizar Contato");
                System.out.println("4. Remover Contato");
                System.out.println("5. Sair");
                System.out.println("\n");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        contactService.adicionarContato(nome, email, telefone);
                        System.out.println("\nContato adicionado com sucesso!");
                        break;
                    case 2:
                
                    List<Contato> contatos = contactService.listarContatos();
                        contatos.forEach(c -> System.out.println("\n" + c.getName() + " - " + c.getEmail() + " - " + c.getPhone()));
                        break;
                    case 3:
                        System.out.print("Nome do contato a atualizar: ");
                        String nomeAtualizar = scanner.nextLine();
                        System.out.print("Novo Email: ");
                        String novoEmail = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        String novoTelefone = scanner.nextLine();
                      //  contato.atualizarContato(nomeAtualizar, novoEmail, novoTelefone);
                        break;
                    case 4:
                        System.out.print("Nome do contato a remover: ");
                        String nomeRemover = scanner.nextLine();
                      //  contato.removerContato(nomeRemover);
                        break;
                    case 5:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

