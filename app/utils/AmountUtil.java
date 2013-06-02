package utils;

public class AmountUtil {
    public static float twofloatResult(float f1, float f2) {
        int m = 0;
        String s1 = "" + f1;
        String s2 = "" + f2;
        m += s1.split("\\.")[1].length();
        m += s2.split("\\.")[1].length();
        return (float) (Float.parseFloat(s1.replace(".", "")) * Float.parseFloat(s2.replace(".", "")) / Math.pow(10, m));
    }
}
