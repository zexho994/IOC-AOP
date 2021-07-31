package utils;

/**
 * @author Zexho
 * @date 2021/7/31 10:56 上午
 */
public class Assert {

    public static void hasText(String str, String message) {
        if (str == null || str.isEmpty() || !containsText(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean containsText(String str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
