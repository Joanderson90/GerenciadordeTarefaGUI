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
 * Classe controladora da tela de edição de tarefas.
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
	 * Método para salvar as alterações em uma tarefa.
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
	 * Método para fechar a tela de edição de tarefas e voltar a tela com a listagem
	 * das tarefas.
	 */

	public void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();

	}

	/**
	 * Verifica se pelo menos um campo está vazio.
	 * 
	 * @return boolean true se pelo menos um campo está vazio, ou false se todos os
	 *         campos estão preenchidos.
	 */

	private boolean isAnyCampoEmpty() {

		boolean isAnyCampoEmpty = false;

		if (txtTitulo.getText() == "" || txtDescricao.getText() == "" || txtValidade.getEditor().getText() == "") {

			isAnyCampoEmpty = true;
		}

		return isAnyCampoEmpty;
	}

	/**
	 * Retorna qual o status foi selecionado no formulário.
	 * 
	 * @return Status status selecionado no formulário.
	 */

	public Status getStatusSelecionado() {

		Status statusSelecionado;

		RadioButton radio = (RadioButton) group.getSelectedToggle();

		if (radio.getText().equals("Pendente")) {

			statusSelecionado = Status.PENDENTE;

		} else if (radio.getText().equals("Concluída")) {

			statusSelecionado = Status.CONCLUIDA;

		} else {

			statusSelecionado = Status.EM_EXECUCAO;
		}

		return statusSelecionado;

	}

	/**
	 * Método da interface Initializable.
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
	 * Método para adicionar um "ouvinte", este interesado a mudança de estado dos
	 * botões deste Formulário.
	 * 
	 * @param listener "ouvinte" interesado a mudança de estado dos botões.
	 */

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnAddNovaTarefaEdit.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	/**
	 * Retorna o título da tarefa editada.
	 * 
	 * @return TextField título da tarefa editada.
	 */

	public TextField getTxtTitulo() {
		return txtTitulo;
	}

	/**
	 * Método que retorna a nova descrição da tarefa.
	 * 
	 * @return TextArea descrição da tarefa.
	 */

	public TextArea getTxtDescricao() {
		return txtDescricao;
	}

	/**
	 * Retorna o botão de voltar.
	 * 
	 * @return Button botão de voltar.
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
	 * Retorna o botão de editar tarefa.
	 * 
	 * @return Button botão de editar tarefa.
	 */

	public Button getBtnAddNovaTarefaEdit() {
		return btnAddNovaTarefaEdit;
	}

}
