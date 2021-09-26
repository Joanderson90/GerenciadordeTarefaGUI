package com.miprogramacao.gerenciadordetarefas.model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	
	private String titulo;
	private String descricao;
	private List<Tarefa> tarefas;
	
	public Projeto(String titulo) {
		this.titulo = titulo;
		this.tarefas = new ArrayList<Tarefa>();
	}
	
	public Projeto(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.tarefas = new ArrayList<Tarefa>();
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
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public void setTarefa(Tarefa tarefa) {
		
		this.tarefas.add(tarefa);
		
	}
	
	public boolean equals(Object obj) {
		
		   
		boolean objIsEqual = false;
        
        if (obj instanceof Projeto){
        	
        	boolean tituloIsEqual = false;
            boolean descricaoIsEqual = false;
            boolean tarefasIsEqual = false;

            Projeto projetoASerComparado = (Projeto) obj;
            
            String tituloProjetoASerComparado =  projetoASerComparado.getTitulo();
            String descricaoProjetoASerComparado = projetoASerComparado.getDescricao();
            List<Tarefa> tarefasProjetoASerComparado = projetoASerComparado.getTarefas();
            
            if(tituloProjetoASerComparado == this.getTitulo()) tituloIsEqual = true;
            
            if(descricaoProjetoASerComparado == this.getDescricao()) descricaoIsEqual = true;
            
            if(tarefasProjetoASerComparado.equals(this.getTarefas())) tarefasIsEqual = true;
            
            
            
            if(tituloIsEqual && descricaoIsEqual && tarefasIsEqual) {
            	
            	objIsEqual = true;
            }
            
            

        }
        
        return objIsEqual;
	}

}
