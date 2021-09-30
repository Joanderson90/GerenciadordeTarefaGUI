package com.miprogramacao.gerenciadordetarefas.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import Interface.UserI;

public class User implements UserI{
	
	private  List<Projeto> projetos = new ArrayList<>();
	private RenameTaskManager renameTaskManager = new RenameTaskManager();
	
	public User() {}
		
	public User(Projeto projeto) {
		
		projetos.add(projeto);
	}
	
	public User(List<Projeto> projetos) {
		
		this.projetos = projetos;
	}
	


	@Override
	public boolean excluirProjeto(Projeto p) {
		
		boolean isAllTarefasConcluidas = verificarTodasTarefasConcluidas(p);
		
		if(isAllTarefasConcluidas) this.projetos.remove(p);
						
		return isAllTarefasConcluidas;
		
		
	
	}
	
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
			
			if(statusTarefaCadastrada == pendente || statusTarefaCadastrada == emExecucao ) {
				
				return false;
			}
			
		}
		
		return true;
	}

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

	@Override
	public boolean mudarValidadeTarefa(Tarefa t, String newValidade) {
		
		boolean isValidadeMudada;
		
		try {
			
			Tarefa temp  = buscarTarefaPorTitulo(t.getTitulo());
			
			temp.setValidade(newValidade);
			
			isValidadeMudada = true;
			
		} catch (Exception e) {
			
			isValidadeMudada = false;
			
		}
		
		return isValidadeMudada;
	}

	@Override
	public boolean mudarStatusTarefa(Tarefa t, Status newStatus) {
		
		boolean isStatusMudado;
		
		try {
			
			Tarefa temp  = buscarTarefaPorTitulo(t.getTitulo());
			
			temp.setStatus(newStatus);
			
			isStatusMudado = true;
			
		} catch (Exception e) {
			
			isStatusMudado = false;
			
		}
		
		return isStatusMudado;
	}

	@Override
	public boolean excluirTarefa(Tarefa t) throws ObjetoInexistenteException {
		
		try {
			
			Projeto projetoQuePossuiTarefa  = buscarProjetoQuePossuiTarefa(t);
			
			projetoQuePossuiTarefa.getTarefas().remove(t);
			
			return true;
			
		} catch (Exception e) {
			
			throw new ObjetoInexistenteException();
			
		}
		
	}

	@Override
	public Tarefa buscarTarefaPorTitulo(String titulo) throws ObjetoInexistenteException {
		
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
				
				if(tituloTarefaCadastrada == titulo) return tarefaCadastrada;
			}
				
			
		}
		
		throw new ObjetoInexistenteException();
	}
	


	public Projeto buscarProjetoQuePossuiTarefa(Tarefa t) throws ObjetoInexistenteException {
		
		Tarefa tarefaCadastrada;
		Projeto projetoCadastrado;
		
		Iterator<Tarefa> itTarefasCadastradas;
		Iterator<Projeto> itProjetosCadastrados = projetos.iterator();
		
		while(itProjetosCadastrados.hasNext()) {
			
			projetoCadastrado = itProjetosCadastrados.next();
			itTarefasCadastradas = projetoCadastrado.getTarefas().iterator();
			
			while(itTarefasCadastradas.hasNext()) {
				
				tarefaCadastrada = itTarefasCadastradas.next();
	
				
				if(tarefaCadastrada == t) return projetoCadastrado;
			}
				
			
		}
		
		throw new ObjetoInexistenteException();
	}

	@Override
	public Projeto buscarProjetoPorTitulo(String titulo) throws ObjetoInexistenteException{
		
	
		String tituloProjetoCadastrado;
		Projeto projetoCadastrado;
		
		Iterator<Projeto> it = projetos.iterator();
		
		while(it.hasNext()) {
			
			projetoCadastrado = it.next();
			tituloProjetoCadastrado = projetoCadastrado.getTitulo();
			
			if(tituloProjetoCadastrado == titulo) {
				
				return projetoCadastrado;
			}
			
		}
		
		throw new ObjetoInexistenteException();
	}


	public  List<Projeto> getProjetos() {
		return this.projetos;
	}


	public  void setProjeto(Projeto projeto) throws ArgumentoInvalidoException{
		
		if(projeto == null) {
			
			throw new ArgumentoInvalidoException();
		}
		
		this.projetos.add(projeto);
	}
	
	
		
	
		
	
}


