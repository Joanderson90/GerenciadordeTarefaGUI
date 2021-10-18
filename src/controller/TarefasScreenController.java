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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.MessageAlert;
import model.Projeto;
import model.Tarefa;
import model.User;

/**
 *
 * @author User
 */

public class TarefasScreenController implements Initializable, EventHandler<ActionEvent> {
	
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
    private Button projetosBTN;
    
    @FXML
    private Button editarTarefaBTN;

    @FXML
    private Button excluirTarefaBTN;

    @FXML
    private Button attTarefasBTN;
	
    private static Projeto projetoQueDetemTarefas;
    
    private FormularioTarefaScreenController formularioController;
    private FormularioTarefaScreenEditController formularioControllerEdit;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    
    
    @FXML
    void addNovaTarefa(ActionEvent event) throws IOException {
    	
    	MainScreenController tempMainScreen = new MainScreenController();
    	
    	Object fxmlLoader = tempMainScreen.openNewScreen("FormularioTarefaScreen", "Cadastro Tarefas");
    			
    	formularioController = (FormularioTarefaScreenController) fxmlLoader;
    	
    	formularioController.addButtonsListener(this);
    }

    @FXML
    void atualizarTarefas(ActionEvent event) {
    	
    	loadTarefas();
    }
    
    @FXML
    void backToScreenProjetos(ActionEvent event) {
    	
    	Stage stage = (Stage) projetosBTN.getScene().getWindow();
    	
    	stage.close();
    }
    
    @FXML
    void editarTarefa(ActionEvent event) throws IOException {
    	
    	if(tarefaSelecionada != null) {
    		
    		MainScreenController tempMainScreen = new MainScreenController();
        	
        	Object fxmlLoader = tempMainScreen.openNewScreen("FormularioTarefaScreenEdit", "Edição Tarefas");
        			
        	formularioControllerEdit = (FormularioTarefaScreenEditController) fxmlLoader;
        	
        	formularioControllerEdit.addButtonsListener(this);
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
    	projetoQueDetemTarefas = ProjetosScreenController.getProjetoSelecionado();
    	
    	formularioControllerEdit = new FormularioTarefaScreenEditController();
    	
    	formularioController = new FormularioTarefaScreenController();
        loadTarefas();
    }

	@Override
	public void handle(ActionEvent arg0) {
		

		if(arg0.getSource() == formularioController.getBtnAddNovaTarefa()) {
				
			formularioController.salvarNovaTarefa();;
			
			loadTarefas();
		
		}
		
		else if(arg0.getSource() == formularioController.getBtnVoltar()) {
			
			formularioController.closeScreen();
			
			
		}
		
		else if(arg0.getSource() == formularioControllerEdit.getBtnAddNovaTarefa()) {
			
			try {
				
				formularioControllerEdit.salvarEditTarefa();
				
				loadTarefas();
				
			} catch (ObjetoInexistenteException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else if(arg0.getSource() == formularioControllerEdit.getBtnVoltar()) {			
			
			formularioControllerEdit.closeScreen();
			
		}
	}    
}
