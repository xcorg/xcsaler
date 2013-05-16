package utils;

import play.cache.Cache;
import play.mvc.Scope.Session;

public class UploadUtil {
    public static String getToken() {
        String token = Session.current().getAuthenticityToken();
        Cache.safeSet(token, true, "1h");
        return token;
    }

    public static boolean checkToken(String token) {
        return Cache.get(token) != null;
    }
}
