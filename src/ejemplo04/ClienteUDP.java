package ejemplo04;
//AHORA VAMOS A TRBAJAR CON UDP
//LO QUE NO LLEGUE, SE PIERDE, ES PARA STREAM, VIDEOLLAMADAS...
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClienteUDP {
	
		public static void main(String[] args) throws IOException {
			int puerto = 12000;
			InetAddress destino = InetAddress.getLocalHost();
			
			byte[] buffer = new byte[1024]; //explicitmaos el tamaño
			String mensaje = "Hello world!";//nos va a sobrar tamaño, se podría ajustar
			buffer = mensaje.getBytes();
			
			//Datagrama es el envoltorio. Tendrá la cabecera y el propio mensaje a enviar
			DatagramPacket paquete = new DatagramPacket(buffer,  buffer.length, destino, puerto); //se pasa mensaje, tamaño, destino y puerto del servidor
			DatagramSocket datagramSocket = new DatagramSocket(34500); // localPort
			
			datagramSocket.send(paquete);
			
			
			datagramSocket.close();
	}

}
