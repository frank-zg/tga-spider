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
        kvCommon("progid=124227603&flashver=WIN&CheckSum=105821293&dc=5361&BossId=2583&iQQ=294743258&sRef=&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=");
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=3&BossId=3007&val1=0&Pwd=881273072&fplayerver" +
                "=30203007&val2=0&sid=124227603&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=0&surl=http" +
                "%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&vurl=&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&ptag=");
        kvCommon("iTy=2052&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=2566&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&itype=50&int1=0&str4=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227603&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=470&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=ABC4F8BFC6462A129DA4E620FEBE586D4FAB756A&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227603" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227603" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D22DA417C30448A78652DA379FC7E211FCB58DBD0%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9850");
        kvCommon("iTy=2052&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=8563&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&itype=50&int1=0&str4=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227603&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=64&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=ABC4F8BFC6462A129DA4E620FEBE586D4FAB756A&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227603" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227603" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D22DA417C30448A78652DA379FC7E211FCB58DBD0%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4631");
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=4&BossId=3007&val1=0&Pwd=881273072&fplayerver" +
                "=30203007&val2=0&sid=124227603&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=540&surl" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sRef=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&vurl=http%3A%2F" +
                "%2F175%2E6%2E26%2E39%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303%2F124227601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&ptag=");
        kvCommon("ftime="+System.currentTimeMillis()+"&cnl=124227603&iTy=2595&cts="+System.currentTimeMillis()
                /1000+"&vky" +
                "=0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&dip=zijian&cip=&avr=TencentPlayerLiveV3%2E2%2E3%2E07&uin=294743258&plt=1&evr=5%2E4&sdt=70202&cky=0KvARZcsbO8Ga1N9CMxu99mxavGxXdbY6K5jazeM0nHRPODwvOeQboIseIfW%5FduiazITJBwjaTHNs95wk847pxYhVWJqbw%5FsGYnYmIVmECUSS5kaYzGjKNMVi8%5FxRkMWTYSg2vmX005UG3tk7Vbxl6rRF1OblbFYNc14FPZoyNWfNbgtOnj7oQNZD10lIANMCO1Wmc97c%2DXLjFDcmY1hoDoH%5F5DPtrnvAdbsTiMwZet7zrGW7nIPJM1HODA2UHvLWcZNjG83A4bU9TLjHR3hMGwSXqsITtbt8VVSYLedw%2DieRxSERBd2og4AVb6tV%2DgDcep0KA");
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=1100&BossId=3007&val1=0&Pwd=881273072" +
                "&fplayerver=30203007&val2=0&sid=124227601&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val" +
                "=392&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fpla%3D0%26flashver%3D29%2C0%2C0%2C113%26queueStatus%3D0%26sdtfrom%3D70202%26livequeue%3D1%26encryptVer%3D5%2E4%26defn%3D%26flvtype%3D1%26rnd%3D423%26browser%3Dchrome%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dwzry%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26fntick%3D0%26vip%5Fstatus%3D0%26cKey%3D0KvARZcsbO8Ga1N9CMxu99mxavGxXdbY6K5jazeM0nHRPODwvOeQboIseIfW%5FduiazITJBwjaTHNs95wk847pxYhVWJqbw%5FsGYnYmIVmECUSS5kaYzGjKNMVi8%5FxRkMWTYSg2vmX005UG3tk7Vbxl6rRF1OblbFYNc14FPZoyNWfNbgtOnj7oQNZD10lIANMCO1Wmc97c%2DXLjFDcmY1hoDoH%5F5DPtrnvAdbsTiMwZet7zrGW7nIPJM1HODA2UHvLWcZNjG83A4bU9TLjHR3hMGwSXqsITtbt8VVSYLedw%2DieRxSERBd2og4AVb6tV%2DgDcep0KA%26system%3D3%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26txvjsv%3D2%26defauto%3D1%26rid%3D22DA417C30448A78652DA379FC7E211FCB58DBD0%26stream%3D2%26cmd%3D2%26cnlid%3D124227603&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&ptag=");
        kvCommon("ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&cnlID" +
                "=124227603&vkey=0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&platform=1");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;
        try {
        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=6&BossId=3007&val1=0&Pwd=881273072&fplayerver" +
                "=30203007&val2=0&sid=124227601&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=1262&surl" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sRef=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&vurl=http%3A%2F" +
                "%2F175%2E6%2E26%2E39%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303%2F124227601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&ptag=");
        kvCommon("flashver=MAC%2029%2E0%2E0%2E113&HttpDownSum=0&playAd=0&str%5Fparam1=zijian&HttpDownlandSpeed=0" +
                "&cnnPS=0&iQQ=294743258&durl=http%3A%2F%2F175%2E6%2E26%2E39%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303%2F124227601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&app=live&UDPDownSum=0&str%5Fparam2=175%2E6%2E26%2E39&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&videopos=0&sOp=webflash&xserverip=&sIp=&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&P2PReDelay=0&fullScreen=0&cmd=205&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=323&SuperNodeIP=0&peerCount=0&fullecode=10000&SuperNodePort=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&prdLength=4&playtime=0&PeerServerIP=0&time="+System.currentTimeMillis()+"&downSpeed=633&ispay=0&fplayerver=30203007&averPeerMeHealth=0&maxSpeed=8076&isuserpay=0&CDNAbnormal=0&cnnTime=939&livepid=48189&ReqSNBlockOutRange=0&switch=0&reCnnCount=0&HashNotFinished=0&playNo=22DA417C30448A78652DA379FC7E211FCB58DBD0&cdn=zijian&seq=0&iFlow=0&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=1834&P2PVer=0&blockHasData=0&PeerServerPort=0&transtype=0&sRef=&adstat=4&dsip=175%2E6%2E26%2E39&progid=124227601");
        live_poll();
        kvCommon("iTy=2052&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=4761&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&itype=52&int1=0&str4=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227601&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=112&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=977734FE84B472CDA4344AAA1D4765B15BB3F53C&pid=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227601" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227601" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D22DA417C30448A78652DA379FC7E211FCB58DBD0%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4680");
        kvCommon("iTy=2052&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=2427&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&itype=52&int1=0&str4=22DA417C30448A78652DA379FC7E211FCB58DBD0&vid=124227601&iSta=7");
        /*kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=60&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=ECBE4FD5732305A4D4BC65DD3E343CAF90255BA8&pid=9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC&vid=124208802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.1.00&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%206.1%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F56.0.2924.76%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124208802%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.1.00%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D9EB2DE81681A41CAEC34CF46E04F8D7DDB2DD9DC%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1395");*/
       
            for (int i = 1; i < videoTime; i++) {
                forEachRequest(i);
            }
        } catch (Exception e) {

        }finally{
        	
            //关闭下载线程
            if (stream != null) {
            	stream.interrupt();
                stream.stop();
                
            }
        	
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
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460" +
                    "&cnlID=124227603&vkey=0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&platform=1");
            sleep();
            kvCommon("flashver=MAC%2029%2E0%2E0%2E113&HttpDownSum=0&playAd=0&str%5Fparam1=zijian&HttpDownlandSpeed=0" +
                    "&cnnPS=0&iQQ=294743258&durl=http%3A%2F%2F175%2E6%2E26%2E39%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                    "%2F0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303%2F124227601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&adstat=4&time="+System.currentTimeMillis()+"&str%5Fparam2=175%2E6%2E26%2E39&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&sOp=webflash&xserverip=&sIp=&RtmfpInfo=0&videopos=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&iSta=0&P2PReDelay=0&fullScreen=0&cmd=263&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&peerCount=0&fullecode=10000&SuperNodePort=0&iFlow=0&prdLength=60&playtime=0&PeerServerIP=0&downSpeed=135&ispay=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&playNo=22DA417C30448A78652DA379FC7E211FCB58DBD0&livepid=48189&ReqSNBlockOutRange=0&switch=0&reCnnCount=0&HashNotFinished=0&cnnTime=0&cdn=zijian&seq="+seq+"&fplayerver=30203007&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=0&P2PVer=0&blockHasData=0&PeerServerPort=0&transtype=0&sRef=&app=live&dsip=175%2E6%2E26%2E39&progid=124227601");
            sleep();
            live_poll();
            sleep();
            kvCommon("ftime="+System.currentTimeMillis()+"&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460" +
                    "&cnlID=124227603&vkey=0F30640DFF3AE6445421D537FD0E3FC5481814A7CBBF4441D2A78E3C2F154F53B83CEF6E72354BC91A18C904900C7F29940D8A08FACC9146DCE7863E825611C110809D3C67E7ED2700E9E821C854598C379BD8EF74814303&platform=1");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258;");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258;");
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
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&pollDataKey=pid%3D48189%26type%3D&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dwzry&apptype=live";
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


