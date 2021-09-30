package controll;
/**
 * Sample Skeleton for 'CadastroTarefas.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TarefaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txt_titulo"
    private TextField txt_titulo; // Value injected by FXMLLoader

    @FXML // fx:id="txt_validade"
    private TextField txt_validade; // Value injected by FXMLLoader

    @FXML // fx:id="txt_descricao"
    private TextArea txt_descricao; // Value injected by FXMLLoader

    @FXML // fx:id="btn_cadastro"
    private Button btn_cadastro; // Value injected by FXMLLoader

    @FXML
    void Cadastrar(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	txt_descricao.setText("pegou");
        /*assert txt_titulo != null : "fx:id=\"txt_titulo\" was not injected: check your FXML file 'CadastroTarefas.fxml'.";
        assert txt_validade != null : "fx:id=\"txt_validade\" was not injected: check your FXML file 'CadastroTarefas.fxml'.";
        assert txt_descricao != null : "fx:id=\"txt_descricao\" was not injected: check your FXML file 'CadastroTarefas.fxml'.";
        assert btn_cadastro != null : "fx:id=\"btn_cadastro\" was not injected: check your FXML file 'CadastroTarefas.fxml'.";*/

    }
}
