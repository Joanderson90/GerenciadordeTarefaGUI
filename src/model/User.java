/*******************************************************************************
Autor: Diego Cerqueira e Joanderson Santos
Componente Curricular: MI Programa��o
Concluido em: 18/10/2021
Declaro que este c�digo foi elaborado por Diego Cerqueira e Joanderson Santos em dupla e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interface.UserI;
import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoInexistenteException;
import renameManager.RenameTaskManager;

/**
 * A Classe <b>User</b> representa a modelagem de um <b>usu�rio</b> do Sistema.
 * @author Diego Cerqueira e Joanderson Santos
 *
 */

public class User implements UserI{
	
	private  List<Projeto> projetos = new ArrayList<>();

	private RenameTaskManager renameTaskManager = new RenameTaskManager();

	
	/**
	 * Contrutor da classe.
	 */
	
	public User() {
		//initialize();
	}
		
	/**
	 * Contrutor da classe.
	 * @param projeto projeto a ser inserido na lista de projetos do usu�rio.
	 */
	
	public User(Projeto projeto) {
		
		projetos.add(projeto);
	}
	
	/**
	 * Contrutor da classe.
	 * @param projetos lista de projetos a ser inserida.
	 */
	
	public User(List<Projeto> projetos) {
		
		this.projetos = projetos;
	}
	
	/**
	 * M�todo para inicializar o projeto com alguns projetos e tarefas para facilitar os testes
	 * Para funcionar � necess�rio descomentar a �nica linha de codigo do contrutor vazio desta classe 
	 */
	
	private void initialize() {
		Projeto p = new Projeto();
		Projeto p2 = new Projeto();
		
		Tarefa t1 = new Tarefa();
		t1 = new Tarefa("PBL", "Sistema Gerenciador de tarefas", "19/10/2021");
		
		Tarefa t2 = new Tarefa("Task Manager", "Problema 2", "29/10/2021");
        
		p.setDescricao("Servi�o de delivery");
		p.setTitulo("PBL1");
		p.setTarefa(t1);
		projetos.add(p);
		
		p2.setDescricao("Sistema Gerenciador de tarefas");
		p2.setTitulo("PBL2");
		p2.setTarefa(t2);
		projetos.add(p2);
	}

	/**
	 * M�todo para excluir um projeto.
	 * @return true se o projeto foi exclu�do, ou false caso contr�rio.
	 */
	
	@Override
	public boolean excluirProjeto(Projeto p) {
		
		boolean isAllTarefasConcluidas = verificarTodasTarefasConcluidas(p);
		
		if(isAllTarefasConcluidas) this.projetos.remove(p);
						
		return isAllTarefasConcluidas;
		
	}
	
	/**
	 * M�todo que verifica se todas as tarefas de um projeto foram conclu�das.
	 * @param p projeto a ser verificado.
	 * @return boolean true se todas as tarefas est�o conclu�das, ou false caso contr�rio.
	 */
	
	public boolean verificarTodasTarefasConcluidas(Projeto p) {
		
		Tarefa tarefaCadastrada;
		Status statusTarefaCadastrada, pendente, emExecucao;
		
		pendente = Status.PENDENTE;
		emExecucao = Status.EM_EXECUCAO;
		
		List<Tarefa> tarefas = p.getTarefas();
		Iterator<Tarefa> it = tarefas.iterator();
		

		while(it.hasNext()) {
				
			tarefaCadastrada = it.next();
			
			statusTarefaCadastrada = tarefaCadastrada.getStatus();
			
			if(statusTarefaCadastrada == pendente || statusTarefaCadastrada == emExecucao) {
				
				return false;
			}
		
		}
		
		return true;
	}

	/**
	 * M�todo para alterar o t�tulo de uma tarefa ou projeto.
	 * @param obj tarefa ou projeto para ter o t�tulo alterado.
	 * @param newTitulo novo t�tulo a ser atribu�do.
	 */
	
