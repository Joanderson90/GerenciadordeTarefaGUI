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

package exceptions;

/**
 * A Classe <b>ArgumentoInvalidoException</b> representa a modelagem de uma exceção, esta referente a um argumento inválido.
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */

public class ArgumentoInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	/**
	 * Obtém um objeto do tipo <b>ArgumentoInvalidoException</b>.<br>
	 * Mensagem:O argumento deve ser diferente de null ou vazio!
	 * @return objeto do tipo <b>ArgumentoInvalidoException</b>.
	 */
	
	public ArgumentoInvalidoException() {
			
		super("O argumento deve ser diferente de null ou vazio!");
	}
	
	/**
	 * Obtém a mensagem referente à exceção.
	 * Mensagem:O argumento deve ser diferente de null ou vazio!
	 * @return mensagem referente à exceção.
	 */
		
	public String getMessage() {
		
		return this.msg;
	}

}
