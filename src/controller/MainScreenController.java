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
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import screenManager.ScreenManager;

/**
 * Controlador da tela inicial.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class MainScreenController implements Initializable {

	@FXML
	private Button btnProjetos;

	@FXML
	private Button btnSobre;

	private ScreenManager screenManager = new ScreenManager();

	/**
	 * Evento para abrir a tela de projetos.
	 * 
	 * @param event
	 * @throws IOException caso a tela n�o exista, ou o caminho esteja errado.
	 */

	@FXML
	void acessProjetos(ActionEvent event) throws IOException {

		screenManager.openNewScreen("ProjetosScreen", "Projetos");
	}

	/**
	 * Evento para abrir a tela de informa��es do sistema.
	 * 
	 * @param event
	 * @throws IOException caso a tela n�o exista, ou o caminho esteja errado.
	 */

	@FXML
	void acessSobreSistema(ActionEvent event) throws IOException {

		screenManager.openNewScreen("SobreScreen", "Sobre");

	}

	/**
	 * M�todo da interface Initializable
	 * 
	 * @param url
	 * @param rb
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}
}
