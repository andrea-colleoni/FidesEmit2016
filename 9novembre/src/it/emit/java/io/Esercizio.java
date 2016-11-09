package it.emit.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Esercizio {

	public static void main(String[] args) {
		Reader sysInReader = new InputStreamReader(System.in);
		try (BufferedReader br = new BufferedReader(sysInReader)) {
			System.out.print("Inserisci il nome di un file: ");
			String fileName = br.readLine();
			File f = new File(fileName);
			try (FileWriter fw = new FileWriter(f)) {
				String rigaLetta;
				do {
					rigaLetta = br.readLine();
					if (rigaLetta != null && !"esci".equals(rigaLetta)) {
						fw.write(rigaLetta + "\n");
					}
				} while (!"esci".equals(rigaLetta));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
