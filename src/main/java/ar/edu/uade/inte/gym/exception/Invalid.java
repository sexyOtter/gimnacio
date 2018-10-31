package ar.edu.uade.inte.gym.exception;

import javax.validation.ValidationException;

public class Invalid extends Exception{
	private static final long serialVersionUID = 2260054145693830712L;

	public Invalid(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Invalid(String message, Throwable cause) {
		super(message, cause);
	}

	public Invalid(String message) {
		super(message);
	}
	
	public Invalid(ValidationException cause) {
		super(cause.getLocalizedMessage(),cause);
	}

	public Invalid(Throwable cause) {
		super("Problemas de validación",cause);
	}

	
}
