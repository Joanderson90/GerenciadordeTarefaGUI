package Interface;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import model.Projeto;
import model.Status;
import model.Tarefa;



public interface UserI {
	
	public abstract boolean renomearTitulo(Object obj, String newTitulo)throws ArgumentoInvalidoException;
	public abstract boolean renomearDescricao(Object obj, String newDescricao)throws ArgumentoInvalidoException;
	
	public abstract boolean excluirProjeto(Projeto p);
	
	public abstract boolean mudarValidadeTarefa(Tarefa t, String newValidade);
	public abstract boolean mudarStatusTarefa(Tarefa t, Status newStatus);
	public abstract boolean excluirTarefa(Tarefa t)throws ObjetoInexistenteException ;
	
	public abstract Tarefa buscarTarefaPorTitulo(String titulo) throws ObjetoInexistenteException;
	public abstract Projeto buscarProjetoPorTitulo(String titulo) throws ObjetoInexistenteException;
}