package com.tga.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        kvCommon("P2PVer=&flashver=WIN&dc=9286&progid=124223602&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&BossId=2583&CheckSum=105821293&sRef=&iQQ=125826029");
        kvCommon("sid=124223602&Pwd=881273072&ctime="+cTimeStr()+"&sdtfrom=70202&vurl=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val=0&iQQ=125826029&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30203006&iTy=3007&flashver=MAC%2027%2E0%2E0%2E183&pid=748D320886AB9DD12107FFB96C481737ABBCB220&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&P2PVer=0&BossId=3007&step=3&adid=");
        kvCommon("iTy=2052&int1=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&rnd=7428&str2=1%2E4%2E6&vid=124223602&itype=50&bid=pcvideo&str3=&val=100&str4=748D320886AB9DD12107FFB96C481737ABBCB220&val2=&str1=&int2=0&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=56&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=0F8B44C01F5C0DFFEDB8683B10633D554ADC5D32&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223602" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D748D320886AB9DD12107FFB96C481737ABBCB220%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3688");
        kvCommon("iTy=2052&int1=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&rnd=5643&str2=1%2E4%2E6&vid=124223602&itype=50&bid=pcvideo&str3=&val=100&str4=748D320886AB9DD12107FFB96C481737ABBCB220&val2=&str1=&int2=1&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=20&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=0F8B44C01F5C0DFFEDB8683B10633D554ADC5D32&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223602" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D748D320886AB9DD12107FFB96C481737ABBCB220%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7361");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=0F8B44C01F5C0DFFEDB8683B10633D554ADC5D32&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6440");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?step=1&pf=out&pid2=748D320886AB9DD12107FFB96C481737ABBCB220&dura=0&t=30000" +
                "&reqtime="+System.currentTimeMillis()/1000);
        kvCommon("sid=124223602&Pwd=881273072&ctime="+cTimeStr()+"&sdtfrom=70202&vurl=&surl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val=0&iQQ=125826029&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30203006&iTy=3007&flashver=MAC%2027%2E0%2E0%2E183&pid=748D320886AB9DD12107FFB96C481737ABBCB220&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&P2PVer=0&BossId=3007&step=7&adid=");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?step=0&pf=out&pid2=748D320886AB9DD12107FFB96C481737ABBCB220&dura=0&t=30000" +
                "&reqtime="+System.currentTimeMillis()/1000);
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124223602&platform=6&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://tga.qq.com/2017winter/lol.htm?from=tga2017&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7166");
        kvCommon("sid=124223602&Pwd=881273072&ctime="+cTimeStr()+"&sdtfrom=70202&vurl=http%3A%2F%2F222%2E242%2E193%2E14" +
                "%3A8080" +
                "%2F1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411%2F124223602%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val=269&iQQ=125826029&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30203006&iTy=3007&flashver=MAC%2027%2E0%2E0%2E183&pid=748D320886AB9DD12107FFB96C481737ABBCB220&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&P2PVer=0&BossId=3007&step=4&adid=");
        kvCommon("dip=zijian&uin=125826029&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cky" +
                "=AWx8fkbr0NQGa1N9CMxu99mxavGxXdbY6K5jazeM0nGKAJSpKPFTNKn8HlHnymQUk9cBlHZnuN7RLCJwSeHe" +
                "%2DrJEu8X46AVil2TQBDDGht0k3jRLkGfzKXTyB7AZ2YXMfEPVpfd6wpW" +
                "%5FTOllgq2Vl013Y08CPO8E1s6m1oc00n8gS5oUwIMBTqnGMh8T%5F0SmW3OChPn8Qyb0XAJwuwcNdcXfD%5F1CCCOq5wBs" +
                "%2DgfC46ATr6PumKuXgXKxzO%2DNlTk891j0SMY6qVmmGNxl5QTTtTKG0vsLEFTaW%5F3OmR" +
                "%5FvJtmvAItBKOtcprbAsRKD1sV8SjysdQ&ftime="+System
                .currentTimeMillis()+"&iTy=2595&cnl=124223602&avr=TencentPlayerLiveV3%2E2%2E3%2E06&evr=5%2E4&vky" +
                "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cts=1510319623&cip=&sdt=70202&plt=1");
        kvCommon("sid=124223602&Pwd=881273072&ctime="+cTimeStr()+"&sdtfrom=70202&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq" +
                "%2Ecom%2F%3Fcmd%3D2%26stream%3D2%26browser%3Dchrome%26vip%5Fstatus%3D0%26rnd%3D41%26encryptVer%3D5%2E4%26cKey%3DAWx8fkbr0NQGa1N9CMxu99mxavGxXdbY6K5jazeM0nGKAJSpKPFTNKn8HlHnymQUk9cBlHZnuN7RLCJwSeHe%2DrJEu8X46AVil2TQBDDGht0k3jRLkGfzKXTyB7AZ2YXMfEPVpfd6wpW%5FTOllgq2Vl013Y08CPO8E1s6m1oc00n8gS5oUwIMBTqnGMh8T%5F0SmW3OChPn8Qyb0XAJwuwcNdcXfD%5F1CCCOq5wBs%2DgfC46ATr6PumKuXgXKxzO%2DNlTk891j0SMY6qVmmGNxl5QTTtTKG0vsLEFTaW%5F3OmR%5FvJtmvAItBKOtcprbAsRKD1sV8SjysdQ%26rid%3D748D320886AB9DD12107FFB96C481737ABBCB220%26sdtfrom%3D70202%26queueStatus%3D0%26flvtype%3D1%26pla%3D0%26defauto%3D1%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252F2017winter%252Flol%2Ehtm%253Ffrom%253Dtga2017%26system%3D3%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26cnlid%3D124223602%26livequeue%3D1%26flashver%3D27%2C0%2C0%2C183%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06%26fntick%3D0%26txvjsv%3D2%26defn%3D&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val=127&iQQ=125826029&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30203006&iTy=3007&flashver=MAC%2027%2E0%2E0%2E183&pid=748D320886AB9DD12107FFB96C481737ABBCB220&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&P2PVer=0&BossId=3007&step=1100&adid=");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("ftime="+System.currentTimeMillis()+"&platform=1&Pwd=779660211&BossId=3460&vkey" +
                "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cnlID=124223602&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
        kvCommon("sid=124223602&Pwd=881273072&ctime="+cTimeStr()+"&sdtfrom=70202&vurl=http%3A%2F%2F222%2E242%2E193%2E14" +
                "%3A8080%2F1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411%2F124223602%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val=449&iQQ=125826029&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30203006&iTy=3007&flashver=MAC%2027%2E0%2E0%2E183&pid=748D320886AB9DD12107FFB96C481737ABBCB220&ptag=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&P2PVer=0&BossId=3007&step=6&adid=");
        kvCommon("videopos=0&time="+System.currentTimeMillis()+"&HashNotFinished=0&sIp=&xserverip=&iQQ=125826029&UDPDownlandSpeed=0" +
                "&sBiz=zhibo&str%5Fparam2=222%2E242%2E193%2E14&HttpDownSum=0&UDPDownSum=0&sOp=webflash&PeerServerPort" +
                "=0&fullScreen=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&UDPUpSum=0&iTy=1991" +
                "&ReqSNBlockOutRange=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&cmd=205&svrCount=0&ispay=0&sRef" +
                "=&HttpDownlandSpeed=0&CDNAbnormal=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&PeerServerIP=0" +
                "&P2PReDelay=0&PeerConnRate=0&SuNodDelay=0&cnnPS=0&P2PVer=0&viewid=&loadingTime=379&type=17" +
                "&SuperNodePort=0&progid=124223602&dsip=222%2E242%2E193%2E14&blockCount=0&playNo" +
                "=748D320886AB9DD12107FFB96C481737ABBCB220&cdn=zijian&blockTime=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&str%5Fparam1=zijian&errorCode=10000&peerCount=0&livepid" +
                "=40930&fullecode=10000&averRemtime=0&pla=1&prdLength=1&app=live&downSpeed=1092&adstat=0&flashver=MAC" +
                "%2027%2E0%2E0%2E183&maxSpeed=3511&fplayerver=30203006&cnnTime=70&live%5Ftype=8&StartP2P=0&durl=http" +
                "%3A%2F%2F222%2E242%2E193%2E14%3A8080" +
                "%2F1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411%2F124223602%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&reCnnCount=0&averPeerMeHealth=0&blockHasData=0&playerOnPlayTime=748&switch=0&lookback=0&transtype=0&playAd=0&lookbackseq=0&clientip=&p2pCount=0&seq=0");
        undefined("http://tga.qq.com/2017winter/undefined?t=30000&pid2=748D320886AB9DD12107FFB96C481737ABBCB220" +
                "&reqtime="+System.currentTimeMillis()/1000);
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=0F8B44C01F5C0DFFEDB8683B10633D554ADC5D32&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2042");
        live_poll();
        kvCommon("ftime="+System.currentTimeMillis()+"&platform=1&Pwd=779660211&BossId=3460&vkey" +
                "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cnlID=124223602&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
        kvCommon("iTy=2052&int1=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&rnd=9660&str2=1%2E4%2E6&vid=124223602&itype=52&bid=pcvideo&str3=&val=100&str4=748D320886AB9DD12107FFB96C481737ABBCB220&val2=&str1=&int2=0&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=11&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=2342DC6795333F598F8C49A3BAAB85D04830B568&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223602" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D748D320886AB9DD12107FFB96C481737ABBCB220%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5335");
        kvCommon("iTy=2052&int1=0&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&rnd=129&str2=1%2E4%2E6&vid=124223602&itype=52&bid=pcvideo&str3=&val=100&str4=748D320886AB9DD12107FFB96C481737ABBCB220&val2=&str1=&int2=1&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=104&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=2342DC6795333F598F8C49A3BAAB85D04830B568&pid=748D320886AB9DD12107FFB96C481737ABBCB220&vid=124223602" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223602" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D748D320886AB9DD12107FFB96C481737ABBCB220%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flol" +
                ".htm%26refer%3D%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=22");
        kvCommon("videopos=0&time="+System.currentTimeMillis()+"&HashNotFinished=0&sIp=&xserverip=&iQQ=125826029&UDPDownlandSpeed=0" +
                "&sBiz" +
                "=zhibo&str%5Fparam2=222%2E242%2E193%2E14&HttpDownSum=0&UDPDownSum=0&sOp=webflash&PeerServerPort=0" +
                "&fullScreen=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=263&iTy=1991" +
                "&ReqSNBlockOutRange=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&ispay=0&sRef" +
                "=&HttpDownlandSpeed=0&CDNAbnormal=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&PeerServerIP=0" +
                "&P2PReDelay=0&PeerConnRate=0&adstat=4&cnnPS=0&P2PVer=0&viewid=&loadingTime=0&type=17&SuperNodePort=0" +
                "&progid=124223602&dsip=222%2E242%2E193%2E14&blockCount=0&playNo" +
                "=748D320886AB9DD12107FFB96C481737ABBCB220&cdn=zijian&blockTime=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&str%5Fparam1=zijian&errorCode=10000&peerCount=0&livepid" +
                "=40930&fullecode=10000&averRemtime=0&pla=1&prdLength=30&app=live&downSpeed=603&SuNodDelay=0&flashver" +
                "=MAC%2027%2E0%2E0%2E183&maxSpeed=0&fplayerver=30203006&cnnTime=0&live%5Ftype=8&StartP2P=0&durl=http" +
                "%3A%2F%2F222%2E242%2E193%2E14%3A8080" +
                "%2F1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411%2F124223602%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&reCnnCount=0&averPeerMeHealth=0&blockHasData=0&playerOnPlayTime=0&switch=0&lookback=0&transtype=0&playAd=0&lookbackseq=0&clientip=&p2pCount=0&seq=1");
        live_poll();
        kvCommon("ftime="+System.currentTimeMillis()+"&platform=1&Pwd=779660211&BossId=3460&vkey" +
                "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cnlID=124223602&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; ied_rf=--; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
        headers1.put("Host", "tga.qq.com");
//        headers1.put("Referer", "https://mail.qq.com/");
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void undefined(String uri){
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "*/*");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; ied_rf=--; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
        headers1.put("Host", "tga.qq.com");
        headers1.put("Referer", uri_index);
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers1.put("X-Requested-With", "ShockwaveFlash/27.0.0.183");
        HttpUtil.get(uri, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("ftime="+System.currentTimeMillis()+"&platform=1&Pwd=779660211&BossId=3460&vkey" +
                    "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cnlID=124223602&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
            sleep();
            kvCommon("videopos=0&time="+System
                    .currentTimeMillis()+"&HashNotFinished=0&sIp=&xserverip=&iQQ=125826029&UDPDownlandSpeed=0" +
                    "&sBiz=zhibo&str%5Fparam2=222%2E242%2E193%2E14&HttpDownSum=0&UDPDownSum=0&sOp=webflash" +
                    "&PeerServerPort=0&fullScreen=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&UDPUpSum" +
                    "=0&iTy=1991&ReqSNBlockOutRange=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&cmd=263&svrCount=0&ispay" +
                    "=0&sRef=&HttpDownlandSpeed=0&CDNAbnormal=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B" +
                    "&PeerServerIP=0&P2PReDelay=0&PeerConnRate=0&SuNodDelay=0&cnnPS=0&P2PVer=0&viewid=&loadingTime=0" +
                    "&type=17&SuperNodePort=0&progid=124223602&dsip=222%2E242%2E193%2E14&blockCount=0&playNo" +
                    "=748D320886AB9DD12107FFB96C481737ABBCB220&cdn=zijian&blockTime=0&progUrl=http%3A%2F%2Ftga%2Eqq" +
                    "%2Ecom%2F2017winter%2Flol%2Ehtm%3Ffrom%3Dtga2017&str%5Fparam1=zijian&errorCode=10000&peerCount=0" +
                    "&livepid=40930&fullecode=10000&averRemtime=0&pla=1&prdLength=60&app=live&downSpeed=212&adstat=0" +
                    "&flashver=MAC%2027%2E0%2E0%2E183&maxSpeed=0&fplayerver=30203006&cnnTime=0&live%5Ftype=8&StartP2P" +
                    "=0&durl=http%3A%2F%2F222%2E242%2E193%2E14%3A8080" +
                    "%2F1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411%2F124223602%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&reCnnCount=0&averPeerMeHealth=0&blockHasData=0&playerOnPlayTime=0&switch=0&lookback=0&transtype=0&playAd=0&lookbackseq=0&clientip=&p2pCount=0&seq="+seq);
            sleep();
            live_poll();
            sleep();
            kvCommon("ftime="+System.currentTimeMillis()+"&platform=1&Pwd=779660211&BossId=3460&vkey" +
                    "=1C3EC5246A1C2F629F0A20F77CE8CFDD6D81FC91274591CE2FC9EDB1B392605AFC2D8EC1FEC03710832C9C95324F926410A77F084C13BD9D07DFCF958CA70A3EC13F738D0EAFC45DD94377D155D57E10C4215862B8150411&cnlID=124223602&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
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


    public void kvGetCommon(String uri) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", uri_index);
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&pollDataKey=pid%3D40930%26type%3D&qqlog=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flol.htm%3Ffrom%3Dtga2017&apptype=live";
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


