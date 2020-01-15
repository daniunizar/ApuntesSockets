package ejemplo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//CONEXIÓN TCP, Si no llega un paquete se vuelve a reenviar.
public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6000; //puerto en el que vamos a estar a la escucha. El puerto debe estar previamente libre
		//importante desactivar firewall o decirle que permita las conexiones entrantes por él
		//un socket se representa con IP y puerto. Necesitamos esas 2 cosas
		ServerSocket server;
		try {
			
			server = new ServerSocket(puerto);
			Socket cliente1 = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //ServerSocket implementa sockets que vienen a conectarse
		
		//hasta aquí, si lanzamos el servidor, l que hace es quedarse a la escucha. NO hace nada más. Está a la espera de conexiones entrantes.
		System.out.println("Cuando el cliente se conecta, el código del servidor continúa hasta acabar y muere");
	}

}
 