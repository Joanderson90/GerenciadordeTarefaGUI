package helloFx;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

	@FXML
    private Label label;
	
	@FXML
	private Button button;
	
	@FXML
	private void buttonActione(MouseEvent e) {
		System.out.println("You clicked me!");
		label.setText("Olá Mundo!");
		button.setText("Fuck");
	}

    public void initialize() {
        label.setText("Hello World!");
        button.setText("Clique aqui!");
    }
}
