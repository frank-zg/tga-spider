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


        kvCommon("flashver=WIN&progid=124223402&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&dc=8323&BossId=2583&sRef=&iQQ=125826029&CheckSum=105821293&P2PVer=");
        kvCommon("val2=0&step=3&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&P2PVer=0&val=0&p2pver=0&BossId=3007&ptag=&Pwd=881273072&vurl=&sid=124223402&adid=&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&ctime=2017%2D11%2D23%2022%3A55%3A29%20107&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon("istr4=310DD296F242AC95EF8EA2F86454C637CD1156F6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&rnd=4295&bid=pcvideo&itype=50&vid=124223402&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str2=1%2E4%2E6&int2=0&str1=&val2=&iSta=7&val=100&str3=&int1=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=63&val1=2&val2=604&val3=&val4=&val5=&apid=9299BB458CE892BEFA11DA34D54CA43413AA2838&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223402%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D3946%26vptag%3D%26pid%3D310DD296F242AC95EF8EA2F86454C637CD1156F6%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html%26refer%3D%26st%3D0&reporttime=2017-11-23%2022:55:29%20192&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5366");
        kvCommon("str4=310DD296F242AC95EF8EA2F86454C637CD1156F6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&rnd=9955&bid=pcvideo&itype=50&vid=124223402&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str2=1%2E4%2E6&int2=1&str1=&val2=&iSta=7&val=100&str3=&int1=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=23&val1=2&val2=604&val3=&val4=&val5=&apid=9299BB458CE892BEFA11DA34D54CA43413AA2838&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223402%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D3946%26vptag%3D%26pid%3D310DD296F242AC95EF8EA2F86454C637CD1156F6%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html%26refer%3D%26st%3D0%26retry%3D1&reporttime=2017-11-23%2022:55:29%20221&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4313");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid=9299BB458CE892BEFA11DA34D54CA43413AA2838&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=.block&reporttime=2017-11-23%2022:55:29%20477&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8092");
        kvCommon("val2=0&step=7&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&P2PVer=0&val=0&p2pver=0&BossId=3007&ptag=&Pwd=881273072&vurl=&sid=124223402&adid=&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&ctime=2017%2D11%2D23%2022%3A55%3A29%20496&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124223402&platform=5&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://v.qq.com/live/p/topic/40928/index.html&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1306");
        regist();

        kvCommon("val2=0&step=4&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&P2PVer=0&val=299&p2pver=0&BossId=3007&ptag=&Pwd=881273072&vurl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080%2FD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831%2F124223402%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1511448930%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&sid=124223402&adid=&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&ctime=2017%2D11%2D23%2022%3A55%3A29%20584&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");

        kvCommon("dip=zijian&cky=daIeezIlstEGa1N9CMxu99mxavGxXdbY5aRSR5GRGMnMwGqhP4nM4h1Eb8CqQvomM%2DxnxKdArq07CL5rJb4bmT1g%5FWMNe7kSnJSkyfEijaH2WN%5FBsNdj%2D4oz5qZFziWqybRXBRJNhvLKh49VbhwLjv32Q%5F%2DXTXbzBqqA3aAk3aOXPV40KDu8CPPz6UksWXNiJ%2D7EGmikfYvrQFRareCebGSU240RSNuOwuj9IIpGUw4ITYPjFUD53ECqx48iUiKcScuOyTQQf5dNqhBgHCZsY9fMRGguTi9a2CpUrgxcZZjkAr8wGzc%5F7RXzrQ1QburOW%2DQu%5Fw&vky=D065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&cnl=124223402&ftime=1511448929597&uin=125826029&evr=5%2E4&sdt=10202&plt=1&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&avr=TencentPlayerLiveV3%2E2%2E3%2E06&cip=&cts=1511448930&iTy=2595");
        kvCommon("val2=0&step=1100&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&P2PVer=0&val=119&p2pver=0&BossId=3007&ptag=&Pwd=881273072&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fstream%3D2%26vip%5Fstatus%3D0%26cmd%3D2%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26rnd%3D638%26encryptVer%3D5%2E4%26rid%3D310DD296F242AC95EF8EA2F86454C637CD1156F6%26system%3D3%26sdtfrom%3D10202%26defn%3D%26fntick%3D0%26pla%3D0%26defauto%3D1%26flvtype%3D1%26host%3Dhttp%253A%252F%252Fv%2Eqq%2Ecom%252Flive%252Fp%252Ftopic%252F40928%252Findex%2Ehtml%26cnlid%3D124223402%26livequeue%3D1%26livepid%3D40928%26flashver%3D27%2C0%2C0%2C187%26browser%3Dchrome%26queueStatus%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06%26txvjsv%3D2%26cKey%3DdaIeezIlstEGa1N9CMxu99mxavGxXdbY5aRSR5GRGMnMwGqhP4nM4h1Eb8CqQvomM%2DxnxKdArq07CL5rJb4bmT1g%5FWMNe7kSnJSkyfEijaH2WN%5FBsNdj%2D4oz5qZFziWqybRXBRJNhvLKh49VbhwLjv32Q%5F%2DXTXbzBqqA3aAk3aOXPV40KDu8CPPz6UksWXNiJ%2D7EGmikfYvrQFRareCebGSU240RSNuOwuj9IIpGUw4ITYPjFUD53ECqx48iUiKcScuOyTQQf5dNqhBgHCZsY9fMRGguTi9a2CpUrgxcZZjkAr8wGzc%5F7RXzrQ1QburOW%2DQu%5Fw&sid=124223402&adid=&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&ctime=2017%2D11%2D23%2022%3A55%3A29%20608&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=1&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=344&play%5Ftype=2");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("vkey=D065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&cnlID=124223402&platform=1&Pwd=779660211&ftime=1511448929829");
        kvCommon("val2=0&step=6&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&tpay=0&sRef=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&P2PVer=0&val=392&p2pver=0&BossId=3007&ptag=&Pwd=881273072&vurl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080%2FD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831%2F124223402%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1511448930%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&sid=124223402&adid=&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&ctime=2017%2D11%2D23%2022%3A55%3A30%20000&iQQ=125826029&surl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&sdtfrom=10202&val1=0&sUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&flashver=MAC%2027%2E0%2E0%2E187&sref=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&fplayerver=30203006&iTy=3007");
        kvCommon("live%5Ftype=8&StartP2P=0&time=1511448930021&fplayerver=30203006&durl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080%2FD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831%2F124223402%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1511448930%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&reCnnCount=0&lookback=0&cnnTime=63&p2pCount=0&lookbackseq=0&playAd=0&playerOnPlayTime=715&seq=0&blockHasData=0&transtype=0&videopos=0&fullScreen=0&switch=0&HashNotFinished=0&HttpDownlandSpeed=0&sIp=&HttpDownSum=0&iQQ=125826029&clientip=&UDPDownlandSpeed=0&sBiz=zhibo&str%5Fparam2=124%2E232%2E155%2E155&xserverip=&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=205&iTy=1991&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&CDNAbnormal=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&P2PReDelay=0&SuperNodePort=0&SuNodDelay=0&dsip=124%2E232%2E155%2E155&type=17&viewid=&loadingTime=329&cdn=zijian&progid=124223402&blockCount=0&playNo=310DD296F242AC95EF8EA2F86454C637CD1156F6&PeerServerIP=0&blockTime=0&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&ReqSNBlockOutRange=0&errorCode=10000&peerCount=0&livepid=40928&fullecode=10000&averRemtime=0&str%5Fparam1=zijian&pla=1&prdLength=7&cnnPS=0&app=live&downSpeed=189&adstat=0&flashver=MAC%2027%2E0%2E0%2E187&maxSpeed=4299&averPeerMeHealth=0");
        live_poll();
        live_poll();
        live_poll();
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid=9299BB458CE892BEFA11DA34D54CA43413AA2838&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=0&vurl=.block&reporttime=2017-11-23%2022:56:00%20494&bdua=0&admtype=0&adid=&guid=&ispip=0&random=422");
        live_pollx();

        kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=6&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=157&play%5Ftype=2");
        kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=258&play%5Ftype=2");
        kvCommon("vkey=D065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&cnlID=124223402&platform=1&Pwd=779660211&ftime=1511448962064");
        live_poll();
        kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=112&play%5Ftype=2");
        kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=114&play%5Ftype=2");
        live_poll();
        kvCommon("str4=310DD296F242AC95EF8EA2F86454C637CD1156F6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&rnd=9302&bid=pcvideo&itype=52&vid=124223402&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str2=1%2E4%2E6&int2=0&str1=&val2=&iSta=7&val=100&str3=&int1=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=374&val1=2&val2=604&val3=&val4=&val5=&apid=1978910C456733F10C20293A283300B743144233&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223402%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D3946%26vptag%3D%26pid%3D310DD296F242AC95EF8EA2F86454C637CD1156F6%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html%26refer%3D&reporttime=2017-11-23%2022:56:16%20676&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7159");
        kvCommon("str4=310DD296F242AC95EF8EA2F86454C637CD1156F6&url=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&rnd=3297&bid=pcvideo&itype=52&vid=124223402&ver=TencentPlayerLiveV3%2E2%2E3%2E06&str2=1%2E4%2E6&int2=1&str1=&val2=&iSta=7&val=100&str3=&int1=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&sRef=&sPageId=&sPos=&step=3&val=78&val1=2&val2=604&val3=&val4=&val5=&apid=1978910C456733F10C20293A283300B743144233&pid=310DD296F242AC95EF8EA2F86454C637CD1156F6&vid=124223402&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.94%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Din%26pt%3D0%26pc%3D0%26vid%3D124223402%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6%26speed%3D3946%26vptag%3D%26pid%3D310DD296F242AC95EF8EA2F86454C637CD1156F6%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html%26refer%3D%26retry%3D1&reporttime=2017-11-23%2022:56:16%20790&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3835");

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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ts_refer=www.google.com.hk/; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; ts_last=v.qq.com/live/p/topic/40928/index.html; pgv_pvid=672048110; o_cookie=125826029; ts_uid=9320616880; ptag=|live");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_info=ssid=s4284042585; pgv_pvid=672048110; o_cookie=125826029");
        headers.put("Host", "bullet.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=1511448921809");
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
            kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=113&play%5Ftype=2");
            kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=118&play%5Ftype=2");
            sleep();
            live_poll();
            live_pollx();
            sleep();
            kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=82&play%5Ftype=2");
            kvCommon("live%5Ftype=8&StartP2P=0&time=1511448990061&fplayerver=30203006&durl=http%3A%2F%2F124%2E232%2E155%2E155%3A8080%2FD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831%2F124223402%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1511448930%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D10202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&reCnnCount=0&lookback=0&cnnTime=0&p2pCount=0&lookbackseq=0&playAd=0&switch=0&seq=1&blockHasData=0&transtype=0&videopos=0&fullScreen=0&playerOnPlayTime=0&HashNotFinished=0&HttpDownlandSpeed=0&sIp=&HttpDownSum=0&iQQ=125826029&clientip=&UDPDownlandSpeed=0&sBiz=zhibo&str%5Fparam2=124%2E232%2E155%2E155&xserverip=&UDPDownSum=0&sOp=webflash&PeerServerPort=0&UpdataSpeed=0&SuperNodeIP=0&playtime=0&returnBitmapErr=0&cmd=263&iTy=1991&ispay=0&iSta=0&RtmfpInfo=0&iFlow=0&isuserpay=0&UDPUpSum=0&svrCount=0&PeerConnRate=0&sRef=&CDNAbnormal=0&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&P2PVer=0&P2PReDelay=0&SuperNodePort=0&adstat=4&dsip=124%2E232%2E155%2E155&type=17&viewid=&loadingTime=0&cdn=zijian&progid=124223402&blockCount=0&playNo=310DD296F242AC95EF8EA2F86454C637CD1156F6&PeerServerIP=0&blockTime=0&progUrl=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&ReqSNBlockOutRange=0&errorCode=10000&peerCount=0&livepid=40928&fullecode=10000&averRemtime=0&str%5Fparam1=zijian&pla=1&prdLength=29&cnnPS=0&app=live&downSpeed=607&SuNodDelay=0&flashver=MAC%2027%2E0%2E0%2E187&maxSpeed=0&averPeerMeHealth=0");
            sleep();
            live_poll();
            kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=85&play%5Ftype=2");
            sleep();
            kvCommon("vkey=D065D6F3CC5796AD601297E444E2A10406A6EE2BDE0727BF622C7D350210515DE3CDF91A3142E4A2817092405B66EE037A28D3521B7282085051D4D66BB8B49AEEB0587BFAAA72F7F1DF97FB5E7799A38C76AE9C8DF99831&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&cnlID=124223402&platform=1&Pwd=779660211&ftime=1511448994010");
            live_poll();
            sleep();
            kvCommon("iFlow=310DD296F242AC95EF8EA2F86454C637CD1156F6&sDomain=live%2Ebpush%2Evideo%2Eqq%2Ecom&platform=1&vid=124223402&Pwd=639535403&ver=158&rcode=0&referer=http%3A%2F%2Fv%2Eqq%2Ecom%2Flive%2Fp%2Ftopic%2F40928%2Findex%2Ehtml&moduleid=8&err%5Ftype=0&BossId=2790&ever=undefined&all%5Ftime=87&play%5Ftype=2");
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
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=1511448921809");
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
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?callback=livepoll&low_login=1&guid=104&pollDataKey=pid%3D40928&qqlog=1632485840&otype=json&_=1511448921638", headers, exceptionStatus, timeout);
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
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&qqlog=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&pollDataKey=pid%3D40928%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Fv.qq.com%2Flive%2Fp%2Ftopic%2F40928%2Findex.html&apptype=live";
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


