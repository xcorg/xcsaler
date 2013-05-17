package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import net.sf.json.JSONObject;
import play.db.jpa.Model;
import play.mvc.Http.Header;
import play.mvc.Http.Request;
import utils.DataUtil;
import controllers.Security;

/**
 * 登陆日志表
 * 
 */
@Entity
public class LoginLog extends Model {

    /**
     * 登录IP
     */
    public String ip;

    /**
     * 登录时间
     */
    public String description;

    /**
     * 操作时间
     */
    public Date oper_date;
    /**
     * 所用浏览器
     */
    public String browser;

    /**
     * 登录用户
     */
    @Column(nullable = false)
    public String username;

    /**
     * 用户类型
     */
    @Column(nullable = false)
    public String user_type;

    /**
     * 得到登陆日志
     */
    public static Map<String, Object> getLoginLogList(Integer page) {
        Map<String, Object> mapRe = new HashMap<String, Object>();
        IUser user = (IUser) Security.currentUser();
        List<LoginLog> listRe = LoginLog.find("username=? order by oper_date desc", user.getUsername()).fetch(page, 15);
        List<LoginLog> logList = new ArrayList<LoginLog>();
        for (LoginLog log : listRe) {
            logList.add(log);
        }
        int pageCount = (int) Math.ceil((double) LoginLog.find("username=?", user.getUsername()).fetch().size() / 15);
        mapRe.put("isNext", listRe.size() > 0 ? true : false);
        mapRe.put("pageCount", pageCount);
        mapRe.put("result", listRe);
        mapRe.put("page", page);
        System.out.println(page + "--");
        System.out.println(listRe.size() + "==");
        return mapRe;
    }

    /**
     * 
     * @param page
     * @return
     */
    public static JSONObject getLoginLogAn(Integer page) {
        JSONObject tablejson = new JSONObject();
        // Map<String, Object> mapRe = new HashMap<String, Object>();
        IUser user = (IUser) Security.currentUser();
        List<LoginLog> listRe = LoginLog.find("username=? order by oper_date desc", user.getUsername()).fetch(page, 15);
        List<LoginLog> logList = new ArrayList<LoginLog>();
        for (LoginLog log : listRe) {
            logList.add(log);
        }
        int count = LoginLog.find("username=?", user.getUsername()).fetch().size();
        int pageCount = (int) Math.ceil((double) count / 15);
        // mapRe.put("isNext", listRe.size() > 0 ? true : false);
        // mapRe.put("pageCount", pageCount);
        // mapRe.put("result", listRe);
        // mapRe.put("page", page);

        tablejson.put("total", pageCount);
        tablejson.put("result", listRe);
        tablejson.put("page", page);
        tablejson.put("records", count);
        tablejson.put("start", (page - 1) * 15 + 1);
        tablejson.put("end", (page - 1) * 15 + listRe.size());

        // tablejson.put("pageNum", pageNum);
        // System.out.println(page+"--");
        // System.out.println(listRe.size()+"==");
        return tablejson;
    }

    /**
     * 取上次登录记录
     * 
     * @return
     */
    public static LoginLog getLatest() {
        IUser user = (IUser) Security.currentUser();
        LoginLog l = new LoginLog();
        if (user == null) {
            return l;
        }
        List<LoginLog> list = LoginLog.find("username=? and description='登录系统。'  order by oper_date desc", user.getUsername()).fetch(2);

        if (list != null && list.size() == 2) {
            l = list.get(1);
        }
        return l;
    }

    /**
     * 得到登陆日志
     */
    public static int getLoginLogPage() {
        IUser user = (IUser) Security.currentUser();
        int pageCount = (int) Math.ceil((double) LoginLog.find("username=?", user.getUsername()).fetch().size() / 15);
        System.out.println(LoginLog.findAll().size());
        System.out.println(pageCount);
        return pageCount;
    }

    /**
     * 记录
     * 
     * @return 记录成功true，否则false
     */
    public static Boolean add(IUser user, String description) {
        LoginLog loginLog = new LoginLog();
        loginLog.ip = Request.current().remoteAddress;
        loginLog.oper_date = Request.current().date;
        loginLog.description = description;
        Header header = Request.current().headers.get("user-agent");
        loginLog.browser = DataUtil.getBrowser(header.value());
        if (user != null) {
            loginLog.username = user.getUsername();
            loginLog.user_type = user.getType().name();
            return loginLog.save().isPersistent();
        } else {
            return false;
        }

    }
}