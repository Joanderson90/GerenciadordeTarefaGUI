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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import message.MessageAlert;
import model.Tarefa;

/**
 * Classe controladora do formul�rio de cria��o de tarefa.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class FormularioTarefaScreenController implements Initializable {

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescricao;

	@FXML
	private Button btnVoltar;

	@FXML
	private DatePicker txtValidade;

	@FXML
	private Button btnAddNovaTarefa;

	private MessageAlert msgAlert = new MessageAlert();

	/**
	 * M�todo para salvar uma nova tarefa;
	 */

	public void salvarNovaTarefa() {

		boolean isCampoAnyEmpty = verificarCampoAnyEmpty();

		if (isCampoAnyEmpty) {

			this.msgAlert.showMessage("Por favor preencha os campos primeiro!", AlertType.ERROR);

		} else {

			Tarefa newTarefa;

			int idProjetoPertencente = ProjetosScreenController.getProjetoSelecionado().getId();
			String titleTarefa = txtTitulo.getText();
			String descriptionTarefa = txtDescricao.getText();
			String dateTarefa = txtValidade.getEditor().getText();

			newTarefa = new Tarefa(titleTarefa, descriptionTarefa, dateTarefa);
			
			newTarefa.setIdProjetoPertencente(idProjetoPertencente);

			TarefasScreenController.setTarefaSalva(newTarefa);

			cleanInfoTarefa();
			closeScreen();

			this.msgAlert.showMessage("Tarefa salva com Sucesso!", AlertType.INFORMATION);

		}
	}

	/**
	 * M�todo para limpar os campos do formul�rio.
	 */

	private void cleanInfoTarefa() {

		txtTitulo.setText("");
		txtDescricao.setText("");
		txtValidade.getEditor().setText("");

	}

	/**
	 * M�todo que fecha a tela do formul�rio e volta para a listagem de tarefas.
	 */

	void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * Verifica se pelo menos um campo est� vazio.
	 * 
	 * @return boolean true se pelo menos um campo est� vazio, ou false se todos os
	 *         campos est�o preenchidos.
	 */

	private boolean verificarCampoAnyEmpty() {

		boolean isCampoAnyEmpty = false;

		if (txtTitulo.getText() == "" || txtDescricao.getText() == "" || txtValidade.getEditor().getText() == "") {

			isCampoAnyEmpty = true;
		}

		return isCampoAnyEmpty;
	}

	/**
	 * M�todo para adicionar um "ouvinte", este interesado a mudan�a de estado dos
	 * bot�es deste Formul�rio.
	 * 
	 * @param listener "ouvinte" interesado a mudan�a de estado dos bot�es.
	 */

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnAddNovaTarefa.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	/**
	 * M�todo da interface Initializable.
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	/**
	 * Retorna o t�tulo da tarefa.
	 * 
	 * @return String t�tulo da tarefa.
	 */

	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * M�todo que retorna a descri��o da tarefa.
	 * 
	 * @return String descri��o da tarefa.
	 */

	public String getTxtDescricao() {
		return txtDescricao.getText();
	}

	/**
	 * Obt�m o bot�o de voltar.
	 * 
	 * @return Button bot�o de voltar.
	 */

	public Button getBtnVoltar() {
		return btnVoltar;
	}

	/**
	 * Retorna a validade da tarefa.
	 * 
	 * @return DatePicker validade da tarefa.
	 */

	public DatePicker getTxtValidade() {
		return txtValidade;
	}

	/**
	 * Retorna o bot�o de salvar a tarefa.
	 * 
	 * @return Button bot�o de salvar a tarefa.
	 */

	public Button getBtnAddNovaTarefa() {
		return btnAddNovaTarefa;
	}

}
