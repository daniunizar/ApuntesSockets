package ejemplo07;

import java.io.Serializable;

public class Persona implements Serializable{
	//Este ser� el objeto que enviaremos entre clientes y servidores
	//Para poder enviarlo la clase Persona deber� existir tanto en Cliente como en Servidor
	String nombre;
	int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
