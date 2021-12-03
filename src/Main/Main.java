/*******************************************************************************
Autor: Diego Cerqueira e Joanderson Santos
Componente Curricular: MI Programa��o
Concluido em: 18/10/2021
Declaro que este c�digo foi elaborado por Diego Cerqueira e Joanderson Santos em dupla e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
******************************************************************************************/

package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal do projeto.
 * @author Diego Cerqueira e Joanderson Santos
 *
 */
public class Main extends Application {
    
    /**
     * M�todo da interface Application que inicializa a tela principal do projeto.
     * @param stage
     */
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/MainScreen.fxml"));
        Parent root = loader.load();
        
        
        Scene scene = new Scene(root);
        
        stage.setTitle("MainScreen");
        //stage.setMaximized(true);
        stage.setMinHeight(332);
        stage.setMinWidth(447);
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
