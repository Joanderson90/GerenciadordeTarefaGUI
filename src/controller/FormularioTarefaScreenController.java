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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import message.MessageAlert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import model.Tarefa;


/**
 * Classe controladora do formulário de criação de tarefa.
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
     * Método para salvar uma nova tarefa;
     */
    
    public void salvarNovaTarefa() {
    	
    	boolean isCampoAnyEmpty  = verificarCampoAnyEmpty();
    	
    	if(isCampoAnyEmpty) {
    		
    		this.msgAlert.getMessageCampoEmBranco();
    		
    	} else {
    		
    		Tarefa newTarefa;
    		
    		String titleTarefa = txtTitulo.getText();
    		String descriptionTarefa = txtDescricao.getText();
    		String dateTarefa = txtValidade.getEditor().getText();
    		
    		newTarefa = new Tarefa(titleTarefa, descriptionTarefa, dateTarefa);
    		
    		TarefasScreenController.setTarefaSalva(newTarefa);
    		
    		cleanInfoTarefa();
    		
    		this.msgAlert.getMessageTarefaSalva();
    		
    	}
    }
  
    /**
     * Método para limpar os campos do formulário.
     */
    
    private void cleanInfoTarefa() {
		
    	txtTitulo.setText("");
    	txtDescricao.setText("");
    	txtValidade.getEditor().setText("");
		
	}
    
    /**
     * Método que fecha a tela do formulário e volta para a listagem de tarefas.
     */
    
    void closeScreen() {
    	
    	Stage stage = (Stage) btnVoltar.getScene().getWindow();
    	
    	stage.close();

    }

	/**
	 * Verifica se pelo menos um campo está vazio.
	 * @return boolean true se pelo menos um campo está vazio, ou false se todos os campos estão preenchidos.
	 */
    
	private boolean verificarCampoAnyEmpty() {
    	
    	boolean isCampoAnyEmpty = false;
    	
    	if( txtTitulo.getText() == "" ||
    	    txtDescricao.getText() == "" ||
    	    txtValidade.getEditor().getText() == "") {
    		
    		isCampoAnyEmpty = true;
    	}
    		
		return isCampoAnyEmpty;
	}
	
	/**
	 * Método para adicionar um "ouvinte", este interesado a mudança de estado dos botões deste Formulário.
	 * @param listener "ouvinte" interesado a mudança de estado dos botões.
	 */
	
	public void addButtonsListener(EventHandler<ActionEvent> listener){
	 	   
    	btnAddNovaTarefa.setOnAction(listener);
    	btnVoltar.setOnAction(listener);
    }

	/**
	 * Método da interface Initializable.
	 */
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

	/**
	 * Retorna o título da tarefa.
	 * @return String título da tarefa.
	 */
	
	public String getTxtTitulo() {
		return txtTitulo.getText();
	}


	/**
	 * Método que retorna a descrição da tarefa.
	 * @return String descrição da tarefa.
	 */
	
	public String getTxtDescricao() {
		return txtDescricao.getText();
	}
	

	/**
	 * Obtém o botão de voltar.
	 * @return Button botão de voltar.
	 */
	
	public Button getBtnVoltar() {
		return btnVoltar;
	}

	

	/**
	 * Retorna a validade da tarefa.
	 * @return DatePicker validade da tarefa.
	 */
	
	public DatePicker getTxtValidade() {
		return txtValidade;
	}

	/**
	 * Retorna o botão de salvar a tarefa.
	 * @return Button botão de salvar a tarefa.
	 */
	
	public Button getBtnAddNovaTarefa() {
		return btnAddNovaTarefa;
	}

}
