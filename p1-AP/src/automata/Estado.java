/**
 * �sta clase implementa los estados de un automata.
 * @author: �ngel David Mart�n Rodr�guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Pr�ctica 1
 */

package automata;

public class Estado {
	
	private String nombre; // Nombre del est�do
	
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
