package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import net.sf.json.JSONObject;
import play.db.jpa.Model;
import play.mvc.Http.Request;
import utils.DateUtil;
import controllers.Security;

@Entity
public class PohNotice extends Model {

    /**
     * 通知标题
     */
    @Column(nullable = false)
    public String title;

    /**
     * 通知内容
     */
    @Column(nullable = false)
    public String content;

    /**
     * 通知所属类别Id,0:普通公告。1：维护公告
     */
    public String type;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Date noTime = Request.current() == null ? new Date() : Request.current().date;

    /**
     * 是否删除
     */
    public Integer delete_flag = 0;

    /**
     * 维护公告开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Date startTime;

    @Transient
    public String startTimes;

    /**
     * 维护公告结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Date endTime;

    @Transient
    public String endTimes;

    /**
     * 普通公告列表
     * 
     * @return
     */
    public static List see() {
        List<PohNotice> notice_list = PohNotice.find("delete_flag=0 and type=0 order by noTime desc").fetch();
        return notice_list;
    }

    /**
     * 两天内的通知列表
     * 
     * @return
     */
    public static Map<String, Object> noticeSee() {
        List<Object> listRe = new ArrayList<Object>();
        Map<String, Object> mapRe = new HashMap<String, Object>();

        Date st = DateUtil.getDateBefore(new Date(), 2);
        List<PohNotice> notice_list = PohNotice.find("delete_flag=0 and type=0 and noTime>=?", st).fetch(1, 3);
        if (notice_list == null) {
            mapRe.put("result", null);
        } else {
            for (PohNotice topic : notice_list) {
                Map<String, Object> map_other = new HashMap<String, Object>();
                map_other.put("noTime", topic.noTime);
                map_other.put("title", topic.title);
                map_other.put("content", topic.content);
                listRe.add(map_other);
            }
            mapRe.put("result", listRe);
        }
        return mapRe;
    }

    /**
     * 两天内的通知列表
     * 
     * @return
     */
    public static boolean noti() {
        boolean b = false;
        List<Object> listRe = new ArrayList<Object>();
        Map<String, Object> mapRe = new HashMap<String, Object>();

        Date st = DateUtil.getDateBefore(new Date(), 2);
        List<PohNotice> notice_list = PohNotice.find("delete_flag=0 and type=0 and noTime>=? order by noTime desc", st).fetch(1, 5);

        return b;
    }

    /**
     * 添加公告
     */
    public static boolean add(PohNotice notice) {
        notice.save();
        // JSONObject obj = new JSONObject();
        // obj.put("id", notice.id);
        // obj.put("title", notice.title);
        // obj.put("type", notice.type);
        // obj.put("content", notice.content);

        // return obj.toString();
        return notice.save().isPersistent();
    }

    /**
     * 修改公告
     * 
     * @param dept
     * @return
     */
    public static boolean update(PohNotice notices) {
        PohNotice noti = PohNotice.find("id=?", notices.id).first();
        noti.title = notices.title;
        noti.content = notices.content;
        noti.type = notices.type;
        noti.startTime = DateUtil.String2Date(notices.startTimes);
        // noti.endTime = DateUtil.String2Date(notices.endTimes);
        noti.save();
        return notices.save().isPersistent();
    }

    /**
     * 删除普通公告
     * 
     * @param companyId
     */
    public static Long delete(PohNotice notice) {
        Long id = notice.id;
        notice.delete_flag = 1;
        notice.save();
        return id;
    }

    /**
     * 验证公告标题是否存在
     * 
     * @param title
     *            公告标题
     * @param id
     *            修改时，该公告的id
     * @return
     */
    public static boolean isnoticeExist(String title, String id) {
        PohNotice notice = PohNotice.find("title=? and delete_flag=0 and type=0", title).first();
        boolean b = true;
        if (id == null || "".equals(id)) {
            b = (notice == null);
        } else {
            if (notice != null)
                b = (notice.id == Integer.parseInt(id));
            else
                b = true;
        }
        return b;
    }

    public static List getNotice() {
        List notice_list = PohNotice.find("delete_flag=0 and type=0 order by id desc").fetch(1, 5);
        return notice_list;
    }

