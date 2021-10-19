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

package Exceptions;

/**
 * A Classe <b>ObjetoInexistenteException</b> representa a modelagem de uma exceção,
 * esta referente a um objeto não cadastrado no Sistema.
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */

public class ObjetoInexistenteException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	/**
	 * Obtém um objeto do tipo <b>ObjetoInexistenteException</b>.<br>
	 * Mensagem: Objeto não encontrado no sistema
	 * @return objeto do tipo <b>ObjetoInexistenteException</b>.
	 */
	
	public ObjetoInexistenteException() {
		
		super("Objeto não encontrado no sistema");
	}
	
	
	/**
	 * Obtém a mensagem referente à exceção.
	 * Mensagem:Objeto não encontrado no sistema
	 * @return mensagem referente a exceção.
	 */
		

	public String getMessage() {
		
		return this.msg;
	}
	 
}
