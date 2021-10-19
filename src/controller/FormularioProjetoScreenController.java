/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Exceptions.ArgumentoInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import message.MessageAlert;
import model.Projeto;

/**
 * Controlador da tela de formulário de projetos
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class FormularioProjetoScreenController implements Initializable {
	
    @FXML
    private TextField txtTitulo;

    @FXML
    private TextArea txtDescricao;
    
    @FXML
    private Button btnSalvar;
    
    @FXML
    private Button btnVoltar;
    
    private MessageAlert msgAlert = new MessageAlert();  
   
    /**
     * metodo para criar novo projeto
     * @throws ArgumentoInvalidoException
     */
    public void addNewProjeto() throws ArgumentoInvalidoException {
    	
    	String titulo = txtTitulo.getText();
    	String descricao = txtDescricao.getText();
    	
    	if(titulo == "" || descricao == "") {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	} else {
    		
    		Projeto newProjeto = new Projeto();
    		
        	newProjeto.setTitulo(titulo);
        	newProjeto.setDescricao(descricao);
        	
        	ProjetosScreenController.setNewProjeto(newProjeto);        	        		
        
        	cleanInfoProjeto();
        	
        	this.msgAlert.getMessageProjetoSalvo();
        	
    	}
    }
   
    /**
     * Metodo para fechar tela de formulário de projeto
     */
    public void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

    }
    
    /**
     * Metodo para limpar campos de cadastro de projeto
     */
    public void cleanInfoProjeto() {
    	
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    	
    }
    
    public  Button getBntSalvar() {
    	
    	return btnSalvar; 
    	
    }
    
    /**
     * Metodo vazio da interface Initializable
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
   /**
    * Metodo para "ouvir" ação do botão e disparar evento
    * @param listener
 	*/
    public void addButtonsListener(EventHandler<ActionEvent> listener){
	   
    	btnSalvar.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
    }

	/**
	 * retorna o titulo do projeto
	 * @return String
	 */
	public String getTxtTitulo() {
		return txtTitulo.getText();
	}
	
	/**
	 * insere o titulo do projeto
	 * @param txtTitulo
	 */
	public void setTxtTitulo(TextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}
	
	/**
	 * retorna a descrição do projeto
	 * @return String
	 */
	public String getTxtDescricao() {
		return txtDescricao.getText();
	}
	
	/**
	 * insere a descrição do projeto
	 * @param txtDescricao
	 */
	public void setTxtDescricao(TextArea txtDescricao) {
		this.txtDescricao = txtDescricao;
	}
	
	/**
	 * retorna o botão de salvar um projeto
	 * @return Button
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}
	
	/**
	 * metodo de inserir um botão ao projeto
	 * @param btnSalvar
	 */
	public void setBtnSalvar(Button btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	
	/**
	 * retorna o botão de voltar
	 * @return Button
	 */
	public Button getBtnVoltar() {
		
		return btnVoltar;
	}
	
	/**
	 * insere o botão de voltar
	 * @param btnVoltar
	 */
	public void setBtnVoltar(Button btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
}
