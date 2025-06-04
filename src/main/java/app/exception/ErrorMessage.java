package app.exception;

public enum ErrorMessage {
	PASSWORD_TOO_SHORT("Password must be at least 6 characters."),
    USERNAME_NOT_FOUND("Username is invalid."),
    WRONG_PASSWORD("Password is incorrect."),
    NO_ROLE_FOUND("You must Login to see this page."),
    TABLE_HAS_NO_HEADER("[Error]: This table has no header."),
    TABLE_HAS_NO_DATA("[Error]: This table has no data."),
    INVALID_TYPE("Invalid type for goods."),
    EXPIRED_GOODS("[Error]: This goods is expired, and will not proceed to adding.");
	
	
	private String message;
	
	ErrorMessage(String message){
		this.message = message;
	}

    public String getMessage() {
        return message;
    }

}
