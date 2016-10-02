/**
 * Esta clase implementa una trancisión entre estados.
 * @author: Ángel David Martín Rodríguez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Práctica 1
 */

package automata;

public class Trancision {
   
	private Estado origen;		// Estado de partida de la trancisión
	private Estado destino;		// Estado de destino de la trancisión
	
	private String entradaCadena;		// Elemento de la cadena analizada
	private String eltoPila;			// Elemento que debe tener la pila para la trancisión
	private String sustPila;			// Elemento/s que pondremos en la pila
	
	// Construimos la trancisión
	public Trancision (Estado q1, String a, String ap1, Estado q2, String ap2) {		//δ(q1, a1, A1) = (q2, A2)
		
		setOrigen (q1);
		setDestino (q2);
		setEntradaCadena (a);
		setEltoPila (ap1);
		setSustPila (ap2);
		
	}

	public Estado getOrigen () {
		return origen;
	}

	public void setOrigen (Estado origen) {
		this.origen = origen;
	}

	public Estado getDestino () {
		return destino;
	}

	public void setDestino (Estado destino) {
		this.destino = destino;
	}

	public String getEntradaCadena () {
		return entradaCadena;
	}

	public void setEntradaCadena (String entradaCadena) {
		this.entradaCadena = entradaCadena;
	}

	public String getEltoPila () {
		return eltoPila;
	}

	public void setEltoPila (String eltoPila) {
		this.eltoPila = eltoPila;
	}

	public String getSustPila () {
		return sustPila;
	}

	public void setSustPila (String sustPila) {
		this.sustPila = sustPila;
	}
	
	
}
