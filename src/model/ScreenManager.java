package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScreenManager {
	
	private Object currentController;
	
	public void openNewScreen(String path, String title) throws IOException{
                
        FXMLLoader fxmlLoader = new FXMLLoader();
        
        Pane p = fxmlLoader.load(getClass().getResource("/view/"+path+".fxml").openStream());
        
        Object controller =  fxmlLoader.getController();
        
        Stage stage = new Stage();
    
        stage.setScene(new Scene(p));
        stage.setTitle(title);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
        this.currentController = controller;
        
    }
	
	public Object getCurrenController() { return this.currentController; }
}
