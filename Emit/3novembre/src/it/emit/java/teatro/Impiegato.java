package it.emit.java.teatro;

public abstract class Impiegato {
	
	private String nome;
	private String cognome;
	private float stipendio;
	
	public void aumentaStipendio(float percentuale) {
		stipendio *= (1 + percentuale);
	}
	
	public abstract void licenzia();
	//public void licenzia() {}
	
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

	public float getStipendio() {
		return stipendio;
	}

	public void setStipendio(float stipendio) {
		this.stipendio = stipendio;
	}

}
