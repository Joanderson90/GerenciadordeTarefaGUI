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
import model.ScreenManager;
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
    
    private ScreenManager screenManager = new ScreenManager();
    
    private static User user = new User();
    private static Projeto projetoSelecionado;
    
    private MessageAlert msgAlert = new MessageAlert();
    
    private FormularioProjetoScreenController formularioProjetoController;
    private FormularioProjetoScreenEditController formularioProjetoControllerEdit;
    
 
    public void loadProjetos() {
    	
    	List<Projeto> projetosCadastrados = user.getProjetos();
    	
    	obsProjetos = FXCollections.observableArrayList(projetosCadastrados);
    
    	lvProjetos.setItems(obsProjetos);
    }

    @FXML
    void openFormularioProjetoScreen(ActionEvent event) throws IOException, ArgumentoInvalidoException {
    	
    	screenManager.openNewScreen("FormularioProjetoScreen", "Cadastro Projetos");
    	
    	setReferenciaFormularioProjetoController();
    	 	
    }
    	  
    
    private void setReferenciaFormularioProjetoController() {
    	
    	Object currentController = screenManager.getCurrenController();
    	
    	formularioProjetoController = (FormularioProjetoScreenController) currentController;
    	
    	formularioProjetoController.addButtonsListener(this);
	}

	@FXML
    void openFormularioProjetoScreenEdit(ActionEvent event) throws IOException {
    	
    	projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();
    	
    	if(projetoSelecionado == null) {
    		
    		this.msgAlert.getMessageProjetoNaoSelecionada();
    		
    	}
    	
    	else {
        	
    		screenManager.openNewScreen("FormularioProjetoScreenEdit", "Edição Projetos");
    		
    		setReferenciaFormularioProjetoControllerEdit();
    		
    	}
    }

  
    private void setReferenciaFormularioProjetoControllerEdit() {
    	
    	Object currentController = screenManager.getCurrenController();
    	
    	formularioProjetoControllerEdit = (FormularioProjetoScreenEditController) currentController;
    	
    	formularioProjetoControllerEdit.addButtonsListener(this);
		
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

	    	screenManager.openNewScreen("TarefasScreen", "Tarefas");
			
		} else {
			
			this.msgAlert.getMessageProjetoNaoSelecionada();
		}
    }
    
    public static Projeto getProjetoSelecionado() {
    	
    	return projetoSelecionado;
    }
    
    public static void setNewProjeto(Projeto projeto) throws ArgumentoInvalidoException {
    	
    	user.setProjeto(projeto);
    	
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 
        loadProjetos();
    }
    
	public static User getUser() {
		
		return user;
	}


	@Override
	public void handle(ActionEvent arg0) {
		
		if(arg0.getSource() == formularioProjetoController.getBntSalvar()) {
			
			try {
				
				formularioProjetoController.addNewProjeto();
				
				loadProjetos();
				
			} catch (ArgumentoInvalidoException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else if(arg0.getSource() == formularioProjetoController.getBtnVoltar()) {
			
			formularioProjetoController.closeScreen();
			
			
		}
		
		else if(arg0.getSource() == formularioProjetoControllerEdit.getBtnSalvar()) {
			
			try {
				
				formularioProjetoControllerEdit.addProjetoEditado();
				
				loadProjetos();
				
			} catch (ArgumentoInvalidoException | ObjetoInexistenteException e) {
				
				e.printStackTrace();
			}
			
		}
		
		else if(arg0.getSource() == formularioProjetoControllerEdit.getBtnVoltar()) {
			
			
			formularioProjetoControllerEdit.closeScreen();
			
		}
		
		
	}
	
	
    
}
