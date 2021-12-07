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

package model;

/**
 * Enum de status das tarefas.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public enum Status {

	PENDENTE('P'), EM_EXECUCAO('E'), CONCLUIDA('C');

	private char value;

	/**
	 * Construtor do Enum.
	 * 
	 * @param value
	 */

	Status(char value) {
		this.value = value;
	}

	/**
	 * Obt�m o valor associado ao Enum.
	 * 
	 * @return char refrente ao Enum.
	 */

	public char getValue() {
		return this.value;
	}

	public static Status getStatus(String arg) {

		for (Status statu : Status.values()) {

			if (statu.toString().equals(arg.toUpperCase()))
				return statu;
		}

		return null;
	}
}
