/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Exceptions.ObjetoInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.*;

/**
 *
 * @author User
 */

public class TarefasScreenController implements Initializable {
	
	@FXML
    private ListView<Tarefa> lvTarefasPendentes;

    @FXML
    private ListView<Tarefa> lvTarefasEmExecucao;

    @FXML
    private ListView<Tarefa> lvTarefasConcluidas;
    
    private static ObservableList<Tarefa> obsTarefasPendentes;
    private static ObservableList<Tarefa> obsTarefasConcluidas;
    private static ObservableList<Tarefa> obsTarefasEmExecucao;
    private static Tarefa tarefaSelecionada;
    @FXML
    private Button addNovaTarefaBTN;

    @FXML
    private Button editarTarefaBTN;

    @FXML
    private Button excluirTarefaBTN;

    @FXML
    private Button attTarefasBTN;
	
    private static Projeto projetoQueDetemTarefas = ProjetosScreenController.getProjetoSelecionado();
    
    private MessageAlert msgAlert = new MessageAlert();
    
    
    
    @FXML
    void addNovaTarefa(ActionEvent event) throws IOException {
    	
    	MainScreenController tempMainScreen = new MainScreenController();
    	tempMainScreen.openNewScreen("FormularioTarefaScreen", "Cadastro Tarefas");
    }

    @FXML
    void atualizarTarefas(ActionEvent event) {
    	
    	loadTarefas();
    }

    @FXML
    void editarTarefa(ActionEvent event) throws IOException {
    	
    	if(tarefaSelecionada != null) {
    		
    		MainScreenController tempMainScreen = new MainScreenController();
        	tempMainScreen.openNewScreen("FormularioTarefaScreenEdit", "Edição Tarefas");
    	}
    	
    	else {
			
			this.msgAlert.getMessageTarefaNaoSelecionada();
		}

    }

    @FXML
    void excluirTarefa(ActionEvent event) {
    	
    	if(tarefaSelecionada != null) {
    		
    		projetoQueDetemTarefas.getTarefas().remove(tarefaSelecionada);
    		
    		loadTarefas();
    		
    		this.msgAlert.getMessageTarefaExcluida();
    	}
    	
    	else {
			
			this.msgAlert.getMessageTarefaNaoSelecionada();
		}

    }
    
    
    public void loadTarefas() {
    	
    	
    	List<Tarefa> tarefasPendentes  = projetoQueDetemTarefas.getTarefasPendentes();
    	List<Tarefa> tarefasEmExecucao  = projetoQueDetemTarefas.getTarefasEmExecucao();
    	List<Tarefa> tarefasConcluidas  = projetoQueDetemTarefas.getTarefasConcluidas();
    	
    	
    	obsTarefasPendentes = FXCollections.observableArrayList(tarefasPendentes);
    	obsTarefasEmExecucao = FXCollections.observableArrayList(tarefasEmExecucao);
    	obsTarefasConcluidas = FXCollections.observableArrayList(tarefasConcluidas);
    	
    	lvTarefasPendentes.setItems(obsTarefasPendentes);
    	lvTarefasEmExecucao.setItems(obsTarefasEmExecucao);
    	lvTarefasConcluidas.setItems(obsTarefasConcluidas);
    }
    
    public static void setTarefaSalva(Tarefa newTarefa) {
    	
    	projetoQueDetemTarefas.setTarefa(newTarefa);
    }
    
    public static void setTarefaSalva(Tarefa newTarefa, String title) throws ObjetoInexistenteException {
    	
    	User userTemp = ProjetosScreenController.getUser();
    	Tarefa tarefaNaoEditada = userTemp.buscarTarefaPorTitulo(title);
    	
    	projetoQueDetemTarefas.getTarefas().remove(tarefaNaoEditada);
    	
    	projetoQueDetemTarefas.setTarefa(newTarefa);
    }
    
    public static Tarefa getTarefaSelecionada() {
    	
    	return tarefaSelecionada;
   
    }
    
    
    @FXML
    void listInViewConcluidas() {
    	
    	
    	tarefaSelecionada = lvTarefasConcluidas.getSelectionModel().getSelectedItem();
    }
    

    @FXML
    void listInViewEmExecucao() {
    	
    	tarefaSelecionada = lvTarefasEmExecucao.getSelectionModel().getSelectedItem();
    }
    @FXML
     void listInViewPendentes() {
    	 
    	tarefaSelecionada = lvTarefasPendentes.getSelectionModel().getSelectedItem();

    }

   
    

    
    	

    
    
 
    
    
    @FXML
    void atualizarProjetos(ActionEvent event) {
    	
    	loadTarefas();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTarefas();
    }    
    
       
    
    
}
