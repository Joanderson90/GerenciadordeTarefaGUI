package com.miprogramacao.gerenciadordetarefas.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import Interface.UserI;

public class User implements UserI{
	
	private  List<Projeto> projetos = new ArrayList<>();
	
	public User() {}
		
	public User(Projeto projeto) {
		
		projetos.add(projeto);
	}
	
	public User(List<Projeto> projetos) {
		
		this.projetos = projetos;
	}
	

	@Override
	public boolean renomearTituloProjeto(Projeto p, String newTitulo) throws ArgumentoInvalidoException {
		
		if(newTitulo == "" || newTitulo == null) {
			
			throw new ArgumentoInvalidoException();
			
		}else {
			
			boolean isProjetoRenomeado;
			
			try {
				
				Projeto temp  = buscarProjetoPorTitulo(p.getTitulo());
				
				temp.setTitulo(newTitulo);
				
				isProjetoRenomeado = true;
				
			} catch (Exception e) {
				
				isProjetoRenomeado = false;
				
			}
			
			return isProjetoRenomeado;
		}
			
			
	}

	@Override
	public boolean renomearDescricaoProjeto(Projeto p, String newDescricao) throws ArgumentoInvalidoException {
		
		if(newDescricao == "" || newDescricao == null) {
			
			throw new ArgumentoInvalidoException();
			
		}else {
			
			boolean isProjetoRenomeado;
			
			try {
				
				Projeto temp  = buscarProjetoPorTitulo(p.getTitulo());
				
				temp.setDescricao(newDescricao);
				
				isProjetoRenomeado = true;
				
			} catch (Exception e) {
				
				isProjetoRenomeado = false;
				
			}
			
			return isProjetoRenomeado;
		}
		
	}

	@Override
	public boolean excluirProjeto(Projeto p) {
		
		boolean isAllTarefasConcluidas = verificarTodasTarefasConcluidas(p);
		
		if(isAllTarefasConcluidas) this.projetos.remove(p);
						
		return isAllTarefasConcluidas;
		
		
	
	}
	
	public boolean verificarTodasTarefasConcluidas(Projeto p) {
		
		boolean hasTarefaConcluida = true;
		
		Tarefa tarefaCadastrada;
		Status statusTarefaCadastrada, pendente, emExecucao;
		
		pendente = Status.PENDENTE;
		emExecucao = Status.EM_EXECUCAO;
		
		List<Tarefa> tarefas = p.getTarefas();
		Iterator<Tarefa> it = tarefas.iterator();
		
		while(it.hasNext() && hasTarefaConcluida) {
			
			tarefaCadastrada = it.next();
			statusTarefaCadastrada = tarefaCadastrada.getStatus();
			
			if(statusTarefaCadastrada == pendente || statusTarefaCadastrada == emExecucao ) {
				
				return false;
			}
			
		}
		
		return true;
	}

	@Override
	public boolean renomearTituloTarefa(Tarefa t, String newTitulo) throws ArgumentoInvalidoException {
		
		if(newTitulo == "" || newTitulo == null) {
			
			throw new ArgumentoInvalidoException();
			
		}else {
			
			boolean isTarefaRenomeada;
			
			try {
				
				Tarefa temp  = buscarTarefaPorTitulo(t.getTitulo());
				
				temp.setTitulo(newTitulo);
				
				isTarefaRenomeada = true;
				
			} catch (Exception e) {
				
				isTarefaRenomeada = false;
				
			}
			
			return isTarefaRenomeada;
		}
	}

	@Override
	public boolean renomearDescricaoTarefa(Tarefa t, String newDescricao) throws ArgumentoInvalidoException {
		
		if(newDescricao == "" || newDescricao == null) {
			
			throw new ArgumentoInvalidoException();
			
		}else {
			
			boolean isTarefaRenomeado;
			
			try {
				
				Tarefa temp  = buscarTarefaPorTitulo(t.getTitulo());
				
				temp.setDescricao(newDescricao);
				
				isTarefaRenomeado = true;
				
			} catch (Exception e) {
				
				isTarefaRenomeado = false;
				
			}
			
			return isTarefaRenomeado;
		}
		
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
			
			Projeto projetoQuePossuiTarefa  = buscarPrjetoQuePossuiTarefa(t);
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
	


	public Projeto buscarPrjetoQuePossuiTarefa(Tarefa t) throws ObjetoInexistenteException {
		
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
