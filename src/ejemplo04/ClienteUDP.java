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
			
			byte[] buffer = new byte[1024]; //explicitmaos el tama�o
			String mensaje = "Hello world!";//nos va a sobrar tama�o, se podr�a ajustar
			buffer = mensaje.getBytes();
			
			//Datagrama es el envoltorio. Tendr� la cabecera y el propio mensaje a enviar
			DatagramPacket paquete = new DatagramPacket(buffer,  buffer.length, destino, puerto); //se pasa mensaje, tama�o, destino y puerto del servidor
			DatagramSocket datagramSocket = new DatagramSocket(34500); // localPort
			
			datagramSocket.send(paquete);
			
			
			datagramSocket.close();
	}

}
