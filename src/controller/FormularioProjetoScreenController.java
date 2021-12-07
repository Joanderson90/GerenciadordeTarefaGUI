/*******************************************************************************
Autor: Diego Cerqueira e Joanderson Santos
Componente Curricular: MI Programação
Concluido em: 18/10/2021
Declaro que este código foi elaborado por Diego Cerqueira e Joanderson Santos em dupla e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
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
 * Controlador da tela de formulário de projetos.
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
	 * Método para criar novo projeto.
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
	 * Método para fechar tela de formulário de projeto.
	 */

	public void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * Método para limpar campos de cadastro do projeto.
	 */

	public void cleanInfoProjeto() {

		txtTitulo.setText("");
		txtDescricao.setText("");

	}

	/**
	 * Obtém o botão de salvar um Projeto.
	 * 
	 * @return botão de salvar um Projeto.
	 */

	public Button getBntSalvar() {

		return btnSalvar;

	}

	/**
	 * Método vazio da interface Initializable.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	/**
	 * Método para adicionar um "ouvinte", este interesado a mudança de estado dos
	 * botões deste Formulário.
	 * 
	 * @param listener "ouvinte" interesado a mudança de estado dos botões.
	 */

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnSalvar.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	/**
	 * Retorna o título do projeto.
	 * 
	 * @return String título do projeto.
	 */

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * Retorna a descrição do projeto.
	 * 
	 * @return String descrição do projeto.
	 */

	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * Retorna o botão de salvar um projeto.
	 * 
	 * @return Button botão de salvar um projeto.
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}

	/**
	 * Retorna o botão de voltar.
	 * 
	 * @return Button botão de voltar.
	 */

	public Button getBtnVoltar() {

		return btnVoltar;
	}

}
