package main;

import java.io.IOException;

import automata.Automata;

public class Main {

	public static void main(String[] args) {
		
		try {
			System.out.println("Uno");
			Automata ap = new Automata(args[0]);
			ap.getInicialS();
		} catch (Exception e) {
			System.err.println ("Exception: " + e.getMessage() );
		}
		

	}

}
