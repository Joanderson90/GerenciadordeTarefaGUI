/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.ScreenManager;

/**
 *
 * @author User
 */

public class MainScreenController implements Initializable {
	
	@FXML
    private Menu menuArquivo;

    @FXML
    private MenuItem menuItemProjetos;

    @FXML
    private Menu menuSobre;

    @FXML
    private MenuItem menuItemSistema;
    
    private ScreenManager screenManager = new ScreenManager();

    @FXML
    void acessProjetos(ActionEvent event) throws IOException {
    	
    	screenManager.openNewScreen("ProjetosScreen", "Projetos");
    }

    @FXML
    void acessSobreSistema(ActionEvent event) {

	}
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
 

    
    
    
    
    
}
