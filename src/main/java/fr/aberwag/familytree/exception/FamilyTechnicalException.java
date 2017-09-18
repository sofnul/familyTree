package fr.aberwag.familytree.exception;

public class FamilyTechnicalException extends FamilyException {

	private static final long serialVersionUID = -2612143646095941282L;

	public FamilyTechnicalException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param arguments
	 */
	public FamilyTechnicalException(String errorCode, Object... arguments) {
		super(errorCode, arguments);
	}

	/**
	 * @param errorCode
	 */
	public FamilyTechnicalException(String errorCode) {
		super(errorCode);
	}

	/**
	 * @param cause
	 * @param errorCode
	 * @param arguments
	 */
	public FamilyTechnicalException(Throwable cause, String errorCode, Object... arguments) {
		super(cause, errorCode, arguments);
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public FamilyTechnicalException(Throwable cause, String errorCode) {
		super(cause, errorCode);
	}

}
