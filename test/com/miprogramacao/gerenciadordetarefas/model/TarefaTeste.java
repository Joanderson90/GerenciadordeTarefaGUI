package com.miprogramacao.gerenciadordetarefas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;


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

}
