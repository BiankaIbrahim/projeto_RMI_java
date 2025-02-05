import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {
    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099
            LocateRegistry.createRegistry(1099);

            // Cria a implementação do serviço
            ContactServiceImpl contactService = new ContactServiceImpl();

            // Registra o serviço no RMI registry
            Naming.rebind("ContactService", contactService);

            System.out.println("Servidor RMI pronto para receber solicitações...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
