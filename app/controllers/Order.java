package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.mvc.Controller;
import utils.PageUtil;

public class Order extends Controller {

    /*
     * 用户订单 u
     */
    /**
     * 我的订单列表
     */
    public static void uView(String orderKey, String date, String state, Integer p) {
        List orderList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Map order = new HashMap();
            order.put("id", i);
            order.put("img", "http://img10.360buyimg.com/N5/3323/5d29ad2a-affc-4881-aa30-59ca4a0973fb.jpg");
            order.put("title", orderKey + " : 斯兰扎克枸杞蜂" + date + "蜜" + state + ":优惠装150g*3瓶" + i);
            order.put("amount", Math.round(Math.random() * 100));
            order.put("time", "2013-01-02 10:10:10");
            order.put("state", "已完成" + p);

            orderList.add(order);
        }

        int total = orderList.size();
        int ps = 5;
        render(orderList, total, p, ps);
    }

    /**
     * 我的订单分页
     */
    public static void uCount() {
        Long count = 50l;
        Long pageCount = PageUtil.totalCount2TotalPage(count, 20);
        Map map = new HashMap();
        map.put("countUrl", "/UserHomeViews/orderCount");
        map.put("count", count);
        map.put("pageCount", pageCount);
        renderJSON(map);
    }

    /**
     * 订单详情
     */
    public static void uDetail() {
        render();
    }

    /**
     * 删除个人订单（只能删除已完成的订单）
     */
    public static void uDelete() {

    }

    /*
     * 店铺订单 c
     */
    /**
     * 查看店铺的某订单详情
     */
    public static void cDetail() {
        render();
    }

    /**
     * 店铺取消（删除）某用户订单
     */
    public static void cCancel() {

    }
}
