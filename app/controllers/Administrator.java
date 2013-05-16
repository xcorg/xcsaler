package controllers;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Company;
import models.FeedBack;
import models.IUser;
import models.Notice;
import models.User;
import net.sf.json.JSONObject;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import utils.Constants;
import utils.DateUtil;
import utils.UploadUtil;

@With(Secure.class)
@Check("Administrator")
public class Administrator extends Controller {

    @Before
    public static void loginInfo() {
        renderArgs.put(Constants.USER, Security.currentUser());
    }

    public static void index() {
        render();
    }

    public static void personalpassword() {
        renderTemplate("/Settings/personalpassword.html");
    }

    /**
     * 验证当前密码
     * 
     * @param password
     *            旧密码
     * @return
     */
    public static boolean authPassword(String password) {
        IUser user = (IUser) Security.currentUser();
        return user.passwordMatches(password);
    }

    /**
     * 修改用户密码
     * <p>
     * 请求方式：POST
     * </p>
     * <p>
     * 渲染：render(true)
     * </p>
     * 
     * @param password
     *            旧密码 new_password新密码
     */
    public static void savePersonalPassword(String password, String new_password) {
        Boolean b = models.Administrator.updatePassword(password, new_password);
        render(Constants._INDEX, b);
    }

    /**
     * 商家列表
     */
    public static void companySee() {
        List<Company> accounts = Company.see();
        render(accounts);
    }

    /**
     * 初始化公司账号添加页面
     */
    public static void companyInitAdd() {
        String token = UploadUtil.getToken();
        String title = "新建公司账号信息";
        render(token, title);
    }

    /**
     * 用户反馈信息
     */
    public static void userFeedback() {
        render();
    }

    /**
     * 
     * @param rows
     * @param page
     * @param sidx
     * @param sord
     */
    public static void feedbackDetail(int rows, int page, String sidx, String sord, String pageSelf, String rowSelf, String search) {
        if (!pageSelf.equals("")) {
            page = Integer.parseInt(pageSelf);
        }
        if (!rowSelf.equals("")) {
            rows = Integer.parseInt(rowSelf);
        }
        JSONObject json = FeedBack.getAllFeedBack(page, rows, search);
        renderJSON(json);

    }

    /**
     * 用户反馈信息angularJs
     * 
     * @param page
     * @param search
     * @param tableLength
     *            每页显示的条数
     */
    public static void feedbackDetailTables(Integer page, String search, String tableLength) {
        JSONObject mapRe = FeedBack.getAllFeedBackAn(page, search, tableLength);
        renderJSON(mapRe);
    }

    /**
     * 
     * @param id
     */
    public static void deleFeeBack(String id) {
        models.FeedBack.deleFeedBack(id);
    }

    /**
     * @author 删除反馈信息 angularJs
     * @param id
     * @param page
     * @param search
     * @param tableLength
     *            每页显示的条数
     */
    public static void deleFeeBackAn(String id, Integer page, String search, String tableLength) {
        models.FeedBack.deleFeedBack(id);
        int pageCount = FeedBack.getPageCount(page, search, tableLength);// 本页的数据个数
        // 不是第一页且删除前本页只有一条数据时，删除后返回前一页
        if (page != 1 && pageCount == 0) {
            page = page - 1;
        }
        JSONObject mapRe = FeedBack.getAllFeedBackAn(page, search, tableLength);
        renderJSON(mapRe);
    }

    /**
     * 回复反馈信息
     */
    public static void editFeedBack(Long id, String answer) {
        // System.out.println("id:" +id +"  "+"answer:" +answer);
        models.FeedBack.editFeedBack(id, answer);
    }

    /**
     * 回复反馈信息 angularJs
     * 
     * @param id
     * @param answer
     * @param page
     * @param search
     * @param tableLength
     *            每页显示的条数
     */
    public static void editFeedBackAn(Long id, String answer, Integer page, String search, String tableLength) {
        models.FeedBack.editFeedBack(id, answer);
        JSONObject mapRe = FeedBack.getAllFeedBackAn(page, search, tableLength);
        renderJSON(mapRe);
    }

