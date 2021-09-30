package com.miprogramacao.gerenciadordetarefas.model;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import model.Projeto;
import model.Tarefa;

	

public class ProjetoTest {
	
	private Projeto projeto;
	private Tarefa t1, t2, t3;

	
	@Before
	public void setUp() throws Exception {
		
		 projeto = new Projeto("Café dourado", "Aprimoramento do café");
		 t1 = new Tarefa("Plantar", "Plantar no vale", "19/10/2021");
		 t2 = new Tarefa("Germinar", "Germinação NaClO", "19/10/2021");
		 t1 = new Tarefa("Colheita", "Colher", "19/10/2021");
	}
	
	@Test
    public void testBasic(){
		 
        assertEquals("Café dourado", projeto.getTitulo());
        assertEquals("Aprimoramento do café", projeto.getDescricao());
        assertEquals(0, projeto.getTarefas().size());
       
	 }
	
	@Test 
	public void testAddTarefas() {
		
		projeto.setTarefa(t1);
		assertEquals(t1, projeto.getTarefas().get(0));
		
		projeto.setTarefa(t2);
		assertEquals(t2, projeto.getTarefas().get(1));
		
		projeto.setTarefa(t3);
		assertEquals(t3, projeto.getTarefas().get(2));
		
		
	}
	
	@Test 
	public void testRemoveTarefas() {
		
		projeto.setTarefa(t1);
		projeto.setTarefa(t2);
		projeto.setTarefa(t3);
		
		assertEquals(3 , projeto.getTarefas().size());
		
		projeto.getTarefas().remove(t1);
		assertEquals(2 , projeto.getTarefas().size());
		
		assertEquals(t2, projeto.getTarefas().get(0));
		assertEquals(t3, projeto.getTarefas().get(1));
		
		projeto.getTarefas().remove(t2);
		assertEquals(1 , projeto.getTarefas().size());
		
		assertEquals(t3, projeto.getTarefas().get(0));
		
		projeto.getTarefas().remove(t3);
		assertEquals(0 , projeto.getTarefas().size());
		
					
	}
	
	@Test
	 public void testEquals() {
		
		Projeto temp = new Projeto("Café", "Aprimoramento do café");
		
		assertFalse(temp.equals(projeto));
		
		temp.setTitulo("Café dourado");
		assertTrue(temp.equals(projeto));
		
		temp.setDescricao("Aprimoramento");
		assertFalse(temp.equals(projeto));
		
		temp.setDescricao("Aprimoramento do café");
		
		temp.setTarefa(t1);
		temp.setTarefa(t2);
		assertFalse(temp.equals(projeto));
		
		projeto.setTarefa(t1);
		projeto.setTarefa(t2);
		
		assertTrue(temp.equals(projeto));
		
	 }
	
}
