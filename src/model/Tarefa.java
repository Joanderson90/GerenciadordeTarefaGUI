package model;
public class Tarefa {
	
	private String titulo;
	private String descricao;
	private String validade;
	private Status status;
	
	public Tarefa() {
		
	}
			
	
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
        
        if (obj instanceof Tarefa){

            Tarefa tarefaASerComparada = (Tarefa) obj;
            
            return (this.titulo == tarefaASerComparada.getTitulo() &&
            		this.descricao == tarefaASerComparada.getDescricao() &&           		
    				this.validade == tarefaASerComparada.getValidade() &&
    				this.status == tarefaASerComparada.getStatus());

        }
        
        return false;
	}

	public boolean getIsAtrasada() {
		
		Status statusConcluida = Status.CONCLUIDA;
		
		boolean isAtrasada = false;
		boolean isTarefaConcluida = (this.status == statusConcluida);
		
		if(!isTarefaConcluida) {
			
			MyDate date = new MyDate();
			
			String currentDate = date.getCurrentDate();
			String dateTarefa = this.validade;
			
			
			int valComp = date.compareTo(currentDate, dateTarefa);//M�todo similar ao CompareTo da classe String
			
			if(valComp >= 1) isAtrasada = true; //Data atual > Data tarefa
		}
	
				
		return isAtrasada;
		
		
	}

	@Override
	public String toString() {
		
		boolean isTarefaAtrasada = this.getIsAtrasada();
		
		String marcacaoAtrasada = "";
		

		if(isTarefaAtrasada)  marcacaoAtrasada = " [Atrasada!]";
		
		return "T�tulo: "    +  this.getTitulo()  + "\n" +
			   "Descri��o: " + this.getDescricao() + "\n" +
			   "Validade: " + this.getValidade() + 
			   marcacaoAtrasada;

		
		
			   
	}
	
}
