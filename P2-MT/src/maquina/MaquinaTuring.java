/**
 * Esta clase implementa la Máquina de Turing (con opción a ser multicinta).
 * @author: Ã�ngel David MartÃ­n RodrÃ­guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 24 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: PrÃ¡ctica 2
 */

package maquina;

import java.io.*;
import java.util.ArrayList;

import conversor.Conversor;

public class MaquinaTuring {

	private ArrayList<Estado> conjuntoQ;				// Conjunto finito de estados.
	private ArrayList<String> alfabetoE;				// Alfabeto de símbolos de entrada.
	private ArrayList<String> alfabetoC;				// Alfabeto de la Cinta
	private Estado inicial;								// Estado incial
	private String blanco;								// Símbolo blanco
	private ArrayList<Estado> estadosAcep;				// Conjunto de estados finales
	private ArrayList<Transicion> funcTransicion;		// Función de Trancisión
	private int nCintas;								// Número de nCintas de la Máquina
	private ArrayList<Cinta> cinta;
	
	public MaquinaTuring() {
		
		this.conjuntoQ = new ArrayList<Estado>();
		this.alfabetoE = new ArrayList<String>();
		this.alfabetoC = new ArrayList<String>();
		this.inicial = new Estado();
		this.blanco = new String();
		this.estadosAcep = new ArrayList<Estado>();
		this.funcTransicion = new ArrayList<Transicion>();
		nCintas = 0;
	}
	
	// Constructor que utiliza un fichero como método para crear la Máquina
	public MaquinaTuring(String nombreArchivo) throws IOException {
		
		Conversor aux = new Conversor(nombreArchivo);
		this.conjuntoQ = aux.getMt().getConjuntoQ();
		this.alfabetoE = aux.getMt().getAlfabetoE();
		this.alfabetoC = aux.getMt().getAlfabetoC();;
		this.inicial = aux.getMt().getInicial();
		this.blanco = aux.getMt().getBlanco();
		this.estadosAcep = aux.getMt().getEstadosAcep();
		this.funcTransicion = aux.getMt().getFuncTransicion();
		this.nCintas = aux.getMt().getNCintas();
		// Nos aseguramos que la máquina no tenga errores
		erroresMaquina();
		
	}
	
	// Constructor por el cual el usuario introduce directamente la máquina
	public MaquinaTuring(int i) throws IOException {
		
		Conversor aux = new Conversor();
		this.conjuntoQ = aux.getMt().getConjuntoQ();
		this.alfabetoE = aux.getMt().getAlfabetoE();
		this.alfabetoC = aux.getMt().getAlfabetoC();;
		this.inicial = aux.getMt().getInicial();
		this.blanco = aux.getMt().getBlanco();
		this.estadosAcep = aux.getMt().getEstadosAcep();
		this.funcTransicion = aux.getMt().getFuncTransicion();
		this.nCintas = aux.getMt().getNCintas();
		// Nos aseguramos que la máquina no tenga errores
		erroresMaquina();
		
	}
	
	
	
	// Funcion que se encarga de interactuar con el usuario para l evaluacion de cadenas
	public void interaccion() throws IOException {
		
		boolean continuar = true;
		String cadena;
		BufferedReader lectorPant = new BufferedReader (new InputStreamReader(System.in));
		
		
		// En esta parte introducimos la cadena a evaluar
		while(continuar) {
			
			cinta = new ArrayList<Cinta>();
			System.out.println("Por favor, introduzca una cadena a evaluar.");
			cadena = lectorPant.readLine();
			Cinta aux = new Cinta(cadena, blanco);
			cinta.add(aux);
			// Si hay más de una cinta el resto serán cintas vacias
			if(getNCintas() > 1) {
				for (int i = 1; i < getNCintas(); i++) {
					aux = new Cinta(getBlanco());
					cinta.add(aux);
				}
			}
			
			if(pertenece()) {
				System.out.println("La cadena introducida pertenece al lenguaje.");
				for(int i = 0; i < cinta.size(); i++) {
					System.out.println("Cinta " + (i + 1) + ":");
					System.out.println(cinta.get(i) + "\n");
				}
			} else {
				System.out.println("La cadena introducida no pertenece al lenguaje.");
				for(int i = 0; i < cinta.size(); i++) {
					System.out.println("Cinta " + (i + 1) + ":");
					System.out.println(cinta.get(i) + "\n");
				}
			}
				
			System.out.println("¿Quieres introducir una nueva cadena?[Y/N]");
			cadena = lectorPant.readLine();
			if(!cadena.toLowerCase().equals("y")) {
				continuar = false;
			}
			
		}
		lectorPant.close();
	}
	
