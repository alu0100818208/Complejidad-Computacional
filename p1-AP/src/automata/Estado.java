/**
 * Ésta clase implementa los estados de un automata.
 * @author: Ángel David Martín Rodríguez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Práctica 1
 */

package automata;

public class Estado {
	
	private String nombre; // Nombre del estádo
	
	// Constructor 
	public Estado (String n) {
		setNombre(n);
	}
	
	public void setNombre (String n) {
		nombre = n;
	}
	
	public String getNombre () {
		return nombre;
	}

}
