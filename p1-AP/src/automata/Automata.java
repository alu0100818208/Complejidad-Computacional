/**
 * Esta clase implementa una aut�mata a pila.
 * @author: �ngel David Mart�n Rodr�guez
 * @email: alu0100818208@ull.edu.es
 * @version: 1.0.0
 * @date: 2 Octubre 2016
 * @subject: Complejidad Computacional
 * @title: Pr�ctica 1
 */

package automata;

import java.io.IOException;
import java.util.ArrayList;

import conversor.Conversor;

public class Automata {
	
	private ArrayList<Estado> conjuntoQ;				// Conjunto de est�dos del aut�mata
	private Estado inicialS;							// Estado inicial y que ser� usado como estado actual 
	private ArrayList<Trancision> funcionTrancision;	// Funci�n de trancision
	private ArrayList<String> alfabetoP;				// Alfabeto de la pila
	private ArrayList<String> alfabetoE;				// Alfabeto de las cadenas de entrada
	private ArrayList<Estado> estadosAcep;				// Estado/s de acepataci�n
	private ArrayList<String> pila;						// Pila del aut�mata
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
	
	// Funcion para a�adir un estado al array de estados
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
	
	// M�todo para a�adir una trancision a la funcion de trancisi�n
	public void addTrancision(Trancision t) {
		funcionTrancision.add(t);
	}

	public ArrayList<String> getAlfabetoP() {
		return alfabetoP;
	}

	public void setAlfabetoP(ArrayList<String> alfabetoP) {
		this.alfabetoP = alfabetoP;
	}
	
	// Funci�n para a�adir un elemento al alfabeto de la pila
	public void addElementoP(String e) {
		alfabetoP.add(e);
	}

	public ArrayList<String> getAlfabetoE() {
		return alfabetoE;
	}

	public void setAlfabetoE(ArrayList<String> alfabetoE) {
		this.alfabetoE = alfabetoE;
	}

	// M�todo para a�adir un elemento al alfabeto de la cadena de entrada
	public void addElementoE(String e) {
		alfabetoE.add(e);
	}
	
	public ArrayList<Estado> getEstadosAcep() {
		return estadosAcep;
	}

	public void setEstadosAcep(ArrayList<Estado> estadosAcep) {
		this.estadosAcep = estadosAcep;
	}
	
	// Funci�n que a�ade un estado de aceptaci�n al conjunto de estados de aceptaci�n
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
