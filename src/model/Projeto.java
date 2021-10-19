/*******************************************************************************
Autor: Diego Cerqueira e Joanderson Santos
Componente Curricular: MI Programação
Concluido em: 18/10/2021
Declaro que este código foi elaborado por Diego Cerqueira e Joanderson Santos em dupla e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public class Projeto {
	
	private String titulo;
	private String descricao;
	private List<Tarefa> tarefas;
	
	/**
	 * Construtor da classe
	 * @param titulo
	 */
	public Projeto(String titulo) {
		
		this.titulo = titulo;
		this.tarefas = new ArrayList<Tarefa>();
	}
	
	/**
	 * Construtor da classe
	 * @param titulo
	 * @param descricao
	 */
	public Projeto(String titulo, String descricao) {
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.tarefas = new ArrayList<Tarefa>();
	}
	
	/**
	 * Construtor da classe
	 */
	public Projeto() {
		this.tarefas = new ArrayList<Tarefa>();
	}

	/**
	 * retorna o titulo do projeto
	 * @return String 
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * insere um titulo ao projeto
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * retorna a descrição do projeto
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * insere uma descrição ao projeto
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * retorna a lista de tarefas associadas ao projeto
	 * @return List<Tarefa>
	 */
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	/**
	 * insere uma lista de tarefas
	 * @param tarefas
	 */
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	/**
	 * adiciona uma tarefa a lista de tarefas
	 * @param tarefa
	 */
	public void setTarefa(Tarefa tarefa) {
		
		this.tarefas.add(tarefa);
		
	}
	
	/**
	 * metodo para comparar dois projetos
	 */
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

	/**
	 * metodo para converter um projeto para uma string com seus dados
	 */
	@Override
	public String toString() {
		
		return "Titulo: " + titulo + "\n" + "Descrição: " + descricao;
	}
	
	
	/**
	 * retorna uma lista com as tarefas pendentes
	 * @return List<Tarefa>
	 */
	public List<Tarefa> getTarefasPendentes(){
		
		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasPendentes = new ArrayList<>();
		
		Iterator<Tarefa> it = tarefasCadastradas.iterator();
		
		Tarefa tarefaCadastrada = new Tarefa();
		Status statusPendente = Status.PENDENTE;
		
		boolean isTarefaPendente;
		
		while(it.hasNext()) {
			
			tarefaCadastrada = it.next();
			
			isTarefaPendente = tarefaCadastrada.getStatus() == statusPendente;
			
			if(isTarefaPendente) tarefasPendentes.add(tarefaCadastrada);
			
		}
		
		return tarefasPendentes;
		
	}
	
	
	/**
	 * retorna uma lista com a s tarefas em execução
	 * @return List<Tarefa>
	 */
	public List<Tarefa> getTarefasEmExecucao(){
		
		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasEmExecucao = new ArrayList<>();
		
		Iterator<Tarefa> it = tarefasCadastradas.iterator();
		
		Tarefa tarefaCadastrada = new Tarefa();
		Status statusEmExecucao = Status.EM_EXECUCAO;
		
		boolean isTarefaEmExecucao;
		
		while(it.hasNext()) {
			
			tarefaCadastrada = it.next();
			
			isTarefaEmExecucao = tarefaCadastrada.getStatus() == statusEmExecucao;
			
			if(isTarefaEmExecucao) tarefasEmExecucao.add(tarefaCadastrada);
			
		}
		
		return tarefasEmExecucao;
		
	}
	
	/**
	 * retorna uma lista com as tarefas concluidas
	 * @return List<Tarefa>
	 */
	public List<Tarefa> getTarefasConcluidas(){
		
		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasConcluidas = new ArrayList<>();
		
		Iterator<Tarefa> it = tarefasCadastradas.iterator();
		
		Tarefa tarefaCadastrada = new Tarefa();
		Status statusConcluida = Status.CONCLUIDA;
		
		boolean isTarefaConcluida;
		
		while(it.hasNext()) {
			
			tarefaCadastrada = it.next();
			
			isTarefaConcluida = tarefaCadastrada.getStatus() == statusConcluida;
			
			if(isTarefaConcluida) tarefasConcluidas.add(tarefaCadastrada);
			
		}
		
		return tarefasConcluidas;
		
	}	
	
}
