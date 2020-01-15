package ejemplo2_infinito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//CONEXIÓN TCP, Si no llega un paquete se vuelve a reenviar.
public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 6000; //puerto en el que vamos a estar a la escucha. El puerto debe estar previamente libre
		//importante desactivar firewall o decirle que permita las conexiones entrantes por él
		//un socket se representa con IP y puerto. Necesitamos esas 2 cosas
		ServerSocket server;
		server = new ServerSocket(puerto);
		boolean finalizar=false;
		while(!finalizar) {
			Socket cliente1 = server.accept();
			//ServerSocket implementa sockets que vienen a conectarse

			//hasta aquí, si lanzamos el servidor, l que hace es quedarse a la escucha. NO hace nada más. Está a la espera de conexiones entrantes.
			System.out.println("Soy el Servidor: Cuando el cliente se conecta, el código del servidor continúa hasta acabar y muere"); //aquí viene lo que va a hacer cuando alguno se le conecte
			InputStream is = cliente1.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			System.out.println(dis.readUTF()); //leemos lo que nos manda el cliente

			DataOutputStream dos = new DataOutputStream(cliente1.getOutputStream());
			dos.writeUTF("Soy el servidor: Mensaje enviado por el servidor");
			//is.close();
			//dos.close();
			
		}			
		server.close();


	}

}
