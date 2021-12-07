/*******************************************************************************
Autor: Diego Cerqueira e Joanderson Santos
Componente Curricular: MI Programa��o
Concluido em: 18/10/2021
Declaro que este c�digo foi elaborado por mim de forma individual e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/

package model;

import date.MyDate;

/**
 * A Classe <b>Tarefa</b> representa a modelagem de uma <b>Tarefa</b> do
 * Sistema.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public class Tarefa {

	private String titulo;
	private String descricao;
	private String validade;
	private Status status;
	private int idProjetoPertencente;

	/**
	 * Construtor vazio de tarefa.
	 */

	public Tarefa() {

	}

	/**
	 * Contrutor de tarefa.
	 * 
	 * @param titulo    t�tulo da tarefa a ser inserido.
	 * @param descricao descri��o da tarefa a ser inserida.
	 * @param validade  validade da tarefa a ser inserida.
	 */

	public Tarefa(String titulo, String descricao, String validade) {

		this.titulo = titulo;
		this.descricao = descricao;
		this.validade = validade;
		this.status = Status.PENDENTE;
	}

	/**
	 * Contrutor de tarefa
	 * 
	 * @param titulo   t�tulo da tarefa a ser inserido.
	 * @param validade validade da tarefa a ser inserida.
	 */

	public Tarefa(String titulo, String validade) {

		this.titulo = titulo;
		this.descricao = "";
		this.validade = validade;
		this.status = Status.PENDENTE;
	}

	/**
	 * retorna o t�tulo da tarefa.
	 * 
	 * @return String t�tulo da tarefa.
	 */

	public String getTitulo() {
		return titulo;
	}

	/**
	 * insere o t�tulo da tarefa
	 * 
	 * @param titulo t�tulo da tarefa a ser inserido.
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * retorna a descri��o da tarefa.
	 * 
	 * @return String descri��o da tarefa.
	 */

	public String getDescricao() {
		return descricao;
	}

	/**
	 * insere a descri��o da tarefa.
	 * 
	 * @param descricao descri��o da tarefa.
	 */

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * retorna a data de validade da tarefa no formato dd/MM/yyyy.
	 * 
	 * @return String validade da tarefa no formato dd/MM/yyyy.
	 */

	public String getValidade() {
		return validade;
	}

	/**
	 * insere uma validade a tarefa no formato dd/MM/yyyy.
	 * 
	 * @param validade validade da tarefa formato dd/MM/yyyy.
	 */

	public void setValidade(String validade) {
		this.validade = validade;
	}

	/**
	 * retorna o status da tarefa.
	 * 
	 * @return Status Enum referente ao Status da tarefa.
	 */

	public Status getStatus() {
		return status;
	}

	/**
	 * insere um status a tarefa
	 * 
	 * @param status Enum referente ao Status da tarefa a ser inserido.
	 */

	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Compara duas tarefas.
	 * 
	 * @return true se os dois projetos s�o iguais, ou false caso contr�rio.
	 */

	public boolean equals(Object obj) {

		if (obj instanceof Tarefa) {

			Tarefa tarefaASerComparada = (Tarefa) obj;

			return (this.titulo == tarefaASerComparada.getTitulo()
					&& this.descricao == tarefaASerComparada.getDescricao()
					&& this.validade == tarefaASerComparada.getValidade()
					&& this.status == tarefaASerComparada.getStatus());

		}

		return false;
	}

	/**
	 * verifica se uma tarefa est� atrasada.
	 * 
	 * @return boolean true se a tarefa est� atrasada, ou false caso contr�rio.
	 */

	public boolean getIsAtrasada() {

		Status statusConcluida = Status.CONCLUIDA;

		boolean isAtrasada = false;
		boolean isTarefaConcluida = (this.status == statusConcluida);

		if (!isTarefaConcluida) {

			MyDate date = new MyDate();

			String currentDate = date.getCurrentDate();
			String dateTarefa = this.validade;

			int valComp = date.compareTo(currentDate, dateTarefa);// M�todo similar ao CompareTo da classe String

			if (valComp >= 1)
				isAtrasada = true; // Data atual > Data tarefa
		}
		return isAtrasada;
	}

	/**
	 * M�todo pra converter um objeto tarefa para uma string.
	 */

	@Override
	public String toString() {

		boolean isTarefaAtrasada = this.getIsAtrasada();

		String marcacaoAtrasada = "";

		if (isTarefaAtrasada)
			marcacaoAtrasada = " [Atrasada!]";

		return "T�tulo: " + this.getTitulo() + "\n" + "Descri��o: " + this.getDescricao() + "\n" + "Validade: "
				+ this.getValidade() + marcacaoAtrasada;

	}

	public int getIdProjetoPertencente() {
		return idProjetoPertencente;
	}

	public void setIdProjetoPertencente(int idProjetoPertencente) {
		this.idProjetoPertencente = idProjetoPertencente;
	}
	
	

}
