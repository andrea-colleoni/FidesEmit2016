/**
 * @author aculnaig
 *
 */

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String toString() {
		return String.format("Studente[%d, %s, %s]", matricola, nome, cognome);
	}
}
