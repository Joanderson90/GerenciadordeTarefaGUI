package Interface;

import Exceptions.ArgumentoInvalidoException;
import Exceptions.ObjetoInexistenteException;

public interface Rename {
	
	public abstract boolean titleRename(Object obj, String newTitle)throws ArgumentoInvalidoException, ObjetoInexistenteException;
	public abstract boolean descriptionRename(Object obj, String newDescription)throws ArgumentoInvalidoException, ObjetoInexistenteException;
	public abstract boolean isValidArgument(Object obj, String renameValue)throws ArgumentoInvalidoException, ObjetoInexistenteException;
			
	
	
}
