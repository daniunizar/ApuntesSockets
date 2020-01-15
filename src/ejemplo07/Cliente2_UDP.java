package ejemplo07;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Cliente2_UDP {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//Nos ponemos a la escucha en un puerto
		//recuperamos el datagrama
		//y pasamos los bytes del datagrama a Objeto
		
		DatagramSocket datagramSocket = new DatagramSocket(6000);
		byte[] recibidos = new byte[1024];
		
		DatagramPacket datagramPacket = new DatagramPacket (recibidos, recibidos.length);
		datagramSocket.receive(datagramPacket); //esto nos pone a la escucha y lo que reciba lo guarda en datagramPacket
		
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(recibidos);
		ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
		Persona persona = (Persona) ois.readObject();
		System.out.println("Cliente 2 imprime persona enviada por cliente 1: "+persona.getNombre());
		ois.close();
		
	}

}
