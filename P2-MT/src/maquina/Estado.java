/**
 * Esta clase implementa un estado.
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package maquina;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
