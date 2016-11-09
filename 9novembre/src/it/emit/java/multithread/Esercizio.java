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
		List<String> righe = new ArrayList<>();
		File root = new File(Esercizio.class.getResource("/").getPath());
		try (BufferedReader br = new BufferedReader(new FileReader(root.getAbsolutePath() + "\\" + "inferno.txt"))) {
			do {
				righe.add(br.readLine());
			} while (righe.get(righe.size() - 1) != null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Testo da cercare? ");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String testoDaCercare = br.readLine();
			if (testoDaCercare != null && !"".equals(testoDaCercare)) {
				try (FileWriter fw = new FileWriter("inferno.txt.filtrato")) {
					righe.stream()
						.filter(s -> s != null && s.contains(testoDaCercare))
						.forEach(s -> {
							try {
								fw.write(s + "\n");
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
