package controllers;

import models.IUser.UserType;
import play.mvc.Controller;

public class IndexDispacher extends Controller {
    public static void index() {
        try {
            if (!Security.isConnected()) {
                Secure.login();
            }
            
            UserType loginType = Security.loginType();
            switch (loginType) {
                case NOT_LOGGED_IN:
                    Secure.logout();
                case Admin:
                    Administrator.index();
                case Company:
                    Company.index();
                case User:
                    Home.index();
            }
        } catch (Throwable e) {

        }
    }
}
