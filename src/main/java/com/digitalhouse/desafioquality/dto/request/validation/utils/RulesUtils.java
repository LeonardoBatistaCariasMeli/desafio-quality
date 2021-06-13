package com.digitalhouse.desafioquality.dto.request.validation.utils;

public interface RulesUtils {

    static boolean isNull(String str) {
        return str == null;
    }

    static boolean isBlank(String str) {
        return str.isBlank();
    }

    static boolean isFirstLetterUpperCase(String str) {
        char c = str.charAt(0);
        return Character.isUpperCase(c);
    }

}
