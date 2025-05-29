package app.view;

import app.modules.User;

public abstract class ProfilePages extends Page{
	protected User user;
	
    public void setUser(User user){
        this.user = user;
        updateUserInfo();
    }
    
    protected abstract void updateUserInfo();
    
}
