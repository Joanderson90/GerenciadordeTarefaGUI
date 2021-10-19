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
import message.MessageAlert;
import model.*;


/**
 *
 * @author Diego Cerqueira e Joanderson Santos
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

    /**
     * metodo de salvar alterações em um projeto
     * @throws ArgumentoInvalidoException
     * @throws ObjetoInexistenteException
     */
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
    
    /**
     * metodo de fechar a tela
     */
    void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

    }
  
    /**
     * metodo initialize da interface Initializable
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();
    	
    	loadInfoProjeto();
        
    }    
    
    /**
     * metodo para carregar informações do projeto
     */
    public void loadInfoProjeto() {
    	
    	txtTitulo.setText(projetoSelecionado.getTitulo());
    	txtDescricao.setText(projetoSelecionado.getDescricao());
    }
    
    /**
     * metodo de limpar campos do formulario de editar projeto
     */
    public void cleanInfoProjeto() {
    	
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    }

    /**
     * Metodo para "ouvir" ação do botão
     * @param listener
     */
    public void addButtonsListener(EventHandler<ActionEvent> listener){
 	   
    	btnSalvar.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
    }

	/**
	 * retorna titulo do projeto
	 * @return String
	 */
	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * insere novo titulo ao projeto
	 * @param txtTitulo
	 */
	public void setTxtTitulo(TextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	/**
	 * retorna descrição do projeto
	 * @return String
	 */
	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * insere nova descrição do projeto
	 * @param txtDescricao
	 */
	public void setTxtDescricao(TextArea txtDescricao) {
		this.txtDescricao = txtDescricao;
	}

	/**
	 * retorna botão de voltar
	 * @return Button
	 */
	public Button getBtnVoltar() {
		return btnVoltar;
	}

	/**
	 * insere botão de voltar
	 * @param btnVoltar
	 */
	public void setBtnVoltar(Button btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	/**
	 * retorna botão de salvar
	 * @return Button
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}

	/**
	 * insere botão de salvar
	 * @param btnSalvar
	 */
	public void setBtnSalvar(Button btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
    
 

    
    
    
    
    
    
    
    
    
}
