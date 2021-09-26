package com.miprogramacao.gerenciadordetarefas.model;

import java.util.Date;

public class Tarefa {
	private String titulo;
	private String descricao;
	private String validade;
	private Status status;
	
	public Tarefa(String titulo, String descricao, String validade) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.validade = validade;
		this.status = status.Pendente;
	}
	
	public Tarefa(String titulo, String validade) {
		this.titulo = titulo;
		this.descricao = "";
		this.validade = validade;
		this.status = status.Pendente;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		Tarefa tarefa = (Tarefa) obj;
		
		return (this.titulo == tarefa.getTitulo() && this.descricao == tarefa.getDescricao() && 
				this.validade == tarefa.getValidade() && this.status == tarefa.getStatus());
	}
}
