package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * 系统公共方法
 * 
 * @version 1.0
 * @author open sourc added by yuezengguang
 */
public class DataUtil {

    /**
     * 判断输入值是否为空，如果为空则返回“”，否则返回输入值
     * 
     * @param strInput
     * @return
     */
    public static String getNoNull(String strInput) {
        return strInput == null ? "" : strInput;
    }

    /**
     * 判断输入值是否为空，如果为空则返回“”，否则返回输入值
     * 
     * @param obInput
     * @return
     */
    public static String getNoNull(Object obInput) {
        return obInput == null ? "" : String.valueOf(obInput);
    }

    /**
     * 判断输入值是否为空，如果为空则返回“”，否则返回输入值
     * 
     * @param dtInput
     * @return
     */
    public static String getNoNull(Double dtInput) {
        return dtInput == null ? "" : String.valueOf(dtInput);
    }

    /**
     * 判断输入值是否为空，如果为空则返回“”，否则返回输入值
     * 
     * @param obInput
     * @return
     */
    public static String getReturnZero(Object obInput) {
        return obInput == null ? "0" : String.valueOf(obInput);
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param strInput
     * @return
     */
    public static String getReturnZero(String strInput) {
        return ((strInput != null) && (!strInput.equals(""))) ? strInput : "0";
    }

    /**
     * 判断输入值是否为空，如果为空则返回0，否则返回输入值
     * 
     * @param strInput
     * @return
     */
    public static Double getDReturnZero(String strInput) {
        if ((strInput != null) && (!strInput.equals(""))) {
            return Double.valueOf(strInput);
        } else {
            return Double.valueOf("0");
        }
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param d
     * @return
     */
    public static Double getDReturnZero(Double d) {
        String strResult = getNoNull(d);
        if ((strResult != null) && (!strResult.equals(""))) {
            return d;
        } else {
            return Double.valueOf("0");
        }
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param l
     * @return
     */
    public static Long getLReturnZero(long l) {
        String strResult = getNoNull(l);
        return ((strResult != null) && (!strResult.equals(""))) ? l : 0l;
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param l
     * @return
     */
    public static Long getLReturnZero(Long l) {
        String strResult = getNoNull(l);
        return ((strResult != null) && (!strResult.equals(""))) ? l : 0l;
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param astrInput
     * @return
     */
    public static Double getReturnDouble(Double astrInput) {
        return astrInput != null ? astrInput : 0.0;
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param astrInput
     * @return
     */
    public static int getReturnInt(String astrInput) {
        return astrInput != null ? Integer.parseInt(astrInput) : 0;
    }

    /**
     * 判断输入值是否为空，如果为空则返回“0”，否则返回输入值
     * 
     * @param astrInput
     * @return
     */
    public static int getReturnInt(Object astrInput) {
        return astrInput != null ? Integer.parseInt(astrInput.toString()) : 0;
    }

    /**
     * 将小数转化成百分数
     * 
     * @param param
     *            :小数
     * @param i
     *            ：保留转化后百分数小数点后的位数；例如：param = 0.123789，i=2时，转化后的百分数为12.4%：
     * @return
     */
    public static String getPercent(double param, int i) {

        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(i);

        return nf.format(param);
    }

    /**
     * 获取十六进制的颜色代码.例如 "#6E36B4" , For HTML ,
     * 
     * @return String
     */
    public static String getRandColorCode() {
        String r, g, b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;

        return r + g + b;
    }

    /**
     * 
     * @return
     */
    public static String getBrowser(String desc) {
        desc = desc.toLowerCase();
        String broser = "";

        if (desc.contains("msie"))
            broser = "IE";
        else if (desc.contains("firefox"))
            broser = "Firefox";
        else if (desc.contains("chrome"))
            broser = "Chrome";
        else if (desc.contains("opera"))
            broser = "Opera";
        else if (desc.contains("safari"))
            broser = "safari";
        else
            broser = "unkown browser";
        return broser;
    }

    public static String decimalFormat(Long value) {
        DecimalFormat df = new DecimalFormat("##,###");
        return df.format(value);
    }

    public static String decimalFormat2(Double value) {
        DecimalFormat df = new DecimalFormat("##.00");
        return df.format(value);
    }

    public static void main(String[] args) {
        System.out.println(DataUtil.getRandColorCode());
    }
}