package utils;


public class PageUtil {
//    public static Long totalCount2TotalPage(Long count) {
//        User u = (User) Security.currentUser();
//        int listCount = u.config.listCount;
//        if (count == null) {
//            return 0l;
//        } else if (count - 0 >= 0) {
//            if (listCount == 0) {
//                return 0l;
//            } else {
//                return (count % listCount == 0) ? (count / listCount) : (count / listCount + 1);
//            }
//        } else {
//            return 0l;
//        }
//    }

    public static Long totalCount2TotalPage(Long count, int listCount) {
        if (count == null) {
            return 0l;
        } else if (count - 0 >= 0) {
            if (listCount == 0) {
                return 0l;
            } else {
                return (count % listCount == 0) ? (count / listCount) : (count / listCount + 1);
            }
        } else {
            return 0l;
        }
    }

}