	@Override
	public boolean renomearTitulo(Object obj, String newTitulo) throws ArgumentoInvalidoException{
		
		boolean isRenomeado = false;
		boolean isUserContemObj = this.userContemObj(obj);
		
		if(isUserContemObj) {
			
			try {
				 
				 this.renameTaskManager.titleRename(obj, newTitulo);
				 
				 isRenomeado = true;
		
				
			} catch (ArgumentoInvalidoException e) {
				
				throw new ArgumentoInvalidoException();
				
			} catch (ObjetoInexistenteException e) {}
		}
		
		
		return isRenomeado;
						
	}
	
	/**
	 * M�todo que verifica se o usu�rio cont�m um objeto espec�fico.
	 * @param obj objeto a ser verificado.
	 * @return boolean true se o usu�rio cont�m o objeto, ou false caso contr�rio.
	 */
	
	public  boolean userContemObj(Object obj) {
		
		boolean userContemObj = false;
		
		if(obj instanceof Tarefa) {
			
			Tarefa temp  = (Tarefa) obj;
			
			try {
				
				this.buscarTarefaPorTitulo(temp.getTitulo());
				
				userContemObj = true;
				
			} catch (ObjetoInexistenteException e) {}
				
		}
		
		else if(obj instanceof Projeto) {
			
			Projeto temp  = (Projeto) obj;
			
			try {
				
				this.buscarProjetoPorTitulo(temp.getTitulo());
				
				userContemObj = true;
				
			} catch (ObjetoInexistenteException e) {}
				
		}
		
		return userContemObj;
	}

	/**
	 * M�todo para alterar a descri��o de uma tarefa ou projeto.
	 * @param obj tarefa ou projeto para ter a descri�ao alterada.
	 * @param newDescricao
	 * @return boolean
	 */
	@Override
	public boolean renomearDescricao(Object obj, String newDescricao) throws ArgumentoInvalidoException {
		
		boolean isRenomeado = false;
		boolean UserContemObj = this.userContemObj(obj);
		
		if(UserContemObj) {
			
			try {
				
				 this.renameTaskManager.descriptionRename(obj, newDescricao);
				 
				 isRenomeado = true;
		
				
			} catch (ArgumentoInvalidoException e) {
				
				throw new ArgumentoInvalidoException();
				
			} catch (ObjetoInexistenteException e) {}
		}
		
		
		return isRenomeado;
	}	

	/**
	 * M�todo para alterar a validade de uma tarefa.
	 * @param tarefa tarefa para ter a validade alterada.
	 * @param newValidade nova validade.
	 * @return boolean true se a validade foi alterada, ou false caso contr�rio.
	 */
	
	@Override
	public boolean mudarValidadeTarefa(Tarefa tarefa, String newValidade) {
		
		boolean isValidadeMudada;
		
		try {
			
			Tarefa temp  = buscarTarefaPorTitulo(tarefa.getTitulo());
			
			temp.setValidade(newValidade);
			
			isValidadeMudada = true;
			
		} catch (Exception e) {
			
			isValidadeMudada = false;
			
		}
		
		return isValidadeMudada;
	}

	/**
	 * M�todo para alterar o status de uma tarefa.
	 * @param tarefa tarefa para ter a validade alterada.
	 * @param newStatus novo status.
	 * @return boolean true se o status foi alterada, ou false caso contr�rio.
	 */
	
	@Override
	public boolean mudarStatusTarefa(Tarefa tarefa, Status newStatus) {
		
		boolean isStatusMudado;
		
		try {
			
			Tarefa temp  = buscarTarefaPorTitulo(tarefa.getTitulo());
			
			temp.setStatus(newStatus);
			
			isStatusMudado = true;
			
		} catch (Exception e) {
			
			isStatusMudado = false;
			
		}
		
		return isStatusMudado;
	}

	/**
	 * M�todo para excluir uma tarefa.
	 * @param tarefa tarefa a ser exclu�da.
	 * @return boolean true se a tarefa foi exclu�da, ou false caso contr�rio.
	 */
	
	@Override
	public boolean excluirTarefa(Tarefa tarefa) throws ObjetoInexistenteException {
		
		try {
			
			Projeto projetoQuePossuiTarefa  = buscarProjetoQuePossuiTarefa(tarefa);

			projetoQuePossuiTarefa.getTarefas().remove(tarefa);
			
			return true;
			
		} catch (Exception e) {
			
			throw new ObjetoInexistenteException();
			
		}
		
	}
	
