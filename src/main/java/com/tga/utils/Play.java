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


        kvCommon("flashver=WIN&progid=124223102&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&P2PVer=&BossId=2583&dc=9532&sRef=&iQQ=125826029&CheckSum=105821293");
        kvCommon("val2=0&step=3&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&val=0&p2pver=0&BossId=3007&ptag=&Pwd=881273072" +
                "&vurl=&sid=124223102&adid=&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&ctime="+cTimeStr()+"&iQQ" +
                "=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon("bid=pcvideo&str2=1%2E4%2E6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&itype=50&int1=0&rnd=648&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str4=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&int2=0&str1=&vid=124223102&val2=&iSta=7&val=100&str3=&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=69&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=E0DFC7971B76F5C3F206A1F85DEAD3AAD2B28302&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DA6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3121");
        kvCommon("bid=pcvideo&str2=1%2E4%2E6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&itype=50&int1=0&rnd=5087&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str4=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&int2=1&str1=&vid=124223102&val2=&iSta=7&val=100&str3=&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=479&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=E0DFC7971B76F5C3F206A1F85DEAD3AAD2B28302&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DA6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=379");
//        regist();

        kvCommon("val2=0&step=4&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&val=534&p2pver=0&BossId=3007&ptag=&Pwd=881273072" +
                "&vurl=http%3A%2F%2F124%2E232%2E162%2E109%3A8080" +
                "%2FEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&sid=124223102&adid=&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&ctime="+cTimeStr()+"&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");

        kvCommon
                ("vky=EE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&iTy=2595&cnl=124223102&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&evr=5%2E4&uin=125826029&cts="+System.currentTimeMillis()/1000+"&plt=1&dip=zijian&sdt=10202&cip=&ftime="+System.currentTimeMillis()+"&avr=TencentPlayerLiveV3%2E2%2E3%2E06&cky=%2DdI0CrpVmKAGa1N9CMxu99mxavGxXdbY5aRSR5GRGMlbLz5JguBPybww55yIFHg3NTzeVtajy5UQc0D0uJhCOH8EOLpVj6WeRzwDNDrhUJ9x%5FRrLuHRGYjcH0Pmz%5FQVMqP9IiPi2SKcpVn2P9t2siumqhz2XrFsuNYjb7gBs9DCXFsRlYjongOR%2DjY17TLaoWMFYoZCII5D5NvTNUjMW3pHfW5Fl9ENLxX8RWRDBXa7%5F6tVTbTlkH6tUREM5XvSaf27XpAJHwLJPfQ%2DQ677QoEYzJI3octXbMKhf7YEuQV4HCQ24MB07UqGOaZ9cgdr1ajWi3w");
        kvCommon("val2=0&step=1100&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml" +
                "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&val=391&p2pver=0&BossId=3007&ptag=&Pwd" +
                "=881273072&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fflvtype%3D1%26queueStatus%3D0%26vip" +
                "%5Fstatus%3D0%26cmd%3D2%26system%3D3%26encryptVer%3D5%2E4%26cKey%3D" +
                "%2DdI0CrpVmKAGa1N9CMxu99mxavGxXdbY5aRSR5GRGMlbLz5JguBPybww55yIFHg3NTzeVtajy5UQc0D0uJhCOH8EOLpVj6WeRzwDNDrhUJ9x%5FRrLuHRGYjcH0Pmz%5FQVMqP9IiPi2SKcpVn2P9t2siumqhz2XrFsuNYjb7gBs9DCXFsRlYjongOR%2DjY17TLaoWMFYoZCII5D5NvTNUjMW3pHfW5Fl9ENLxX8RWRDBXa7%5F6tVTbTlkH6tUREM5XvSaf27XpAJHwLJPfQ%2DQ677QoEYzJI3octXbMKhf7YEuQV4HCQ24MB07UqGOaZ9cgdr1ajWi3w%26rid%3DA6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26sdtfrom%3D10202%26browser%3Dchrome%26rnd%3D742%26pla%3D0%26defauto%3D1%26livepid%3D40925%26host%3Dhttp%253A%252F%252Fv%2Eqq%2Ecom%252Flive%252Fp%252Ftopic%252F40925%252Findex%2Ehtml%26cnlid%3D124223102%26livequeue%3D1%26flashver%3D27%2C0%2C0%2C187%26fntick%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06%26defn%3D%26txvjsv%3D2%26stream%3D2&sid=124223102&adid=&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&ctime="+cTimeStr()+"&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon
                ("platform=1&vkey=EE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&cnlID=124223102&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&Pwd=779660211&BossId=3460");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvGetCommon("http://btrace.video.qq.com/kvcollect?BossId=3098&Pwd=390647416&oper=25&main_type=&uin=0&host=v.qq.com&url=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex.html&_dc=0.6710380502831816");
        kvCommon("val2=0&step=6&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&val=5207&p2pver=0&BossId=3007&ptag=&Pwd=881273072" +
                "&vurl=http%3A%2F%2F124%2E232%2E162%2E109%3A8080" +
                "%2FEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&sid=124223102&adid=&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&ctime="+cTimeStr()+"&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon("live%5Ftype=8&StartP2P=0&time="+System.currentTimeMillis()+"&fplayerver=30203006&flashver=MAC%2027%2E0%2E0%2E187" +
                "&cnnTime=4854&reCnnCount=0&lookback=0&durl=http%3A%2F%2F124%2E232%2E162%2E109%3A8080" +
                "%2FEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&p2pCount=0&lookbackseq=0&fullScreen=0&playerOnPlayTime=5772&seq=0&blockHasData=0&transtype=0&videopos=0&HashNotFinished=0&clientip=&sIp=&HttpDownSum=0&iQQ=125826029&HttpDownlandSpeed=0&UDPDownlandSpeed=0&sBiz=zhibo&switch=0&xserverip=&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=205&SuperNodePort=0&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&CDNAbnormal=0&P2PVer=0&playAd=0&iTy=1991&adstat=4&cnnPS=0&type=17&viewid=&loadingTime=353&dsip=124%2E232%2E162%2E109&progid=124223102&blockCount=0&playNo=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&PeerServerIP=0&blockTime=0&str%5Fparam2=124%2E232%2E162%2E109&averRemtime=0&cdn=zijian&errorCode=10000&peerCount=0&livepid=40925&fullecode=10000&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&str%5Fparam1=zijian&pla=1&prdLength=8&ReqSNBlockOutRange=0&app=live&downSpeed=181&SuNodDelay=0&P2PReDelay=0&maxSpeed=4179&averPeerMeHealth=0");
        live_pollx();
        kvCommon("ever=undefined&err%5Ftype=0&iFlow=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102&platform=2&ver=158&play%5Ftype=2&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&BossId=2790&rcode=0&Pwd=639535403&all%5Ftime=202&moduleid=6");
        kvCommon("ever=undefined&err%5Ftype=0&iFlow=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102&platform=2&ver=158&play%5Ftype=2&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&BossId=2790&rcode=0&Pwd=639535403&all%5Ftime=339&moduleid=8");
        live_poll();
        kvCommon("bid=pcvideo&str2=1%2E4%2E6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&itype=52&int1=0&rnd=6367&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str4=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&int2=0&str1=&vid=124223102&val2=&iSta=7&val=100&str3=&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=12&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=086CB27610ACE536006168DB53BDD367EB3A6D65&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DA6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3959");
        kvCommon("bid=pcvideo&str2=1%2E4%2E6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&itype=52&int1=0&rnd=5867&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str4=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&int2=1&str1=&vid=124223102&val2=&iSta=7&val=100&str3=&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=27&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=086CB27610ACE536006168DB53BDD367EB3A6D65&pid=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DA6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9151");
        live_poll();
        live_poll();
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ts_refer=www.google.com.hk/; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; ts_last=v.qq.com/live/p/topic/40925/index.html; pgv_pvid=672048110; o_cookie=125826029; ts_uid=9320616880; ptag=|live");
        headers1.put("Host", "v.qq.com");
//        headers1.put("Referer", "https://mail.qq.com/");
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void regist(){
        String body = "programid=40929&type=1&name=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&title=live%20video%20title";
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s3902629128; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "bullet.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive" +
                ".swf?max_age=86400&v="+System.currentTimeMillis());
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/27.0.0.187");
        HttpUtil.post("http://bullet.video.qq.com/fcgi-bin/target/regist", body, headers, exceptionStatus, timeout);
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
            kvCommon
                    ("platform=1&vkey=EE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&cnlID=124223102&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&Pwd=779660211&BossId=3460");
            kvCommon("live%5Ftype=8&StartP2P=0&time="+System.currentTimeMillis()+"&fplayerver=30203006&flashver=MAC%2027%2E0%2E0" +
                    "%2E187&cnnTime=0&reCnnCount=0&lookback=0&durl=http%3A%2F%2F124%2E232%2E162%2E109%3A8080" +
                    "%2FEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&p2pCount=0&lookbackseq=0&fullScreen=0&playerOnPlayTime=0&seq=1&blockHasData=0&transtype=0&videopos=0&HashNotFinished=0&clientip=&sIp=&HttpDownSum=0&iQQ=125826029&HttpDownlandSpeed=0&UDPDownlandSpeed=0&sBiz=zhibo&switch=0&xserverip=&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=263&SuperNodePort=0&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&CDNAbnormal=0&P2PVer=0&playAd=0&iTy=1991&adstat=4&cnnPS=0&type=17&viewid=&loadingTime=0&dsip=124%2E232%2E162%2E109&progid=124223102&blockCount=0&playNo=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&PeerServerIP=0&blockTime=0&str%5Fparam2=124%2E232%2E162%2E109&averRemtime=0&cdn=zijian&errorCode=10000&peerCount=0&livepid=40925&fullecode=10000&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&str%5Fparam1=zijian&pla=1&prdLength=60&ReqSNBlockOutRange=0&app=live&downSpeed=285&SuNodDelay=0&P2PReDelay=0&maxSpeed=0&averPeerMeHealth=0");
            sleep();
            live_poll();
            live_pollx();
            sleep();
            kvCommon("ever=undefined&err%5Ftype=0&iFlow=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102&platform=2&ver=158&play%5Ftype=2&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&BossId=2790&rcode=0&Pwd=639535403&all%5Ftime=102&moduleid=8");
            kvCommon
                    ("platform=1&vkey=EE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&cnlID=124223102&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&Pwd=779660211&BossId=3460");
            sleep();
            live_poll();
            kvCommon("ever=undefined&err%5Ftype=0&iFlow=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&vid=124223102&platform=2&ver=158&play%5Ftype=2&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&BossId=2790&rcode=0&Pwd=639535403&all%5Ftime=99&moduleid=8");
            sleep();
            kvCommon("live%5Ftype=8&StartP2P=0&time="+System.currentTimeMillis()+"&fplayerver=30203006&flashver=MAC%2027%2E0%2E0%2E187" +
                    "&cnnTime=0&reCnnCount=0&lookback=0&durl=http%3A%2F%2F124%2E232%2E162%2E109%3A8080" +
                    "%2FEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DEE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&p2pCount=0&lookbackseq=0&fullScreen=0&playerOnPlayTime=0&seq=2&blockHasData=0&transtype=0&videopos=0&HashNotFinished=0&clientip=&sIp=&HttpDownSum=0&iQQ=125826029&HttpDownlandSpeed=0&UDPDownlandSpeed=0&sBiz=zhibo&switch=0&xserverip=&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=263&SuperNodePort=0&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&CDNAbnormal=0&P2PVer=0&playAd=0&iTy=1991&SuNodDelay=0&cnnPS=0&type=17&viewid=&loadingTime=0&dsip=124%2E232%2E162%2E109&progid=124223102&blockCount=0&playNo=A6105D13C2BE205449E4C3EE2D9BCFE4C9B12CE6&PeerServerIP=0&blockTime=0&str%5Fparam2=124%2E232%2E162%2E109&averRemtime=0&cdn=zijian&errorCode=10000&peerCount=0&livepid=40925&fullecode=10000&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40925%2Findex%2Ehtml&str%5Fparam1=zijian&pla=1&prdLength=60&ReqSNBlockOutRange=0&app=live&downSpeed=197&adstat=0&P2PReDelay=0&maxSpeed=0&averPeerMeHealth=0");
            live_poll();
            sleep();
            kvCommon
                    ("platform=1&vkey=EE8CE35F3290AB2A5F7CCE650DB779F2CE89E3827FE47A3C3F09F1A485D0143352B095EABF727E95306AB7CC62F6D52AE183EF6B82FB12EC7033F83234DC39016D0F529EE92F255388B5AFA414652024A55B7EC20C5A2484&cnlID=124223102&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&Pwd=779660211&BossId=3460");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; pgv_pvid=672048110; o_cookie=125826029");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/27.0.0.187");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; pgv_pvid=672048110; o_cookie=125826029");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive" +
                ".swf?max_age=86400&v="+ System.currentTimeMillis());
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/27.0.0.187");
        HttpUtil.post(KV_URL, body, headers, exceptionStatus, timeout);
    }

    public void live_poll() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; pgv_pvid=672048110; o_cookie=125826029");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get("http://live.mobile.video.qq" +
                ".com/fcgi-bin/live_poll?callback=livepoll&low_login=1&guid=104&pollDataKey=pid%3D40925&qqlog" +
                "=1632485840&otype=json&_="+System.currentTimeMillis(), headers, exceptionStatus, timeout);
    }

    public void live_pollx() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; pgv_pvid=672048110; o_cookie=125826029");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/27.0.0.187");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&pollDataKey=pid%3D40925%26type%3D&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&qqlog=&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40925%2Findex.html&apptype=live";
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
            conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/27.0.0.187");
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


