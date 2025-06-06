package app.view;

import java.awt.event.ActionListener;

import app.modules.User;

public interface updatedPage {
	
	void setUser(User user);
	
    void updateUserInfo();
    
    void setAction(ActionListener... args);
}
