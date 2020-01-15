package ejemplo2_infinito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost"; //127.0.0.1 es la dirección del equipo local
		int puerto = 6000; //el cliente no tiene que poner puerto a la escucha. Este es el puerto al que iremos al servidor
		System.out.println("Soy el cliente: Conexión al servidor");
		Socket cliente = new Socket(host, puerto); 
		DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
		dos.writeUTF("Soy el cliente: Probando");
		
		
		InputStream is = cliente.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		System.out.println(dis.readUTF());	
		dos.close();
		cliente.close();
	}

}
