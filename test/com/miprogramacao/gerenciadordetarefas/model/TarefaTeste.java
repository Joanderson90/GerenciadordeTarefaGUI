package com.miprogramacao.gerenciadordetarefas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import model.Status;
import model.Tarefa;


public class TarefaTeste {
	
	private Tarefa tarefa;
	
	 @Before
	 public void setUp() throws Exception {
		 tarefa = new Tarefa("PBL", "Sistema Gerenciador de tarefas", "19/10/2021");
	 }
	 
	 @Test
	 public void testBasic() throws ParseException {
		 
        assertEquals("Sistema Gerenciador de tarefas", tarefa.getDescricao());
        assertEquals("PBL", tarefa.getTitulo());
        assertEquals("19/10/2021", tarefa.getValidade());

        tarefa.setDescricao("Task Manager");
        tarefa.setTitulo("Problema 2");
        tarefa.setValidade("29/10/2021");
        
        assertEquals("Task Manager", tarefa.getDescricao());
        assertEquals("Problema 2", tarefa.getTitulo());
        assertEquals("29/10/2021", tarefa.getValidade());
	    }
	 
	 @Test
	 public void testEquals() {
		 
		 Tarefa temp = new Tarefa("PBL3", "Sistema Gerenciador de tarefas", "19/10/2021");
		 assertFalse(temp.equals(tarefa));

        temp.setTitulo("PBL");
        assertTrue(temp.equals(tarefa));

        temp = new Tarefa("PBL4", "Desconhecido");
        assertFalse(temp.equals(tarefa));
	 }
	 
	 @Test 
	 public void testTarefaIniciaComoPendente() {
		 
		 Status esperado = Status.PENDENTE;
		 Status obtido = tarefa.getStatus();
		 
		 assertEquals(esperado, obtido);
		 
	 }
	 
	 @Test 
	 public void testMudancaStatusTarefa() {
		 
		 Status emExecucao = Status.EM_EXECUCAO;
		 Status concluida = Status.CONCLUIDA;
		 Status pendente = Status.PENDENTE;
		 
		 tarefa.setStatus(emExecucao);
		 assertEquals(emExecucao, tarefa.getStatus());
		 
		 tarefa.setStatus(concluida);
		 assertEquals(concluida, tarefa.getStatus());
		 
		 tarefa.setStatus(pendente);
		 assertEquals(pendente, tarefa.getStatus());
	 }
	 
	 @Test
	 public void testSetTarefaAtrasadaDay(){
		 
		 String dataTarefaMenorDataAtual = "25/09/2021"; //Data atual teste: 26/09/2021
		 tarefa.setValidade(dataTarefaMenorDataAtual);
		 
		 
		 boolean esperado = true;
		 
		 boolean obtido = tarefa.getIsAtrasada();
		 
		 assertEquals(esperado, obtido);
		 
		 
	 }
	 
	 @Test
	 public void testSetTarefaAtrasadaMonth(){
		 
		 String dataTarefaMenorDataAtual = "26/08/2021"; //Data atual teste: 26/09/2021
		 tarefa.setValidade(dataTarefaMenorDataAtual);
		 
		 
		 boolean esperado = true;
		 
		 boolean obtido = tarefa.getIsAtrasada();
		 
		 assertEquals(esperado, obtido);
		 
		 
	 }
	 
	 @Test
	 public void testSetTarefaAtrasadaYear(){
		 
		 String dataTarefaMenorDataAtual = "26/09/2020"; //Data atual teste: 26/09/2021
		 tarefa.setValidade(dataTarefaMenorDataAtual);
		 
		 
		 boolean esperado = true;
		 
		 boolean obtido = tarefa.getIsAtrasada();
		 
		 assertEquals(esperado, obtido);
		 
		 
	 }

}
