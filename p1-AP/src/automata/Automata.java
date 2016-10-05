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

import java.util.ArrayList;

public class Automata {
	
	private ArrayList<Estado> conjuntoQ;				// Conjunto de est�dos del aut�mata
	private Estado inicialS;							// Estado inicial y que ser� usado como estado actual 
	private ArrayList<Trancision> funcionTrancision;	// Funci�n de trancision
	private ArrayList<String> alfabetoP;				// Alfabeto de la pila
	private ArrayList<String> alfabetoE;				// Alfabeto de las cadenas de entrada
	private ArrayList<Estado> estadosAcep;				// Estado/s de acepataci�n
	private ArrayList<String> pila;						// Pila del aut�mata
	private String inicialZ;							// Elemento inicial de la pila
	private String cadenaDeEntrada;						// Cadena a Analizar
	
	public Automata(ArrayList<Estado> conjuntoQ, Estado inicialS, ArrayList<Trancision> funcionTrancision,
			ArrayList<String> alfabetoP, ArrayList<String> alfabetoE, ArrayList<Estado> estadosAcep,
			ArrayList<String> pila, String inicialZ, String cadenaDeEntrada) {
		
		this.conjuntoQ = conjuntoQ;
		this.inicialS = inicialS;
		this.funcionTrancision = funcionTrancision;
		this.alfabetoP = alfabetoP;
		this.alfabetoE = alfabetoE;
		this.estadosAcep = estadosAcep;
		this.pila = pila;
		this.inicialZ = inicialZ;
		this.cadenaDeEntrada = cadenaDeEntrada;
	}
	
	public ArrayList<Estado> getConjuntoQ() {
		return conjuntoQ;
	}

	public void setConjuntoQ(ArrayList<Estado> conjuntoQ) {
		this.conjuntoQ = conjuntoQ;
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

	public ArrayList<String> getAlfabetoP() {
		return alfabetoP;
	}

	public void setAlfabetoP(ArrayList<String> alfabetoP) {
		this.alfabetoP = alfabetoP;
	}

	public ArrayList<String> getAlfabetoE() {
		return alfabetoE;
	}

	public void setAlfabetoE(ArrayList<String> alfabetoE) {
		this.alfabetoE = alfabetoE;
	}

	public ArrayList<Estado> getEstadosAcep() {
		return estadosAcep;
	}

	public void setEstadosAcep(ArrayList<Estado> estadosAcep) {
		this.estadosAcep = estadosAcep;
	}

	public ArrayList<String> getPila() {
		return pila;
	}

	public void setPila(ArrayList<String> pila) {
		this.pila = pila;
	}

	public String getInicialZ() {
		return inicialZ;
	}

	public void setInicialZ(String inicialZ) {
		this.inicialZ = inicialZ;
	}

	public String getCadenaDeEntrada() {
		return cadenaDeEntrada;
	}

	public void setCadenaDeEntrada(String cadenaDeEntrada) {
		this.cadenaDeEntrada = cadenaDeEntrada;
	}

}
