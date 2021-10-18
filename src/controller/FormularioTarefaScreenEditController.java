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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import message.MessageAlert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    private Button btnVoltar;

    @FXML
    private DatePicker txtValidade;
    
    @FXML
    private Button btnAddNovaTarefaEdit;

    @FXML
    private ToggleGroup group;
   
    private MessageAlert msgAlert = new MessageAlert();
    
    private Tarefa tarefaSelecionada;


    public void salvarEditTarefa() throws ObjetoInexistenteException {
    	
    	boolean isCampoAnyEmpty  = verificarCampoAnyEmpty();
    	
    	if(isCampoAnyEmpty) {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    	}
    	
    	else {
    		
			String titleTarefa = txtTitulo.getText();
    		String descriptionTarefa = txtDescricao.getText();
    		String dateTarefa = txtValidade.getEditor().getText();
    		Status statusSelecionado = getStatusSelecionado();
    		
    		tarefaSelecionada.setTitulo(titleTarefa);
    		tarefaSelecionada.setDescricao(descriptionTarefa);
    		tarefaSelecionada.setValidade(dateTarefa);
    		tarefaSelecionada.setStatus(statusSelecionado);
    		  		
    		cleanInfoTarefa();
    		
    		this.msgAlert.getMessageTarefaEditada();
    		
    	}
    }
    
   
   public void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

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
		
		tarefaSelecionada = TarefasScreenController.getTarefaSelecionada();
		
		txtTitulo.setText(tarefaSelecionada.getTitulo());
    	txtDescricao.setText(tarefaSelecionada.getDescricao());
    	txtValidade.getEditor().setText(tarefaSelecionada.getValidade());
        
    }    
    
 
	public void addButtonsListener(EventHandler<ActionEvent> listener){
		   
		btnAddNovaTarefaEdit.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
    }


	public TextField getTxtTitulo() {
		return txtTitulo;
	}


	public void setTxtTitulo(TextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}


	public TextArea getTxtDescricao() {
		return txtDescricao;
	}


	public void setTxtDescricao(TextArea txtDescricao) {
		this.txtDescricao = txtDescricao;
	}


	public Button getBtnVoltar() {
		return btnVoltar;
	}


	public void setBtnVoltar(Button btnVoltar) {
		this.btnVoltar = btnVoltar;
	}


	public DatePicker getTxtValidade() {
		return txtValidade;
	}


	public void setTxtValidade(DatePicker txtValidade) {
		this.txtValidade = txtValidade;
	}


	
	public ToggleGroup getGroup() {
		return group;
	}


	public void setGroup(ToggleGroup group) {
		this.group = group;
	}


	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}


	public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}


	public Button getBtnAddNovaTarefaEdit() {
		return btnAddNovaTarefaEdit;
	}


	public void setBtnAddNovaTarefaEdit(Button btnAddNovaTarefaEdit) {
		this.btnAddNovaTarefaEdit = btnAddNovaTarefaEdit;
	}

}
