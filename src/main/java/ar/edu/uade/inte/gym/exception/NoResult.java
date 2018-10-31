package ar.edu.uade.inte.gym.exception;

import javax.validation.ValidationException;

public class NoResult extends Exception{
	private static final long serialVersionUID = 2260054145693830712L;

	public NoResult(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoResult(String message, Throwable cause) {
		super(message, cause);
	}

	public NoResult(String message) {
		super(message);
	}
	
	public NoResult(ValidationException cause) {
		super(cause.getLocalizedMessage(),cause);
	}

	public NoResult(Throwable cause) {
		super("Busqueda sin resultado",cause);
	}

	
}
