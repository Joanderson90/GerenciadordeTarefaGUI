package com.miprogramacao.gerenciadordetarefas.model;

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
}
