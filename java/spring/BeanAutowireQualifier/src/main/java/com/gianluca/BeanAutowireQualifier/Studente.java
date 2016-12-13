/**
 *
 * @author aculnaig
 *
 */

/*
 * Classe che rappresenta uno Studente
 *
 */

package com.gianluca.BeanAutowireQualifier;


public class Studente {

    // Propriet�
    private int eta;
    private String nome;

    // Metodi getter e setter
    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getEta() {
	return this.eta;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return this.nome;
    }

}
