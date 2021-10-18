/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;


/**
 *
 * @author User
 */

public class FormularioProjetoScreenEditController implements Initializable {
	
    @FXML
    private TextField txtTitulo;

    @FXML
    private TextArea txtDescricao;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnSalvar;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private Projeto projetoSelecionado;

    public void addProjetoEditado() throws ArgumentoInvalidoException, ObjetoInexistenteException {
    	
    	String titulo = txtTitulo.getText();
    	String descricao = txtDescricao.getText();
    	
    	if(titulo == "" || descricao == "") {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	}
    	
    	else {
    		
    		
        	projetoSelecionado.setTitulo(titulo);
        	projetoSelecionado.setDescricao(descricao);
       
        	cleanInfoProjeto();
        	
        	this.msgAlert.getMessageProjetoEditado();
        	
        	
    	}
    	
    	
    }
    
 
    void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();
    	
    	loadInfoProjeto();
        
    }    
    
    public void loadInfoProjeto() {
    	
    	txtTitulo.setText(projetoSelecionado.getTitulo());
    	txtDescricao.setText(projetoSelecionado.getDescricao());
    }
    
    public void cleanInfoProjeto() {
    	
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    }

    public void addButtonsListener(EventHandler<ActionEvent> listener){
 	   
    	btnSalvar.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
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

	public Button getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(Button btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
    
 

    
    
    
    
    
    
    
    
    
}
