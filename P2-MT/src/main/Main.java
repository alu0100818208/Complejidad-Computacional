package main;

import java.io.IOException;

import maquina.MaquinaTuring;

public class Main {

	public static void main(String[] args) throws IOException {
		
		MaquinaTuring mt;
		try {
			mt = new MaquinaTuring(args[0]);
			System.out.println(mt + "\n");
			mt.interaccion();
			
		} catch (Exception e) {
			mt = new MaquinaTuring(0);
			System.out.println(mt + "\n");
			mt.interaccion();
		}

	}

}
