/**
 * Esta clase implementa una autómata a pila.
 * @author: Ángel David Martín Rodríguez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Práctica 1
 */

package automata;

import java.io.*;
import java.util.ArrayList;

import conversor.Conversor;

public class Automata {
	
	private ArrayList<String> epsilon = new ArrayList<String>();
	
	private ArrayList<Estado> conjuntoQ;				// Conjunto de estádos del autómata
	private Estado inicialS;							// Estado inicial
	private ArrayList<Transicion> funcionTrancision;	// Función de trancision
	private ArrayList<String> alfabetoP;				// Alfabeto de la pila
	private ArrayList<String> alfabetoE;				// Alfabeto de las cadenas de entrada
	private ArrayList<Estado> estadosAcep;				// Estado/s de acepatación
	private ArrayList<String> pila;						// Pila del autómata
	private String eltoInicialP;						// Elemento inicial de la pila
	
	
	public Automata() {
		this.conjuntoQ = new ArrayList<Estado>();
		this.inicialS = new Estado();
		this.funcionTrancision = new ArrayList<Transicion>();
		this.alfabetoP = new ArrayList<String>();
		this.alfabetoE = new ArrayList<String>();
		this.estadosAcep = new ArrayList<Estado>();
		this.pila = new ArrayList<String>();
	}
	
	public Automata (String nombreArchivo) throws IOException {
		
		Conversor aux = new Conversor(nombreArchivo);
		this.conjuntoQ = aux.getAutomata().conjuntoQ;
		this.inicialS = aux.getAutomata().inicialS;
		this.funcionTrancision = aux.getAutomata().funcionTrancision;
		this.alfabetoP = aux.getAutomata().alfabetoP;
		this.alfabetoE = aux.getAutomata().alfabetoE;
		this.estadosAcep = aux.getAutomata().estadosAcep;
		this.pila = aux.getAutomata().pila;
		this.eltoInicialP = pila.get(0);
		
		interaccion();
	}
	
	// Constructor de copia
	public Automata (Automata a) throws IOException {
		
		this.conjuntoQ = a.conjuntoQ;
		this.inicialS = a.inicialS;
		this.funcionTrancision = a.funcionTrancision;
		this.alfabetoP = a.alfabetoP;
		this.alfabetoE = a.alfabetoE;
		this.estadosAcep = a.estadosAcep;
		this.pila = a.pila;
		
		interaccion();
		
		
	}
	
	// Funcion que se encarga de interactuar con el usuario para l evaluacion de cadenas
	public void interaccion() throws IOException {
		
		epsilon.add(".");
		boolean continuar = true;
		boolean traza = false;		// Si queremos mostrar la traza
		String cadena;
		BufferedReader lectorPant = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("¿Desea ver la traza del automata?[Y/N]");
		cadena = lectorPant.readLine();
		if(cadena.toLowerCase().equals("y")) {
			traza = true;
		}
		
		
		// En ésta parte introducimos la cadena a evaluar
		while(continuar) {
			
			System.out.println("Por favor, introduzca una cadena a evaluar.");
			cadena = lectorPant.readLine();
			
			if(pertenece(cadena, traza)) {
				System.out.println("La cadena introducida pertenece al lenguaje.");
			} else {
				System.out.println("La cadena introducida no pertenece al lenguaje.");
			}
			
			System.out.println("¿Quieres introducir una nueva cadena?[Y/N]");
			cadena = lectorPant.readLine();
			if(!cadena.toLowerCase().equals("y")) {
				continuar = false;
				System.out.println("Adios y gracias por usar el software :).");
			}
			// Retornamos la pila a su estado inicial para una nueva evaluación
			pila.clear();
			pila.add(this.eltoInicialP);
			
		}
	}

