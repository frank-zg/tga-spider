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

        kvCommon("P2PVer=&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&BossId=2583&flashver=WIN&progid=124223102&CheckSum=105821293&sRef=&dc=8510&iQQ=408404664");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&adid=&vurl" +
                "=&flashver=WIN%2027%2E0%2E0%2E183&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Ddnf&fplayerver=30203006&tpay=0&iQQ=408404664&ptag=&iTy=3007&val=0&step=3&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&P2PVer=0&BossId=3007&pid" +
                "=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&Pwd=881273072&sid=124223102&val1=0&ctime=" + cTimeStr() + "&val2=0" +
                "&sdtfrom=70202&guid=59BE71766CC9239F7799DD0E3717A38635876F66&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&p2pver=0");
        kvCommon("bid=pcvideo&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&str4=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&itype=50&str2=1%2E4%2E6&rnd=4968&iSta=7&val=100&iTy=2052&int2=0&val2=&str3=&vid=124223102&int1=0&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=3&val=54&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=F0301AE238647764E8E9166E37EDC6B1CA538EEF&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124223102%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DABD77E2A5D1096C63FED2973DEC955A3AF016B62%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2729");
        kvCommon("bid=pcvideo&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&str4=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&itype=50&str2=1%2E4%2E6&rnd=5482&iSta=7&val=100&iTy=2052&int2=1&val2=&str3=&vid=124223102&int1=0&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=3&val=13&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=F0301AE238647764E8E9166E37EDC6B1CA538EEF&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124223102%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DABD77E2A5D1096C63FED2973DEC955A3AF016B62%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2017%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime=" + cTimeStr
                () + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1858");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=F0301AE238647764E8E9166E37EDC6B1CA538EEF&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5414");
        undefined("http://tga.qq.com/match/2017/undefined?pid2=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&pf=out&dura" +
                "=0&step=1&reqtime=" + System.currentTimeMillis() / 1000 + "&t=30000");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&adid=&vurl" +
                "=&flashver=WIN%2027%2E0%2E0%2E183&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Ddnf&fplayerver=30203006&tpay=0&iQQ=408404664&ptag=&iTy=3007&val=0&step=7&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&P2PVer=0&BossId=3007&pid" +
                "=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&Pwd=881273072&sid=124223102&val1=0&ctime=" + cTimeStr() + "&val2=0" +
                "&sdtfrom=70202&guid=59BE71766CC9239F7799DD0E3717A38635876F66&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&p2pver=0");
        undefined("http://tga.qq.com/match/2017/undefined?pid2=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&pf=out&dura" +
                "=0&step=0&reqtime=" + System.currentTimeMillis() / 1000 + "&t=30000");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124223102&platform=6&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://tga.qq.com/match/2017/pc_game.html?game=dnf&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6269");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&adid=&vurl=http%3A" +
                "%2F%2F124%2E232%2E144%2E146%3A8080" +
                "%2FE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&flashver=WIN%2027%2E0%2E0%2E183&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&fplayerver=30203006&tpay=0&iQQ=408404664&ptag=&iTy=3007&val=473&step=4&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&P2PVer=0&BossId=3007&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&Pwd=881273072&sid=124223102&val1=0&ctime=" + cTimeStr() + "&val2=0&sdtfrom=70202&guid=59BE71766CC9239F7799DD0E3717A38635876F66&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&p2pver=0");
        kvCommon("avr=TencentPlayerLiveV3%2E2%2E3%2E06&cip=&dip=zijian&cky" +
                "=EJRvCVcTw6MGa1N9CMxu99mxavGxXdbY6K5jazeM0nGZWfRfWL8bFBl9bcZf6vVbheGTgyYUVXB2iQwg0" +
                "%5FeJDIfhiUCh4L1wGwHh9vTHesvkL%2DaECqez36ebbZTfrQxB1ouJ3qbJ9kihXYpLO79l1Quyt%5FiPh%2Dcag6wzcpo%2DhB5" +
                "%5FY8eTCGtLck8sAgsGDgpIL3O67CXg2vFl87T67DpwNOylHzngKYbuInCkEUiU17RGK5VZwOd0VOFi5k02W4LxjIuQ4i14PhkRV" +
                "%5F4yqMqWH3mKGI3mGE%2DzcannYOD%5FqUSXP9l5vS9BsB42Sa7hgi1BWRN5RA&cnl=124223102&vky" +
                "=E743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&iTy=2595&ftime=" + System.currentTimeMillis() + "&uin=408404664&evr=5%2E4&gid=59BE71766CC9239F7799DD0E3717A38635876F66&cts=1510277187&sdt=70202&plt=1");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&adid=&vurl=http%3A" +
                "%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fsdtfrom%3D70202%26guid" +
                "%3D59BE71766CC9239F7799DD0E3717A38635876F66%26cnlid%3D124223102%26flashver%3D27%2C0%2C0%2C183" +
                "%26browser%3Dchrome%26cKey" +
                "%3DEJRvCVcTw6MGa1N9CMxu99mxavGxXdbY6K5jazeM0nGZWfRfWL8bFBl9bcZf6vVbheGTgyYUVXB2iQwg0" +
                "%5FeJDIfhiUCh4L1wGwHh9vTHesvkL%2DaECqez36ebbZTfrQxB1ouJ3qbJ9kihXYpLO79l1Quyt%5FiPh%2Dcag6wzcpo%2DhB5" +
                "%5FY8eTCGtLck8sAgsGDgpIL3O67CXg2vFl87T67DpwNOylHzngKYbuInCkEUiU17RGK5VZwOd0VOFi5k02W4LxjIuQ4i14PhkRV" +
                "%5F4yqMqWH3mKGI3mGE%2DzcannYOD%5FqUSXP9l5vS9BsB42Sa7hgi1BWRN5RA%26host%3Dhttp%253A%252F%252Ftga%2Eqq" +
                "%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Ddnf%26rnd%3D448%26vip%5Fstatus%3D0" +
                "%26encryptVer%3D5%2E4%26defn%3D%26cmd%3D2%26fntick%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E06" +
                "%26txvjsv%3D2%26defauto%3D1%26flvtype%3D1%26rid%3DABD77E2A5D1096C63FED2973DEC955A3AF016B62%26pla%3D0" +
                "%26livequeue%3D1%26stream%3D2%26system%3D0%26queueStatus%3D0&flashver=WIN%2027%2E0%2E0%2E183&sref" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&fplayerver=30203006&tpay" +
                "=0&iQQ=408404664&ptag=&iTy=3007&val=285&step=1100&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&P2PVer=0&BossId=3007&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&Pwd=881273072&sid=124223102&val1=0&ctime=" + cTimeStr() + "&val2=0&sdtfrom=70202&guid=59BE71766CC9239F7799DD0E3717A38635876F66&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&p2pver=0");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("ftime=" + System.currentTimeMillis() + "&BossId=3460&cnlID=124223102&vkey" +
                "=E743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&Pwd=779660211&guid=59BE71766CC9239F7799DD0E3717A38635876F66&platform=1");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&adid=&vurl=http%3A" +
                "%2F%2F124%2E232%2E144%2E146%3A8080" +
                "%2FE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&flashver=WIN%2027%2E0%2E0%2E183&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&fplayerver=30203006&tpay=0&iQQ=408404664&ptag=&iTy=3007&val=4045&step=6&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&P2PVer=0&BossId=3007&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&Pwd=881273072&sid=124223102&val1=0&ctime=" + cTimeStr() + "&val2=0&sdtfrom=70202&guid=59BE71766CC9239F7799DD0E3717A38635876F66&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&p2pver=0");
        kvCommon("PeerServerIP=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf" +
                "&downSpeed=271&flashver=WIN%2027%2E0%2E0%2E183&prdLength=5&maxSpeed=358&fplayerver=30203006&time" +
                "=" + System.currentTimeMillis() + "&cnnTime=210&ReqSNBlockOutRange=0&cdn=zijian&HashNotFinished=0&dsip=124%2E232%2E144" +
                "%2E146&PeerServerPort=0&blockHasData=0&returnBitmapErr=0&reCnnCount=0&CDNAbnormal=0&playerOnPlayTime" +
                "=4542&fullScreen=0&cmd=205&transtype=0&adstat=0&HttpDownlandSpeed=0&HttpDownSum=0&str%5Fparam1" +
                "=zijian&seq=0&cnnPS=0&UDPDownlandSpeed=0&durl=http%3A%2F%2F124%2E232%2E144%2E146%3A8080" +
                "%2FE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&videopos=0&lookback=0&UDPDownSum=0&str%5Fparam2=124%2E232%2E144%2E146&sIp=&type=17&clientip=&viewid=&playtime=0&UDPUpSum=0&xserverip=&sBiz=zhibo&ispay=0&RtmfpInfo=0&iQQ=408404664&guid=59BE71766CC9239F7799DD0E3717A38635876F66&sOp=webflash&isuserpay=0&PeerConnRate=0&UpdataSpeed=0&iSta=0&livepid=40925&svrCount=0&playNo=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&p2pCount=0&progid=124223102&P2PReDelay=0&iTy=1991&sRef=&live%5Ftype=8&SuNodDelay=0&iFlow=0&P2PVer=0&averRemtime=0&loadingTime=3835&peerCount=0&blockCount=0&switch=0&averPeerMeHealth=0&playAd=0&StartP2P=0&errorCode=10000&SuperNodeIP=0&blockTime=0&pla=1&fullecode=10000&lookbackseq=0&SuperNodePort=0&app=live");
        undefined("http://tga.qq.com/match/2017/undefined?pid2=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&reqtime" +
                "=" + System.currentTimeMillis() / 1000 + "&t=30000");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=F0301AE238647764E8E9166E37EDC6B1CA538EEF&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7671");
        live_poll();
        kvCommon("ftime=" + System.currentTimeMillis() + "&BossId=3460&cnlID=124223102&vkey" +
                "=E743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&Pwd=779660211&guid=59BE71766CC9239F7799DD0E3717A38635876F66&platform=1");
        kvCommon("bid=pcvideo&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&str4=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&itype=52&str2=1%2E4%2E6&rnd=9670&iSta=7&val=100&iTy=2052&int2=0&val2=&str3=&vid=124223102&int1=0&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=3&val=82&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=8CED1921B69ED8759C49E32F2C03B204B7587C09&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DABD77E2A5D1096C63FED2973DEC955A3AF016B62%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7489");
        kvCommon("bid=pcvideo&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Ddnf&str4=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&itype=52&str2=1%2E4%2E6&rnd=1849&iSta=7&val=100&iTy=2052&int2=1&val2=&str3=&vid=124223102&int1=0&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E06");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%3Fgame%3Ddnf&sRef=&sPageId=&sPos=&step=3&val=44&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=8CED1921B69ED8759C49E32F2C03B204B7587C09&pid=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&vid=124223102" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.06&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F62.0.3202.75%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew" +
                ".l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223102" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.06%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DABD77E2A5D1096C63FED2973DEC955A3AF016B62%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime=" + cTimeStr() + "&bdua=0&admtype=0&adid=&guid=&ispip=0&random" +
                "=5190");
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
        headers1.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s9736305008; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=1118471560; o_cookie=408404664; ts_uid=6520861252");
        headers1.put("Host", "tga.qq.com");
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void undefined(String uri) {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "*/*");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s9736305008; ts_last=tga.qq.com/match/2017/pc_game.html; pgv_pvid=1118471560; o_cookie=408404664; ts_uid=6520861252");
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
            kvCommon("ftime=" + System.currentTimeMillis() + "&BossId=3460&cnlID=124223102&vkey" +
                    "=E743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&Pwd=779660211&guid=59BE71766CC9239F7799DD0E3717A38635876F66&platform=1");
            sleep();
            kvCommon("PeerServerIP=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame" +
                    "%3Ddnf&downSpeed=390&flashver=WIN%2027%2E0%2E0%2E183&prdLength=34&maxSpeed=0&fplayerver=30203006" +
                    "&time=" + System.currentTimeMillis() + "&dsip=124%2E232%2E144%2E146&ReqSNBlockOutRange=0&cdn=zijian&HashNotFinished=0" +
                    "&cnnTime=0&PeerServerPort=0&blockHasData=0&returnBitmapErr=0&reCnnCount=0&CDNAbnormal=0" +
                    "&playerOnPlayTime=0&fullScreen=0&cmd=263&transtype=0&adstat=4&HttpDownlandSpeed=0&HttpDownSum=0" +
                    "&str%5Fparam1=zijian&seq=" + seq + "&cnnPS=0&UDPDownlandSpeed=0&durl=http%3A%2F%2F124%2E232%2E144" +
                    "%2E146" +
                    "%3A8080%2FE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42%2F124223102%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" + System.currentTimeMillis() / 1000 + "%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DE743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&videopos=0&lookback=0&UDPDownSum=0&str%5Fparam2=124%2E232%2E144%2E146&sIp=&type=17&clientip=&viewid=&playtime=0&UDPUpSum=0&xserverip=&sBiz=zhibo&ispay=0&RtmfpInfo=0&iQQ=408404664&guid=59BE71766CC9239F7799DD0E3717A38635876F66&sOp=webflash&isuserpay=0&PeerConnRate=0&UpdataSpeed=0&iSta=0&livepid=40925&svrCount=0&playNo=ABD77E2A5D1096C63FED2973DEC955A3AF016B62&p2pCount=0&progid=124223102&P2PReDelay=0&iTy=1991&sRef=&live%5Ftype=8&SuNodDelay=0&iFlow=0&P2PVer=0&averRemtime=0&loadingTime=0&peerCount=0&blockCount=0&switch=0&averPeerMeHealth=0&playAd=0&StartP2P=0&errorCode=10000&SuperNodeIP=0&blockTime=0&pla=1&fullecode=10000&lookbackseq=0&SuperNodePort=0&app=live");
            sleep();
            live_poll();
            sleep();
            kvCommon("ftime=" + System.currentTimeMillis() + "&BossId=3460&cnlID=124223102&vkey" +
                    "=E743BCAEC569793A1C8FC284DF29353B120302CC4947CFDE572E9F05198BFDD1312370A8E9F268AC4B7C118E64B40B7B9A2FB6E71D4337BF1BA2710A2DDAC96145F9D556B68BC4748ED597732207EBE0D80AF604DC414C42&Pwd=779660211&guid=59BE71766CC9239F7799DD0E3717A38635876F66&platform=1");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s9736305008; pgv_pvid=1118471560; o_cookie=408404664");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s9736305008; pgv_pvid=1118471560; o_cookie=408404664");
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
        headers.put("Cookie", "pgv_pvi=3304220672; RK=+WdyHLx7Oo; ptcz=478ca7fd50f0f5b3e3e9a6f2b15ac903a05b02d54549ddd8ad252ee913e4fb65; pt2gguin=o0408404664; eas_sid=01Y5s0G93681P3q5f4R504s7N4; tvfe_boss_uuid=3c6ff62f28b10133; pac_uid=0_ae0dccf2deb68; pgv_info=ssid=s9736305008; pgv_pvid=1118471560; o_cookie=408404664");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&guid=59BE71766CC9239F7799DD0E3717A38635876F66&needmark=1&pollDataKey=pid%3D40925%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=59BE71766CC9239F7799DD0E3717A38635876F66&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_game.html%3Fgame%3Ddnf&apptype=live";
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


