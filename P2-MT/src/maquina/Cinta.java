/**
 * Esta clase implementa una cinta de la Máquina de Turing
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package maquina;

import java.util.ArrayList;

public class Cinta {

	static final int TAMCINTA = 20;			// Constante con tamaño de la cinta por los lados además del contenido
	
	private ArrayList<String> cinta;
	private int cabeza;						// Posición cabeza lectora
	private String blanco;					// Elemento blanco
	
	public Cinta() {
		
		setCinta(new ArrayList<String>());
		setCabeza(0);
		setBlanco(new String());
		
	}
	
	// Constructor que crea una cinta con 20 simbolos blanco
	public Cinta(String blanco) {
		
		ArrayList<String> aux = new ArrayList<String>();
		for(int i = 0; i < TAMCINTA; i++) {
			aux.add(blanco);
		}
		setCinta(aux);
		setCabeza(0);
		setBlanco(blanco);
		
	}
	
	// Constructor con la cadena que se pondrá en la cinta
	public Cinta(String cadena, String blanco) {
		ArrayList<String> cinta = new ArrayList<String>();
		for(int i = 0; i < cadena.length(); i++) {
			cinta.add(String.valueOf(cadena.charAt(i)));
		}
		setCinta(cinta);
		setCabeza(0);
		this.blanco = blanco;
	}
	
	
	
	// Método para ejecutar el movimiento y la sustitución de la trancisión
	public void Mover(Movimiento mov) {
		
		// Si estamos a la izquierda del todo movemos el array 20 elementos a la derecha y rellenamos con blancos
		if(mov.getMov().equals("L")) {
			
			if(getCabeza() == 0) {
				Crecer("L");
			}
			
			cinta.set(cabeza, mov.getElemento());
			setCabeza(getCabeza() - 1);
			
		// Si estamos en el último elemento de la derecha le añadimos 20 elementos blancos por la derecha	
		} else if (mov.getMov().equals("R")) {
			
			if(getCabeza() == (getCinta().size() - 1)) {
				Crecer("R");
			}
			
			cinta.set(cabeza, mov.getElemento());
			setCabeza(getCabeza() + 1);
			
		} else if (mov.getMov().equals("S")) {
			
			cinta.set(cabeza, mov.getElemento());
			
		}
		
		
		
	}
	
	// Método para agrandar la cinta en caso de que sea necesario y así lograr la visión infinita de la misma
	private void Crecer(String lado) {
		
		ArrayList<String> aux = new ArrayList<String>();
		// Rellenamos el auxiliar con blancos
		for(int i = 0; i < TAMCINTA; i++) {
			aux.add(getBlanco());
		}
		
		// En caso de ir hacia la izquierda y estar en la posición 0 del array
		if(lado.equals("L")) {
			
			// Añadimos TAMCINTA elementos por la izquierda
			aux.addAll(cinta);
			// Y movemos la cabeza 20 posiciones a la derecha
			setCabeza(getCabeza() + TAMCINTA);
			
		} else if (lado.equals("R")) {
			
			// Añadimos TAMCINTA elementos por la derecha
			cinta.addAll(aux);
			
		}
		
	}

	public ArrayList<String> getCinta() {
		return cinta;
	}

	public void setCinta(ArrayList<String> cinta) {
		this.cinta = cinta;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}

	public String getBlanco() {
		return blanco;
	}

	public void setBlanco(String blanco) {
		this.blanco = blanco;
	}

	@Override
	public String toString() {
		String out = new String();
		for(int i = 0; i < cinta.size(); i++) {
			out = out + "[" + cinta.get(i);
			if(cabeza == i) {
				out = out + "*]";
			} else {
				out = out + "]";
			}
		}
		return out;
	}
	
}
