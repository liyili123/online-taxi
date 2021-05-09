package com.example.demo.ketang;

public class IPUtils {
    public static Long getIPNum(final String IP) {
        Long IPNum = 0l;
        final String IPStr = IP.trim();
        if (IP != null && IPStr.length() != 0) {
            final String[] subips = IPStr.split("\\.");
            for (final String str : subips) {
                // 向左移8位
                IPNum = IPNum << 8;
                IPNum += Integer.parseInt(str);
            }
        }
        return IPNum;
    }

    public static String getIPString(final Long IPNum) {
        final Long andNumbers[] = { 0xff000000L, 0x00ff0000L, 0x0000ff00L, 0x000000ffL };
        final StringBuilder IPStrSb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            IPStrSb.append(String.valueOf((IPNum & andNumbers[i]) >> 8 * (3 - i)));
            if (i != 3) {
                IPStrSb.append(".");
            }
        }
        return IPStrSb.toString();
    }

    public static void main(final String[] args) {
        final String IPStr = "192.185.11.11";
        System.out.println(getIPNum(IPStr));

        final Long IPNum = 3233352459L;
        System.out.println(getIPString(IPNum));
    }

}
