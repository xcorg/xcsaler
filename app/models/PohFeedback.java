package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import net.sf.json.JSONObject;
import play.db.jpa.Model;

/**
 * PohFeedback entity.
 */

@Entity
public class PohFeedback extends Model {

    // Fields
    // @Id
    // public Integer msgId;
    public Integer parentId;
    public Long userId;
    public String username;
    public String userEmail;
    public String msgTitle;
    public Boolean msgType;
    public Boolean msgStatus;
    public String msgContent;
    public Integer msgTime;
    public String messageImg;
    public Integer orderId;
    public Boolean msgArea;

    /**
     * 是否已经给予回复
     */
    public String isAn;

    /**
     * 回复内容
     */
    public String answer;

    /**
     * 反馈用户登录账户
     */
    public String account;
    /**
     * 反馈用户电话
     */
    public String telephone;

    /**
     * 问题类型
     * **/
    public String type;

    public static boolean editFeedBack(Long id, String content) {
        PohFeedback fd = PohFeedback.find("id=?", id).first();
        fd.isAn = "是";
        fd.answer = content;
        boolean re = fd.save().isPersistent();
        return re;
    }

    /**
     * @author 获得所有的用户反馈信息angularJs
     * @param page
     * @param search
     *            查询条件
     * @param tableLength
     *            每页显示的条数
     * @return JSONObject
     */
    public static JSONObject getAllFeedBackAn(Integer page, String search, String tableLength) {
        int tlength = Integer.parseInt(tableLength);
        JSONObject tablejson = new JSONObject();
        List<PohFeedback> listRe = new ArrayList<PohFeedback>();
        List<Map> result = new ArrayList<Map>();
        int count = 0;
        // 未输入搜索条件
        if (search == null || search.equals("")) {
            count = PohFeedback.find("").fetch().size();
            if (tlength == -1) {// 每页显示全部
                tlength = count;
            }
            listRe = PohFeedback.find("").fetch(page, tlength);
        } else {// 输入搜索条件
            count = PohFeedback.find("info like ?", "%" + search + "%").fetch().size();
            if (tlength == -1) {// 每页显示全部
                tlength = count;
            }
            listRe = PohFeedback.find("info like ?", "%" + search + "%").fetch(page, tlength);
        }
        // System.out.println("查询结果："+listRe.size()+":"+count);
        for (PohFeedback f : listRe) {
            Map map = new HashMap();
            map.put("id", f.id);
            map.put("username", f.username);
            map.put("type", f.msgType);
            map.put("account", f.account);
            map.put("telephone", f.telephone);
            map.put("info", f.msgContent);
            map.put("isAn", f.isAn);
            map.put("answer", f.answer);
            result.add(map);
        }

        int pageCount = (int) Math.ceil((double) count / tlength);
        tablejson.put("total", pageCount);
        tablejson.put("result", result);
        tablejson.put("page", page);
        tablejson.put("records", count);
        tablejson.put("start", (page - 1) * tlength + 1);
        tablejson.put("end", (page - 1) * tlength + listRe.size());
        return tablejson;
    }

    /**
     * 删除反馈信息
     * 
     * @param id
     * @return
     */
    public static int deleFeedBack(String id) {
        Long fid = Long.parseLong(id);
        int info = PohFeedback.delete("id=?", fid);
        return info;
    }

    /**
     * @author 获取该页的数据个数
     * @param page
     * @param search
     * @return
     */
    public static int getPageCount(Integer page, String search, String tableLength) {
        int tlength = Integer.parseInt(tableLength);
        int count = 0;
        // 如果是全部，返回1
        if (tlength == -1) {
            count = 1;
        } else {
            // 未输入搜索条件
            if (search == null || search.equals("")) {
                count = PohFeedback.find("").fetch(page, tlength).size();
            } else {// 输入搜索条件
                count = PohFeedback.find("info like ?", "%" + search + "%").fetch(page, tlength).size();
            }
        }
        return count;
    }

    /**
     * 获得所有的用户的反馈信息（加上搜索条件）
     * 
     * @param page
     * @param rows
     * @param search
     *            搜索条件
     * @return
     */
    public static JSONObject getAllFeedBack(int page, int rows, String search) {
        JSONObject tablejson = new JSONObject();
        // User currentuser = (User)Security.currentUser();
        // Long uid = currentuser.id;
        // Long uid = new Long(171);
        // int start ;
        // int end ;
        List result = new ArrayList();
        // List<Object> totalList = new ArrayList();
        List<Object> countList = new ArrayList();
        List<Object> subList = new ArrayList();
        String sql = "";
        // 未输入搜索条件
        if (search == null || search.equals("")) {
            countList = PohFeedback.find("select count(*) from FeedBack fd").fetch();
            sql = "select fd.id,fd.answer, fd.seri, fd.type, fd.username, fd.account, fd.telephone, fd.info, fd.isAn from FeedBack fd";
            // subList =
            // FeedBack.find("select fd.id,fd.answer, fd.seri, fd.type, fd.username, fd.account, fd.telephone, fd.info, fd.isAn from FeedBack fd").fetch(page,
            // rows);
        } else {// 输入搜索条件
            countList = PohFeedback.find("select count(*) from FeedBack fd where fd.info like ?", "%" + search + "%").fetch();
            sql = "select fd.id,fd.answer, fd.seri, fd.type, fd.username, fd.account, fd.telephone, fd.info, fd.isAn from FeedBack fd where fd.info like "
                    + "'%" + search + "%'";
            // totalList =
            // FeedBack.find("select fd.id,fd.answer, fd.seri, fd.type, fd.username, fd.account, fd.telephone, fd.info, fd.isAn from FeedBack fd where fd.info like ?","%"+search+"%").fetch();
        }

        int count = Integer.parseInt(countList.get(0).toString());
        // int count = 25;
        if (rows == -1) {
            rows = count;
        }
        int total = count % rows == 0 ? count / rows : count / rows + 1;
        if (page > total)
            page = total;
        subList = PohFeedback.find(sql).fetch(page, rows);
        String a[] = { "", "", "", "", "", "", "", "", "" };
        // String a[] = {"","", "", "","","","",""};
        if (total == 0) {
            a[0] = "没有数据";
        }
        Map mapfisrt = new HashMap();
        mapfisrt.put("id", "none");
        mapfisrt.put("cell", a);
        result.add(mapfisrt);
        if (count > 0) {// 查询结果为空，显示“没有数据”
            for (int i = 0; i < subList.size(); i++) {
                Object[] ts = (Object[]) subList.get(i);
                Map map = new HashMap();
                map.put("id", ts[0]);
                ts[2] = (page - 1) * rows + i + 1;
                map.put("cell", ts);
                result.add(map);
            }
        }
        if (count == 0) {
            page = -25;
            total = 0;
        }
        tablejson.put("page", page);
        tablejson.put("total", total);
        tablejson.put("rows", result);
        tablejson.put("records", count);

        // System.out.println("查询结果："+totalList.size());
        return tablejson;
    }
}