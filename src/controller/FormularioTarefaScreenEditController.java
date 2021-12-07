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

import dao.TarefaDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import message.MessageAlert;
import model.Status;
import model.Tarefa;

/**
 * Classe controladora da tela de edi��o de tarefas.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class FormularioTarefaScreenEditController implements Initializable {

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescricao;

	@FXML
	private Button btnVoltar;

	@FXML
	private DatePicker txtValidade;

	@FXML
	private Button btnAddNovaTarefaEdit;

	@FXML
	private ToggleGroup group;

	private MessageAlert msgAlert = new MessageAlert();

	private Tarefa tarefaSelecionada;

	/**
	 * M�todo para salvar as altera��es em uma tarefa.
	 * 
	 */

	public void salvarEditTarefa() {

		if (isAnyCampoEmpty()) {

			this.msgAlert.showMessage("Por favor preencha os campos primeiro!", AlertType.WARNING);

		} else {

			String titleTarefa = txtTitulo.getText();
			String descriptionTarefa = txtDescricao.getText();
			String dateTarefa = txtValidade.getEditor().getText();
			Status statusSelecionado = getStatusSelecionado();

			tarefaSelecionada.setTitulo(titleTarefa);
			tarefaSelecionada.setDescricao(descriptionTarefa);
			tarefaSelecionada.setValidade(dateTarefa);
			tarefaSelecionada.setStatus(statusSelecionado);

			TarefaDAO.update(tarefaSelecionada);

			closeScreen();

			this.msgAlert.showMessage("Tarefa editada com Sucesso!", AlertType.INFORMATION);

		}
	}

	/**
	 * M�todo para fechar a tela de edi��o de tarefas e voltar a tela com a listagem
	 * das tarefas.
	 */

	public void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * Verifica se pelo menos um campo est� vazio.
	 * 
	 * @return boolean true se pelo menos um campo est� vazio, ou false se todos os
	 *         campos est�o preenchidos.
	 */

	private boolean isAnyCampoEmpty() {

		boolean isAnyCampoEmpty = false;

		if (txtTitulo.getText() == "" || txtDescricao.getText() == "" || txtValidade.getEditor().getText() == "") {

			isAnyCampoEmpty = true;
		}

		return isAnyCampoEmpty;
	}

	/**
	 * Retorna qual o status foi selecionado no formul�rio.
	 * 
	 * @return Status status selecionado no formul�rio.
	 */

	public Status getStatusSelecionado() {

		Status statusSelecionado;

		RadioButton radio = (RadioButton) group.getSelectedToggle();

		if (radio.getText().equals("Pendente")) {

			statusSelecionado = Status.PENDENTE;

		} else if (radio.getText().equals("Conclu�da")) {

			statusSelecionado = Status.CONCLUIDA;

		} else {

			statusSelecionado = Status.EM_EXECUCAO;
		}

		return statusSelecionado;

	}

	/**
	 * M�todo da interface Initializable.
	 * 
	 * @param url
	 * @param rb
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		tarefaSelecionada = TarefasScreenController.getTarefaSelecionada();

		txtTitulo.setText(tarefaSelecionada.getTitulo());
		txtDescricao.setText(tarefaSelecionada.getDescricao());
		txtValidade.getEditor().setText(tarefaSelecionada.getValidade());

	}

	/**
	 * M�todo para adicionar um "ouvinte", este interesado a mudan�a de estado dos
	 * bot�es deste Formul�rio.
	 * 
	 * @param listener "ouvinte" interesado a mudan�a de estado dos bot�es.
	 */

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnAddNovaTarefaEdit.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	/**
	 * Retorna o t�tulo da tarefa editada.
	 * 
	 * @return TextField t�tulo da tarefa editada.
	 */

	public TextField getTxtTitulo() {
		return txtTitulo;
	}

	/**
	 * M�todo que retorna a nova descri��o da tarefa.
	 * 
	 * @return TextArea descri��o da tarefa.
	 */

	public TextArea getTxtDescricao() {
		return txtDescricao;
	}

	/**
	 * Retorna o bot�o de voltar.
	 * 
	 * @return Button bot�o de voltar.
	 */
	public Button getBtnVoltar() {
		return btnVoltar;
	}

	/**
	 * Retorna uma data selecionada.
	 * 
	 * @return DatePicker data selecionada.
	 */

	public DatePicker getTxtValidade() {
		return txtValidade;
	}

	/**
	 * Retorna um ToggleGroup.
	 * 
	 * @return ToggleGroup
	 */

	public ToggleGroup getGroup() {
		return group;
	}

	/**
	 * Retorna a tarefa selecionada.
	 * 
	 * @return Tarefa tarefa selecionada.
	 */

	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}

	/**
	 * Retorna o bot�o de editar tarefa.
	 * 
	 * @return Button bot�o de editar tarefa.
	 */

	public Button getBtnAddNovaTarefaEdit() {
		return btnAddNovaTarefaEdit;
	}

}
