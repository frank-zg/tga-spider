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


        kvCommon("progid=124223502&P2PVer=&flashver=WIN&dc=4375&iQQ=408404664&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&BossId=2583&CheckSum=105821293&sRef=");
        kvCommon("step=3&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&p2pver=0&P2PVer=0" +
                "&BossId=3007&Pwd=881273072&val=0&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&sid=124223502&adid" +
                "=&ctime="+cTimeStr()+"&vurl=&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929" +
                "%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("itype=50&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&str2=1%2E4%2E6&iTy=2052&str4=85D2404AD61C507BCAB586A2F96B50890314C35C&val=100&int1=0&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E06&bid=pcvideo&str3=&str1=&rnd=6660&vid=124223502&val2=&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=97&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=4F3A5B3B592D1B73E8CFC8DFDCFA918E473749FC&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&vid=124223502" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Din%26pt%3D0%26pc%3D0%26vid" +
                "%3D124223502%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D85D2404AD61C507BCAB586A2F96B50890314C35C%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq" +
                ".com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html%26refer%3D%26st%3D0&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7384");
        kvCommon("itype=50&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&str2=1%2E4%2E6&iTy=2052&str4=85D2404AD61C507BCAB586A2F96B50890314C35C&val=100&int1=0&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E06&bid=pcvideo&str3=&str1=&rnd=9726&vid=124223502&val2=&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=421&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=4F3A5B3B592D1B73E8CFC8DFDCFA918E473749FC&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&vid=124223502" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Din%26pt%3D0%26pc%3D0%26vid" +
                "%3D124223502%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D85D2404AD61C507BCAB586A2F96B50890314C35C%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq" +
                ".com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2871");
        regist();

        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=1&err%5Ftype=0&all%5Ftime=736&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");

        kvCommon("step=4&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&p2pver=0&P2PVer=0" +
                "&BossId=3007&Pwd=881273072&val=1131&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&sid=124223502&adid" +
                "=&ctime="+cTimeStr()+"&vurl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080" +
                "%2F37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A%2F124223502%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("step=5&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&p2pver=0&vurl=http" +
                "%3A%2F%2F218%2E75%2E176%2E190%3A8080" +
                "%2FDF9521656366814BFD50490660DD460DFC45394276162645C71AE80BBED414EE52DDA52011C01DF0283613CA32B7D1048DCD968FC2D2D1B505533D32F67F66965FD11DD42F85FAA8860A81D65CA854795667DD36E1FEA27A%2F124223502%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DDF9521656366814BFD50490660DD460DFC45394276162645C71AE80BBED414EE52DDA52011C01DF0283613CA32B7D1048DCD968FC2D2D1B505533D32F67F66965FD11DD42F85FAA8860A81D65CA854795667DD36E1FEA27A&BossId=3007&Pwd=881273072&P2PVer=0&pid=8F9079CCD4EBED9B46311AFA4A1E51FB597AFE98&sid=124223502&adid=&ctime="+cTimeStr()+"&val=60176&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("step=5&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&P2PVer=0&vurl=http" +
                "%3A%2F%2F124%2E232%2E162%2E102%3A8080" +
                "%2F94F7FDAA8DD5E6AF86FB2395ED21F3789678EB98E069B537DAA0A55EE5D7CB0198A01E7E870F5D398A642CCEE5618E0F3A5E50E99FFAA2B240BAA6C9862494E893F33CDD006F3692EF15F5D285FEA75C6E6A38E276FA2A85%2F124223502%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D94F7FDAA8DD5E6AF86FB2395ED21F3789678EB98E069B537DAA0A55EE5D7CB0198A01E7E870F5D398A642CCEE5618E0F3A5E50E99FFAA2B240BAA6C9862494E893F33CDD006F3692EF15F5D285FEA75C6E6A38E276FA2A85&BossId=3007&Pwd=881273072&val=360068&pid=38B2C96DF49CC4F0D989C4DC69124F53E1B430D4&sid=124223502&adid=&ctime="+cTimeStr()+"&p2pver=0&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("cnl=124223502&uin=408404664&vky" +
                "=37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A&cky=fsIJ4DlFpUoGa1N9CMxu99mxavGxXdbY5aRSR5GRGMmH2ZvZdJej6gK0IbGPd1Z4KkZcUM52feSlGAUoYiu6P6o2Hhr8WYyYHtvWboKZ%2DINCeORewdRcT%5FMnZPZ3tV2%5FycqfRSdrXjWMMr%2D1mxd6cx5%5Fw4i8sH9kZ25cAwVVkXbNkGNl%5FWtdDjWe8lSUEYhp%5FNbOwdVy24cz09SY5vj8RwPoTtEjFtwTshB5h6ini8rBe%5Fsbq%5FR5iSCdhFnnGP%5Fro56x8uLBKBOlT8vLalLIjDi3Tb%5FByKq8tWnoDnAyS02rN1aGeQK6PTZ0zB1YcqNeN%5FFjWw&iTy=2595&cip=218%2E77%2E106%2E136&sdt=10202&dip=zijian&avr=TencentPlayerLiveV3%2E2%2E3%2E06&cts="+System.currentTimeMillis()/1000+"&gid=59BE71766CC9239F7799DD0E3717A38635876F66&plt=1&evr=5%2E4&ftime="+System.currentTimeMillis());
        kvCommon("step=1100&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&p2pver=0&P2PVer=0" +
                "&BossId=3007&Pwd=881273072&val=420&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&sid=124223502&adid" +
                "=&ctime="+cTimeStr()+"&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fbrowser%3Dchrome" +
                "%26queueStatus%3D0%26txvjsv%3D2%26cKey%3DfsIJ4DlFpUoGa1N9CMxu99mxavGxXdbY5aRSR5GRGMmH2ZvZdJej6gK0IbGPd1Z4KkZcUM52feSlGAUoYiu6P6o2Hhr8WYyYHtvWboKZ%2DINCeORewdRcT%5FMnZPZ3tV2%5FycqfRSdrXjWMMr%2D1mxd6cx5%5Fw4i8sH9kZ25cAwVVkXbNkGNl%5FWtdDjWe8lSUEYhp%5FNbOwdVy24cz09SY5vj8RwPoTtEjFtwTshB5h6ini8rBe%5Fsbq%5FR5iSCdhFnnGP%5Fro56x8uLBKBOlT8vLalLIjDi3Tb%5FByKq8tWnoDnAyS02rN1aGeQK6PTZ0zB1YcqNeN%5FFjWw%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06%26vip%5Fstatus%3D0%26flvtype%3D1%26guid%3D59BE71766CC9239F7799DD0E3717A38635876F66%26cmd%3D2%26stream%3D2%26host%3Dhttp%253A%252F%252Fv%2Eqq%2Ecom%252Flive%252Fp%252Ftopic%252F40929%252Findex%2Ehtml%26rid%3D85D2404AD61C507BCAB586A2F96B50890314C35C%26system%3D0%26sdtfrom%3D10202%26defn%3D%26fntick%3D0%26pla%3D0%26encryptVer%3D5%2E4%26defauto%3D1%26livepid%3D40929%26cnlid%3D124223502%26rnd%3D100%26livequeue%3D1%26flashver%3D27%2C0%2C0%2C187&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("platform=1&Pwd=779660211&cnlID=124223502&guid=59BE71766CC9239F7799DD0E3717A38635876F66&BossId=3460" +
                "&ftime="+System
                .currentTimeMillis()+"&vkey=37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("step=6&fplayerver=30203006&iTy=3007&val2=0&ptag=&guid=59BE71766CC9239F7799DD0E3717A38635876F66" +
                "&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&p2pver=0&P2PVer=0" +
                "&BossId=3007&Pwd=881273072&val=4107&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&sid=124223502&adid" +
                "=&ctime="+cTimeStr()+"&vurl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080" +
                "%2F37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A%2F124223502%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A&iQQ=408404664&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&flashver=WIN%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml");
        kvCommon("fplayerver=30203006&time="+System.currentTimeMillis()+"&live%5Ftype=8&StartP2P=0&durl=http%3A%2F%2F124%2E232%2E155" +
                "%2E155%3A8080%2F37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A%2F124223502%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A&averPeerMeHealth=0&maxSpeed=420&switch=0&cnnTime=779&reCnnCount=0&lookback=0&p2pCount=0&lookbackseq=0&playAd=0&playerOnPlayTime=5314&seq=0&blockHasData=0&transtype=0&videopos=0&fullScreen=0&HashNotFinished=0&HttpDownlandSpeed=0&sIp=&HttpDownSum=0&iQQ=408404664&clientip=&UDPDownlandSpeed=0&sBiz=zhibo&str%5Fparam2=124%2E232%2E155%2E155&xserverip=&UDPDownSum=0&sOp=webflash&type=17&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=205&iTy=1991&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&CDNAbnormal=0&guid=59BE71766CC9239F7799DD0E3717A38635876F66&P2PVer=0&P2PReDelay=0&SuperNodePort=0&adstat=4&dsip=124%2E232%2E155%2E155&playNo=85D2404AD61C507BCAB586A2F96B50890314C35C&viewid=&loadingTime=3328&cdn=zijian&progid=124223502&PeerServerPort=0&blockCount=0&PeerServerIP=0&blockTime=0&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&ReqSNBlockOutRange=0&errorCode=10000&peerCount=0&livepid=40929&fullecode=10000&averRemtime=0&str%5Fparam1=zijian&pla=1&prdLength=9&cnnPS=0&app=live&downSpeed=156&SuNodDelay=0&flashver=WIN%2027%2E0%2E0%2E187");
        live_poll();
        live_pollx();
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=6&err%5Ftype=0&all%5Ftime=153&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=337&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=110&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
        live_poll();
        kvCommon("itype=52&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&str2=1%2E4%2E6&iTy=2052&str4=85D2404AD61C507BCAB586A2F96B50890314C35C&val=100&int1=0&int2=0&ver=TencentPlayerLiveV3%2E2%2E3%2E06&bid=pcvideo&str3=&str1=&rnd=5334&vid=124223502&val2=&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=21&val1=2&val2=604&val3=&val4=&val5=&apid=1AD68E93495847A319AD0F8C7DE79876E73E7FD9&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&vid=124223502&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223502%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D85D2404AD61C507BCAB586A2F96B50890314C35C%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html%26refer%3D&reporttime=2017-11-16%2015:00:53%20849&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3004");
        kvCommon("itype=52&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&str2=1%2E4%2E6&iTy=2052&str4=85D2404AD61C507BCAB586A2F96B50890314C35C&val=100&int1=0&int2=1&ver=TencentPlayerLiveV3%2E2%2E3%2E06&bid=pcvideo&str3=&str1=&rnd=5397&vid=124223502&val2=&iSta=7");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=93&val1=2&val2=604&val3=&val4=&val5=&apid=1AD68E93495847A319AD0F8C7DE79876E73E7FD9&pid=85D2404AD61C507BCAB586A2F96B50890314C35C&vid=124223502&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223502%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D85D2404AD61C507BCAB586A2F96B50890314C35C%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html%26refer%3D%26retry%3D1&reporttime=2017-11-16%2015:00:53%20946&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2816");
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=110&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=110&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
        live_poll();
        kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=105&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
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
        headers1.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; ts_refer=sports.qq.com/a/20171115/018806.htm; ts_uid=1730588920; pgv_pvid=1118471560; o_cookie=408404664");
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
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=106&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
            kvCommon("platform=1&Pwd=779660211&cnlID=124223502&guid=59BE71766CC9239F7799DD0E3717A38635876F66&BossId" +
                    "=3460&ftime="+System
                    .currentTimeMillis()+"&vkey=37FBB84FDD1ACAB8E57B2FE5E8A348A7E3CE6DF0766D108593EE921CDF7DFD60902000A1FADD578302F4BE749BE8C6AB5F89784FB465704A784959A53F9B325EA222BC61B33CC641A2089C6DE9B2BC6028192B784FA5232A");
            sleep();
            live_poll();
            live_pollx();
            sleep();
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=106&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=108&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
            sleep();
            live_poll();
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=104&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
            sleep();
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=108&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
            live_poll();
            sleep();
            kvCommon("Pwd=639535403&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&moduleid=8&err%5Ftype=0&all%5Ftime=105&platform=1&rcode=0&ever=undefined&ver=158&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40929%2Findex%2Ehtml&play%5Ftype=2&iFlow=85D2404AD61C507BCAB586A2F96B50890314C35C&BossId=2790&vid=124223502");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s3902629128; pgv_pvid=1118471560; o_cookie=408404664");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s3902629128; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s3902629128; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get("http://live.mobile.video.qq" +
                ".com/fcgi-bin/live_poll?callback=livepoll&low_login=1&guid=104&pollDataKey=pid%3D40929&qqlog" +
                "=1632485840&otype=json&_="+System.currentTimeMillis(), headers, exceptionStatus, timeout);
    }

    public void live_pollx() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9739225135");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/27.0.0.187");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=59BE71766CC9239F7799DD0E3717A38635876F66&qqlog=&needmark=1&pollDataKey=pid%3D40929%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=59BE71766CC9239F7799DD0E3717A38635876F66&refer=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40929%2Findex.html&apptype=live";
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


