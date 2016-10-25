/**
 * Esta clase implementa una trancisiÃ³n entre estados.
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package maquina;

import java.util.ArrayList;

public class Transicion {

	private Estado origen;		// Estado de partida de la trancisiÃ³n
	private Estado destino;		// Estado de destino de la trancisiÃ³n
	
	private String entrada;							// Elemento/s de la/s cinta/s. 
	private ArrayList<Movimiento> sustCintas;		// Elementos que pondremos en la cinta y el movimiento que se tendrá que hacer.
	
	// Construimos la trancisiÃ³n
	public Transicion (Estado q1, String a, Estado q2, ArrayList<Movimiento> m) {		//(q1, a1, ab) = (q2, (., L), (., S), ...)
		
		setOrigen (q1);
		setDestino (q2);
		setEntrada (a);
		setSustCintas (m);
		
		
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

	public String getEntrada () {
		return entrada;
	}

	public void setEntrada (String entradaCadena) {
		this.entrada = entradaCadena;
	}

	public ArrayList<Movimiento> getSustCintas() {
		return sustCintas;
	}

	public void setSustCintas(ArrayList<Movimiento> sustCintas) {
		this.sustCintas = sustCintas;
	}
	
	@Override
	public String toString() {
		return "(" + origen + "," + entrada + ") = (" + destino + "," + sustCintas + ")";
	}
	
}
