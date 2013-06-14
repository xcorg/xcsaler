package controllers;

import models.PohUsers;
import play.mvc.Controller;

public class Register extends Controller {

    public static void initreg() {
        render();
    }
    
    /**
     * 用户注册
     */
    public static void reguser(PohUsers user) {
        System.out.println(user);
        boolean b = user.save().isPersistent();
        if(b){
            try {
                Secure.login();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }else{
            
        }
    }

    public static void regshop() {
    
    }



    
}
