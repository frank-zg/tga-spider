package com.tga.utils;

import java.io.IOException;
import java.time.*;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Auth {

    public static final boolean checkAuth(boolean exceptionStatus, int timeout) {
        try {
            /*String body = HttpUtil.getOrReturn("http://www.beijing-time.org/time15.asp", new HashMap<>(),
                    exceptionStatus, timeout);
            if (body != null) {
                String[] times = body.split(";");
                int year = Integer.parseInt(times[1].split("=")[1]);
                int month = Integer.parseInt(times[2].split("=")[1]);
                int day = Integer.parseInt(times[3].split("=")[1]);
                System.out.println("now date: " + year + " / " + month + " / " + day);
                if (LocalDate.of(year, month, day).compareTo(LocalDate.of(2018, 6, 30)) <= 0) {
                    return true;
                }
            }*/

            String json = HttpUtil.getOrReturn("https://www.immomo.com/login?action=captcha",new HashMap<>(),false,10);

            long timestamp = System.currentTimeMillis();
            try {
                timestamp = Long.parseLong(JsonUtil.filter(json, "timesec")) * 1000;
            }catch (Exception e){
            }
            LocalDate beijing = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp / 1000),
                    TimeZone.getDefault().toZoneId()).toLocalDate();

            if (beijing.compareTo(LocalDate.of(2018, 6, 30)) <= 0) {
                return true;
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }



    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, IOException {
        String url = "http://qqlive.hdl.lxdns.com:80/124219102.flv?cdncode=%2f18907E7BE0798990%2f&time=1503638985&cdn=wangsu&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey=25DD5AAB6E0B2DD12D815F1FCDDEB54395BABA0E6FEA235C37F87D65F1D880F7D10D32520B7D784C898AB0A76E0122F8580E63CEFD2FAF284CBAE7379C6597116E345220E24AA882D6D2EC66366EC49AB3A538C70ED14194";
        int index1 = url.indexOf("time");
        System.out.println();

        url = url.substring(0, index1 + 5) + System.currentTimeMillis() / 1000 + url.substring(index1 + 15, url.length() -
                1);

        System.out.println(url.indexOf("guid"));


    }


}
