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

package model;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {
	
	private Alert alert;
	
	public void getMessageCampoEmBranco() {
		
		alert = new Alert(AlertType.WARNING);
		alert.setContentText("Por favor preenche os campos primeiro");
		
		alert.show();
		
	}
	
	public void getMessageTarefasNaoConcluidas() {
		
		alert = new Alert(AlertType.WARNING);
		alert.setContentText("As tarefas devem estar concluídas para que um projeto seja excluído");
		
		alert.show();
		
	}
	
	public void getMessageProjetoSalvo() {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Projeto Salvo com Sucesso!");
		
		alert.show();
	}
	
	public void getMessageProjetoEditado() {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Projeto Editado com Sucesso!");
		
		alert.show();
	}
	
	public void getMessageProjetoNaoSelecionada() {
		
		alert = new Alert(AlertType.WARNING);
		alert.setContentText("Por favor selecione um projeto primeiro!");
		
		alert.show();
	}
	
	public void getMessageProjetoExcluida() {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Projeto excluído com Sucesso!");
		
		alert.show();
	}

	public void getMessageTarefaSalva() {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Tarefa salva com Sucesso!");
		
		alert.show();
		
	}

	public void getMessageTarefaEditada() {
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Tarefa editada com Sucesso!");
		
		alert.show();
		
	}

	public void getMessageTarefaNaoSelecionada() {
		
		alert = new Alert(AlertType.WARNING);
		alert.setContentText("Por favor selecione uma Tarefa!");
		
		alert.show();
		
	}

	public void getMessageTarefaExcluida() {
	
		
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Tarefa excluída com Sucesso!");
		
		alert.show();
	}
		
	
}
