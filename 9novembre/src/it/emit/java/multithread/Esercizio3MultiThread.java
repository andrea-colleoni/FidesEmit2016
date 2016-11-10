package it.emit.java.multithread;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Esercizio3MultiThread {

	public static void main(String[] args) {
		try (BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Inserire percosro directory: ");
			String directoryInCuiCercare = br.readLine();
			File directory = new File(directoryInCuiCercare);
			if (directory.exists() && directory.isDirectory()) {
				System.out.print("Testo da cercare? ");
				String testoDaCercare = br.readLine();
				// mi doto di oggetto in grado di processare i file
				Esercizio e = new Esercizio();
				for(File f : directory.listFiles()) {
					// lavoro solo sui file .txt
					if (f.getName().endsWith(".txt")) {
						Thread t = new Thread(() -> e.cercaTestoNelFile(f, testoDaCercare));
						t.start();
						try {
							t.join();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
