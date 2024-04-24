import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class HelloClient {
    private HelloClient() {}

    public static void main(String[] args) {
        try {
            // Get the reference to the remote object
            Registry registry = LocateRegistry.getRegistry(null);
            Hello stub = (Hello) registry.lookup("Hello");

            // Invoke the remote method
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
