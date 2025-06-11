package app.exception;

public enum ErrorMessage {
	PASSWORD_TOO_SHORT("Password must be at least 6 characters."),
    USERNAME_NOT_FOUND("Username is invalid."),
    WRONG_PASSWORD("Password is incorrect."),
    NO_ROLE_FOUND("You must Login to see this page."),
    TABLE_HAS_NO_HEADER("This table has no header."),
    TABLE_HAS_NO_DATA("This table has no data."),
    INVALID_TYPE("Invalid type for goods."),
    EXPIRED_GOODS("This goods is expired, and will not proceed to adding."),
    UNSELECTED_CELL("Please pick one cell."),
    WRONG_FORMAT("Please edit the cell with this format "),
    UNPERMITTED_EDIT("Can't edit this cell.");
	
	
	private String message;
	
	ErrorMessage(String message){
		this.message = message;
	}

    public String getMessage() {
        return message;
    }

}
