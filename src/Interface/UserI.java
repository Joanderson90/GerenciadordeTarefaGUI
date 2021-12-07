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

package Interface;

import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoInexistenteException;
import model.Projeto;
import model.Status;
import model.Tarefa;

/**
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
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
