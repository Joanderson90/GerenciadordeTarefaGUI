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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.TarefaDAO;

/**
 * A Classe <b>Projeto</b> representa a modelagem de um <b>projeto</b> do
 * Sistema.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public class Projeto {

	private int id;
	private String titulo;
	private String descricao;
	private List<Tarefa> tarefas;

	/**
	 * Construtor da classe.
	 * 
	 * @param titulo t�tulo do projeto a ser inserido.
	 */

	public Projeto(String titulo) {

		this.titulo = titulo;
		this.tarefas = new ArrayList<Tarefa>();
	}

	/**
	 * Construtor da classe.
	 * 
	 * @param titulo    t�tulo do projeto a ser inserido.
	 * @param descricao descri��o do projeto a ser inserida.
	 */

	public Projeto(String titulo, String descricao) {

		this.titulo = titulo;
		this.descricao = descricao;
		this.tarefas = new ArrayList<Tarefa>();
	}

	/**
	 * Construtor da classe.
	 */

	public Projeto() {
		this.tarefas = new ArrayList<Tarefa>();
	}

	/**
	 * retorna o t�tulo do projeto.
	 * 
	 * @return String t�tulo do projeto.
	 */

	public String getTitulo() {
		return titulo;
	}

	/**
	 * insere um t�tulo ao projeto.
	 * 
	 * @param titulo t�tulo do projeto a ser inserido.
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * retorna a descri��o do projeto.
	 * 
	 * @return String descri��o do projeto.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * insere uma descri��o ao projeto
	 * 
	 * @param descricao descri��o do projeto a ser inserida.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * retorna a lista de tarefas associadas ao projeto.
	 * 
	 * @return List<Tarefa> lista de tarefas associadas ao projeto.
	 */
	public List<Tarefa> getTarefas() {

		return TarefaDAO.getTarefasByIdProjeto(id);
	}

	/**
	 * insere uma lista de tarefas.
	 * 
	 * @param tarefas lista de tarefas a ser inserida.
	 */
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	/**
	 * adiciona uma tarefa a lista de tarefas.
	 * 
	 * @param tarefa tarefa a ser inserida.
	 */

	public void setTarefa(Tarefa tarefa) {

		this.tarefas.add(tarefa);

	}

	/**
	 * M�todo para comparar dois projetos.
	 * 
	 * @return true se os dois projetos s�o iguais, ou false caso contr�rio.
	 */

	public boolean equals(Object obj) {

		boolean objIsEqual = false;

		if (obj instanceof Projeto) {

			boolean tituloIsEqual = false;
			boolean descricaoIsEqual = false;
			boolean tarefasIsEqual = false;

			Projeto projetoASerComparado = (Projeto) obj;

			String tituloProjetoASerComparado = projetoASerComparado.getTitulo();
			String descricaoProjetoASerComparado = projetoASerComparado.getDescricao();
			List<Tarefa> tarefasProjetoASerComparado = projetoASerComparado.getTarefas();

			if (tituloProjetoASerComparado == this.getTitulo())
				tituloIsEqual = true;

			if (descricaoProjetoASerComparado == this.getDescricao())
				descricaoIsEqual = true;

			if (tarefasProjetoASerComparado.equals(this.getTarefas()))
				tarefasIsEqual = true;

			if (tituloIsEqual && descricaoIsEqual && tarefasIsEqual) {

				objIsEqual = true;
			}
		}

		return objIsEqual;
	}

	/**
	 * M�todo para converter um projeto para uma string com seus dados.
	 */

	@Override
	public String toString() {

		return "Titulo: " + titulo + "\n" + "Descri��o: " + descricao;
	}

	/**
	 * retorna uma lista com as tarefas pendentes
	 * 
	 * @return List<Tarefa> lista com as tarefas pendentes.
	 */

	public List<Tarefa> getTarefasPendentes() {

		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasPendentes = new ArrayList<>();

		Iterator<Tarefa> it = tarefasCadastradas.iterator();

		Tarefa tarefaCadastrada = new Tarefa();
		Status statusPendente = Status.PENDENTE;

		boolean isTarefaPendente;

		while (it.hasNext()) {

			tarefaCadastrada = it.next();

			isTarefaPendente = tarefaCadastrada.getStatus() == statusPendente;

			if (isTarefaPendente)
				tarefasPendentes.add(tarefaCadastrada);

		}

		return tarefasPendentes;

	}

	/**
	 * retorna uma lista com as tarefas em execu��o
	 * 
	 * @return List<Tarefa> tarefas em execu��o.
	 */
	public List<Tarefa> getTarefasEmExecucao() {

		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasEmExecucao = new ArrayList<>();

		Iterator<Tarefa> it = tarefasCadastradas.iterator();

		Tarefa tarefaCadastrada = new Tarefa();
		Status statusEmExecucao = Status.EM_EXECUCAO;

		boolean isTarefaEmExecucao;

		while (it.hasNext()) {

			tarefaCadastrada = it.next();

			isTarefaEmExecucao = tarefaCadastrada.getStatus() == statusEmExecucao;

			if (isTarefaEmExecucao)
				tarefasEmExecucao.add(tarefaCadastrada);

		}

		return tarefasEmExecucao;

	}

	/**
	 * retorna uma lista com as tarefas conclu�das
	 * 
	 * @return List<Tarefa> tarefas conclu�das.
	 */

	public List<Tarefa> getTarefasConcluidas() {

		List<Tarefa> tarefasCadastradas = this.getTarefas();
		List<Tarefa> tarefasConcluidas = new ArrayList<>();

		Iterator<Tarefa> it = tarefasCadastradas.iterator();

		Tarefa tarefaCadastrada = new Tarefa();
		Status statusConcluida = Status.CONCLUIDA;

		boolean isTarefaConcluida;

		while (it.hasNext()) {

			tarefaCadastrada = it.next();

			isTarefaConcluida = tarefaCadastrada.getStatus() == statusConcluida;

			if (isTarefaConcluida)
				tarefasConcluidas.add(tarefaCadastrada);

		}

		return tarefasConcluidas;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
