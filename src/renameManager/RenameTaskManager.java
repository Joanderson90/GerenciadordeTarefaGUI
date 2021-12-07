/*******************************************************************************
Autores: Joanderson Santos e Diego Cerqueira
Componente Curricular: Algoritmos II
Concluido em: 18/10/2021
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/
package renameManager;

import Interface.Rename;
import exceptions.ArgumentoInvalidoException;
import exceptions.ObjetoInexistenteException;
import model.Projeto;
import model.Tarefa;

/**
 * A Classe <b>RenameTaskManager</b> permite atrav�s de uma inst�ncia a renome��o de
 * <b>Tarefas</b> e <b>Projetos</b>.
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */

public class RenameTaskManager implements Rename{

	
	
	
	/**
	 * Renomea um t�tulo de uma <b>tarefa</b> ou <b>projeto</b>.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newTitle novo t�tulo para renomea��o.
	 * @return true se o t�tulo foi renomeado, ou false caso contr�rio.
	 * @throws ArgumentoInvalidoException se o argumento for null ou vazio.
	 * @throws ObjetoInexistenteException caso o objeto for diferente de <b>tarefa</b> ou <b>projeto</b>.
	 */
	
	@Override
	public boolean titleRename(Object obj, String newTitle) throws ArgumentoInvalidoException, ObjetoInexistenteException{
		
		boolean isArgumentoValido = isValidArgument(obj, newTitle);
		boolean isRenomeado = false;
		
		if(isArgumentoValido) {
			
			
			if(obj instanceof Tarefa ) ((Tarefa) obj).setTitulo(newTitle);
			
			else ((Projeto) obj).setTitulo(newTitle);
			
			isRenomeado = true;
			
		}
			
		return isRenomeado;
			
	}
	
	/**
	 *  Verifica se o argumento � v�lido.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newTitle novo t�tulo para renomea��o.
	 * @return true se o objeto � do tipo <b>tarefa</b> ou <b>projeto</b> e a String n�o � vazia, ou false caso contr�rio.
	 * @throws ArgumentoInvalidoException se o argumento for null ou vazio.
	 * @throws ObjetoInexistenteException caso o objeto for diferente de <b>tarefa</b> ou <b>projeto</b>.
	 */
	
	public boolean isValidArgument(Object obj, String renameValue) throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		boolean isObjetoTarefaOuProjeto = obj instanceof Tarefa || obj instanceof Projeto;
		
		if(renameValue == "" || renameValue == null) {
			
			throw new ArgumentoInvalidoException();
		}
		
		else if(!isObjetoTarefaOuProjeto) {
			
			throw new ObjetoInexistenteException();
			
		}
		
		return true;
	}
	
	/**
	 * Renomea uma descri��o de uma <b>tarefa</b> ou <b>projeto</b>.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newDescription nova descri��o para renomea��o.
	 * @return true se a descri��o foi renomeada, ou false caso contr�rio.
	 * @throws ArgumentoInvalidoException se o argumento for null ou vazio.
	 * @throws ObjetoInexistenteException caso o objeto for diferente de <b>tarefa</b> ou <b>projeto</b>.
	 */

	@Override
	public boolean descriptionRename(Object obj, String newDescription) throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		boolean isArgumentoValido = isValidArgument(obj, newDescription);
		boolean isRenomeado = false;
		
		if(isArgumentoValido) {
			
			
			if(obj instanceof Tarefa ) ((Tarefa) obj).setDescricao(newDescription);
			
			else ((Projeto) obj).setDescricao(newDescription);
			
			isRenomeado = true;
			
		}
			
		return isRenomeado;
			
	}

}
