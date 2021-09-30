package model;

import java.util.Date;

public class Tarefa {
	
	private String titulo;
	private String descricao;
	private String validade;
	private Status status;
	
	
	public Tarefa() {};
		
		

	
	public Tarefa(String titulo, String descricao, String validade) {
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.validade = validade;
		this.status = Status.PENDENTE;
	}
	
	public Tarefa(String titulo, String validade) {
		this.titulo = titulo;
		this.descricao = "";
		this.validade = validade;
		this.status = Status.PENDENTE;
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
		
   
	   boolean objIsEqual = false;
        
        if (obj instanceof Tarefa){
        	
        	boolean tituloIsEqual = false;
            boolean descricaoIsEqual = false;
            boolean validadeIsEqual = false;
            boolean statusIsEqual = false;

            Tarefa tarefaASerComparada = (Tarefa) obj;
            
            String tituloTarefaASerComparada =  tarefaASerComparada.getTitulo();
            String descricaoTarefaASerComparada = tarefaASerComparada.getDescricao();
            String validadeTarefaASerComparada =  tarefaASerComparada.getValidade();
            Status statusTarefaASerComparada = tarefaASerComparada.getStatus();
            
            if(tituloTarefaASerComparada == this.getTitulo()) tituloIsEqual = true;
            
            if(descricaoTarefaASerComparada == this.getDescricao()) descricaoIsEqual = true;
            
            if(validadeTarefaASerComparada == this.getValidade()) validadeIsEqual = true;
            
            if(statusTarefaASerComparada == this.getStatus()) statusIsEqual = true;
            
            if(tituloIsEqual && descricaoIsEqual && validadeIsEqual && statusIsEqual) {
            	
            	objIsEqual = true;
            }
            
            

        }
        
        return objIsEqual;
	}

	public boolean getIsAtrasada() {
		
		boolean isAtrasada = false;
		MyDate date = new MyDate();
		
		String currentDate = date.getCurrentDate();
		String dateTarefa = this.validade;
		
		
		int valComp = date.compareTo(currentDate, dateTarefa);//Método similar ao CompareTo da classe String
		
		if(valComp == 1) isAtrasada = true; //Data atual > Data tarefa
		
		return isAtrasada;
		
		
	}
}
