package it.emit.java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProgrammaServer {

	public static void main(String[] args) {
		ProgrammaServer prg = new ProgrammaServer();
		prg.avvia();
	}
	
	public void avvia() {
		try (ServerSocket ss = new ServerSocket(5000)) {
			System.out.println("Server avviato sulla porta 5000");
			while(true) {
				Socket s = ss.accept();
				System.out.println("Nuova connessione da " + s.getRemoteSocketAddress().toString());
				new Thread(() -> {
					try {
						echo(s);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void echo(Socket s) throws IOException {
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(s.getInputStream()));
		PrintWriter pw = 
				new PrintWriter(
						new OutputStreamWriter(s.getOutputStream()));		
		String messaggio = "";
		while(!messaggio.equals("esci")) {
			messaggio = br.readLine();
			System.out.println("console: " + messaggio);
			pw.println("socket : " + messaggio);
			pw.flush();
		}
		s.close();
	}
}
