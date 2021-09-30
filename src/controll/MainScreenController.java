/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    @FXML
    void acessProjetos(ActionEvent event) throws IOException {
    	
    	openNewScreen("ProjetosScreen", "Projetos");
    }

    @FXML
    void acessSobreSistema(ActionEvent event) {

	}
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
 

    
    
    public void openNewScreen(String path, String title) throws IOException{
        
        Parent form = FXMLLoader.load(getClass().getResource("/view/"+path+".fxml"));
        
        Stage stage = new Stage();
        stage.setScene(new Scene(form));
        
        stage.setTitle(title);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
    }
    
    
    
    
    
    
}
