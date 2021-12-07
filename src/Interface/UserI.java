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
