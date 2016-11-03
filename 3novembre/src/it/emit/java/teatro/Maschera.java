package it.emit.java.teatro;

public class Maschera extends Impiegato {

	public Maschera() {
	}

	public void checkIn() {
		this.getNome();
		Impiegato i = (Impiegato)this;
		// (Impiegato)this equivale a super;
	}
	
	public void controlloPresenze() {
		
	}

	@Override
	public void licenzia() {
		// TODO Auto-generated method stub
		
	}
}
