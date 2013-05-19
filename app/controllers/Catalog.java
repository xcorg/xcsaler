package controllers;

import java.util.List;
import java.util.Map;

import models.PohCategory;
import play.mvc.Controller;

public class Catalog extends Controller {

    /**
     * 取得商品一级分类
     */
    public static void topclass() {
        List<PohCategory> topClass = PohCategory.topclass();
        render(topClass);
    }

    /**
     * 取得一级分类的常用分类
     */
    public static void topeasyclass() {

    }

    /**
     * 取得二级分类和三级分类--异步加载页面
     */
    public static void syclass() {
        List<PohCategory> syClass = PohCategory.syclass();
        render(syClass);
    }

    public static void allclass() {
        Map<Object, Object> allClass = PohCategory.allClass();
        render(allClass);
    }
}
