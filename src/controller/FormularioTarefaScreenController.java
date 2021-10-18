/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import model.MessageAlert;
import model.Tarefa;


/**
 *
 * @author User
 */

public class FormularioTarefaScreenController implements Initializable {
	
	@FXML
    private TextField txtTitulo;

    @FXML
    private TextArea txtDescricao;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private DatePicker txtValidade;
 

    @FXML
    private Button btnAddNovaTarefa;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private Tarefa newTarefa;


    public void salvarNovaTarefa() {
    	
    	boolean isCampoAnyEmpty  = verificarCampoAnyEmpty();
    	
    	if(isCampoAnyEmpty) {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	} else {
    		
    		String titleTarefa = txtTitulo.getText();
    		String descriptionTarefa = txtDescricao.getText();
    		String dateTarefa = txtValidade.getEditor().getText();
    		
    		newTarefa = new Tarefa(titleTarefa, descriptionTarefa, dateTarefa);
    		
    		TarefasScreenController.setTarefaSalva(newTarefa);
    		
    		cleanInfoTarefa();
    		
    		this.msgAlert.getMessageTarefaSalva();
    		
    	}
    }
  
    private void cleanInfoTarefa() {
		
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    	txtValidade.getEditor().setText("");
		
	}
    
 
    void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

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
	
	public void addButtonsListener(EventHandler<ActionEvent> listener){
	 	   
    	btnAddNovaTarefa.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
    }

	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	public void setTxtTitulo(TextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public String getTxtDescricao() {
		return txtDescricao.getText();
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

	public Button getBtnAddNovaTarefa() {
		return btnAddNovaTarefa;
	}

	public void setBtnAddNovaTarefa(Button btnAddNovaTarefa) {
		this.btnAddNovaTarefa = btnAddNovaTarefa;
	}    
    
 

    
    
    
    
    
    
    
    
    
}
