package ejemplo06;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {
	
	public static void main(String[] args) throws IOException{
		String host = "localhost";
	int puerto = 6000;
	Socket cliente = new Socket (host, puerto);
	
	ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
	oos.writeObject(new Persona("Daniel", 11));
	
	oos.close();
	cliente.close();
	}
}
