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
 * Controlador do formulario de edição de projetos
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
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
