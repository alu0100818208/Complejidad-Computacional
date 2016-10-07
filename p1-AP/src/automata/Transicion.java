/**
 * Esta clase implementa una trancisiÃ³n entre estados.
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 1
 */

package automata;

import java.util.ArrayList;

public class Transicion {
   
	private Estado origen;		// Estado de partida de la trancisiÃ³n
	private Estado destino;		// Estado de destino de la trancisiÃ³n
	
	private String entradaCadena;		// Elemento de la cadena analizada
	private String eltoPila;			// Elemento que debe tener la pila para la trancisiÃ³n
	private ArrayList<String> sustPila;			// Elemento/s que pondremos en la pila
	
	// Construimos la trancisiÃ³n
	public Transicion (Estado q1, String a, String ap1, Estado q2, ArrayList<String> ap2) {		//Î´(q1, a1, A1) = (q2, A2)
		
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

	public ArrayList<String> getSustPila () {
		return sustPila;
	}

	public void setSustPila (ArrayList<String> ap2) {
		this.sustPila = ap2;
	}

	@Override
	public String toString() {
		return "(" + origen + "," + entradaCadena + "," + eltoPila
				+ ") = (" + destino + "," + sustPila + ")";
	}
	
	
}
