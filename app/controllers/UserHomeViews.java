package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.mvc.Controller;
import utils.PageUtil;

public class UserHomeViews extends Controller {

    /**
     * 用户首页
     */
    public static void indexView() {
        render();
    }

    /**
     * 欢迎页
     */
    public static void welcomeView() {
        render();
    }

    /**
     * 我的订单
     */
    public static void orderView(Integer p) {
        List orderList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Map order = new HashMap();
            order.put("id", i);
            order.put("img", "http://img10.360buyimg.com/N5/3323/5d29ad2a-affc-4881-aa30-59ca4a0973fb.jpg");
            order.put("title", "斯兰扎克枸杞蜂蜜 : 斯兰扎克枸杞蜂蜜优惠装150g*3瓶" + i);
            order.put("amount", Math.random() * 100);
            order.put("time", new Date());
            order.put("state", "已完成" + i);

            orderList.add(order);
        }

        int total = orderList.size();
        int ps = 20;
        render(orderList, total, p, ps);
    }

    public static void HotEntityCount() {
        Long count = 50l;
        Long pageCount = PageUtil.totalCount2TotalPage(count, 20);
        Map map = new HashMap();
        map.put("countUrl", "/UserHomeViews/HotEntityCount");
        map.put("count", count);
        map.put("pageCount", pageCount);
        renderJSON(map);
    }

    /**
     * 我的购物车
     */
    public static void cartView() {
        render();
    }

    /**
     * 收货地址
     */
    public static void deliveryAddressView() {
        render();
    }

    /**
     * 我的收藏
     */
    public static void favoriteView() {
        render();
    }

    /**
     * 咨询回复
     */
    public static void askReplyView() {
        render();
    }

    /**
     * 我的评论
     */
    public static void commentView() {
        render();
    }

    /**
     * 资金管理
     */
    public static void fundView() {
        render();
    }

    /**
     * 积分管理
     */
    public static void scoreView() {
        render();
    }

    /**
     * 优惠卡券
     */
    public static void discountView() {
        render();
    }

    /**
     * 退货管理
     */
    public static void returnGoodsView() {
        render();
    }

    /**
     * 举报管理
     */
    public static void offenseView() {
        render();
    }

    /**
     * 安全设置
     */
    public static void secureSettingView() {
        render();
    }

    /**
     * 我的好友
     */
    public static void friendsView() {
        render();
    }

    /**
     * 消息提醒
     */
    public static void messageView() {
        render();
    }

    /**
     * 帮助
     */
    public static void helpView() {
        render();
    }

    /**
     * 用户信息
     */
    public static void userInfoView() {
        render();
    }

    /**
     * 用户级别介绍
     */
    public static void usergradeView() {
        render();
    }
}
