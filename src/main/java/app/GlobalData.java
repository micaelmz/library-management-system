package app;

import app.model.BaseUser;

public class GlobalData {
    private static BaseUser loggedUser;

    public static BaseUser getLoggedUser(){
        return loggedUser;
    }

    public static boolean checkCredentials(String password){
        return loggedUser.checkCredentials(loggedUser.getUsername(), password);
    }

    public static void setLoggedUser(BaseUser loggedNow){
        loggedUser = loggedNow;
    }
}
