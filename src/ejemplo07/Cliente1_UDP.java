package ejemplo07;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente1_UDP {
//soy el cliente que construye un datagrama y lo env�a
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Para UDP:
		//Debemos construir el datagrama y enviarlo.
		//No hay que hacer conexi�n ni sockets ni nada.
		//El servidor reconstruye el datagramPacket y lo lee
		//Al hacerlo con objetos, la �nica dificultad es pasarlo a bytes
		
		InetAddress host = InetAddress.getLocalHost();
		int puerto = 6000;
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		Persona persona = new Persona("Daniel", 11);
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);
		oos.writeObject(persona);
		oos.close(); //cerramos, s�lo lo hemos usado para crear los bytes
		byte[] bytes = arrayOutputStream.toByteArray(); //aqu� tenemos perosna como un conjunto de bytes
		//para enviar un datagrama tenemos que convertir todo a bytes
		
		//lo que sigue no difire mucho del ejemplo de datagramas que no son objetos:
		
		DatagramPacket envio = new DatagramPacket(bytes, bytes.length, host, puerto);//le pasamos el archivo, tama�o, host y puerto
		datagramSocket.send(envio);
		datagramSocket.close();//esto ya env�a, pero hasta que no hagamos el cliente 2 no hay nadie a la escucha
		
	}

}
