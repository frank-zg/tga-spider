package com.tga.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Play implements Runnable {
    public static final String KV_URL = "http://btrace.video.qq.com/kvcollect";
    private final String uri_index;
    private final String videoUri;
    private double videoTime;
    private int videoDownSize;
    private boolean exceptionStatus;
    private int timeout;
    private AtomicInteger autoIndex;

    public Play(String uri, String videoUri, double videoTime, int videoDownSize, int timeout, boolean exceptionStatus,
                AtomicInteger autoIndex) {
        this.uri_index = uri;
        this.videoTime = videoTime;
        this.autoIndex = autoIndex;
        this.videoUri = videoUri;
        if (videoDownSize == 1) {
            this.videoDownSize = 1024;
        } else if (videoDownSize == 0) {
            this.videoDownSize = 0;
        } else {
            this.videoDownSize = 1024 * 1024 * 7;
        }
        this.exceptionStatus = exceptionStatus;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        autoIndex.incrementAndGet();
        System.out.println(autoIndex.get());
        indexPage();

//        Map<String, String> headers2 = new HashMap<>();
//        headers2.put("Accept", "*/*");
//        headers2.put("Accept-Encoding", "gzip, deflate");
//        headers2.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        headers2.put("Connection", "keep-alive");
//        headers2.put("Content-Length", "164");
//        headers2.put("Content-Type", "application/x-www-form-urlencoded");
//        headers2.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
//        headers2.put("Host", "btrace.video.qq.com");
//        headers2.put("Origin", "http://imgcache.qq.com");
//        headers2.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
//        headers2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
//        headers2.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&CheckSum=105821293&progid=124227103&P2PVer=&flashver=WIN&BossId=2583&dc=1379&iQQ=294743258&sRef=");
        kvCommon("step=3&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227103&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&vurl=&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&pid=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&tpay=0");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&val2=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&rnd=8619&itype=50&bid=pcvideo&vid=124227103&str3=&str1=&str2=1%2E4%2E6&int1=0&str4=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&int2=0");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=486&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=6CED43308351F51F88DFE7D34BF6A2BAD871B90D&pid=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&vid=124227103" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.146%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227103" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D8CD2A8D4F906CECA3539C6242464C4C9034D5B34%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2938");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&val2=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&rnd=754&itype=50&bid=pcvideo&vid=124227103&str3=&str1=&str2=1%2E4%2E6&int1=0&str4=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&int2=1");
        kvCommon("step=4&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227103&val1=0&ctime="+cTimeStr()+"&adid=&val=566&sdtfrom=70202&iTy=3007" +
                "&vurl=http%3A%2F%2F175%2E6%2E13%2E139%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F269EAE4B37762B4DF7BD55F9654CAA9DC650E7144B63998E191682C636D4D3491382C6043C518E3EB400016CB5197E77012273AC09ACC4BE1FF0552E415ECE78574D2A107D1ADDD53526EA3217AE52DAC212BBFCF3048A5F%2F124227101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D269EAE4B37762B4DF7BD55F9654CAA9DC650E7144B63998E191682C636D4D3491382C6043C518E3EB400016CB5197E77012273AC09ACC4BE1FF0552E415ECE78574D2A107D1ADDD53526EA3217AE52DAC212BBFCF3048A5F&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&pid=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&tpay=0");
        kvCommon("cts="+System.currentTimeMillis()/1000+"&ftime="+System.currentTimeMillis()
                +"&cnl=124227103&iTy=2595&vky" +
                "=269EAE4B37762B4DF7BD55F9654CAA9DC650E7144B63998E191682C636D4D3491382C6043C518E3EB400016CB5197E77012273AC09ACC4BE1FF0552E415ECE78574D2A107D1ADDD53526EA3217AE52DAC212BBFCF3048A5F&dip=zijian&cky=ss3BL%2DVKbYUGa1N9CMxu99mxavGxXdbY6K5jazeM0nHdah%2DFmeis8T5kP4F%5FcSzAsiFF9lGRPDqgdNudH%5Fp4NVxZkmWEpFU%2DPX5a9Ee3d9bf6iZQTOM%2DFiwD%5F5JkmuiDPDDF7NDwY6S5fMgJ3bnMqUrJ6VJ16tVDLh1L9VJhh6F7%5F1VB2BQ3K%2DmpjBRgnuacsBE5IGUWCQyDReWV5gLttAuFI9yOZJqsYV4%5Ffpyp0q%2DDDRYSm3LQd%5FgGaTDFYVNXoo%5FHOFJuXn9JepuHu0LUrvr45pABVzPga2fHRL15Zuv57ZcT5k1qF5Hw%2DhXl2VSkEEcM%5Fg&sdt=70202&cip=&evr=5%2E4&uin=294743258&plt=1&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&avr=TencentPlayerLiveV3%2E2%2E3%2E07");
        kvCommon("step=1100&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227101&val1=0&ctime="+cTimeStr()+"&adid=&val=412&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2Finfo%2Ezb" +
                "%2Evideo%2Eqq%2Ecom%2F%3FqueueStatus%3D0%26pla%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dlol%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26sdtfrom%3D70202%26livequeue%3D1%26rnd%3D236%26system%3D3%26flashver%3D29%2C0%2C0%2C113%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26browser%3Dchrome%26flvtype%3D1%26encryptVer%3D5%2E4%26fntick%3D0%26vip%5Fstatus%3D0%26cnlid%3D124227103%26cKey%3Dss3BL%2DVKbYUGa1N9CMxu99mxavGxXdbY6K5jazeM0nHdah%2DFmeis8T5kP4F%5FcSzAsiFF9lGRPDqgdNudH%5Fp4NVxZkmWEpFU%2DPX5a9Ee3d9bf6iZQTOM%2DFiwD%5F5JkmuiDPDDF7NDwY6S5fMgJ3bnMqUrJ6VJ16tVDLh1L9VJhh6F7%5F1VB2BQ3K%2DmpjBRgnuacsBE5IGUWCQyDReWV5gLttAuFI9yOZJqsYV4%5Ffpyp0q%2DDDRYSm3LQd%5FgGaTDFYVNXoo%5FHOFJuXn9JepuHu0LUrvr45pABVzPga2fHRL15Zuv57ZcT5k1qF5Hw%2DhXl2VSkEEcM%5Fg%26cmd%3D2%26stream%3D2%26txvjsv%3D2%26defauto%3D1%26rid%3D8CD2A8D4F906CECA3539C6242464C4C9034D5B34%26defn%3D&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&pid=8CD2A8D4F906CECA3539C6242464C4C9034D5B34&tpay=0");
        kvCommon
                ("BossId=3460&ftime="+System
                        .currentTimeMillis()+"&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&vkey" +
                        "=269EAE4B37762B4DF7BD55F9654CAA9DC650E7144B63998E191682C636D4D3491382C6043C518E3EB400016CB5197E77012273AC09ACC4BE1FF0552E415ECE78574D2A107D1ADDD53526EA3217AE52DAC212BBFCF3048A5F&cnlID=124227103");
        //kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() +
        //        "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
        //        "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
        //        "%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom" +
        //        "%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=353&ptag" +
        //        "=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=1100" +
        //        "&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F" +
        //        "%3Flivequeue%3D1%26rid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26flvtype%3D1%26defn%3D%26host" +
        //        "%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dlol" +
        //        "%26cnlid%3D124209001%26system%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26guid" +
        //        "%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26cKey
        // %3DTCvnbQusS8cGa1N9CMxu99mxavGxXdbY6K5jazeM0nFv7F%5FZRmcwLdOfYhte%2DmsJXACH5w1AijuX0Tsn0R5sDxjVTlCSV%2DabIkepag0IsRXdPRGh4jdA8H6QOfMd70k1ONRdszlMdj5L73Ari79TFsEay8IZ9lI2bMY%5F36POohluRLzZDidQXT9%2D%5FBp%2DvmTnrKhVyeVvlSTUE3knpwmrAX744LYQ58xdQre3cD7p679pvW8RU2qkyTjWC29zzJhZcfEIR8F883uAP0VSvMDD%5FtPgRHXg33RM6xD4Dl0xdushdofqBl4IYYoHbMU%2DSW0UF%5FoYtQ%26browser%3Dchrome%26vip%5Fstatus%3D0%26cmd%3D2%26flashver%3D26%2C0%2C0%2C151%26queueStatus%3D0%26sdtfrom%3D70202%26defauto%3D1%26fntick%3D0%26encryptVer%3D5%2E4%26rnd%3D78%26pla%3D0%26txvjsv%3D2%26stream%3D2&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("platform=1&Pwd=779660211&vkey" +
                "=D552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cnlID=124227103&ftime="+System.currentTimeMillis()+"&BossId=3460");
        kvCommon("iQQ=294743258&val=250&flashver=MAC%2029%2E0%2E0%2E113&step=6&BossId=3007&val1=0&Pwd=881273072" +
                "&fplayerver=30203007&val2=0&sid=124227101&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc" +
                "%5Fgame%2Ehtml%3Fgame%3Dlol&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dlol&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&P2PVer" +
                "=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&tpay=0&vurl=http" +
                "%3A%2F%2F124%2E232%2E162%2E219%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F%2F124227101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&pid=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&ptag=");
        kvCommon("flashver=MAC%2029%2E0%2E0%2E113&HttpDownSum=0&str%5Fparam1=zijian&HttpDownlandSpeed=0&cnnPS=0&iQQ" +
                "=294743258&durl=http%3A%2F%2F124%2E232%2E162%2E219%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F%2F124227101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&app=live&UDPDownSum=0&str%5Fparam2=124%2E232%2E162%2E219&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&videopos=0&sOp=webflash&xserverip=&sIp=&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&P2PReDelay=0&fullScreen=0&cmd=205&live%5Ftype=8&SuNodDelay=0&lookback=0&switch=0&averRemtime=0&pla=1&type=17&blockTime=0&cdn=zijian&StartP2P=0&errorCode=10000&loadingTime=85&SuperNodeIP=0&peerCount=0&fullecode=10000&dsip=124%2E232%2E162%2E219&SuperNodePort=0&fplayerver=30203007&prdLength=1&playtime=0&PeerServerIP=0&time="+System.currentTimeMillis()+"&downSpeed=396&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=4603&isuserpay=0&CDNAbnormal=0&cnnTime=165&livepid=48181&ReqSNBlockOutRange=0&sRef=&reCnnCount=0&HashNotFinished=0&playNo=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&seq=0&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=485&P2PVer=0&blockHasData=0&PeerServerPort=0&transtype=0&playAd=0&adstat=0&progid=124227101");
        live_poll();
        kvCommon("platform=1&Pwd=779660211&vkey" +
                "=D552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cnlID=124227103&ftime="+System.currentTimeMillis()+"&BossId=3460");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=13&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=4B46E5519BD36D2D3814F40A2FFD92CEB046D05E&pid=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&vid=124227101" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227101" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3881");
        kvCommon("str4=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&iTy=2052&int2=1&int1=0&val=100&itype=52&rnd=9163&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str2=1%2E4%2E6&bid=pcvideo&str3=&val2=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&vid=124227101&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dlol&sRef=&sPageId=&sPos=&step=3&val=21&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=4B46E5519BD36D2D3814F40A2FFD92CEB046D05E&pid=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&vid=124227101" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227101" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4030");
        try {
            for (int i = 1; i < videoTime; i++) {
                forEachRequest(i);
            }
        } catch (Exception e) {

        }

        //关闭下载线程
        if (videoTime > 0 && videoDownSize > 0 && stream != null) {
            stream.stop();
        }
