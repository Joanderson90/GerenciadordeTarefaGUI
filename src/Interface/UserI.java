package Interface;

import com.miprogramacao.gerenciadordetarefas.model.Projeto;
import com.miprogramacao.gerenciadordetarefas.model.Status;
import com.miprogramacao.gerenciadordetarefas.model.Tarefa;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;


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
