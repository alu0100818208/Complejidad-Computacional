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

import java.io.IOException;
import java.util.ArrayList;

import conversor.Conversor;

public class Automata {
	
	private ArrayList<Estado> conjuntoQ;				// Conjunto de estádos del autómata
	private Estado inicialS;							// Estado inicial y que será usado como estado actual 
	private ArrayList<Trancision> funcionTrancision;	// Función de trancision
	private ArrayList<String> alfabetoP;				// Alfabeto de la pila
	private ArrayList<String> alfabetoE;				// Alfabeto de las cadenas de entrada
	private ArrayList<Estado> estadosAcep;				// Estado/s de acepatación
	private ArrayList<String> pila;						// Pila del autómata
	private String cadenaDeEntrada;						// Cadena a Analizar
	
	
	public Automata() {
		this.conjuntoQ = new ArrayList<Estado>();
		this.inicialS = new Estado();
		this.funcionTrancision = new ArrayList<Trancision>();
		this.alfabetoP = new ArrayList<String>();
		this.alfabetoE = new ArrayList<String>();
		this.estadosAcep = new ArrayList<Estado>();
		this.pila = new ArrayList<String>();
		this.cadenaDeEntrada = new String();
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
		this.cadenaDeEntrada = aux.getAutomata().cadenaDeEntrada;
	}
	
	// Constructor de copia
	public Automata (Automata a) {
		
		this.conjuntoQ = a.conjuntoQ;
		this.inicialS = a.inicialS;
		this.funcionTrancision = a.funcionTrancision;
		this.alfabetoP = a.alfabetoP;
		this.alfabetoE = a.alfabetoE;
		this.estadosAcep = a.estadosAcep;
		this.pila = a.pila;
		this.cadenaDeEntrada = a.cadenaDeEntrada;
		
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

	public ArrayList<Trancision> getFuncionTrancision() {
		return funcionTrancision;
	}

	public void setFuncionTrancision(ArrayList<Trancision> funcionTrancision) {
		this.funcionTrancision = funcionTrancision;
	}
	
	// Método para añadir una trancision a la funcion de trancisión
	public void addTrancision(Trancision t) {
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

	public String getCadenaDeEntrada() {
		return cadenaDeEntrada;
	}

	public void setCadenaDeEntrada(String cadenaDeEntrada) {
		this.cadenaDeEntrada = cadenaDeEntrada;
	}

	public ArrayList<String> getPila() {
		return pila;
	}

	public void setPila(ArrayList<String> pila) {
		this.pila = pila;
	}

}