    /**
     * 读取未读公告
     * 
     * @return
     */
    public static List<PohNotice> getUnreadNotice(Integer p, Integer ps) {
        PohUsers user = (PohUsers) Security.currentUser();
        List<PohNotice> notice_list = new ArrayList<PohNotice>();
        if (user == null) {
            return notice_list;
        }

        // 取得当前用户公告读取时间
        String type = "notice_" + user.id;
        PohUnread unread = PohUnread.find("type=?", type).first();
        if (unread == null || unread.date == null) {
            notice_list = PohNotice.find("delete_flag=0 and type=0 and startTime<=? order by noTime desc", new Date()).fetch(p, ps);

            unread = new PohUnread();
            unread.type = type;
        } else {
            notice_list = PohNotice
                    .find("delete_flag=0 and type=0 and ((noTime>=? and startTime is null) or ( startTime>=? and startTime<=?)) order by noTime desc",
                            unread.date, unread.date, new Date()).fetch(p, ps);
        }

        // 更新读取公告时间
        unread.date = new Date();
        unread.save();

        return notice_list;
        // List<Object> listRe = new ArrayList<Object>();
        // Map<String, Object> mapRe = new HashMap<String, Object>();
        //
        // // Date st = DateUtil.getDateBefore(new Date(), 2);
        // // List<Notice> notice_list = Notice.find("delete_flag=0 and type=0 and noTime>=?", unread.date).fetch(1, 3);
        // if (notice_list == null || notice_list.size() == 0) {
        // mapRe.put("result", null);
        // } else {
        // for (Notice topic : notice_list) {
        // Map<String, Object> map_other = new HashMap<String, Object>();
        // map_other.put("noTime", topic.noTime);
        // map_other.put("title", topic.title);
        // map_other.put("content", topic.content);
        // listRe.add(map_other);
        // }
        // mapRe.put("result", listRe);
        // }
        // return mapRe;
    }

    public static long getUnreadNoticeNum() {
        PohUsers user = (PohUsers) Security.currentUser();
        long unreadNum = 0;

        // 取得当前用户公告读取时间
        PohUnread unread = PohUnread.find("type=?", "notice_" + user.id).first();
        if (unread == null || unread.date == null) {
            unreadNum = PohNotice.count("delete_flag=0 and type=0 and startTime<=?", new Date());
        } else {
            unreadNum = PohNotice.count(
                    "delete_flag=0 and type=0 and ((noTime>=? and startTime is null) or ( startTime>=? and startTime<=?))", unread.date,
                    unread.date, new Date());
        }

        return unreadNum;
    }

    /**
     * 取得最新的系统公告（开启的）,用于展示维护公告，普通用户不能登录
     * 
     * @return
     */
    public static PohNotice systemNotice() {
        Date now = new Date();
        PohNotice notice = PohNotice.find(
                "delete_flag=0 and type=1 and (startTime is null or startTime <= ?) and (endTime is null or endTime >= ?)", now, now)
                .first(); // order by noTime desc
        return notice;
    }

    /**
     * 取得最新的系统公告(开启和关闭的),用于更新系统公告
     * 
     * @return
     */
    public static PohNotice systemNotices() {
        PohNotice notice = PohNotice.find("type=1").first(); // order by noTime desc
        return notice;
    }

    /**
     * 取得系统公告的数目
     * 
     * @return
     */
    public static long systemNoticeCnt() {
        Date now = new Date();
        long noticeCnt = PohNotice.count(
                "delete_flag=0 and type=1 and (startTime is null or startTime <= ?) and (endTime is null or endTime >= ?)", now, now);
        return noticeCnt;
    }

    /**
     * 
     * @param page
     * @return
     */
    public static JSONObject getNotice(Integer page) {
        JSONObject tablejson = new JSONObject();
        Date now = new Date();
        List<PohNotice> noticeList = PohNotice.find(
                "delete_flag=0 and type=0 and ( startTime is null or startTime<=?) order by noTime desc", now).fetch(page, 15);
        long count = PohNotice.count("delete_flag=0 and type=0 and ( startTime is null or startTime<=?)", now);
        int pageCount = (int) Math.ceil((double) count / 15);

        tablejson.put("total", pageCount);
        tablejson.put("result", noticeList);
        tablejson.put("page", page);
        tablejson.put("records", count);
        tablejson.put("start", (page - 1) * 15 + 1);
        tablejson.put("end", (page - 1) * 15 + noticeList.size());

        return tablejson;
    }

    /**
     * 普通公告的页码数
     * 
     * @return
     */
    public static int getNoticePage() {
        Date now = new Date();
        int pageCount = (int) Math
                .ceil((double) PohNotice.count("delete_flag=0 and type=0 and ( startTime is null or startTime<=?)", now) / 15);
        return pageCount;
    }
}
