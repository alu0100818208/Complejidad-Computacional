/**
 * Esta clase implementa una autómata a pila.
 * @author: Ángel David Martín Rodríguez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Práctica 1
 */

package conversor;

import java.io.*;
import java.util.ArrayList;

import automata.Automata;
import automata.Estado;
import automata.Trancision;

public class Conversor {

	private Automata ap;
	
	public Conversor (String nombreArchivo) throws IOException {
		
		ap = new Automata();
		
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
		
		// La primera línea corresponde con los estados del automata
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addEstado(new Estado(spliter[i]));
		}
		
		// La segunda línea corresponde con el alfabeto de la cadena de entrada
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addElementoE(spliter[i]);
		}
		
		// La tercera línea corresponde con  el alfabeto de la pila
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addElementoP(spliter[i]);
		}
		
		// La cuarta línea corresponde con el estado inicial
		dummy = lector.readLine();
		ap.setInicialS(new Estado(dummy));
		
		// La quinta línea corresponde con el símbolo inicial de la pila
		dummy = lector.readLine();
		ArrayList<String> pila = new ArrayList<String>();
		pila.add(dummy);
		ap.setPila(pila);
		
		// La sexta línea corresponde con el conunto de estados de aceptación
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			ap.addEstadoAcep(new Estado(spliter[i]));
		}
		
		// El resto de líneas son trancisiones
		ArrayList<String> auxString;			// Variable auxiliar para trabajar con las sustituciones en la pila
		while(lector.ready()) {
			auxString = new ArrayList<String>();
			dummy = lector.readLine();
			spliter = dummy.split(" ");
			// Cada trancision tiene un origen, un destino, un elemento de entrada y en la pila y una sustitución en la pila
			for(int i = 4; i < spliter.length; i++) {
				auxString.add(spliter[i]);
			}
			ap.addTrancision(new Trancision(new Estado(spliter[0]), spliter[1], spliter[2], new Estado(spliter[3]), auxString));
		}
		
		// Cerramos el fichero para evitar erroes y sobreescrituras
		lector.close();
		
	}
	
	public Automata getAutomata ()
	{
		return ap;
	}
}
