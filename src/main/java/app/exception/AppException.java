package app.exception;


public class AppException extends Exception{
	public AppException(ErrorMessage message) {
		super(message.getMessage());
	}

}
