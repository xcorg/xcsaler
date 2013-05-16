package controllers;

import java.util.Date;

import models.Administrator;
import models.Auth;
import models.Company;
import models.ForgetPass;
import models.IUser;
import models.IUser.UserType;
import models.User;

import org.apache.commons.lang.StringUtils;

import play.mvc.Http.Header;
import play.mvc.Router;
import utils.Cache;

/**
 * @author Administrator
 * 
 */
public class Security extends Secure.Security {

    /**
     * This method is called if a check does not succeed. By default it shows the not allowed page (the controller forbidden method).
     * 
     * @param profile
     */
    static void onCheckFailed(String profile) {
        try {
            IndexDispacher.index();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // try {
        // Secure.login();
        // } catch (Throwable e) {
        // }
    }

    /**
     * Secure 模块的方法，用来验证用户是否登录成功
     * 
     * @param username
     *            用户输入的用户名
     * @param password
     *            用户输入的密码
     * @return true=登录成功，false=登录失败
     */
    static boolean authenticate(String username, String password) {
        if (username != null) {
            username = username.trim();
        }
        // if(password!=null){
        // password=password.trim();
        // }
        IUser user = getUser(username);
        if (user == null) {
            return false;
        }

        if (user.passwordMatches(password)) {
            session.put("loginType", user.getType());
            if (loginType().equals(UserType.Administrator)) {
                flash.put("url", Router.getFullUrl("Administrator.index"));
            }
            if (loginType().equals(UserType.Company)) {
                flash.put("url", Router.getFullUrl("Company.index"));
                Company company = (Company) user;
                accountActivate(company);
                accountOverdue(company.endDate);
            }
            if (loginType().equals(UserType.User)) {
                User u = (User) user;

                if (flash.get("url") == null) {
                    flash.put("url", Router.getFullUrl("Home.index"));
                }

                accountActivate(u.company);
                accountOverdue(u.company.endDate);

                // 通过nginx反向代理取远程访问用户真实的ip地址
                Header header = request.headers.get("x-real-ip");
                String ip = null;
                if (header != null) {
                    ip = header.value();
                } else {
                    ip = request.remoteAddress;
                }
            }

            models.LoginLog.add(user, "登录系统。");
            return true;
        } else {
            return false;
        }

    }

    static void accountOverdue(Date compareDate) {
        Date date = new Date();
        if (!compareDate.after(date)) {
            flash.error("账号已过期");
            try {
                Secure.login();
            } catch (Throwable e) {
            }
        }
    }

    static void accountActivate(Company company) {
        if (!company.activation) {
            flash.error("账号未被激活");
            try {
                Secure.login();
            } catch (Throwable e) {
            }
        }
    }

    static void onDisconnect() {
        if (isConnected()) {
            IUser user = (IUser) Security.currentUser();
            models.LoginLog.add(user, "退出系统。");
        }
    }

    static IUser getUser(String username) {
        IUser user = null;
        user = Administrator.get(username);
        if (user == null) {
            user = Company.get(username);
        }
        if (user == null) {
            user = User.get(username);
        }
        return user;
    }

    static UserType loginType() {
        try {
            return UserType.valueOf(session.get("loginType"));
        } catch (Exception e) {
            return UserType.NOT_LOGGED_IN;
        }

    }

    /**
     * This method checks that a profile is allowed to view this page/method. This method is called prior to the method's controller
     * annotated with the @Check method.
     * 
     * @param profile
     * @return true if you are allowed to execute this controller method.
     */
    static boolean check(String profile) {
        UserType userType = UserType.NOT_LOGGED_IN;
        try {
            // 因为profile可能传Administrator，也可能传Company。也可能传权限，所以在这儿判断一下是否传递的是Administrator或Company。如是，则可转换成功
            userType = UserType.valueOf(profile);
        } catch (Exception e) {
        }
        if (UserType.NOT_LOGGED_IN == userType)
            return false;
        if (loginType() == userType)
            return true; // 所有用户都有与用户类型同名的权限
        if (!isUser())
            return false; // 如果不是User，不判断Role和Auth权限，直接返回false
        String username = Security.connected();
        User user = User.get(username);
        return Auth.check(user, profile);

    }

    public static boolean isUser() {
        return loginType() == UserType.User;
    }

    public static boolean isAdministrator() {
        return loginType() == UserType.Administrator;
    }

    public static boolean isCompany() {
        return loginType() == UserType.Company;
    }

    public static IUser currentUser() {

        return (IUser) Cache.cache("username?username=" + (StringUtils.isEmpty(connected()) ? "" : connected().trim()), "48h",
                new Cache.CacheFactory() {
                    public Object create() {
                        return getUser(StringUtils.isEmpty(connected()) ? "" : connected().trim()); // 2013-4-17 getUser
                    }
                });
    }

    public static void admin_login() {
        render();
    }

    public static void pass(String type, String token, String ukeyid, String responseinfo) {

        String passHtml = "/Secure/pass.html";
        if (type.equals("com")) {
            type = "1";
        } else if (type.equals("us")) {
            type = "0";
        } else if (type.equals("ukey")) {
            type = "2";
            passHtml = "/Secure/passukey.html";
        }
        Long time = System.currentTimeMillis();
        ForgetPass person = ForgetPass.find("type=? and token=?", Integer.valueOf(type), token).first();
        String username = person.username;
        String email = person.email;

        Long times = time - person.time; // 超过半小时未点击？
        if (person.state == 0) {
            if (times > 1800000) {
                person.state = 1;
                person.save();
                renderTemplate("/Secure/passError.html");
            } else {
                person.state = 1;
                person.save();
                renderTemplate(passHtml, username, email, type, responseinfo);
            }
        } else {
            renderTemplate("/Secure/passError.html");
        }
    }

    public static void sigView() {
        renderTemplate("/Secure/sigView.html");
    }
}
