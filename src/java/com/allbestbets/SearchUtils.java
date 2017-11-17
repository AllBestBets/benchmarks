package com.allbestbets;

import java.util.Map;

public class SearchUtils {

    static String[] parseStringArray(String str) {
        if (str == null || str.equals("")) return new String[0];
        return str.split(",");
    }

    static byte[] parseByteArray(String str) {
        if (str == null || str.equals("")) return new byte[0];

        String[] stringList = str.split(",");

        byte[] result = new byte[stringList.length];

        for (int i = 0; i < stringList.length; i++)
            result[i] = Byte.parseByte(stringList[i]);

        return result;
    }

    static short[] parseShortArray(String str) {
        if (str == null || str.equals("")) return new short[0];

        String[] stringList = str.split(",");

        short[] result = new short[stringList.length];

        for (int i = 0; i < stringList.length; i++)
            result[i] = Short.parseShort(stringList[i]);

        return result;
    }

    public static long[] parseLongArray(String str) {
        if (str == null || str.equals("")) return new long[0];

        String[] stringList = str.split(",");

        long[] result = new long[stringList.length];

        for (int i = 0; i < stringList.length; i++)
            result[i] = Long.parseLong(stringList[i]);

        return result;
    }

    public static boolean includeInArray(byte[] array, byte item) {
        if (array == null) return false;

        for (byte anArray : array) if (anArray == item) return true;

        return false;
    }

    public static boolean includeInArray(short[] array, short item) {
        if (array == null) return false;

        for (short anArray : array) if (anArray == item) return true;

        return false;
    }

    public static boolean includeInArray(int[] array, int item) {
        if (array == null) return false;

        for (int anArray : array) if (anArray == item) return true;

        return false;
    }

    public static boolean includeInArray(long[] array, long item) {
        if (array == null) return false;

        for (long anArray : array) if (anArray == item) return true;

        return false;
    }

    public static boolean includeInArray(String[] array, String item) {
        if (array == null) return false;

        for (String anArray : array) if (anArray.equals(item)) return true;

        return false;
    }

    public static boolean includeInArray(String[] array, String[] items) {
        if (array == null) return false;

        int itemLength = items.length;

        for (String arrayItem : array)
            for (String item : items)
                if (arrayItem.equals(item)) return true;


        return false;
    }

    public static boolean includeInArray(long[] array, long item1, long item2) {
        if (array == null) return false;

        for (long arrayItem : array) {
            if (arrayItem == 0) continue;
            if (arrayItem == item1 || arrayItem == item2) return true;
        }
        return false;
    }

    public static boolean includeInArray(long[] array, long item1, long item2, long item3) {
        if (array == null) return false;

        for (long arrayItem : array) {
            if (arrayItem == 0) continue;
            if (arrayItem == item1 || arrayItem == item2 || arrayItem == item3) return true;
        }

        return false;
    }

    public static boolean includeInArray(String[] array, String item1, String item2, String item3) {
        if (array == null) return false;

        for (String arrayItem : array) {
            if (arrayItem.equals(item1) || arrayItem.equals(item2) || (item3 != null && arrayItem.equals(item3)))
                return true;
        }

        return false;
    }

    static Float parseFloat(final Map<String, String> params, String key) {
        return params.containsKey(key) ? Float.valueOf(params.get(key).replace(",", ".")) : null;
    }
}
