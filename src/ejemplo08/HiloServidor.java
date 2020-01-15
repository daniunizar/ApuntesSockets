package ejemplo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//es el hilo del servidor, No tiene main ni nada.
//El servidor va a recibir una cadena del socket que tenga como parámetro y responderá mientras no reciba un asterisco
public class HiloServidor extends Thread{
	Socket socket;
	BufferedReader br;
	PrintWriter printWriter;
	public HiloServidor(Socket s) throws IOException { //vamos a recibir por parámetro un socket, cuando instanciemos el hilo le pasaremos la conexión socket ya hecha
		socket = s; //como necesitamos acceder a socket desde el hilo, desdel el método run, lo igualamos a la de arriba
		printWriter = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //se podría leer byte a byte, pero esto facilita
	}
	public void run() {
		String cadena = "";
		System.out.println("Conexión con "+socket.toString());
		
		while(!cadena.trim().equals("*")) { //el trim quita espacios
			try {
				cadena = br.readLine(); //leemos del bufferedReader hasta que lleguemos a un asterisco
				System.out.println("He leído: "+cadena); //mostramos el buffer por consola
				//lo que nos permite el PrintWriter es esto:
				printWriter.println("Hola cliente, soy tu servidor, me has enviado: "+cadena);
				//este último println no va a ir a la consola del servidor,irá al getOutputStream del socket enviando al cliente
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {//liberamos recursos
			socket.close();
			printWriter.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Hilo finalizado"+getName()); //así cuando recibamos asterisco, informaremos del fin del hilo
	}
}
