/**
 * @author aculnaig
 */

public class Studente {
    
    private int matricola;
    private String nome;
    private String cognome;

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getMatricola() {
	return this.matricola;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return this.nome;
    }

    public void setCognome(String cognome) {
	this.cognome = cognome;
    }

    public String toString() {
	    return String.format("Studente[%d, %s, %s]", matricola, nome, cognome);
	}
}
