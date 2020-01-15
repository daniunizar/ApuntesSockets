package ejemplo08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//esta es la clase principal del servidor
//los clientes contactarán con él, y para cada uno, creará un hilo
public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(6000);
		while (true) {
			Socket cliente = new Socket();
			cliente = server.accept();//pone al servidor a la escucha. Se queda aquí parado hasta que le contactan
			//cuando llega el cliente, pasa lo siguiente:
			HiloServidor hiloServidor = new HiloServidor(cliente); //le pasamos por parámetro el socket
			hiloServidor.start();
		}
	}

}
