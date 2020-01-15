package ejemplo05;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class ServidorUDP {
	//EN ESTE EJEMPLO EL SERVIDOR ENVÍA, EN EL ANTERIOR RECIBÍA
//VAMOS A HACER UN BROADCAST
	//VAMOS A PONER VARIOS PROGRAMAS A LA ESCUCHA, Y QUE UNO ENVÍE UN MENSAJE A TODOS ELLOS
	//enviaremos algo que escribiremos por teclado
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 42000;
		Scanner teclado = new Scanner(System.in);
		MulticastSocket multicastSocket = new MulticastSocket(); //como es el que va a enviar no hace falta definir puerto.
		//Se define puerto si estás a la escucha
		InetAddress address = InetAddress.getByName("225.0.0.1");
		String linea = "";
		while (!(linea = teclado.nextLine()).equals("*")){
			byte[] buffer = new byte[1024];
			buffer = linea.getBytes();
			
			DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, address, puerto);
			multicastSocket.send(paquete);
		}
		
		multicastSocket.close();
	}

}