	public boolean pertenece () {
		
		Estado actual = inicial;
		ArrayList<String> eltoCinta = new ArrayList<String>();
		Transicion auxTran = new Transicion();
		boolean dummy = true;
		
		while(dummy) {
			
			for(int i = 0; i < nCintas; i++) {
				eltoCinta.add(cinta.get(i).getCinta().get(cinta.get(i).getCabeza()));
			}
		
			auxTran = buscarTran(actual, eltoCinta);
			if(auxTran == null) {
				break;
			} else {
				actual = transitar(auxTran);
			}
			eltoCinta = new ArrayList<String>();
		}
		
		if(this.estadosAcep.contains(actual)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Método para buscar las trancisiones
	public Transicion buscarTran(Estado estadoActual, ArrayList<String> eltosCinta) {
		
		String aux = new String();
		
		for(int j = 0; j < nCintas; j++) {
			aux = aux + eltosCinta.get(j);
		}
		
		for(int i = 0; i < funcTransicion.size(); i++) {
			
			if(funcTransicion.get(i).getOrigen().equals(estadoActual)
					&& funcTransicion.get(i).getEntrada().equals(aux)) {
				return funcTransicion.get(i);
			}
				
		}
		
		return null;
		
	}
	
	// Funcion que se encarga de transitar de un estado a otro hjunto con las operaciones de sobreescritura y movimiento
	public Estado transitar( Transicion t) {
		for(int i = 0; i < nCintas; i++) {
			cinta.get(i).Mover(t.getSustCintas().get(i));
		}
		return t.getDestino();
	}
	
	// Esta metodo se encargará de detectar si la máquina se ha creado correctamente
	private void erroresMaquina() {
		// Si los estados de aceptación no están en el conjunto Q hay un error
		if (!conjuntoQ.containsAll(estadosAcep)) {
			System.err.println("Error en la Máquina: Existe algún estado de aceptación que no está en el Conjunto Q.");
			System.exit(0);
		}
		// Si el alfabeto de entrada no está contenido en el alfabeto de la cinta, hay un error
		if(!alfabetoC.containsAll(alfabetoE)) {
			System.err.println("Error en la Máquina: Existe algún elemento del alfabeto de entrada que no existe en el alfabeto de la/s cinta/s.");
			System.exit(0);
		}
		// Si el estado inicial no pertenece a Q, hay un error.
		if(!conjuntoQ.contains(inicial)) {
			System.err.println("Error en la Máquina: El estado inical debe pertenecer al Conjunto Q.");
			System.exit(0);
		}
		// b debe existir en el alfabeto de la cinta pero no en el de los simbolos de entrada.
		if(!alfabetoC.contains(blanco)) {
			System.err.println("Error en la Máquina: El símbolo blanco debe pertenecer al alfabeto de la cinta.");
			System.exit(0);
		}
		if(alfabetoE.contains(blanco)) {
			System.err.println("Error en la Máquina: El símbolo blanco no debe pertenecer al alfabeto de entrada.");
			System.exit(0);
		}
		
		for(int i = 0; i < funcTransicion.size(); i++) {
			// Si el origen de la trancision no pertenece al conjunto Q, hay un error.
			if(!conjuntoQ.contains(funcTransicion.get(i).getOrigen())) {
				System.err.println("Error en la Máquina: El origen de la Trancision " + funcTransicion.get(i) + " no pertenece al conunto Q.");
				System.exit(0);
			}
			if(nCintas > 1) {
				for(int j = 0; j < nCintas; j++) {
					// EN caso de que sean varias cintas debemos mirar si los elementos pertenecen al alfabeto de las cintas
					if(!alfabetoC.contains(String.valueOf(funcTransicion.get(i).getEntrada().charAt(j)))) {
						System.err.println("Error en la Máquina: Los elementos de entrada de la Trancision "
								+ funcTransicion.get(i) + " no pertenece al alfabeto de la cinta.");
						System.exit(0);
					}
					
					if(!alfabetoC.contains(funcTransicion.get(i).getSustCintas().get(j).getElemento())) {
						System.err.println("Error en la Máquina: Existe algún elemento de sustitución de la Trancision "
								+ funcTransicion.get(i) + " que no pertenece al alfabeto de la cinta.");
						System.exit(0);
					}
				}
			} else {
				if(!alfabetoC.contains(String.valueOf(funcTransicion.get(i).getEntrada()))) {
					System.err.println("Error en la Máquina: El elemento de entrada de la Trancision "
							+ funcTransicion.get(i) + " no pertenece al alfabeto de la cinta.");
					System.exit(0);
				}
				
				if(!alfabetoC.contains(funcTransicion.get(i).getSustCintas().get(0).getElemento())) {
					System.err.println("Error en la Máquina: El elemento de sustitución de la Trancision "
							+ funcTransicion.get(i) + " no pertenece al alfabeto de la cinta.");
					System.exit(0);
				}
			}
			// Si el destino de la trancision no pertenece al conjunto Q, hay un error.
			if(!conjuntoQ.contains(funcTransicion.get(i).getDestino())) {
				System.err.println("Error en la Máquina: El destino de la Trancision " + funcTransicion.get(i) + " no pertenece al conunto Q.");
				System.exit(0);
			}
		}
	}
//----------------------------------GETTERS Y SETTERS----------------------------------
	
	// Funcion para añadir un estado al array de estados
	public void addEstado(Estado q) {
		conjuntoQ.add(q);
	}
	
	// Función para añadir un elemento al alfabeto de los símbolos de entrada
	public void addElementoE(String e) {
		alfabetoE.add(e);
	}
	
	// Método para añadir un elemento al alfabeto de la cinta
	public void addElementoC(String e) {
		alfabetoC.add(e);
	}
	
	// Método para añadir una trancision a la funcion de trancisión
	public void addTrancision(Transicion t) {
		funcTransicion.add(t);
	}
	
	// Función que añade un estado de aceptación al conjunto de estados de aceptación
	public void addEstadoAcep(Estado e) {
		estadosAcep.add(e);
	}
	
	public ArrayList<Estado> getConjuntoQ() {
		return conjuntoQ;
	}
	
	public void setConjuntoQ(ArrayList<Estado> conjuntoQ) {
		this.conjuntoQ = conjuntoQ;
	}
	
	public ArrayList<String> getAlfabetoE() {
		return alfabetoE;
	}
	
	public void setAlfabetoE(ArrayList<String> alfabetoE) {
		this.alfabetoE = alfabetoE;
	}
	
	public ArrayList<String> getAlfabetoC() {
		return alfabetoC;
	}
	
	public void setAlfabetoC(ArrayList<String> alfabetoC) {
		this.alfabetoC = alfabetoC;
	}
	
	public Estado getInicial() {
		return inicial;
	}
	
	public void setInicial(Estado inicial) {
		this.inicial = inicial;
	}
	
	public String getBlanco() {
		return blanco;
	}
	
	public void setBlanco(String blanco) {
		this.blanco = blanco;
	}
	
	public ArrayList<Estado> getEstadosAcep() {
		return estadosAcep;
	}
	
	public void setEstadosAcep(ArrayList<Estado> estadosAcep) {
		this.estadosAcep = estadosAcep;
	}
	
	public ArrayList<Transicion> getFuncTransicion() {
		return funcTransicion;
	}
	
	public void setFuncTransicion(ArrayList<Transicion> funcTransicion) {
		this.funcTransicion = funcTransicion;
	}

	public int getNCintas() {
		return nCintas;
	}

	public void setNCintas(int cintas) {
		this.nCintas = cintas;
	}

	public ArrayList<Cinta> getCinta() {
		return cinta;
	}

	public void setCinta(ArrayList<Cinta> cinta) {
		this.cinta = cinta;
	}

	@Override
	public String toString() {
		String out = "\n*****Maquina de Turing*****\n\nConjuntoQ = " + conjuntoQ + "\nAlfabetoE = " + alfabetoE + "\nAlfabetoC = " + alfabetoC
				+ "\nEstado inicial = " + inicial + "\nSímbolo blanco = " + blanco + "\nEstados de Aceptación = " + estadosAcep + "\nFunción de Transición = \n";
		for(int i = 0; i < funcTransicion.size(); i++) {
			out = out + funcTransicion.get(i) + "\n";
		}
		return out;
	}
	
	

}
