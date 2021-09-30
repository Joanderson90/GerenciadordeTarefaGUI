/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miprogramacao.gerenciadordetarefas.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.miprogramacao.gerenciadordetarefas.model.*;

/**
 *
 * @author User
 */

public class ProjetosScreenController implements Initializable {
	
	@FXML
    private  ListView<Projeto> lvProjetos;
	

    @FXML
    private Button novoProjetoBTN;
    
    @FXML
    private Button openTarefasBTN;
    
    @FXML
    private Button atualizarProjetosBTN;

    @FXML
    private Button excluirProjetoBTN;

    @FXML
    private Button editarProjetoBTN;
    
    private  ObservableList<Projeto> obsProjetos;
    
    private static User user = new User();
    private static Projeto projetoSelecionado;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    
    
    
    public void loadProjetos() {
    	
    	List<Projeto> projetosCadastrados = user.getProjetos();
    	
    	obsProjetos = FXCollections.observableArrayList(projetosCadastrados);
    	
    	lvProjetos.setItems(obsProjetos);
    }

    @FXML
    void addNovoProjeto(ActionEvent event) throws IOException, ArgumentoInvalidoException {
    	
    	MainScreenController tempMainScreen = new MainScreenController();
    	tempMainScreen.openNewScreen("FormularioProjetoScreen", "Cadastro Projetos");
    	
    	
    	
    }

    @FXML
    void editarProjeto(ActionEvent event) throws IOException {
    	
    	projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	if(projetoSelecionado == null) {
    		
    		this.msgAlert.getMessageProjetoNaoSelecionada();
    		
    	}
    	
    	else {
    		
    		MainScreenController tempMainScreen = new MainScreenController();
        	tempMainScreen.openNewScreen("FormularioProjetoScreenEdit", "Edição de Projetos");
    		
    	}
    	
    	
    }
    
    

    @FXML
    void excluirProjeto(ActionEvent event) {
    	
    	Projeto projetoAlvo = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	
    	if(projetoAlvo == null) {
    		
    		this.msgAlert.getMessageProjetoNaoSelecionada();
    		
    	}
    	
    	else {
    		
    		boolean isProjetoExcluido = user.excluirProjeto(projetoAlvo);
    		
    		if(isProjetoExcluido) {
    			
    			this.msgAlert.getMessageProjetoExcluida();;
    			
    		}
    		
    		else {
    			
    			this.msgAlert.getMessageTarefasNaoConcluidas();
    		}
    	}
    	
    	

    }
    
    @FXML
    void openTarefas(ActionEvent event) throws IOException {
    	
    	projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	boolean isProjetoSelecionado = projetoSelecionado != null;
    	
		if(isProjetoSelecionado) {
			
			MainScreenController tempMainScreen = new MainScreenController();
	    	tempMainScreen.openNewScreen("TarefasScreen", "Tarefas");
			
		}
		
		else {
			
			this.msgAlert.getMessageProjetoNaoSelecionada();
		}
    	

    }
    
    public static Projeto getProjetoSelecionado() {
    	
    	return projetoSelecionado;
    }
    
    public static void setProjetoSalvo(Projeto projeto) throws ArgumentoInvalidoException {
    	
    	user.setProjeto(projeto);
    	
    	
    }
    
    
    @FXML
    void atualizarProjetos(ActionEvent event) {
    	
    	loadProjetos();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadProjetos();
    }

	public static void setProjetoEditado(Projeto projetoEditado, String titulo) throws ObjetoInexistenteException, ArgumentoInvalidoException {
		
		Projeto projetoNaoEditado = user.buscarProjetoPorTitulo(titulo);
		
		user.excluirProjeto(projetoNaoEditado);
		
		user.setProjeto(projetoEditado);
		
		
	}    
    
       
    
    
}
