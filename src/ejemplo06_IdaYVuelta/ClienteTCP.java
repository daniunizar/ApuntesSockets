package ejemplo06_IdaYVuelta;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String host = "localhost";
	int puerto = 6000;
	Socket cliente = new Socket (host, puerto);
	
	//ENVIAMOS AL SERVIDOR UNA PERSONA
	ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
	oos.writeObject(new Persona("Daniel", 11));
	
	
	
	// RECIBIMOS UNA PERSONA DE CLIENTE, ES LA QUE HEMOS ENVIADO, PERO MODIFICADA
	ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
	Persona persona = (Persona) ois.readObject();
	System.out.println("El cliente recibe del Servidor: "+persona.getNombre());
	oos.close();
	cliente.close();
	}
}
