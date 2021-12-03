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
 * Controlador do formulario de edi��o de projetos.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class FormularioProjetoScreenEditController implements Initializable {

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescricao;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnSalvar;

	private MessageAlert msgAlert = new MessageAlert();

	private Projeto projetoSelecionado;

	/**
	 * M�todo de salvar altera��es de um projeto.
	 */

	public void addProjetoEditado() {

		String titulo = txtTitulo.getText();
		String descricao = txtDescricao.getText();

		if (titulo == "" || descricao == "") {

			this.msgAlert.showMessage("Por favor preencha os campos primeiro!", AlertType.ERROR);

		}

		else {

			projetoSelecionado.setTitulo(titulo);
			projetoSelecionado.setDescricao(descricao);

			cleanInfoProjeto();

			this.msgAlert.showMessage("Projeto Editado com Sucesso!", AlertType.INFORMATION);

		}
	}

	/**
	 * M�todo de fechar a tela.
	 */

	void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * M�todo initialize da interface Initializable.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();

		loadInfoProjeto();

	}

	/**
	 * M�todo para carregar informa��es do projeto.
	 */

	public void loadInfoProjeto() {

		txtTitulo.setText(projetoSelecionado.getTitulo());
		txtDescricao.setText(projetoSelecionado.getDescricao());
	}

	/**
	 * M�todo de limpar campos do formul�rio de editar projeto
	 */

	public void cleanInfoProjeto() {

		txtTitulo.setText("");
		txtDescricao.setText("");
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
	 * Retorna t�tulo do projeto.
	 * 
	 * @return String t�tulo do projeto.
	 */

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * Retorna descri��o do projeto.
	 * 
	 * @return String descri��o do projeto.
	 */

	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * Retorna bot�o de voltar.
	 * 
	 * @return Button bot�o de voltar.
	 */

	public Button getBtnVoltar() {
		return btnVoltar;
	}

	/**
	 * Retorna bot�o de salvar.
	 * 
	 * @return Button bot�o de salvar.
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}

}
