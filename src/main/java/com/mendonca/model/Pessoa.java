package com.mendonca.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Pessoa {

@Id
private int idPessoa;

	
private String nome;


public int getIdPessoa() {
	return idPessoa;
}


public void setIdPessoa(int idPessoa) {
	this.idPessoa = idPessoa;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}




	
	
	
	
	
}
