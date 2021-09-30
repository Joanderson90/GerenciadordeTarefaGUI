package com.miprogramacao.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.miprogramacao.gerenciadordetarefas.model.ProjetoTest;
import com.miprogramacao.gerenciadordetarefas.model.TarefaTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		ProjetoTest.class,
        TarefaTest.class
})
public class AllTestes {

}
