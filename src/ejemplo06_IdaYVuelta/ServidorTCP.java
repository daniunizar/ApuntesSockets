package ejemplo06_IdaYVuelta;
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
		
		//RECIBIMOS UNA PERSONA DE CLIENTE
		ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
		Persona persona = (Persona) ois.readObject();
		System.out.println("Recibimos en el Servidor: "+persona.getNombre());
		
		
		
		//LA MODIFICAMOS
		persona.setNombre("NombreNuevo");
		
		//y la enviamos al cliente:
		ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
		oos.writeObject(persona);
		ois.close();
		oos.close();
		serverSocket.close();
	}

}
