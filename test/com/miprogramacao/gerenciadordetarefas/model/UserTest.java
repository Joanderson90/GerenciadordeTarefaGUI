package com.miprogramacao.gerenciadordetarefas.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;


public class UserTest {

	private User user;
	private Projeto p1, p2, p3;
	private Tarefa t1, t2, t3;

	@Before
	public void setUp() throws Exception {
		
		user = new User();
		
		p1 = new Projeto ("Café dourado", "Aprimoramento do café");
		p2 = new Projeto ("Milho branco", "Aprimoramento do milho");
		p3 = new Projeto ("Arroz azul", "Aprimoramento do arroz");
		
		t1 = new Tarefa("Plantar", "Plantar no vale", "19/10/2021");
		t2 = new Tarefa("Germinar", "Germinação NaClO", "19/10/2021");
		t3 = new Tarefa("Colheita", "Colher", "19/10/2021");
		
	}

	@Test
	public void testBasic() {
				
		assertTrue(user.getProjetos().isEmpty());
		
	}
	
	@Test
	public void testAddProjetosValidos() throws ArgumentoInvalidoException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p2.setTarefa(t3);
		
		user.setProjeto(p1);
		
		
		
		assertEquals(1, user.getProjetos().size());
		assertEquals(p1, user.getProjetos().get(0));
		
		user.setProjeto(p2);
		
