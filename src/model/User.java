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

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import Interface.UserI;
import renameManager.RenameTaskManager;

/**
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public class User implements UserI{
	
	private  List<Projeto> projetos = new ArrayList<>();

	private RenameTaskManager renameTaskManager = new RenameTaskManager();

	
	/**
	 * Contrutor da classe
	 */
	public User() {
		//initialize();
	}
		
	/**
	 * Contrutor da classe
	 */
	public User(Projeto projeto) {
		
		projetos.add(projeto);
	}
	
	/**
	 * Contrutor da classe
	 */
	public User(List<Projeto> projetos) {
		
		this.projetos = projetos;
	}
	
	/**
	 * metodo para inicializar o projeto com alguns projetos e tarefas para facilitar os testes
	 * Para funcionar é necessário descomentar a unica linha de codigo do contrutor vazio dessa classe 
	 */
	private void initialize() {
		Projeto p = new Projeto();
		Projeto p2 = new Projeto();
		
		Tarefa t1 = new Tarefa();
		t1 = new Tarefa("PBL", "Sistema Gerenciador de tarefas", "19/10/2021");
		
		Tarefa t2 = new Tarefa("Task Manager", "Problema 2", "29/10/2021");
        
		p.setDescricao("Serviço de delivery");
		p.setTitulo("PBL1");
		p.setTarefa(t1);
		projetos.add(p);
		
		p2.setDescricao("Sistema Gerenciador de tarefas");
		p2.setTitulo("PBL2");
		p2.setTarefa(t2);
		projetos.add(p2);
	}

	/**
	 * metodo para escluir um projeto
	 */
	@Override
	public boolean excluirProjeto(Projeto p) {
		
		boolean isAllTarefasConcluidas = verificarTodasTarefasConcluidas(p);
		
		if(isAllTarefasConcluidas) this.projetos.remove(p);
						
		return isAllTarefasConcluidas;
		
	}
	
	/**
	 * Metodo que verifica se todas as tarefas de um projeto foram concluidas
	 * @param p
	 * @return boolean
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
	 * Metodo para alterar o titulo de uma tarefa ou projeto
	 * @param obj
	 * @param newTitulo
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
	 * Metodo que verifica se umm Object é do tipo Tarefa ou Projeto
	 * @param obj
	 * @return boolean
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
	 * Metodo para alterar a descrição de uma tarefa ou projeto
	 * @param obj
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
	 * Metodo para alterar a validade de uma tarefa
	 * @param tarefa
	 * @param newValidade
	 * @return boolean
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
	 * Metodo para alterar o status de uma tarefa
	 * @param tarefa
	 * @param newStatus
	 * @return boolean
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
	 * Metodo para escluir uma tarefa
	 * @param tarefa
	 * @return boolean
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
	 * Metodo que busca um projeto associado a uma lista de tarefas
	 * @param tarefaTarget
	 * @return Projeto
	 * @throws ObjetoInexistenteException
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
	 * Metodo que busca uma tarefa pelo seu titulo
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
	 * Metodo que busca um projeto pelo seu titulo
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
	 * retorna uma lista de projetos
	 * @return List<Projeto>
	 */
	public  List<Projeto> getProjetos() {
		return this.projetos;
	}


	/**
	 * insere um projeto a lista
	 * @param projeto
	 * @throws ArgumentoInvalidoException
	 */
	public  void setProjeto(Projeto projeto) throws ArgumentoInvalidoException{
		
		if(projeto == null) {
			
			throw new ArgumentoInvalidoException();
		}
		
		this.projetos.add(projeto);
	}
}


