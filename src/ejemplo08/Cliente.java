package ejemplo08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String host = "localhost";
		int puerto = 6000; //lo que hemos puesto en el servidor
		
		Socket cliente = new Socket (host, puerto);
		
		//nuestro cliente va a enviar mensajes al servidor
		PrintWriter printWriter = new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		//y ya simplemente
		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			String cadena = teclado.nextLine();
			printWriter.println(cadena);
			String respuesta = br.readLine(); //recogemos lo que nos responde el servidor
			System.out.println("El servidor nos ha contestado: "+respuesta);
			if (cadena.equals("*")) break; //si leemos asterisco, salimos
		}
		//al salir cerramos todo
		cliente.close();
		printWriter.close();
		br.close();
	}

}
