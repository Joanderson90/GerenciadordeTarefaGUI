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

package message;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * A Classe <b>MessageAlert</b> representa a modelagem de <b>mensagens</b> de
 * <b>alerta</b> referente � GUI do <b>Gerenciador de Tarefas</b>.
 * 
 * @since 2021
 * @author Joanderson Santos e Dicego Cerqueira
 */
public class MessageAlert {

	private Alert alert;

	/**
	 * Apresenta uma mensagem na tela.
	 * 
	 * @param message          conte�do da mensagem.
	 * @param alertTypeMessage tipo da mensagem.
	 */

	public void showMessage(String message, AlertType alertTypeMessage) {

		alert = new Alert(alertTypeMessage);
		alert.setContentText(message);

		alert.show();

	}

}
