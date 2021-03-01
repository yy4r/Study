package com.example.base.myProcessor.common.utils;

import java.util.Collection;
import java.util.Map;

public class Assert {

    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        if (expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isBlank(String str, String message) {
        if (!isBlank0(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String str, String message) {
        if (isBlank0(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean isBlank0(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(Map map, String message) {
        if (map != null && !map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Map map, String message) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void equals(Object a, Object b, String message) {
        if (a == null) {
            if (b != null) {
                throw new IllegalArgumentException(message);
            }
        } else {
            if (!a.equals(b)) {
                throw new IllegalArgumentException(message);
            }
        }
    }
}