    /**
     * 添加公司账号
     * 
     * @param companyId
     */
    public static void companyAdd(Company account) {
        Calendar cal = Calendar.getInstance();// 结束日期的时间修正为当天的23:59:59
        cal.setTime(account.endDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        account.endDate = cal.getTime();
        Company.Add(account);
        index();
    }

    /**
     * 初始化修改公司账号页面
     */
    public static void companyInitUpdate(String companyId) {
        String token = UploadUtil.getToken();
        Company account = Company.initUpdate(companyId);
        String title = "修改公司账号信息";
        // String emailBefore=account.email;
        render(account, token, title);
    }

    /**
     * 信誉失效检测页面
     * 
     */
    public static void infoFaileDetect() {

        render();
    }

    /**
     * 修改公司账号
     */
    public static void companyUpdate(Company account) {

        Calendar cal = Calendar.getInstance();// 结束日期的时间修正为当天的23:59:59
        cal.setTime(account.endDate);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        account.endDate = cal.getTime();
        Company.update(account);
        index();
    }

    /**
     * 删除公司账号
     */
    public static void companyDelete(String companyId) {
        Company.delete(companyId);
        index();
    }

    /**
     * 验证公司账号唯一
     * 
     * @param username
     * @param id
     * @return
     */
    public static boolean companyIsExist(String username, String id) {
        // false 表示已经存在
        boolean b = User.isExist(username, id);
        return b;
    }

    /**
     * 验证公司邮箱唯一
     * 
     * @param username
     * @param id
     * @return
     */
    public static boolean emailIsExist(String email, String id) {
        // false 表示已经存在
        boolean b = User.isemailExist(email, id);
        return b;
    }

    /**
     * 普通公告列表
     */
    public static void noticeSee() {
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Notice> notices = Notice.see();
        // for(Notice notice:notices){
        // notice.showTime = formatter.format(notice.noTime);
        // }
        render(notices);
    }

    /**
     * 系统公告
     */
    public static void sysNoticeSee() {
        models.Notice sysNotice = models.Notice.systemNotices();

        String token = UploadUtil.getToken();

        File imgDirectory = new File("public/systemNoticeImg");
        // File imgfile = new File("D:\\Workspaces\\MyEclipse 8.5\\YQPT 2.0\\public\\systemNoticeImg");
        File[] imgFiles = imgDirectory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // *.jpg;*.gif;*.png
                if (name.endsWith(".jpg") || name.endsWith(".gif") || name.endsWith(".png")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        // System.out.println(imgFiles[0].getName());

        List<String> imgs = new ArrayList<String>();
        if (imgFiles != null) {
            for (File img : imgFiles) {
                imgs.add(img.getName());
            }
        }
        String imgpath = "/public/systemNoticeImg/";
        render(sysNotice, token, imgs, imgpath);
    }

    /**
     * 添加普通通知
     * 
     * @param
     */
    public static void noticeAdd(Notice notice) {
        notice.type = "0";

        notice.startTime = DateUtil.String2Date(notice.startTimes);
        // notice.endTime = DateUtil.String2Date(notice.endTimes);
        boolean isSuccess = Notice.add(notice);
        // noticeSee();
        // return str;
        renderText(isSuccess);
    }

    /**
     * 添加系统通知
     * 
     * @param
     */
    public static void sysNoticeAdd(Notice notice) {
        notice.type = "1";

        models.Notice sysNotice = models.Notice.systemNotices();
        if (sysNotice != null) {
            sysNotice.title = notice.title;
            sysNotice.content = notice.content;
            sysNotice.delete_flag = notice.delete_flag;

            // if(notice.startTime == null){
            // sysNotice.startTime = notice.startTime;
            // } else {
            sysNotice.startTime = DateUtil.String2Date(notice.startTimes);
            // }

            // if(notice.endTime == null){
            // sysNotice.endTime = notice.endTime;
            // } else {
            sysNotice.endTime = DateUtil.String2Date(notice.endTimes);
            // }

        } else {
            sysNotice = notice;
        }
        boolean isSuccess = Notice.add(sysNotice);
        renderText(isSuccess);
    }

    /**
     * 修改普通通知
     */
    public static boolean noticeUpdate(Notice notices) {
        notices.type = "0";
        boolean str = Notice.update(notices);
        return str;
    }

    /**
     * 删除通知
     */
    public static Long noticeDel(Notice notice) {
        Long id = Notice.delete(notice);
        return id;
    }

    /**
     * 普通通知是否存在
     * 
     * @param username
     * @param id
     * @return
     */
    public static boolean noticeIsExist(String title, String id) {
        // false 表示已经存在
        boolean b = Notice.isnoticeExist(title, id);
        return b;
    }

    /**
     * 媒体分类管理页面
     * 
     * @author wlj
     * @since 2013-4-11下午05:14:08
     */
    public static void infoclass() {
        // JSONObject mapRe = models.InfoClassManager.getClassJson();
        render();
    }

}