		assertEquals(2, user.getProjetos().size());
		assertEquals(p2, user.getProjetos().get(1));
				
	}
	
	@Test
	public void testAddProjetoInvalido() {
		
		Projeto projetoInvalido = null;
		
		assertThrows(ArgumentoInvalidoException.class, () -> user.setProjeto(projetoInvalido));
		
	}
	
	@Test 
	public void testBuscarProjetoCadastrado() throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		
		assertEquals(p1, user.buscarProjetoPorTitulo("Café dourado"));
		assertEquals(p2, user.buscarProjetoPorTitulo("Milho branco"));
		assertEquals(p3, user.buscarProjetoPorTitulo("Arroz azul"));
		
	}
	
	
	@Test 
	public void testBuscarProjetoNaoCadastrado(){
		
		assertThrows(ObjetoInexistenteException.class,
				() -> user.buscarProjetoPorTitulo("Inválido nome"));
		
	}
	
	@Test
	public void testExcluirProjetoTarefasNaoConcluidas() throws ArgumentoInvalidoException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p2.setTarefa(t3);
		p3.setTarefa(t3);
		
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		assertFalse(user.excluirProjeto(p1));
		assertFalse(user.excluirProjeto(p2));
		assertFalse(user.excluirProjeto(p3));
		
		assertEquals(3, user.getProjetos().size());
		
	}
	
	@Test
	public void testExcluirProjetoTarefasConcluidas() throws ArgumentoInvalidoException {
		
		t1.setStatus(Status.CONCLUIDA);
		t2.setStatus(Status.CONCLUIDA);
		t3.setStatus(Status.CONCLUIDA);
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p2.setTarefa(t3);
		
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		assertTrue(user.excluirProjeto(p1));
		assertTrue(user.excluirProjeto(p2));
		assertTrue(user.excluirProjeto(p3));
		
		assertEquals(0, user.getProjetos().size());
			
	}
	
	@Test
	public void testExcluirProjetoTarefasEmExecucao() throws ArgumentoInvalidoException {
		
		t1.setStatus(Status.EM_EXECUCAO);
		t2.setStatus(Status.EM_EXECUCAO);
		t3.setStatus(Status.EM_EXECUCAO);
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p2.setTarefa(t3);
		p3.setTarefa(t2);
		
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		assertFalse(user.excluirProjeto(p1));
		assertFalse(user.excluirProjeto(p2));
		assertFalse(user.excluirProjeto(p3));
		
		assertEquals(3, user.getProjetos().size());
		
	}
	
	@Test
	public void testRenomearTituloProjetoCadastrado() throws ArgumentoInvalidoException {
		
		String newTituloP1 = "Arroz especial";
		String newTituloP2 = "Feijão especial";
		String newTituloP3 = "Trigo especial";
			
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		assertTrue(user.renomearTitulo(p1, newTituloP1));
		
		assertEquals(newTituloP1, p1.getTitulo());
		
		assertTrue(user.renomearTitulo(p2, newTituloP2));
		
		assertEquals(newTituloP2, p2.getTitulo());
		
		assertTrue(user.renomearTitulo(p3, newTituloP3));
		
		assertEquals(newTituloP3, p3.getTitulo());
		
		
	}
	
	@Test
	public void testRenomearTituloProjetoNaoCadastrado() throws ArgumentoInvalidoException {
		
		Projeto projetoNaoCadastrado = new  Projeto("Arroz vermelho");
		
		assertFalse(user.renomearTitulo(projetoNaoCadastrado, "Arroz"));
		
		assertEquals("Arroz vermelho", projetoNaoCadastrado.getTitulo());
			
	}
	
	@Test
	public void testRenomearTituloProjetoTituloInvalido() throws ArgumentoInvalidoException {
		
		p1.setTarefa(t1);
		
		user.setProjeto(p1);

		assertThrows(ArgumentoInvalidoException.class,
				() -> user.renomearTitulo(p1, null));
		
		
		assertThrows(ArgumentoInvalidoException.class,
				() -> user.renomearTitulo(p1, ""));
		
		assertEquals("Café dourado", p1.getTitulo());	
	}
	
	
	@Test
	public void testRenomearDescricaoProjeto() throws ArgumentoInvalidoException   {
		
		String newDescricaoP1 = "Test1";
		String newDescricaoP2 = "Test2";
		String newDescricaoP3 = "Test3";
			
		user.setProjeto(p1);
		user.setProjeto(p2);
		user.setProjeto(p3);
		
		assertTrue(user.renomearDescricao(p1, newDescricaoP1));
		
		assertEquals(newDescricaoP1, p1.getDescricao());
		
		assertTrue(user.renomearDescricao(p2, newDescricaoP2));
		
		assertEquals(newDescricaoP2, p2.getDescricao());
		
		assertTrue(user.renomearDescricao(p3, newDescricaoP3));
		
		assertEquals(newDescricaoP3, p3.getDescricao());
		
		
	}
	
	@Test 
	public void testBuscaTarefaCadastrada() throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p1.setTarefa(t3);
		
		user.setProjeto(p1);
		
		assertEquals(t1, user.buscarTarefaPorTitulo("Plantar"));
		assertEquals(t2, user.buscarTarefaPorTitulo("Germinar"));
		assertEquals(t3, user.buscarTarefaPorTitulo("Colheita"));
		
	}
	
	@Test 
	public void testBuscaTarefaNaoCadastrada() throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		
		user.setProjeto(p1);
		
		
		assertThrows(ObjetoInexistenteException.class,
				() -> user.buscarTarefaPorTitulo("Colheita"));
		
		
	}
	
	@Test
	public void excluirTarefaCadastrada() throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		p1.setTarefa(t3);
		
		user.setProjeto(p1);
		
		assertTrue(user.excluirTarefa(t1));
		assertTrue(user.excluirTarefa(t2));
		assertTrue(user.excluirTarefa(t3));
		
		assertEquals(0, p1.getTarefas().size());
		
	}
	
	@Test
	public void excluirTarefaNaoCadastrada() throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		
		user.setProjeto(p1);
			
		assertThrows(ObjetoInexistenteException.class,
				() -> user.excluirTarefa(t3));
		
		assertEquals(2, p1.getTarefas().size());
		
	}
	
	@Test
	public void testRenomearTituloTarefa() throws ArgumentoInvalidoException {
		
		String newTituloT1 = "Test1";
		String newTituloT2 = "Test2";
			
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		
		user.setProjeto(p1);
		
		assertTrue(user.renomearTitulo(t1, newTituloT1));
		
		assertEquals(newTituloT1, t1.getTitulo());
		
		assertTrue(user.renomearTitulo(t2, newTituloT2));
		
		assertEquals(newTituloT2, t2.getTitulo());	
		
	}
	
	@Test
	public void testRenomearDescricaoTarefa() throws ArgumentoInvalidoException {
		
		String newDescricaoT1 = "Test1";
		String newDescricaoT2 = "Test2";
			
		p1.setTarefa(t1);
		p1.setTarefa(t2);
		
		user.setProjeto(p1);
		
		assertTrue(user.renomearDescricao(t1, newDescricaoT1));
		
		assertEquals(newDescricaoT1, t1.getDescricao());
		
		assertTrue(user.renomearDescricao(t2, newDescricaoT2));
		
		assertEquals(newDescricaoT2, t2.getDescricao());	
		
	}
	
	@Test
	public void testMudarValidadeTarefa() throws ArgumentoInvalidoException {
			
		p1.setTarefa(t1);

		user.setProjeto(p1);
		
		assertTrue(user.mudarValidadeTarefa(t1, "19/12/2021"));
		
		assertEquals("19/12/2021", t1.getValidade());
	}
	
	@Test
	public void testMudarStatusTarefa() throws ArgumentoInvalidoException {
		
		Status s1, s2, s3;
		
		s1 = Status.CONCLUIDA;
		s2 = Status.EM_EXECUCAO;
		s3 = Status.PENDENTE;
		
		p1.setTarefa(t1);

		user.setProjeto(p1);
		
		assertTrue(user.mudarStatusTarefa(t1, s1));
		assertEquals(s1, t1.getStatus());
		
		assertTrue(user.mudarStatusTarefa(t1, s2));
		assertEquals(s2, t1.getStatus());
		
		assertTrue(user.mudarStatusTarefa(t1, s3));
		assertEquals(s3, t1.getStatus());
		
	}
	
	
}
