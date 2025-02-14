package src.servidor;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099
            LocateRegistry.createRegistry(1099);

            // Cria a implementação do serviço
            ContatoServidorImpl contactService = new ContatoServidorImpl();

            // Registra o serviço no RMI registry
            Naming.rebind("ContactService", contactService);

            System.out.println("Servidor RMI pronto para receber solicitações...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
