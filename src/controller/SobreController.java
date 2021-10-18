package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * 
 * @author diego
 *
 */
public class SobreController implements Initializable{

    @FXML
    void openRepository(ActionEvent event) {
    	
    	try {
    		
			URI uri = new URI("https://github.com/Diego10Rocha/GerenciadordeTarefaGUI");
			
			Desktop.getDesktop().browse(uri);
			
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