	// Método para evaluar las cadenas de entrada
	public boolean pertenece(String cadena, boolean traza) {
		
		if (traza) {
			System.out.println("   Estado   |          Cadena          |          Pila         |   Trancisiones");
		}
		
		String elto;
		
		if (!cadena.isEmpty()) {
			
			elto = String.valueOf(cadena.charAt(0));
			cadena = cadena.substring(1);
			
		} else {
			elto = epsilon.get(0);
		}
		
		Estado estActual = getInicialS();
		// Array con las trancisiones pendientes de realizar.
		ArrayList<Transicion> tranPend = new ArrayList<Transicion>();
		tranPend.addAll(buscarTran(estActual, elto, pila.get(0)));
		// Transicion que usaremos de forma auxiliar
		Transicion temp;
		
		// Minetras nos queden transiciones que realizar y no se haya aceptado la cadena seguimos evaluando
		while (!tranPend.isEmpty()) {
			
			if (traza) {
				System.out.printf("%6s %27s %25s      %s\n", estActual, elto + cadena, pila.toString(), buscarTran(estActual, elto, pila.get(0)).toString());
			}
			
			temp = tranPend.get(tranPend.size() - 1);
			tranPend.remove(temp);
			estActual = transitar(temp);
			
			if (!cadena.isEmpty()) {
			  elto = String.valueOf(cadena.charAt(0));
			  cadena = cadena.substring(1);
			} else {
				elto = epsilon.get(0);
			}
			
			if(!pila.isEmpty()) {
				tranPend.addAll(buscarTran(estActual, elto, pila.get(0)));
			}
			
			// Si los estados de aceptación estan vacios es que es por vaciado de pila
			if (estadosAcep.isEmpty()) {
				if(pila.isEmpty() && cadena.isEmpty()) {
					if (traza) {
						System.out.printf("%6s %27s %25s\n", estActual, elto + cadena, pila.toString());
					}
					return true;
				}
			} else {
				for (int i = 0; i < getEstadosAcep().size(); i++) {
					if(getEstadosAcep().get(i).equals(estActual) && cadena.isEmpty()) {
						if (traza) {
							System.out.printf("%6s %27s %25s\n", estActual, elto + cadena, pila.toString());
						}
						return true;
					}
				}
			}
			
		} 
		
		return false;
		
	}
	
	// Funcion que se encarga de buscar las transiciones
	public ArrayList<Transicion> buscarTran(Estado estadoActual, String eltoCad, String eltoPila) {
		
		ArrayList<Transicion> resultado = new ArrayList<Transicion>();
		
		for(int i = 0; i < funcionTrancision.size(); i++) {
			if((funcionTrancision.get(i).getOrigen().equals(estadoActual))
				&& (funcionTrancision.get(i).getEntradaCadena().equals(eltoCad))
				&& (funcionTrancision.get(i).getEltoPila().equals(eltoPila))) {
				
				resultado.add(funcionTrancision.get(i));
			}
		}
		
		return resultado;
	}
	
	// Método que realiza los cambios de la transición
	public Estado transitar (Transicion t) {
		
		// Eliminamos el elmento de la pila
		pila.remove(t.getEltoPila());
		// Sustituimos con lo necesario y si es vacio no añadimos nada
		if (!t.getSustPila().equals(epsilon)) {
			pila.addAll(0, t.getSustPila());
		}
		// Retornamos el estado al que vamos
		return t.getDestino();
	}
	
//----------------------------------GETTERS Y SETTERS----------------------------------
	
	public ArrayList<Estado> getConjuntoQ() {
		return conjuntoQ;
	}

	public void setConjuntoQ(ArrayList<Estado> conjuntoQ) {
		this.conjuntoQ = conjuntoQ;
	}
	
	// Funcion para añadir un estado al array de estados
	public void addEstado(Estado q) {
		conjuntoQ.add(q);
	}

	public Estado getInicialS() {
		return inicialS;
	}

	public void setInicialS(Estado inicialS) {
		this.inicialS = inicialS;
	}

	public ArrayList<Transicion> getFuncionTrancision() {
		return funcionTrancision;
	}

	public void setFuncionTrancision(ArrayList<Transicion> funcionTrancision) {
		this.funcionTrancision = funcionTrancision;
	}
	
	// Método para añadir una trancision a la funcion de trancisión
	public void addTrancision(Transicion t) {
		funcionTrancision.add(t);
	}

	public ArrayList<String> getAlfabetoP() {
		return alfabetoP;
	}

	public void setAlfabetoP(ArrayList<String> alfabetoP) {
		this.alfabetoP = alfabetoP;
	}
	
	// Función para añadir un elemento al alfabeto de la pila
	public void addElementoP(String e) {
		alfabetoP.add(e);
	}

	public ArrayList<String> getAlfabetoE() {
		return alfabetoE;
	}

	public void setAlfabetoE(ArrayList<String> alfabetoE) {
		this.alfabetoE = alfabetoE;
	}

	// Método para añadir un elemento al alfabeto de la cadena de entrada
	public void addElementoE(String e) {
		alfabetoE.add(e);
	}
	
	public ArrayList<Estado> getEstadosAcep() {
		return estadosAcep;
	}

	public void setEstadosAcep(ArrayList<Estado> estadosAcep) {
		this.estadosAcep = estadosAcep;
	}
	
	// Función que añade un estado de aceptación al conjunto de estados de aceptación
	public void addEstadoAcep(Estado e) {
		estadosAcep.add(e);
	}

	public ArrayList<String> getPila() {
		return pila;
	}

	public void setPila(ArrayList<String> pila) {
		this.pila = pila;
	}

}