//        });
    }

    public void indexPage() {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s9238996620; ts_last=tga.qq.com/match/2018/pc_game.html");
        headers1.put("Host", "tga.qq.com");
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("platform=1&Pwd=779660211&vkey" +
                    "=D552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cnlID=124227103&ftime="+System.currentTimeMillis()+"&BossId=3460");
            sleep();
            kvCommon("iQQ=294743258&HttpDownSum=0&str%5Fparam1=zijian&HttpDownlandSpeed=0&cnnPS=0&flashver=MAC%2029" +
                    "%2E0%2E0%2E113&durl=http%3A%2F%2F124%2E232%2E162%2E219%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                    "%2FD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F%2F124227101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&app=live&UDPDownSum=0&str%5Fparam2=124%2E232%2E162%2E219&UDPDownlandSpeed=0&sBiz=zhibo&sIp=&clientip=&videopos=0&sOp=webflash&xserverip=&UpdataSpeed=0&RtmfpInfo=0&time="+ System.currentTimeMillis()+"&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&iSta=0&switch=0&fullScreen=0&cmd=263&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&P2PReDelay=0&type=17&blockTime=0&cdn=zijian&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&peerCount=0&fullecode=10000&dsip=124%2E232%2E162%2E219&SuperNodePort=0&fplayerver=30203007&prdLength=60&playtime=0&PeerServerIP=0&downSpeed=136&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&playNo=21CE826DC1B74B2BC0FA04EE72A4180A661EEC6C&livepid=48181&ReqSNBlockOutRange=0&sRef=&reCnnCount=0&HashNotFinished=0&cnnTime=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&seq="+seq+"&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=0&P2PVer=0&blockHasData=0&PeerServerPort=0&transtype=0&playAd=0&adstat=0&progid=124227101");
            sleep();
            live_poll();
            sleep();
            kvCommon("platform=1&Pwd=779660211&vkey" +
                    "=D552013A18D8C54108235BDAEAFA4C299BD69156BC24D3D6463D8331891CDC2521AD3B5069CC3893A056A70FE077B5EF2407A669B1E641C3BCFFE1782CD430A8F1FF3ADEF4410D8D9B868507F696FFD70DAD23307130334F&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cnlID=124227103&ftime="+System.currentTimeMillis()+"&BossId=3460");
            sleep();
        } catch (InterruptedException e) {

        }
    }

    private static String cTimeStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss SSS"));
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(2 * 1000);
    }

    public void flashStream() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
        headers.put("Host", "112.90.167.8080");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://112.90.53.167:8080/FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC9613086" +
                        "8DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time" +
                        "=" + System.currentTimeMillis() / 1000 + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" +
                        "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223" +
                        "D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B47" +
                        "9ABA9&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&apptype=live",
                headers, exceptionStatus, timeout);
    }

    public void kvGetCommon(String uri) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s9238996620");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Upgrade-Insecure-Requests", "1");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        //System.out.println(HttpUtils.httpGet(new HttpEntity("http://tga.qq.com/match/2017/pc_index.html",  )), 10));
        HttpUtil.get(uri, headers, exceptionStatus, timeout);
    }

    public void kvCommon(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s9238996620");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.post(KV_URL, body, headers, exceptionStatus, timeout);
    }

    public void live_poll() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s9238996620");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&pollDataKey=pid%3D48181%26type%3D&qqlog=&markContext=last%3D0", headers, exceptionStatus, timeout);
    }

    /**
     * http stream下载
     */
    public void httpDownload() {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dlol&apptype=live";
            String host = tmpUrl.substring(8);
            host2 = host.substring(0, host.indexOf('/'));


            url = new URL(tmpUrl);
        } catch (Exception e1) {
            if (exceptionStatus) {
                e1.printStackTrace();
            }
            // TODO Auto-generated catch block
        }
        URLConnection conn;
        InputStream inStream = null;
        try {
            conn = url.openConnection();
            conn.setConnectTimeout(1000 * 20);
            conn.addRequestProperty("Accept", "*/*");
            conn.addRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.addRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            conn.addRequestProperty("Connection", "keep-alive");
            conn.addRequestProperty("Host", host2);
            conn.addRequestProperty("Referer", uri_index);
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            inStream = conn.getInputStream();

            byte[] buffer = new byte[1204];
            int totalSize = videoDownSize;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                //限制视频大小
                if (bytesum >= totalSize) {
                    System.out.println("视频大小上限..." + bytesum + "---" + totalSize);
                    break;
                }
            }
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (inStream != null)
                    inStream.close();
            } catch (IOException e) {
            }
        }
    }
}


