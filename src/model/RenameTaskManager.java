package model;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;
import Interface.Rename;


public class RenameTaskManager implements Rename{

	@Override
	public boolean titleRename(Object obj, String newTitle) throws ArgumentoInvalidoException, ObjetoInexistenteException{
		
		boolean isArgumentoValido = isValidArgument(obj, newTitle);
		boolean isRenomeado = false;
		
		if(isArgumentoValido) {
			
			
			if(obj instanceof Tarefa ) ((Tarefa) obj).setTitulo(newTitle);
			
			else ((Projeto) obj).setTitulo(newTitle);
			
			isRenomeado = true;
			
		}
			
		return isRenomeado;
			
	}
	
	public boolean isValidArgument(Object obj, String renameValue) throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		boolean isObjetoTarefaOuProjeto = obj instanceof Tarefa || obj instanceof Projeto;
		
		if(renameValue == "" || renameValue == null) {
			
			throw new ArgumentoInvalidoException();
		}
		
		else if(!isObjetoTarefaOuProjeto) {
			
			throw new ObjetoInexistenteException();
			
		}
		
		return true;
	}
	

	@Override
	public boolean descriptionRename(Object obj, String newDescription) throws ArgumentoInvalidoException, ObjetoInexistenteException {
		
		boolean isArgumentoValido = isValidArgument(obj, newDescription);
		boolean isRenomeado = false;
		
		if(isArgumentoValido) {
			
			
			if(obj instanceof Tarefa ) ((Tarefa) obj).setDescricao(newDescription);
			
			else ((Projeto) obj).setDescricao(newDescription);
			
			isRenomeado = true;
			
		}
			
		return isRenomeado;
			
	}

}
