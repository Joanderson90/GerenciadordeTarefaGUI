/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import screenManager.ScreenManager;

/**
 * Controlador da tela inicial
 * @author Diego Cerqueira e Joanderson Santos
 * @since 2021
 */

public class MainScreenController implements Initializable {
	
	@FXML
    private Menu menuArquivo;

    @FXML
    private MenuItem menuItemProjetos;

    @FXML
    private Menu menuSobre;

    @FXML
    private MenuItem menuItemSistema;
    
    private ScreenManager screenManager = new ScreenManager();

    /**
     * Evento para abrir a tela de projetos
     * @param event
     * @throws IOException
     */
    @FXML
    void acessProjetos(ActionEvent event) throws IOException {
    	
    	screenManager.openNewScreen("ProjetosScreen", "Projetos");
    }

    /**
     * Evento para abrir a tela de informações do sistema
     * @param event
     * @throws IOException
     */
    @FXML
    void acessSobreSistema(ActionEvent event) throws IOException {
    	
    	screenManager.openNewScreen("SobreScreen", "Sobre");

	}
    
    /**
     * Metodo da interface Initializable
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
