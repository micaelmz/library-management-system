package app;

import app.model.BaseUser;

public class GlobalData {
    private static BaseUser loggedUser;

    public static BaseUser getLoggedUser(){
        return loggedUser;
    }

    public static void setLoggedUser(BaseUser loggedNow){
        loggedUser = loggedNow;
    }
}
