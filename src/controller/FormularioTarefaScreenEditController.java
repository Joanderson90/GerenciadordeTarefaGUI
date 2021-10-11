/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Exceptions.ObjetoInexistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import model.MessageAlert;
import model.Status;
import model.Tarefa;


/**
 *
 * @author User
 */

public class FormularioTarefaScreenEditController implements Initializable {
	
	@FXML
    private TextField txtTitulo;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private DatePicker txtValidade;
    
    @FXML
    private Button salvarEditTarefaBTN;

    @FXML
    private ToggleGroup group;
   
    private MessageAlert msgAlert = new MessageAlert();
    private Tarefa tarefaSelecionada = TarefasScreenController.getTarefaSelecionada();

    @FXML
    void salvarEditTarefa(ActionEvent event) throws ObjetoInexistenteException {
    	
    	boolean isCampoAnyEmpty  = verificarCampoAnyEmpty();
    	
    	if(isCampoAnyEmpty) {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    	}
    	
    	else {
    		
			String titleTarefa = txtTitulo.getText();
    		String descriptionTarefa = txtDescricao.getText();
    		String dateTarefa = txtValidade.getEditor().getText();
    		Status statusSelecionado = getStatusSelecionado();
    		
    		Tarefa newTarefaEdit = new Tarefa(titleTarefa, descriptionTarefa, dateTarefa);
    		newTarefaEdit.setStatus(statusSelecionado);
    		
    		TarefasScreenController.setTarefaSalva(newTarefaEdit, tarefaSelecionada.getTitulo());
    		
    		cleanInfoTarefa();
    		
    		this.msgAlert.getMessageTarefaEditada();
    		
    	}
    }
  
    private void cleanInfoTarefa() {
		
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    	txtValidade.getEditor().setText("");
		
	}

	private boolean verificarCampoAnyEmpty() {
    	
    	boolean isCampoAnyEmpty = false;
    	
    	if( txtTitulo.getText() == "" ||
    	    txtDescricao.getText() == "" ||
    	    txtValidade.getEditor().getText() == "") {
    		
    		isCampoAnyEmpty = true;
    	}
    		
		return isCampoAnyEmpty;
	}
	
	public Status getStatusSelecionado() {
		
		Status statusSelecionado;
		
		RadioButton radio = (RadioButton) group.getSelectedToggle();
		
		if(radio.getText().equals("Pendente")) {
			
			
			statusSelecionado = Status.PENDENTE;
		}
		
		else if(radio.getText().equals("Concluída")) {
			
			
			statusSelecionado = Status.CONCLUIDA;
		}
		
		else {
			
			statusSelecionado = Status.EM_EXECUCAO;
		}
		
		return statusSelecionado;
		
	}
	
	

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
		txtTitulo.setText(tarefaSelecionada.getTitulo());
    	txtDescricao.setText(tarefaSelecionada.getDescricao());
    	txtValidade.getEditor().setText(tarefaSelecionada.getValidade());
        
    }    
    
 

    
    
    
    
    
    
    
    
    
}
