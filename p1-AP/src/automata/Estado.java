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
	
	public Estado() {
		setNombre(new String(""));
	}
	
	public void setNombre (String n) {
		nombre = n;
	}
	
	public String getNombre () {
		return nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public boolean equals(Estado obj) {
		if(nombre.equals(obj.getNombre())) {
			return true;
		} else {
			return false;
		}
	}

}
