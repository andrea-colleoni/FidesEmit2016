package it.emit.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProgrammaIO {

	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\Andrea\\Desktop\\Temp\\CorsoJavaEmit\\Git\\FidesEmit2016\\9novembre\\src\\prova.txt");
			if (f.exists()) {
				// try with resources
				try (BufferedReader br = 
						new BufferedReader(new FileReader(f))) {
					String rigaLetta;
					do {
						rigaLetta = br.readLine();
						System.out.println("=> " + rigaLetta);
					} while(rigaLetta != null);
				}
				
				try (FileWriter fw = new FileWriter(f, true)) {
					fw.write("\nAltra stringa scritta da Java");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Il file non è stato trovato.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Il file non è leggibile");
			e.printStackTrace();
		} 
	}

}
