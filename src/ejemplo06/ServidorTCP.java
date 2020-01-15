package ejemplo06;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ServidorTCP {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int puerto = 6000;
		ServerSocket serverSocket = new ServerSocket(puerto);
		Socket cliente = serverSocket.accept();
		
		ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
		Persona persona = (Persona) ois.readObject();
		System.out.println("Recibimos en el Servidor: "+persona.getNombre());
		ois.close();
		serverSocket.close();
		
	}

}
