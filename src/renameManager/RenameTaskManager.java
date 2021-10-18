/*******************************************************************************
Autores: Joanderson Santos e Diego Cerqueira
Componente Curricular: Algoritmos II
Concluido em: 18/10/2021
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package renameManager;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import Interface.Rename;
import model.Projeto;
import model.Tarefa;

/**
 * A Classe <b>RenameTaskManager</b> permite através de uma instância a renomeção de
 * <b>Tarefas</b> e <b>Projetos</b>.
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */

public class RenameTaskManager implements Rename{

	
	
	
	/**
	 * Renomea um título de uma <b>tarefa</b> ou <b>projeto</b>.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newTitle novo título para renomeação.
	 * @return true se o título foi renomeado, ou false caso contrário.
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
	 *  Verifica se o argumento é válido.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newTitle novo título para renomeação.
	 * @return true se o objeto é do tipo <b>tarefa</b> ou <b>projeto</b> e a String não é vazia, ou false caso contrário.
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
	 * Renomea uma descrição de uma <b>tarefa</b> ou <b>projeto</b>.
	 * @param obj <b>tarefa</b> ou <b>projeto</b> a ser renomeado(a).
	 * @param newDescription nova descrição para renomeação.
	 * @return true se a descrição foi renomeada, ou false caso contrário.
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
