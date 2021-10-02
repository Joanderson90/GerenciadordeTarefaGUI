/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;


/**
 *
 * @author User
 */

public class ProjetoScreenEditNameController implements Initializable {
	
    @FXML
    private TextField txtTitulo;

    @FXML
    private Button salvarNomeBTN;

 
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private Projeto temp = new Projeto("temp");
    private Projeto projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();

    @FXML
    void salvarNome(ActionEvent event) throws ArgumentoInvalidoException, ObjetoInexistenteException {
    	
    	String titulo = txtTitulo.getText();
   
    	
    	if(titulo == "") {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	}
    	
    	else {
    		
   		
        	temp.setTitulo(titulo);
        	temp.setDescricao(projetoSelecionado.getDescricao());

        	
        	ProjetosScreenController.setProjetoEditado(temp, projetoSelecionado.getTitulo());
        	
        	this.msgAlert.getMessageProjetoEditado();;
        	
        	
    	}
    	
    	
    }
    
    public void loadName() {
    	
    	txtTitulo.setText(projetoSelecionado.getTitulo());
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadName();
    }    
    
 

    
    
    
    
    
    
    
    
    
}
