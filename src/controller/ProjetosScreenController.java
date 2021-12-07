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
import java.util.List;
import java.util.ResourceBundle;

import exceptions.ArgumentoInvalidoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import message.MessageAlert;
import model.Projeto;
import model.User;
import screenManager.ScreenManager;

/**
 * Classe controladora da p�gina de projetos.
 * 
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class ProjetosScreenController implements Initializable, EventHandler<ActionEvent> {

	@FXML
	private ListView<Projeto> lvProjetos;

	@FXML
	private Button novoProjetoBTN;

	@FXML
	private Button openTarefasBTN;

	@FXML
	private Button atualizarProjetosBTN;

	@FXML
	private Button excluirProjetoBTN;

	@FXML
	private Button editarProjetoBTN;

	@FXML
	private MenuButton menuBTN;

	@FXML
	private MenuItem menuItemNome;

	@FXML
	private MenuItem menuItemDescricao;

	private ObservableList<Projeto> obsProjetos;

	private ScreenManager screenManager = new ScreenManager();

	private static User user = new User();
	private static Projeto projetoSelecionado;

	private MessageAlert msgAlert = new MessageAlert();

	private FormularioProjetoScreenController formularioProjetoController;
	private FormularioProjetoScreenEditController formularioProjetoControllerEdit;

	/**
	 * M�todo que carrega os projetos na tela.
	 */

	public void loadProjetos() {

		List<Projeto> projetosCadastrados = user.getProjetos();

		obsProjetos = FXCollections.observableArrayList(projetosCadastrados);

		lvProjetos.setItems(obsProjetos);
	}

	/**
	 * M�todo que abre o formul�rio de cadastro de projetos.
	 * 
	 * @param event
	 * @throws IOException caso a tela n�o exista, ou o caminho esteja errado.
	 */

	@FXML
	void openFormularioProjetoScreen(ActionEvent event) throws IOException {

		screenManager.openNewScreen("FormularioProjetoScreen", "Cadastro Projetos");

		setReferenciaFormularioProjetoController();

	}

	/**
	 * Atribui uma refer�ncia ao controlador, esta referente ao Formul�rio do
	 * Projeto.
	 */

	private void setReferenciaFormularioProjetoController() {

		Object currentController = screenManager.getCurrenController();

		formularioProjetoController = (FormularioProjetoScreenController) currentController;

		formularioProjetoController.addButtonsListener(this);
	}

	/**
	 * M�todo que abre o formul�rio de edi��o de projetos.
	 * 
	 * @param event
	 * @throws IOException caso a tela n�o exista, ou o caminho esteja errado.
	 */

	@FXML
	void openFormularioProjetoScreenEdit(ActionEvent event) throws IOException {

		projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();

		if (projetoSelecionado == null) {

			this.msgAlert.showMessage("Por favor selecione um projeto primeiro!", AlertType.ERROR);

		} else {

			screenManager.openNewScreen("FormularioProjetoScreenEdit", "Edi��o Projetos");

			setReferenciaFormularioProjetoControllerEdit();

		}
	}

	/**
	 * Atribui uma refer�ncia ao controlador, esta referente ao Formul�rio de edi��o
	 * dos Projetos.
	 */

	private void setReferenciaFormularioProjetoControllerEdit() {

		Object currentController = screenManager.getCurrenController();

		formularioProjetoControllerEdit = (FormularioProjetoScreenEditController) currentController;

		formularioProjetoControllerEdit.addButtonsListener(this);

	}

	/**
	 * Evento para excluir um projeto.
	 * 
	 * @param event
	 */

	@FXML
	void excluirProjeto(ActionEvent event) {

		Projeto projetoAlvo = lvProjetos.getSelectionModel().getSelectedItem();

		if (projetoAlvo == null) {

			this.msgAlert.showMessage("Por favor selecione um projeto primeiro!", AlertType.ERROR);

		} else {

			boolean isProjetoExcluido = user.excluirProjeto(projetoAlvo);

			if (isProjetoExcluido) {

				loadProjetos();

				this.msgAlert.showMessage("Projeto exclu�do com Sucesso!", AlertType.INFORMATION);

			} else {

				this.msgAlert.showMessage("O projeto det�m tarefas n�o conclu�das!", AlertType.ERROR);

			}
		}
	}

	/**
	 * Evento para abrir as tarefas, estas relacionadas a um projeto selecionado.
	 * 
	 * @param event
	 * @throws IOException
	 */

	@FXML
	void openTarefas(ActionEvent event) throws IOException {

		projetoSelecionado = lvProjetos.getSelectionModel().getSelectedItem();

		boolean isProjetoSelecionado = projetoSelecionado != null;

		if (isProjetoSelecionado) {

			screenManager.openNewScreen("TarefasScreen", "Tarefas");

		} else {

			this.msgAlert.showMessage("Por favor selecione um projeto primeiro!", AlertType.ERROR);
		}
	}

	/**
	 * M�todo que retorna qual projeto foi selecionado.
	 * 
	 * @return Projeto projeto selecionado.
	 */

	public static Projeto getProjetoSelecionado() {

		return projetoSelecionado;
	}

	/**
	 * M�todo que insere um novo projeto.
	 * 
	 * @param projeto projeto a ser inserido.
	 * @throws ArgumentoInvalidoException caso o projeto seja null.
	 */

	public static void setNewProjeto(Projeto projeto) throws ArgumentoInvalidoException {

		user.setProjeto(projeto);

	}

	/**
	 * M�todo da interface Initializable.
	 * 
	 * @param url
	 * @param rb
	 */

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		formularioProjetoController = new FormularioProjetoScreenController();
		formularioProjetoControllerEdit = new FormularioProjetoScreenEditController();

		loadProjetos();
	}

	/**
	 * Retorna o usu�rio da aplica��o.
	 * 
	 * @return User usu�rio da aplica��o.
	 */

	public static User getUser() {

		return user;
	}

	/**
	 * M�todo que verifica qual bot�o foi clicado e, executa uma a��o referente ao
	 * Formul�rio que o bot�o pertence.O bot�o pode ser do Formul�rio de edi��o de
	 * Projetos, ou do Formul�rio de cadastro de Projetos.
	 * 
	 * @param arg0
	 */

	@Override
	public void handle(ActionEvent arg0) {

		if (arg0.getSource() == formularioProjetoController.getBntSalvar()) {

			try {

				formularioProjetoController.addNewProjeto();

				loadProjetos();

			} catch (ArgumentoInvalidoException e) {

				e.printStackTrace();
			}

		} else if (arg0.getSource() == formularioProjetoController.getBtnVoltar()) {

			formularioProjetoController.closeScreen();

		}

		else if (arg0.getSource() == formularioProjetoControllerEdit.getBtnSalvar()) {

			formularioProjetoControllerEdit.addProjetoEditado();

			loadProjetos();

		} else if (arg0.getSource() == formularioProjetoControllerEdit.getBtnVoltar()) {

			formularioProjetoControllerEdit.closeScreen();

		}
	}
}
