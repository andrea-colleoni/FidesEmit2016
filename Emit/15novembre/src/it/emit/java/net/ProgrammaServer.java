package it.emit.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaServer {
	
	class ClientConnesso {
		Socket s;
		PrintWriter pw;
		String nome;
		
		public ClientConnesso(Socket s) {
			super();
			this.s = s;
			try {
				this.pw = new PrintWriter(
						new OutputStreamWriter(s.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	List<ClientConnesso> clientConnessi;

	public static void main(String[] args) {
		ProgrammaServer prg = new ProgrammaServer();
		prg.avvia();
	}

	public void avvia() {
		clientConnessi = new ArrayList<>();
		try (ServerSocket ss = new ServerSocket(5000)) {
			System.out.println("Server avviato sulla porta 5000");
			while (true) {
				Socket s = ss.accept();
				clientConnessi.add(new ClientConnesso(s));
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
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String nome = br.readLine();
		String messaggio = "";
		while (!messaggio.equals("esci")) {
			messaggio = br.readLine();
			System.out.println("console: " + messaggio);
			for (ClientConnesso cc : clientConnessi) {
				cc.pw.println(nome + " : " + messaggio);
				cc.pw.flush();
			}
		}
		s.close();
	}
}
