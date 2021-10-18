package com.miprogramacao.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.miprogramacao.gerenciadordetarefas.model.ProjetoTest;
import com.miprogramacao.gerenciadordetarefas.model.TarefaTest;
import com.miprogramacao.gerenciadordetarefas.model.UserTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		ProjetoTest.class,
        TarefaTest.class,
        UserTest.class
})
public class AllTestes {

}
