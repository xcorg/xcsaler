package utils;

import java.util.Collection;
import java.util.Map;

public class UtilValidate {

    public static final String module = UtilValidate.class.getName();

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    /**
     * Check whether an object is empty, will see if it is a String, Map, Collection, etc.
     */
    public static boolean isEmpty(Object o) {
        return ObjectType.isEmpty(o);
    }

    /**
     * Check whether an object is NOT empty, will see if it is a String, Map, Collection, etc.
     */
    public static boolean isNotEmpty(Object o) {
        return !ObjectType.isEmpty(o);
    }

    /**
     * Check whether string s is empty.
     */
    public static boolean isEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     * Check whether collection c is empty.
     */
    public static <E> boolean isEmpty(Collection<E> c) {
        return ((c == null) || (c.size() == 0));
    }

    /**
     * Check whether map m is empty.
     */
    public static <K, E> boolean isEmpty(Map<K, E> m) {
        return ((m == null) || (m.size() == 0));
    }

    /**
     * Check whether charsequence c is empty.
     */
    public static <E> boolean isEmpty(CharSequence c) {
        return ((c == null) || (c.length() == 0));
    }

    /**
     * Check whether string s is NOT empty.
     */
    public static boolean isNotEmpty(String s) {
        return ((s != null) && (s.length() > 0));
    }

    /**
     * Check whether collection c is NOT empty.
     */
    public static <E> boolean isNotEmpty(Collection<E> c) {
        return ((c != null) && (c.size() > 0));
    }

    /**
     * Check whether charsequence c is NOT empty.
     */
    public static <E> boolean isNotEmpty(CharSequence c) {
        return ((c != null) && (c.length() > 0));
    }

    public static boolean isString(Object obj) {
        return ((obj != null) && (obj instanceof java.lang.String));
    }

    /**
     * 校验由id和,组成的字符串 格式如 1,2,3
     * 
     * @param s
     *            id组成的字符串
     * @param request
     *            获取请求路径时需要
     * @return
     */
    public static boolean validateIdStr(String s) {
        if (s.matches("(\\d+,)*\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证pagesize的值
     * 
     * @param ps
     *            输入的pagesize
     * @param defaultcount
     *            默认值
     * @param max
     *            最大值
     * @param request
     * @return
     */
    public static boolean validatePageSize(int ps, int defaultcount, int max) {
        if (ps < 0 || ps > max) {
            return false;
        } else {
            if (ps == 0) {
                ps = defaultcount;
            }
            return true;
        }
    }

    /**
     * 验证pagenumber
     * 
     * @param p
     * @param defaultpage
     * @param request
     * @return
     */
    public static boolean validatePageNumber(int p, int defaultpage) {
        if (p < 0) {
            return false;
        } else {
            if (p == 0) {
                p = defaultpage;
            }
            return true;
        }
    }

    /**
     * 验证url
     * 
     * @param url
     * @param request
     * @return
     */
    public static boolean validateBoardUrl(String url) {
        String strRegex = "^((https|http|ftp|rtsp|mms)?://)" + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" // ftp的user@
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                + "|" // 允许IP和DOMAIN（域名）
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                + "[a-z]{2,6})" // first level domain- .com or .museum
                + "(:[0-9]{1,4})?" // 端口- :80
                + "((/?)|" // a slash isn't required if there is no file name
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        if (url.matches(strRegex)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 验证网站url
     * 
     * @param url
     * @param request
     * @return
     */
    public static boolean validateSiteUrl(String url) {
        return validateBoardUrl(url);
    }

}
