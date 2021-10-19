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

package model;

/**
 * Enum de status das tarefas.
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public enum Status {

	PENDENTE('P'),
	EM_EXECUCAO('E'),
	CONCLUIDA('C');
	
	private char value;
	
	/**
	 * Construtor do Enum.
	 * @param value
	 */
	
	Status(char value) { this.value = value; }
	
	/**
	 * Obtém o valor associado ao Enum.
	 * @return char refrente ao Enum.
	 */
	
	public char getValue() { return this.value; }
}
