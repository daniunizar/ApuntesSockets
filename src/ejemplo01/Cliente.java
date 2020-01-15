package ejemplo01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost"; //127.0.0.1 es la direcci�n del equipo local
		int puerto = 6000; //el cliente no tiene que poner puerto a la escucha. Este es el puerto al que iremos al servidor
		
		Socket cliente = new Socket(host, puerto); //necesitamos ip y puerto
		//aqu� ya se ha conectado, e inicia el c�digo del Servidor
		
		//AHORA vamos a coger informaci�n de la conexi�n
		InetAddress address = cliente.getInetAddress();
		//m�todos de InetAddress
		System.out.println("Puerto local: "+address.getHostAddress());
		System.out.println("Nombre Puerto local: "+address.getHostName());
		//M�todos del cliente
		System.out.println("El puerto del cliente es: "+cliente.getLocalPort());
		System.out.println("El cliente se est� conectando al puerto:"+ cliente.getPort());
	}

}
