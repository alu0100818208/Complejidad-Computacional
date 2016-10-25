/**
 * Esta clase implementa una movimiento de la máquina junto con el elemento a depositar en la cinta.
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package maquina;

public class Movimiento {

	private String elemento;
	private String mov;
	
	
	public Movimiento(String elemento, String mov) {
		
		setElemento(elemento);
		setMov(mov);
	}
	
	public String getElemento() {
		return elemento;
	}
	
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	public String getMov() {
		return mov;
	}
	
	public void setMov(String mov) {
		this.mov = mov;
	}

	@Override
	public String toString() {
		return "(" + elemento + ", " + mov + ")";
	}
	
}
