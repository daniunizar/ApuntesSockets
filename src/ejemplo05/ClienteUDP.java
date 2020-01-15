package ejemplo05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClienteUDP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 42000;
		MulticastSocket multicastSocket = new MulticastSocket(puerto); //creamos un objeto de esta clase en ese puerto
		InetAddress address = InetAddress.getByName("225.0.0.1"); //si cogemos una ip diferente no funcionar�, est� dise�ado para eso
		multicastSocket.joinGroup(address); //el programa se pone a la escucha de todos los paquetes con esa ip.
		//Cuando se env�e algo a esa ip, todos los que est�n en el grupo estar�n para recibirla
		
		String linea = "";
		while (!linea.trim().equals("*")){//mientras el cliente no reciba un asterisco vamos a hacer bucle
			byte[] buffer = new byte[1024];
			
			DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
			multicastSocket.receive(recibido);
			String paquete = new String (recibido.getData());
			System.out.println("Recibido: "+paquete);			
		}
		
		multicastSocket.leaveGroup(address);
		multicastSocket.close();
		
	}

}
