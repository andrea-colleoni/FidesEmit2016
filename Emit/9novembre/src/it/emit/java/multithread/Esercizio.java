package it.emit.java.multithread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Esercizio {

	public static void main(String[] args) {
		File root = new File(Esercizio.class.getResource("/").getPath());
		File daProcessare = new File(root.getAbsolutePath() + "\\" + "inferno.txt");
		System.out.print("Testo da cercare? ");
		try (BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in))) {
			String testoDaCercare = br.readLine();
			Esercizio e = new Esercizio();
			e.cercaTestoNelFile(daProcessare, testoDaCercare);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cercaTestoNelFile(File file, String testoDaCercare) {
		List<String> righe = new ArrayList<>();
		// ottengo la directory corrente (dove viene eseguita la
		// mia applicazione Java) come Resource dal class loader
		
		try (BufferedReader br = 
				new BufferedReader(
						new FileReader(file))) {
			do {
				righe.add(br.readLine());
			} while (righe.get(righe.size() - 1) != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		if (testoDaCercare != null && !"".equals(testoDaCercare)) {
			try (FileWriter fw = new FileWriter(file.getName() + ".filtrato")) {
				righe.stream()
					.filter(s -> s != null && s.contains(testoDaCercare))
					.forEach(s -> {
						try {
							fw.write(s + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
	}

}
