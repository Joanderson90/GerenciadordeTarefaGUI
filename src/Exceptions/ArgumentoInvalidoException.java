package Exceptions;

public class ArgumentoInvalidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public ArgumentoInvalidoException() {
			
		super("O argumento deve ser diferente de null ou vazio!");
	}
		
	public String getMessage() {
		
		return this.msg;
	}

}
