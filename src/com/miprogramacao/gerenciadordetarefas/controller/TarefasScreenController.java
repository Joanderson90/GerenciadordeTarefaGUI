/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Exceptions.ArgumentoInvalidoException;
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

    @FXML
    private Button addNovaTarefaBTN;

    @FXML
    private Button editarTarefaBTN;

    @FXML
    private Button excluirTarefaBTN;

    @FXML
    private Button attTarefasBTN;
	
    private Projeto projetoQueDetemTarefas = ProjetosScreenController.getProjetoSelecionado();
    
    private MessageAlert msgAlert = new MessageAlert();
    
    
    
    @FXML
    void addNovaTarefa(ActionEvent event) throws IOException {
    	
    	MainScreenController tempMainScreen = new MainScreenController();
    	tempMainScreen.openNewScreen("FormularioTarefaScreen", "Cadastro Tarefas");
    }

    @FXML
    void atualizarTarefas(ActionEvent event) {

    }

    @FXML
    void editarTarefa(ActionEvent event) {

    }

    @FXML
    void excluirTarefa(ActionEvent event) {

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

   
    

    
    	

    
    
 
    
    
    @FXML
    void atualizarProjetos(ActionEvent event) {
    	
    	loadTarefas();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTarefas();
    }    
    
       
    
    
}
