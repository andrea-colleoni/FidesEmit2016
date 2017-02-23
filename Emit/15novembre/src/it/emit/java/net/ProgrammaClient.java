package it.emit.java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProgrammaClient {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(Inet4Address.getLocalHost().toString());
		try (Socket s = new Socket("172.16.99.13", 5000)) {
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(s.getInputStream()));
			PrintWriter pw = 
					new PrintWriter(
							new OutputStreamWriter(s.getOutputStream()));
			pw.println("messaggio da client java");
			pw.flush();
			pw.println("esci");
			pw.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