	/**
	 * M�todo que busca o projeto que possui uma dada tarefa.
	 * @param tarefaTarget tarefa alvo.
	 * @return Projeto projeto que possui a tarefa.
	 * @throws ObjetoInexistenteException caso o usu�ro n�o tenha a tarefa.
	 */
	
	public Projeto buscarProjetoQuePossuiTarefa(Tarefa tarefaTarget) throws ObjetoInexistenteException {

		
		Tarefa tarefaCadastrada;
		Projeto projetoCadastrado;
		
		Iterator<Tarefa> itTarefasCadastradas;
		Iterator<Projeto> itProjetosCadastrados = projetos.iterator();
		
		while(itProjetosCadastrados.hasNext()) {
			
			projetoCadastrado = itProjetosCadastrados.next();
			
			itTarefasCadastradas = projetoCadastrado.getTarefas().iterator();
			
			while(itTarefasCadastradas.hasNext()) {
				
				tarefaCadastrada = itTarefasCadastradas.next();
					
				if(tarefaCadastrada == tarefaTarget) return projetoCadastrado;
			}
				
		}
		
		throw new ObjetoInexistenteException();
	}
	
	/**
	 * M�todo que busca uma tarefa por t�tulo.
	 * @param tituloTarget tarefa alvo.
	 * @return Tarefa encontrada.
	 * @throws ObjetoInexistenteException caso o usu�ro n�o tenha a tarefa.
	 */
	
	@Override
	public Tarefa buscarTarefaPorTitulo(String tituloTarget) throws ObjetoInexistenteException {
		
		Tarefa tarefaCadastrada;
		String tituloTarefaCadastrada;
		Projeto projetoCadastrado;
		
		Iterator<Tarefa> itTarefasCadastradas;
		Iterator<Projeto> itProjetosCadastrados = projetos.iterator();
		
		while(itProjetosCadastrados.hasNext()) {
			
			projetoCadastrado = itProjetosCadastrados.next();
			
			itTarefasCadastradas = projetoCadastrado.getTarefas().iterator();
			
			while(itTarefasCadastradas.hasNext()) {
				
				tarefaCadastrada = itTarefasCadastradas.next();
				
				tituloTarefaCadastrada = tarefaCadastrada.getTitulo();
				
				if(tituloTarefaCadastrada == tituloTarget) return tarefaCadastrada;
			}
				
			
		}
		
		throw new ObjetoInexistenteException();
	}
	
	/**
	 * M�todo que busca um projeto por t�tulo.
	 * @param tituloTarget tarefa alvo.
	 * @return Projeto encontrado.
	 * @throws ObjetoInexistenteException caso o usu�ro n�o tenha o projeto.
	 */
	
	@Override
	public Projeto buscarProjetoPorTitulo(String tituloTarget) throws ObjetoInexistenteException{
		
		String tituloProjetoCadastrado;
		Projeto projetoCadastrado;
		
		Iterator<Projeto> it = projetos.iterator();
		
		while(it.hasNext()) {
			
			projetoCadastrado = it.next();
			tituloProjetoCadastrado = projetoCadastrado.getTitulo();
			
			if(tituloProjetoCadastrado == tituloTarget) {
				
				return projetoCadastrado;
			}
			
		}
		
		throw new ObjetoInexistenteException();
	}


	/**
	 * retorna uma lista de projetos.
	 * @return List<Projeto> lista de projetos.
	 */
	public  List<Projeto> getProjetos() {
		return this.projetos;
	}


	/**
	 * insere um projeto a lista.
	 * @param projeto projeto a ser inserido.
	 * @throws ArgumentoInvalidoException caso o projeto seja null.
	 */
	
	public  void setProjeto(Projeto projeto) throws ArgumentoInvalidoException{
		
		if(projeto == null) {
			
			throw new ArgumentoInvalidoException();
		}
		
		this.projetos.add(projeto);
	}
}


