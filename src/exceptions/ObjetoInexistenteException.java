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

package exceptions;

/**
 * A Classe <b>ObjetoInexistenteException</b> representa a modelagem de uma exce��o,
 * esta referente a um objeto n�o cadastrado no Sistema.
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */

public class ObjetoInexistenteException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	/**
	 * Obt�m um objeto do tipo <b>ObjetoInexistenteException</b>.<br>
	 * Mensagem: Objeto n�o encontrado no sistema.
	 * @return objeto do tipo <b>ObjetoInexistenteException</b>.
	 */
	
	public ObjetoInexistenteException() {
		
		super("Objeto n�o encontrado no sistema.");
	}
	
	
	/**
	 * Obt�m a mensagem referente � exce��o.
	 * Mensagem:Objeto n�o encontrado no sistema
	 * @return mensagem referente a exce��o.
	 */
		

	public String getMessage() {
		
		return this.msg;
	}
	 
}
