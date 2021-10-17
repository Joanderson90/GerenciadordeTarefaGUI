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

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import model.MessageAlert;
import model.Projeto;
import model.User;

/**
 *
 * @author User
 */

public class ProjetosScreenController implements Initializable, EventHandler<ActionEvent> {
	
	@FXML
    private ListView<Projeto> lvProjetos;
	
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
    
    @FXML
    private MenuButton menuBTN;

    @FXML
    private MenuItem menuItemNome;

    @FXML
    private MenuItem menuItemDescricao;
    
    private ObservableList<Projeto> obsProjetos;
    
    private static User user = new User();
    private static Projeto projetoSelecionado;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private FormularioProjetoScreenController formularioController;
    private FormularioProjetoScreenEditController formularioControllerEdit;
 
    public void loadProjetos() {
    	
    	
    	List<Projeto> projetosCadastrados = user.getProjetos();
    	
    	obsProjetos = FXCollections.observableArrayList(projetosCadastrados);
    
    	lvProjetos.setItems(obsProjetos);
    }

    @FXML
    void addNovoProjeto(ActionEvent event) throws IOException, ArgumentoInvalidoException {
    	
    	MainScreenController tempMainScreen = new MainScreenController();
    	
    	Object fxmlLoader = tempMainScreen.openNewScreen("FormularioProjetoScreen", "Cadastro Projetos");
    			
    	formularioController = (FormularioProjetoScreenController) fxmlLoader;
    	
    	formularioController.addButtonsListener(this);
    	 	
    }
    
    	  
    
    @FXML
    void editarProjeto(ActionEvent event) throws IOException {
    	
    	projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	if(projetoSelecionado == null) {
    		
    		this.msgAlert.getMessageProjetoNaoSelecionada();
    		
    	}
    	
    	else {
    		
    		MainScreenController tempMainScreen = new MainScreenController();
        	
        	Object fxmlLoader = tempMainScreen.openNewScreen("FormularioProjetoScreenEdit", "Edição Projetos");
        			
        	formularioControllerEdit = (FormularioProjetoScreenEditController) fxmlLoader;
        	
        	formularioControllerEdit.addButtonsListener(this);
    		
    	}
    }

  
    @FXML
    void excluirProjeto(ActionEvent event) {
    	
    	Projeto projetoAlvo = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	
    	if(projetoAlvo == null) {
    		
    		this.msgAlert.getMessageProjetoNaoSelecionada();
    		
    	} else {
    		
    		boolean isProjetoExcluido = user.excluirProjeto(projetoAlvo);
    		
    		if(isProjetoExcluido) {
    			
    			
    			loadProjetos();
    			
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
			
		} else {
			
			this.msgAlert.getMessageProjetoNaoSelecionada();
		}
    }
    
    public static Projeto getProjetoSelecionado() {
    	
    	return projetoSelecionado;
    }
    
    public static void setProjetoSalvo(Projeto projeto) throws ArgumentoInvalidoException {
    	
    	user.setProjeto(projeto);
    	
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
	
	public static User getUser() {
		
		return user;
	}


	@Override
	public void handle(ActionEvent arg0) {
		
		if(arg0.getSource() == formularioController.getBntSalvar()) {
			
			try {
				
				formularioController.addNewProjeto();
				
				loadProjetos();
				
			} catch (ArgumentoInvalidoException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else if(arg0.getSource() == formularioController.getBtnVoltar()) {
			
			formularioController.closeScreen();
			
			
		}
		
		else if(arg0.getSource() == formularioControllerEdit.getBtnSalvar()) {
			
			try {
				
				formularioControllerEdit.addProjetoEditado();
				
				loadProjetos();
				
			} catch (ArgumentoInvalidoException | ObjetoInexistenteException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else if(arg0.getSource() == formularioControllerEdit.getBtnVoltar()) {
			
			
			formularioControllerEdit.closeScreen();
			
		}
		
		
	}
	
	
    
}
