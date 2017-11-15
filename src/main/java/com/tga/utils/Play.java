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

        kvCommon("flashver=WIN&progid=124223002&P2PVer=&sRef=&iQQ=125826029&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&CheckSum=105821293&BossId=2583&dc=4158");
        kvCommon("adid=&sid=124223002&Pwd=881273072&ctime="+cTimeStr()+"&vurl=&iQQ=125826029&val=0&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&sdtfrom=70202&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&iTy=3007&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&flashver=MAC%2027%2E0%2E0%2E183&ptag=&fplayerver=30203006&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&step=3&p2pver=0&BossId=3007");
        kvCommon("val2=&iSta=7&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&iTy=2052&str3=&str4=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002&rnd=7237&itype=50&int2=0&int1=0&bid=pcvideo&val=100&str1=&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=74&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=77BF19B77A7A283ABC9C5C7D16A5A010DA7884A9&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DD7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5124");
        kvCommon("ival2=&iSta=7&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&iTy=2052&str3=&str4=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002&rnd=5089&itype=50&int2=1&int1=0&bid=pcvideo&val=100&str1=&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=43&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=77BF19B77A7A283ABC9C5C7D16A5A010DA7884A9&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DD7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9937");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=77BF19B77A7A283ABC9C5C7D16A5A010DA7884A9&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8097");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?pf=out&dura=0&pid2=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&reqtime" +
                "="+System.currentTimeMillis()/1000+"&step=1&t=30000");
        kvCommon("adid=&sid=124223002&Pwd=881273072&ctime="+cTimeStr()+"&vurl=&iQQ=125826029&val=0&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&sdtfrom=70202&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&iTy=3007&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&flashver=MAC%2027%2E0%2E0%2E183&ptag=&fplayerver=30203006&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&step=7&p2pver=0&BossId=3007");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?pf=out&dura=0&pid2=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&reqtime" +
                "="+System.currentTimeMillis()/1000+"&step=0&t=30000");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124223002&platform=6&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://tga.qq.com/2017winter/codol.htm?from=tga2017&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4256");
        kvCommon("adid=&sid=124223002&Pwd=881273072&ctime="+cTimeStr()+"&vurl=http%3A%2F%2F218%2E75%2E176%2E195%3A8080" +
                "%2F5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&iQQ=125826029&val=300&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&sdtfrom=70202&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&iTy=3007&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&flashver=MAC%2027%2E0%2E0%2E183&ptag=&fplayerver=30203006&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&step=4&p2pver=0&BossId=3007");
        kvCommon("cnl=124223002&ftime="+System.currentTimeMillis()+"&vky" +
                "=5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&uin=125826029&cky=GQ8YQ16ItOkGa1N9CMxu99mxavGxXdbY6K5jazeM0nGdLWxMOtS7bZX%5F4GpMMS4evCFUbABrQL8lzi26iJagSlZloJvpUaysHNGHwQGYewmXC5AY86Wyn8vTCwiDSsqBWTsUONKlDLhjTQEtGZnm6HccScTSVkDp9SD8J34JpmaQAZ6m9Xx%2DY4TwPHg8O79YI2gHFtTkD3pRJ963CReMAcQTDpzVhJq1LakvS%2DCRuX3jWoY2Yd778HP2yfTJMN3JKZc0ucJfOlMD0F3njVKw%5FoS0CL1baFLDXkXmUaMSYUSvgHvpD42DekHSy8UVaKRLXh4Ehg&evr=5%2E4&iTy=2595&cip=&avr=TencentPlayerLiveV3%2E2%2E3%2E06&plt=1&sdt=70202&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&cts=1510760323&dip=zijian");
        kvCommon("adid=&sid=124223002&Pwd=881273072&ctime="+cTimeStr()+"&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F" +
                "%3Fflashver%3D27%2C0%2C0%2C183%26fntick%3D0%26cKey%3DGQ8YQ16ItOkGa1N9CMxu99mxavGxXdbY6K5jazeM0nGdLWxMOtS7bZX%5F4GpMMS4evCFUbABrQL8lzi26iJagSlZloJvpUaysHNGHwQGYewmXC5AY86Wyn8vTCwiDSsqBWTsUONKlDLhjTQEtGZnm6HccScTSVkDp9SD8J34JpmaQAZ6m9Xx%2DY4TwPHg8O79YI2gHFtTkD3pRJ963CReMAcQTDpzVhJq1LakvS%2DCRuX3jWoY2Yd778HP2yfTJMN3JKZc0ucJfOlMD0F3njVKw%5FoS0CL1baFLDXkXmUaMSYUSvgHvpD42DekHSy8UVaKRLXh4Ehg%26cmd%3D2%26queueStatus%3D0%26livequeue%3D1%26flvtype%3D1%26vip%5Fstatus%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26rnd%3D793%26browser%3Dchrome%26sdtfrom%3D70202%26defauto%3D1%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252F2017winter%252Fcodol%2Ehtm%253Ffrom%253Dtga2017%26pla%3D0%26encryptVer%3D5%2E4%26rid%3DD7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3%26stream%3D2%26system%3D3%26cnlid%3D124223002%26txvjsv%3D2%26defn%3D&iQQ=125826029&val=153&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&sdtfrom=70202&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&iTy=3007&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&flashver=MAC%2027%2E0%2E0%2E183&ptag=&fplayerver=30203006&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&step=1100&p2pver=0&BossId=3007");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("cnlID=124223002&Pwd=779660211&vkey" +
                "=5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()
                +"&platform=1&BossId=3460");
        kvCommon("adid=&sid=124223002&Pwd=881273072&ctime="+cTimeStr()+"&vurl=http%3A%2F%2F218%2E75%2E176%2E195%3A8080" +
                "%2F5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&iQQ=125826029&val=4568&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&sdtfrom=70202&val1=0&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&val2=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&iTy=3007&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&flashver=MAC%2027%2E0%2E0%2E183&ptag=&fplayerver=30203006&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&step=6&p2pver=0&BossId=3007");
        kvCommon("lookback=0&seq=0&time="+System.currentTimeMillis()+"&videopos=0&HashNotFinished=0&clientip=&sIp=&xserverip=&iQQ" +
                "=125826029&HttpDownlandSpeed=0&UDPDownlandSpeed=0&sBiz=zhibo&str%5Fparam2=218%2E75%2E176%2E195" +
                "&HttpDownSum=0&fullScreen=0&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&iSta=0&playtime" +
                "=0&returnBitmapErr=0&UDPUpSum=0&SuperNodePort=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B" +
                "&SuperNodeIP=0&RtmfpInfo=0&iFlow=0&isuserpay=0&cmd=205&iTy=1991&ispay=0&sRef=&CDNAbnormal=0" +
                "&PeerServerIP=0&svrCount=0&PeerConnRate=0&adstat=0&type=17&P2PVer=0&dsip=218%2E75%2E176%2E195" +
                "&loadingTime=3771&SuNodDelay=0&progid=124223002&cdn=zijian&blockCount=0&playNo" +
                "=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&viewid=&blockTime=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&ReqSNBlockOutRange=0&errorCode=10000&peerCount=0" +
                "&livepid=40924&fullecode=10000&P2PReDelay=0&str%5Fparam1=zijian&pla=1&prdLength=6&cnnPS=0&app=live" +
                "&downSpeed=229&flashver=MAC%2027%2E0%2E0%2E183&maxSpeed=337&fplayerver=30203006&switch=0&live%5Ftype" +
                "=8&StartP2P=0&durl=http%3A%2F%2F218%2E75%2E176%2E195%3A8080" +
                "%2F5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&reCnnCount=0&averPeerMeHealth=0&cnnTime=797&p2pCount=0&averRemtime=0&playerOnPlayTime=4895&blockHasData=0&transtype=0&playAd=0&lookbackseq=0");
        undefined("http://tga.qq.com/2017winter/undefined?t=30000&pid2=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3" +
                "&reqtime="+System.currentTimeMillis()/1000);
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=77BF19B77A7A283ABC9C5C7D16A5A010DA7884A9&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8777");
        live_poll();
        kvCommon("cnlID=124223002&Pwd=779660211&vkey" +
                "=5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&platform=1&BossId=3460");
        kvCommon("val2=&iSta=7&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&iTy=2052&str3=&str4=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002&rnd=332&itype=52&int2=0&int1=0&bid=pcvideo&val=100&str1=&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=11&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=B80984363277BB38A851FDF038A87D6741A3BD07&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DD7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6948");
        kvCommon("val2=&iSta=7&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&iTy=2052&str3=&str4=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002&rnd=5758&itype=52&int2=1&int1=0&bid=pcvideo&val=100&str1=&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=109&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=B80984363277BB38A851FDF038A87D6741A3BD07&pid=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3DD7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcodol" +
                ".htm%26refer%3D%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=883");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; ied_rf=--; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s666309884");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; ied_rf=--; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s666309884");
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
            kvCommon("lookback=0&seq="+seq+"&time="+System.currentTimeMillis()
                    +"&videopos=0&HashNotFinished=0&clientip=&sIp=&xserverip=&iQQ" +
                    "=125826029&HttpDownlandSpeed=0&UDPDownlandSpeed=0&sBiz=zhibo&str%5Fparam2=218%2E75%2E176%2E195" +
                    "&HttpDownSum=0&fullScreen=0&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&iSta=0" +
                    "&playtime=0&returnBitmapErr=0&cmd=263&SuperNodePort=0&ispay=0&SuperNodeIP=0&RtmfpInfo=0&iFlow=0" +
                    "&isuserpay=0&UDPUpSum=0&iTy=1991&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sRef=&CDNAbnormal" +
                    "=0&PeerServerIP=0&svrCount=0&PeerConnRate=0&SuNodDelay=0&type=17&P2PVer=0&dsip=218%2E75%2E176" +
                    "%2E195&loadingTime=0&adstat=4&progid=124223002&cdn=zijian&blockCount=0&playNo" +
                    "=D7F2DB4C831A1B4F449A85AA85102EBB2F6C28D3&viewid=&blockTime=0&progUrl=http%3A%2F%2Ftga%2Eqq" +
                    "%2Ecom%2F2017winter%2Fcodol%2Ehtm%3Ffrom%3Dtga2017&ReqSNBlockOutRange=0&errorCode=10000" +
                    "&peerCount=0&livepid=40924&fullecode=10000&P2PReDelay=0&str%5Fparam1=zijian&pla=1&prdLength=34" +
                    "&cnnPS=0&app=live&downSpeed=386&flashver=MAC%2027%2E0%2E0%2E183&maxSpeed=0&fplayerver=30203006" +
                    "&cnnTime=0&live%5Ftype=8&StartP2P=0&durl=http%3A%2F%2F218%2E75%2E176%2E195%3A8080" +
                    "%2F5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&reCnnCount=0&averPeerMeHealth=0&switch=0&p2pCount=0&averRemtime=0&playerOnPlayTime=0&blockHasData=0&transtype=0&playAd=0&lookbackseq=0");
            sleep();
            kvCommon("cnlID=124223002&Pwd=779660211&vkey" +
                    "=5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&platform=1&BossId=3460");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124223002&Pwd=779660211&vkey" +
                    "=5B73A63143A84E8F57AAB8A5E5E60A7875FC759CD7D8DEC13846B3D19162AB91B17819466834A90E1A05AAFF877DAF71DFC38B731AFB07D077D8F53EB5C51C892FFA2F810350B80C7353BEF9781A7431F0AC471785DC7652&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ftime="+System.currentTimeMillis()+"&platform=1&BossId=3460");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s666309884");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s666309884");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s666309884");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&pollDataKey=pid%3D40924%26type%3D&needmark=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcodol.htm%3Ffrom%3Dtga2017&apptype=live";
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


