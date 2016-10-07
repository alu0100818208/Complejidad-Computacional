/**
 * Esta clase implementa una aut�mata a pila.
 * @author: �ngel David Mart�n Rodr�guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Pr�ctica 1
 */

package conversor;

import java.io.*;
import java.util.ArrayList;

import automata.Automata;
import automata.Estado;
import automata.Transicion;

public class Conversor {

	private Automata ap;
	
	public Conversor (String nombreArchivo) throws IOException {
		
		ap = new Automata();
		
		ArrayList<String> epsilon = new ArrayList<String>();
		epsilon.add(".");
		
		// Si el  archivo no es de tipo automata a pila notificamos el error y cerramos el programa
		if (!nombreArchivo.endsWith(".ap")) {
			System.err.println("Error: El archivo no es de tipo Automata con Pila (.ap).");
			System.exit(0);
		}
		
		
		BufferedReader lector = new BufferedReader (new FileReader(nombreArchivo));
		String dummy = lector.readLine();
		
		// Minentras sean lineas con comentarios, las pasamos.
		while (dummy.startsWith("#")) {
			dummy = lector.readLine();
		}
		
		String[] spliter;
		
		// La primera l�nea corresponde con los estados del automata
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addEstado(new Estado(spliter[i]));
		}
		
		// La segunda l�nea corresponde con el alfabeto de la cadena de entrada
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addElementoE(spliter[i]);
		}
		
		// La tercera l�nea corresponde con  el alfabeto de la pila
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addElementoP(spliter[i]);
		}
		
		// La cuarta l�nea corresponde con el estado inicial
		dummy = lector.readLine();
		ap.setInicialS(new Estado(dummy));
		
		// La quinta l�nea corresponde con el s�mbolo inicial de la pila
		dummy = lector.readLine();
		ArrayList<String> pila = new ArrayList<String>();
		pila.add(dummy);
		ap.setPila(pila);
		
		// La sexta l�nea corresponde con el conunto de estados de aceptaci�n
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		if (!dummy.equals(".")) {
			for(int i = 0; i < spliter.length; i++) {
				ap.addEstadoAcep(new Estado(spliter[i]));
			}
		} else {
			ap.setEstadosAcep(new ArrayList<Estado>());
		}
		
		// El resto de l�neas son trancisiones
		ArrayList<String> auxString;			// Variable auxiliar para trabajar con las sustituciones en la pila
		while(lector.ready()) {
			auxString = new ArrayList<String>();
			dummy = lector.readLine();
			spliter = dummy.split(" ");
			// Cada trancision tiene un origen, un destino, un elemento de entrada y en la pila y una sustituci�n en la pila
			for(int i = 4; i < spliter.length; i++) {
				auxString.add(spliter[i]);
			}
			ap.addTrancision(new Transicion(new Estado(spliter[0]), spliter[1], spliter[2], new Estado(spliter[3]), auxString));
		}
		
		// Cerramos el fichero para evitar erroes y sobreescrituras
		lector.close();
		
	}
	
	public Automata getAutomata ()
	{
		return ap;
	}
}
