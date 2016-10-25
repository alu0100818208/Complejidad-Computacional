/**
 * Esta clase implementa un conversor de fichero .mt a un objeto MáquinaTurnig o la entrada del usuario
 * al objeto MaquinaTuring
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package conversor;

import java.io.*;
import java.util.ArrayList;

import maquina.*;

public class Conversor {

	private MaquinaTuring mt;
	
	public Conversor (String nombreArchivo) throws IOException {
		
		mt = new MaquinaTuring();
		
		// Si el  archivo no es de tipo automata a pila notificamos el error y cerramos el programa
		if (!nombreArchivo.endsWith(".mt")) {
			System.err.println("Error: El archivo no es de tipo Máquina de Turing (.mt).");
			System.exit(0);
		}
		
		BufferedReader lector = new BufferedReader (new FileReader(nombreArchivo));
		String dummy = lector.readLine();
		
		// Minentras sean lineas con comentarios, las pasamos.
		while (dummy.startsWith("#")) {
			dummy = lector.readLine();
		}
		
		String[] spliter;
		
		// La primera línea corresponde con los estados de la máquina.
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addEstado(new Estado(spliter[i]));
		}
		
		// La segunda línea corresponde con el alfabeto de la cadena de entrada
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addElementoE(spliter[i]);
		}
		
		// La tercera línea corresponde con el alfabeto de la cinta
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addElementoC(spliter[i]);
		}
		
		// La cuarta línea corresponde con el estado inicial
		dummy = lector.readLine();
		mt.setInicial(new Estado(dummy));
		
		// La quinta línea corresponde con el blanco
		dummy = lector.readLine();
		mt.setBlanco(dummy);
		
		// La sexta línea corresponde con el conunto de estados de aceptación
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addEstadoAcep(new Estado(spliter[i]));
		}
		
		// El resto de líneas son trancisiones
		ArrayList<Movimiento> movement;		// arrayhlist con los movimientos de la trancisión
		int j;							// Indice para controlar los movimientos en caso de tener más de una cinta
		while(lector.ready()) {
			j = 3;
			movement = new ArrayList<Movimiento>();
			dummy = lector.readLine();
			spliter = dummy.split(" ");
			// Cada trancision tiene un origen, un destino, un/os elemento/s de entrada , un/os elemento/s a sustituir y un o varios movivmientos (dependiendo del número de cintas)
			if(spliter[1].length() > 1) {
				
				mt.setNCintas(spliter[1].length());
				
				for(int i = 0; i < spliter[1].length(); i++) {
					
					movement.add(new Movimiento (spliter[j], spliter[j + 1]));
					j += 2;
					
				}
				
			} else {
				
				mt.setNCintas(1);
				movement.add(new Movimiento(spliter[3], spliter[4]));
				mt.addTrancision(new Transicion(new Estado (spliter[0]), spliter[1], new Estado(spliter[2]), movement));
				
			}
		}
		
		// Cerramos el fichero para evitar erroes y sobreescrituras
		lector.close();
	}
	
	public Conversor() throws IOException {
		
		mt = new MaquinaTuring();
		
		BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
		String[] spliter;
		
		System.out.println("Por favor, introduzca el Conjunto Q (ej: q1 q2 q3 …)");
		String dummy = lector.readLine();
		// La primera línea corresponde con los estados de la máquina.
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addEstado(new Estado(spliter[i]));
		}
		
		System.out.println("Por favor, introduzca el Alfabeto de los símbolos de entrada (ej: a1 a2 a3 …)");
		// La segunda línea corresponde con el alfabeto de la cadena de entrada
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addElementoE(spliter[i]);
		}
		
		System.out.println("Por favor, introduzca el Alfabeto de la/s Cinta/s (ej: a1 a2 a3 …)");
		// La tercera línea corresponde con el alfabeto de la cinta
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addElementoC(spliter[i]);
		}
		
		System.out.println("Por favor, introduzca el estado Inicial (ej: q1)");
		// La cuarta línea corresponde con el estado inicial
		dummy = lector.readLine();
		mt.setInicial(new Estado(dummy));
		
		System.out.println("Por favor, introduzca el símbolo blanco (ej: .)");
		// La quinta línea corresponde con el blanco
		dummy = lector.readLine();
		mt.setBlanco(dummy);
		
		System.out.println("Por favor, introduzca el Conjunto de estados finales (ej: q2 q3)");
		// La sexta línea corresponde con el conunto de estados de aceptación
		dummy = lector.readLine();
		spliter = dummy.split(" ");
		for(int i = 0; i < spliter.length; i++) {
			mt.addEstadoAcep(new Estado(spliter[i]));
		}
		
		System.out.println("Por favor, introduzca las trancisiones (ej: q1 a1 q2 a2 m)");
		System.out.println("Para acabar de introducir trancisiones escriba solamente STOP.");
		// El resto de líneas son trancisiones
		ArrayList<Movimiento> movement;		// arrayhlist con los movimientos de la trancisión
		int j;							// Indice para controlar los movimientos en caso de tener más de una cinta
		while(true) {
			j = 3;
			movement = new ArrayList<Movimiento>();
			dummy = lector.readLine();
			if(dummy.equals("STOP")) {
				break;
			} else {
				spliter = dummy.split(" ");
				// Cada trancision tiene un origen, un destino, un/os elemento/s de entrada , un/os elemento/s a sustituir y un o varios movivmientos (dependiendo del número de cintas)
				if(spliter[1].length() > 1) {
					
					mt.setNCintas(spliter[1].length());
					
					for(int i = 0; i < spliter[1].length(); i++) {
						
						movement.add(new Movimiento (spliter[j], spliter[j + 1]));
						j += 2;
						
					}
					
				} else {
					
					mt.setNCintas(1);
					movement.add(new Movimiento(spliter[3], spliter[4]));
					mt.addTrancision(new Transicion(new Estado (spliter[0]), spliter[1], new Estado(spliter[2]), movement));
					
				}
			}
		}
		lector.close();
	}

	public MaquinaTuring getMt() {
		return mt;
	}

	public void setMt(MaquinaTuring mt) {
		this.mt = mt;
	}
	
}
