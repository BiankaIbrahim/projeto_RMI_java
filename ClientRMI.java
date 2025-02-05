import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            // Localiza o serviço remoto
            ContactService contactService = (ContactService) Naming.lookup("rmi://localhost/ContactService");

            contactService.addContact("John Doe", "john@example.com", "123456789");
            contactService.addContact("Jane Smith", "jane@example.com", "987654321");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
