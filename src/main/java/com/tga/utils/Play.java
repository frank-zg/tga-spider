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

        kvCommon("progid=124227303&flashver=WIN&CheckSum=105821293&dc=7074&BossId=2583&iQQ=294743258&sRef=&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=");
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=3&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val1=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227303&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=0&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&vurl=&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&ptag=");
        kvCommon("str4=88D08EB8D229CB87EB45AC762F32CCCF8660C075&iTy=2052&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=4111&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&itype=50&int1=0&vid=124227303&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=482&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=E95F220C93B02489F98D5997BFF4C7789E71419D&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&vid=124227303" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227303" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D88D08EB8D229CB87EB45AC762F32CCCF8660C075%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3465");
        kvCommon("str4=88D08EB8D229CB87EB45AC762F32CCCF8660C075&iTy=2052&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=1020&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&itype=50&int1=0&vid=124227303&iSta=7");
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=4&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val1=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227303&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=666&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc" +
                "%5Findex%2Ehtml&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=0&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&vurl=http%3A%2F%2F175%2E6" +
                "%2E13%2E189%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50%2F124227301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&ptag=");
        kvCommon("plt=1&cnl=124227303&iTy=2595&avr=TencentPlayerLiveV3%2E2%2E3%2E07&vky" +
                "=FBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&cky=PEUe6XvCskMGa1N9CMxu99mxavGxXdbY6K5jazeM0nF%5F04kprTFEE3h%5FhIUXuM31nUwal8PYJEUW1fCymjmkxctetwpXsTBwChIAHcER2UI2tc9%5F2pOMKG5AainWBwew%2D%5FpvHvwZ5t8fz7%5FNpWm4KZn0jItcQAMNl%2DxijNDBxRmQoZOAPAp9mwSh4GQnhf5ua%5F712UCL0p%5Fz0AZoI8fUFS0Z6uk8OWetOYJgQUyQNlKkn%5FeTRZm9Wx2nW%5FJNgSj2sDJlzs9Vd2ycUkPsNhevRblKcxUufYwLtjH8lteBx6FPHCDW3qRy5wBSPE%2De3yIqNEVGvQ&dip=zijian&cip=&sdt=70202&uin=294743258&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&evr=5%2E4&ftime="+System.currentTimeMillis()+"&cts="+System.currentTimeMillis()/1000);
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=1100&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val1=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227301&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=534&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fpla%3D0%26flashver%3D29%2C0%2C0%2C113%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26sdtfrom%3D70202%26livequeue%3D1%26system%3D3%26flvtype%3D1%26defn%3D%26cKey%3DPEUe6XvCskMGa1N9CMxu99mxavGxXdbY6K5jazeM0nF%5F04kprTFEE3h%5FhIUXuM31nUwal8PYJEUW1fCymjmkxctetwpXsTBwChIAHcER2UI2tc9%5F2pOMKG5AainWBwew%2D%5FpvHvwZ5t8fz7%5FNpWm4KZn0jItcQAMNl%2DxijNDBxRmQoZOAPAp9mwSh4GQnhf5ua%5F712UCL0p%5Fz0AZoI8fUFS0Z6uk8OWetOYJgQUyQNlKkn%5FeTRZm9Wx2nW%5FJNgSj2sDJlzs9Vd2ycUkPsNhevRblKcxUufYwLtjH8lteBx6FPHCDW3qRy5wBSPE%2De3yIqNEVGvQ%26rnd%3D894%26browser%3Dchrome%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Findex%2Ehtml%26encryptVer%3D5%2E4%26fntick%3D0%26vip%5Fstatus%3D0%26cnlid%3D124227303%26cmd%3D2%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26txvjsv%3D2%26defauto%3D1%26rid%3D88D08EB8D229CB87EB45AC762F32CCCF8660C075%26stream%3D2%26queueStatus%3D0&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&ptag=");
        kvCommon("cnlID=124227303&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&platform=1&vkey" +
                "=FBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&ftime="+System.currentTimeMillis()+"&BossId=3460");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("iQQ=294743258&flashver=MAC%2029%2E0%2E0%2E113&step=6&BossId=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val1=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124227301&p2pver=0&ctime="+cTimeStr()+"&adid=&sdtfrom=70202&iTy=3007&val=1127&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc" +
                "%5Findex%2Ehtml&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=0&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&vurl=http%3A%2F%2F175%2E6" +
                "%2E13%2E189%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50%2F124227301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&ptag=");
        kvCommon("flashver=MAC%2029%2E0%2E0%2E113&HttpDownSum=0&playAd=0&str%5Fparam1=zijian&HttpDownlandSpeed=0" +
                "&cnnPS=0&iQQ=294743258&durl=http%3A%2F%2F175%2E6%2E13%2E189%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50%2F124227301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&app=live&UDPDownSum=0&str%5Fparam2=175%2E6%2E13%2E189&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&videopos=0&sOp=webflash&xserverip=&sIp=&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&P2PReDelay=0&fullScreen=0&cmd=205&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=317&SuperNodeIP=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&fullecode=10000&SuperNodePort=0&fplayerver=30203007&switch=0&playtime=0&PeerServerIP=0&time="+System.currentTimeMillis()+"&downSpeed=551&dsip=175%2E6%2E13%2E189&iFlow=0&prdLength=4&averPeerMeHealth=0&maxSpeed=7136&isuserpay=0&CDNAbnormal=0&ispay=0&peerCount=0&livepid=48183&ReqSNBlockOutRange=0&cdn=zijian&reCnnCount=0&HashNotFinished=0&cnnTime=810&P2PVer=0&seq=0&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=1824&playNo=88D08EB8D229CB87EB45AC762F32CCCF8660C075&blockHasData=0&PeerServerPort=0&transtype=0&sRef=&adstat=4&progid=124227301");
        live_poll();
        kvCommon("tr4=88D08EB8D229CB87EB45AC762F32CCCF8660C075&iTy=2052&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=9637&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&itype=52&int1=0&vid=124227301&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=116&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=2F0198353982ABB5EE042FAB690103306350DF28&pid=88D08EB8D229CB87EB45AC762F32CCCF8660C075&vid=124227301" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.162%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124227301" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D88D08EB8D229CB87EB45AC762F32CCCF8660C075%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9673");
        kvCommon("str4=88D08EB8D229CB87EB45AC762F32CCCF8660C075&iTy=2052&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&str2=1%2E4%2E6&rnd=1982&bid=pcvideo&val2=&str1=&str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&itype=52&int1=0&vid=124227301&iSta=7");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s1706771681; ts_last=tga.qq.com/match/2017/pc_index.html");
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
            kvCommon("cnlID=124227303&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&platform=1&vkey" +
                    "=FBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&ftime="+System.currentTimeMillis()+"&BossId=3460");
            sleep();
            kvCommon("flashver=MAC%2029%2E0%2E0%2E113&HttpDownSum=0&playAd=0&str%5Fparam1=zijian&HttpDownlandSpeed=0" +
                    "&iQQ=294743258&durl=http%3A%2F%2F175%2E6%2E13%2E189%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                    "%2FFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50%2F124227301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+ System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&adstat=4&time="+System.currentTimeMillis()+"&str%5Fparam2=175%2E6%2E13%2E189&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&sOp=webflash&xserverip=&sIp=&RtmfpInfo=0&videopos=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&PeerConnRate=0&iTy=1991&iSta=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&svrCount=0&P2PReDelay=0&fullScreen=0&cmd=263&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&fullecode=10000&SuperNodePort=0&fplayerver=30203007&switch=0&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=175&dsip=175%2E6%2E13%2E189&iFlow=0&prdLength=59&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&ispay=0&playNo=88D08EB8D229CB87EB45AC762F32CCCF8660C075&livepid=48183&ReqSNBlockOutRange=0&cdn=zijian&reCnnCount=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq="+seq+"&returnBitmapErr=0&lookbackseq=0&playerOnPlayTime=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0&sRef=&app=live&progid=124227301");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124227303&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&Pwd=779660211&platform=1&vkey" +
                    "=FBC857A3F0CA1B47CBF5D8B6583DF9503369B8845FB6DB2959A27A5248C9581BEE1E029B0B7F93133EF94F4AE74D2FBD21ADEFBA0B02CDB983C154B97E0E0F40E16DB4A7BF584504DA159A6CECAF086489FF08423CBBAA50&ftime="+System.currentTimeMillis()+"&BossId=3460");
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
        headers.put("Host", "tga.qq.com");
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
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
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&pollDataKey=pid%3D48183%26type%3D&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&qqlog=&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index.html&apptype=live";
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
            conn.addRequestProperty("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
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


