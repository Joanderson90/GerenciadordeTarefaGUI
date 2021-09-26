package com.miprogramacao.gerenciadordetarefas.model;

public enum Status {

	PENDENTE('P'),
	EM_EXECUCAO('E'),
	CONCLUIDA('C');
	
	private char value;
	
	Status(char value) { this.value = value; }
	
	public char getValue() { return this.value; }
}
