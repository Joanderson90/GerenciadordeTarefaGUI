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
 * Controlador do formulario de edição de projetos.
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
	 * Método de salvar alterações de um projeto.
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
	 * Método de fechar a tela.
	 */

	void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * Método initialize da interface Initializable.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		projetoSelecionado = ProjetosScreenController.getProjetoSelecionado();

		loadInfoProjeto();

	}

	/**
	 * Método para carregar informações do projeto.
	 */

	public void loadInfoProjeto() {

		txtTitulo.setText(projetoSelecionado.getTitulo());
		txtDescricao.setText(projetoSelecionado.getDescricao());
	}

	/**
	 * Método de limpar campos do formulário de editar projeto
	 */

	public void cleanInfoProjeto() {

		txtTitulo.setText("");
		txtDescricao.setText("");
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
	 * Retorna título do projeto.
	 * 
	 * @return String título do projeto.
	 */

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * Retorna descrição do projeto.
	 * 
	 * @return String descrição do projeto.
	 */

	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * Retorna botão de voltar.
	 * 
	 * @return Button botão de voltar.
	 */

	public Button getBtnVoltar() {
		return btnVoltar;
	}

	/**
	 * Retorna botão de salvar.
	 * 
	 * @return Button botão de salvar.
	 */
	public Button getBtnSalvar() {
		return btnSalvar;
	}

}
