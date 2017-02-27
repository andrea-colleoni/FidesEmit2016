package it.fides.sp.model;

public class ClienteInfo {
	
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return String.format("ClienteInfo[%s]", nome);
	}

}
