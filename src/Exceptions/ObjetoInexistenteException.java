package Exceptions;

public class ObjetoInexistenteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ObjetoInexistenteException() {
		
		super("Objeto não encontrado no sistema");
	}
	
	public String getMessage() {
		
		return this.msg;
	}
	 
}
