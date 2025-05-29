package app.exception;

public enum ErrorMessage {
	PASSWORD_TOO_SHORT("Password must be at least 6 characters."),
    USERNAME_NOT_FOUND("Username is invalid."),
    WRONG_PASSWORD("Password is incorrect"),
    NO_ROLE_FOUND("You must Login to see this page");
	
	
	private final String message;
	
	ErrorMessage(String message){
		this.message = message;
	}

    public String getMessage() {
        return message;
    }

}
