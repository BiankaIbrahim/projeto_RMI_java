import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {

         try {
            ContatoInterface contato = (ContatoInterface) Naming.lookup("rmi://localhost/ContatoService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Listar Contatos");
                System.out.println("3. Atualizar Contato");
                System.out.println("4. Remover Contato");
                System.out.println("5. Sair");
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
                        contato.adicionarContato(nome, email, telefone);
                        break;
                    case 2:
                        List<String> contatos = contato.listarContatos();
                        contatos.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Nome do contato a atualizar: ");
                        String nomeAtualizar = scanner.nextLine();
                        System.out.print("Novo Email: ");
                        String novoEmail = scanner.nextLine();
                        System.out.print("Novo Telefone: ");
                        String novoTelefone = scanner.nextLine();
                        contato.atualizarContato(nomeAtualizar, novoEmail, novoTelefone);
                        break;
                    case 4:
                        System.out.print("Nome do contato a remover: ");
                        String nomeRemover = scanner.nextLine();
                        contato.removerContato(nomeRemover);
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

