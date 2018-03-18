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
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&CheckSum=105821293&progid=124227703&P2PVer=&flashver=WIN&BossId=2583&dc=5789&iQQ=294743258&sRef=");
        kvCommon("step=3&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227703&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&vurl=&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&tpay=0");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int1=0&itype=50&str1=&str3=&bid=pcvideo&vid=124227703&rnd=6336&str2=1%2E4%2E6&val2=&int2=0&str4=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=58&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=E145CCAFC7531F95A87DB3DFF4D41DB80A0C17F5&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&vid=124227703" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227703" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D1C9BD57B6659B9A9764E7FB93D06C1581D8795E1%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4888");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int1=0&itype=50&str1=&str3=&bid=pcvideo&vid=124227703&rnd=711&str2=1%2E4%2E6&val2=&int2=1&str4=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=E145CCAFC7531F95A87DB3DFF4D41DB80A0C17F5&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&vid=124227703" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9556");
        kvCommon("step=7&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227703&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&vurl=&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&tpay=0");
        kvCommon("step=4&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227703&val1=0&ctime="+cTimeStr()+"&adid=&val=265&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2F218%2E75" +
                "%2E177%2E102%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F%2F124227701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&tpay=0");
        kvCommon("plt=1&dip=zijian&avr=TencentPlayerLiveV3%2E2%2E3%2E07&iTy=2595&ftime="+System
                .currentTimeMillis()+"&cts="+System.currentTimeMillis()/1000+"&evr=5" +
                "%2E4&sdt=70202&cnl=124227703&uin=294743258&vky=B4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cky=WdvW0x5cenkGa1N9CMxu99mxavGxXdbY6K5jazeM0nFJRPj4TT5sZuT9OTni%2Dhsl%5F47Wd55w0Bk17D87pTaxACw9k5YR9MOsTsBHdblR31Nw5UU9WQP3tGbO26USMUsSWAD%2DzSZqhG4ZKF1dk7USOS0NIR8lqAuoN2%2DiQGTcBkGNrSdbSrz1%5FmlEQ5Dqb9G5OSTLeZ72Ezi%5FV8AjTlCTkfsPZSMAjyYc8HLk%2DGsCHfC7rmn5F50JugTVdEsRBw0aDiWMD3%2Dq4ZkE%5FuF8789SyI91TPsgU%5F6lMCZMoRCQBhiVn0Y42I38q3aMccYN%2DBDtOh2a0A&cip=");
        kvCommon("step=1100&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227701&val1=0&ctime="+cTimeStr()+"&adid=&val=126&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2Finfo%2Ezb" +
                "%2Evideo%2Eqq%2Ecom%2F%3FqueueStatus%3D0%26flvtype%3D1%26pla%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dcfm%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26sdtfrom%3D70202%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26livequeue%3D1%26system%3D3%26flashver%3D29%2C0%2C0%2C113%26cKey%3DWdvW0x5cenkGa1N9CMxu99mxavGxXdbY6K5jazeM0nFJRPj4TT5sZuT9OTni%2Dhsl%5F47Wd55w0Bk17D87pTaxACw9k5YR9MOsTsBHdblR31Nw5UU9WQP3tGbO26USMUsSWAD%2DzSZqhG4ZKF1dk7USOS0NIR8lqAuoN2%2DiQGTcBkGNrSdbSrz1%5FmlEQ5Dqb9G5OSTLeZ72Ezi%5FV8AjTlCTkfsPZSMAjyYc8HLk%2DGsCHfC7rmn5F50JugTVdEsRBw0aDiWMD3%2Dq4ZkE%5FuF8789SyI91TPsgU%5F6lMCZMoRCQBhiVn0Y42I38q3aMccYN%2DBDtOh2a0A%26browser%3Dchrome%26encryptVer%3D5%2E4%26fntick%3D0%26vip%5Fstatus%3D0%26cnlid%3D124227703%26rnd%3D330%26cmd%3D2%26stream%3D2%26txvjsv%3D2%26defauto%3D1%26rid%3D1C9BD57B6659B9A9764E7FB93D06C1581D8795E1%26defn%3D&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&tpay=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("BossId=3460&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&ftime="+System.currentTimeMillis()
                +"&vkey=B4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&cnlID=124227703");
        kvCommon("step=6&ptag=&iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227701&val1=0&ctime="+cTimeStr()+"&adid=&val=234&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2F218%2E75" +
                "%2E177%2E102%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F%2F124227701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&tpay=0");
        kvCommon("sRef=&app=live&cdn=zijian&progid=124227701&iQQ=294743258&adstat=0&str%5Fparam1=zijian" +
                "&HttpDownlandSpeed=0&flashver=MAC%2029%2E0%2E0%2E113&durl=http%3A%2F%2F218%2E75%2E177%2E102%3A8080" +
                "%2Fvzb%2Etc%2Eqq%2Ecom%2FB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F%2F124227701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&HttpDownSum=0&videopos=0&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&sIp=&clientip=&UDPDownSum=0&UDPUpSum=0&xserverip=&UpdataSpeed=0&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str%5Fparam2=218%2E75%2E177%2E102&PeerConnRate=0&live%5Ftype=8&svrCount=0&blockCount=0&iTy=1991&fullScreen=0&time="+System.currentTimeMillis()+"&P2PReDelay=0&p2pCount=0&SuNodDelay=0&lookback=0&averRemtime=0&cmd=205&pla=1&switch=0&averPeerMeHealth=0&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=163&SuperNodeIP=0&type=17&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=1&playtime=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&peerCount=0&downSpeed=1033&ispay=0&iFlow=0&viewid=&PeerServerIP=0&isuserpay=0&CDNAbnormal=0&dsip=218%2E75%2E177%2E102&playNo=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&livepid=48190&ReqSNBlockOutRange=0&maxSpeed=6264&playAd=0&reCnnCount=0&HashNotFinished=0&cnnTime=71&P2PVer=0&seq=0&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=530&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
        live_poll();
        kvCommon("BossId=3460&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&ftime="+System.currentTimeMillis()
                +"&vkey=B4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&cnlID=124227703");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=10&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=0E62976A602F81898111099052204FEDAB56898D&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&vid=124227701" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227701" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D1C9BD57B6659B9A9764E7FB93D06C1581D8795E1%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6385");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int1=0&itype=52&str1=&str3=&bid=pcvideo&vid=124227701&rnd=2837&str2=1%2E4%2E6&val2=&int2=0&str4=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=20&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=0E62976A602F81898111099052204FEDAB56898D&pid=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&vid=124227701" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227701" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D1C9BD57B6659B9A9764E7FB93D06C1581D8795E1%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6511");
        kvCommon("sRef=&adstat=4&cdn=zijian&progid=124227701&iQQ=294743258&app=live&str%5Fparam1=zijian" +
                "&HttpDownlandSpeed=0&flashver=MAC%2029%2E0%2E0%2E113&durl=http%3A%2F%2F218%2E75%2E177%2E102%3A8080" +
                "%2Fvzb%2Etc%2Eqq%2Ecom%2FB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F%2F124227701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&HttpDownSum=0&videopos=0&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&UDPUpSum=0&xserverip=&sIp=&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str%5Fparam2=218%2E75%2E177%2E102&PeerConnRate=0&live%5Ftype=8&svrCount=0&blockCount=0&iTy=1991&fullScreen=0&time="+System.currentTimeMillis()+"&P2PReDelay=0&p2pCount=0&SuNodDelay=0&lookback=0&averRemtime=0&cmd=263&pla=1&playerOnPlayTime=0&averPeerMeHealth=0&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&type=17&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=29&playtime=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&peerCount=0&downSpeed=344&ispay=0&iFlow=0&viewid=&PeerServerIP=0&isuserpay=0&CDNAbnormal=0&dsip=218%2E75%2E177%2E102&playNo=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&livepid=48190&ReqSNBlockOutRange=0&maxSpeed=0&playAd=0&reCnnCount=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq=1&returnBitmapErr=0&lookbackseq=0&switch=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s1706771681; ts_last=tga.qq.com/match/2018/pc_game.html");
        headers1.put("Host", "tga.qq.com");
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("BossId=3460&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&ftime" +
                    "="+System
                    .currentTimeMillis()+"&vkey=B4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&cnlID=124227703");
            sleep();
            kvCommon("sRef=&app=live&cdn=zijian&progid=124227701&iQQ=294743258&adstat=0&str%5Fparam1=zijian" +
                    "&HttpDownlandSpeed=0&flashver=MAC%2029%2E0%2E0%2E113&durl=http%3A%2F%2F218%2E75%2E177%2E102" +
                    "%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                    "%2FB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F%2F124227701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&HttpDownSum=0&videopos=0&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&UDPUpSum=0&xserverip=&sIp=&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str%5Fparam2=218%2E75%2E177%2E102&PeerConnRate=0&live%5Ftype=8&svrCount=0&blockCount=0&iTy=1991&fullScreen=0&time="+System.currentTimeMillis()+"&P2PReDelay=0&cmd=263&SuNodDelay=0&lookback=0&averRemtime=0&p2pCount=0&pla=1&playerOnPlayTime=0&averPeerMeHealth=0&type=17&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&blockTime=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=60&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=130&ispay=0&iFlow=0&viewid=&maxSpeed=0&isuserpay=0&CDNAbnormal=0&dsip=218%2E75%2E177%2E102&playNo=1C9BD57B6659B9A9764E7FB93D06C1581D8795E1&livepid=48190&ReqSNBlockOutRange=0&playAd=0&reCnnCount=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq="+seq+"&returnBitmapErr=0&lookbackseq=0&switch=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
            sleep();
            live_poll();
            sleep();
            kvCommon("BossId=3460&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&ftime" +
                    "="+System
                    .currentTimeMillis()+"&vkey=B4FB265ECD4852828F5BEE9BF1EF58E801C09528BC42F4F6A56EDE87E53A064934406B2C869A01681D82726FBB9AF36B9E2AE9C039CC4E701A788C7DC0A44124E785EB0338D7FC23F089B4E2AD3B39C16BCA07F314B7C51F&cnlID=124227703");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s1706771681");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s1706771681");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s1706771681");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&pollDataKey=pid%3D48190%26type%3D&qqlog=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcfm&apptype=live";
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


