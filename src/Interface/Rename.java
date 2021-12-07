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

/**
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public interface Rename {

	public abstract boolean titleRename(Object obj, String newTitle)throws ArgumentoInvalidoException, ObjetoInexistenteException;
	public abstract boolean descriptionRename(Object obj, String newDescription)throws ArgumentoInvalidoException, ObjetoInexistenteException;
	public abstract boolean isValidArgument(Object obj, String renameValue)throws ArgumentoInvalidoException, ObjetoInexistenteException;
			
	
	
}
