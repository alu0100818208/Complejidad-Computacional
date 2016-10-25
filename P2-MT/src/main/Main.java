package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
