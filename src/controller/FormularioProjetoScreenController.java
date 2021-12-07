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

import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ArgumentoInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import message.MessageAlert;
import model.Projeto;

/**
 * Controlador da tela de formul�rio de projetos.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class FormularioProjetoScreenController implements Initializable {

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescricao;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnVoltar;

	private MessageAlert msgAlert = new MessageAlert();

	/**
	 * M�todo para criar novo projeto.
	 * 
	 * @throws ArgumentoInvalidoException caso o projeto seja null.
	 */

	public void addNewProjeto() throws ArgumentoInvalidoException {

		String titulo = txtTitulo.getText();
		String descricao = txtDescricao.getText();

		if (titulo == "" || descricao == "") {

			this.msgAlert.showMessage("Por favor preencha os campos primeiro!", AlertType.WARNING);

		} else {

			Projeto newProjeto = new Projeto();

			newProjeto.setTitulo(titulo);
			newProjeto.setDescricao(descricao);

			ProjetosScreenController.setNewProjeto(newProjeto);

			cleanInfoProjeto();
			closeScreen();

			this.msgAlert.showMessage("Projeto Salvo com Sucesso!", AlertType.INFORMATION);

		}
	}

	/**
	 * M�todo para fechar tela de formul�rio de projeto.
	 */

	public void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * M�todo para limpar campos de cadastro do projeto.
	 */

	public void cleanInfoProjeto() {

		txtTitulo.setText("");
		txtDescricao.setText("");

	}

	/**
	 * Obt�m o bot�o de salvar um Projeto.
	 * 
	 * @return bot�o de salvar um Projeto.
	 */

	public Button getBntSalvar() {

		return btnSalvar;

	}

	/**
	 * M�todo vazio da interface Initializable.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	/**
	 * M�todo para adicionar um "ouvinte", este interesado a mudan�a de estado dos
	 * bot�es deste Formul�rio.
	 * 
	 * @param listener "ouvinte" interesado a mudan�a de estado dos bot�es.
	 */

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnSalvar.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	/**
	 * Retorna o t�tulo do projeto.
	 * 
	 * @return String t�tulo do projeto.
	 */

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * Retorna a descri��o do projeto.
	 * 
	 * @return String descri��o do projeto.
	 */

	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * Retorna o bot�o de salvar um projeto.
	 * 
	 * @return Button bot�o de salvar um projeto.
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}

	/**
	 * Retorna o bot�o de voltar.
	 * 
	 * @return Button bot�o de voltar.
	 */

	public Button getBtnVoltar() {

		return btnVoltar;
	}

}
