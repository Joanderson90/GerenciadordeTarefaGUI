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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import model.*;


/**
 *
 * @author User
 */

public class ProjetoScreenEditDescricaoController implements Initializable {
	
	 @FXML
	 private TextArea txtDescricao;

	 @FXML
	 private Button salvarDescricaoBTN;

 
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private Projeto temp = new Projeto("temp");
    private Projeto projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();

    @FXML
    void salvarDescricao(ActionEvent event) throws ArgumentoInvalidoException, ObjetoInexistenteException {
    	
    	String descricao = txtDescricao.getText();
   
    	
    	if(descricao == "") {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	}
    	
    	else {
    		
   		
        	temp.setDescricao(descricao);

        	
        	ProjetosScreenController.setProjetoEditado(temp, projetoSelecionado.getTitulo());
        	
        	this.msgAlert.getMessageProjetoEditado();;
        	
        	
    	}
    	
    	
    }
    
    public void loadDescricao() {
    	
    	txtDescricao.setText(projetoSelecionado.getTitulo());
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadDescricao();
    }    
    
 

    
    
    
    
    
    
    
    
    
}
