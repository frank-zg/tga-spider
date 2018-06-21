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

    public Play(String uri, String videoUri, double videoTime, int videoDownSize, int timeout, boolean exceptionStatus, AtomicInteger autoIndex) {
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

    public void run() {
        this.autoIndex.incrementAndGet();
        System.out.println(this.autoIndex.get());
        this.indexPage();
        this.kvCommon("dc=7169&flashver=WIN&progid=124236703&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&P2PVer=&sRef=&CheckSum=105821293&iQQ=408404664&BossId=2583");
        this.kvCommon("surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2030%2E0%2E0" +
                "%2E113&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy" +
                "=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=3&ptag=&P2PVer=0&adid=&vurl=&val1=0&BossId" +
                "=3007&val2=0&Pwd=881273072&p2pver=0&sid=124236703&iQQ=408404664&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&val=0&pid" +
                "=50F826DD87BE6C8B51ABC30D9050276FBB4110EA");
        this.kvCommon("rnd=6814&str2=1%2E4%2E6&int2=0&iSta=7&bid=pcvideo&iTy=2052&str4=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&val2=&val=100&str3=&int1=0&vid=124236703&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_index" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=16&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=706BF51FCA938608E1DB8F91357FDD1990A999EB&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&vid=124236703" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124236703%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07" +
                "%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D50F826DD87BE6C8B51ABC30D9050276FBB4110EA%26adaptor" +
                "%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_index.html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2328");
        this.kvCommon("surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2030%2E0%2E0" +
                "%2E113&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy" +
                "=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=7&ptag=&P2PVer=0&adid=&vurl=&val1=0&BossId" +
                "=3007&val2=0&Pwd=881273072&p2pver=0&sid=124236703&iQQ=408404664&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&val=0&pid" +
                "=50F826DD87BE6C8B51ABC30D9050276FBB4110EA");
        this.kvCommon("surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2030%2E0%2E0" +
                "%2E113&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy" +
                "=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=4&ptag=&P2PVer=0&adid=&vurl=http%3A%2F" +
                "%2Fqqlive%2Ehdl%2Elxdns%2Ecom%3A80%2F124236701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time" +
                "%3D"+System.currentTimeMillis()
                /1000+"%26cdn%3Dwangsu%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag" +
                "%3D1%26buname%3Dqqlive%26vkey" +
                "%3D7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&val1=0&BossId=3007&val2=0&Pwd=881273072&p2pver=0&sid=124236703&iQQ=408404664&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&val=529&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA");
        this.kvCommon
                ("vky=7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&cnl=124236703&iTy=2595&sdt=70202&evr=5%2E4&ftime="+System.currentTimeMillis()+"&cts="+System.currentTimeMillis()/1000+"&plt=1&gid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&avr=TencentPlayerLiveV3%2E2%2E3%2E07&cip=&uin=408404664&dip=wangsu&cky=DGaBwEvhLWoGa1N9CMxu99mxavGxXdbY6K5jazeM0nGO3qL%2DAhl%5FWohG1u%2D2x12aQ6mU1meEDSFPr9bCK9K4b3muyrE0I8yVj0pJ9odY1RFbS5iWGMEAxXozG9%2Dk%5F%2DUdXzzsPsObR3fA2yhosZF9U9RccUmEEYQhGKfDwPhz0Zj2kLIpxtS4I5jWecdEkvTGTdA7enjxJiYlhRDQ%2DXFjLBXN4M6VAxWjABzjPchI7tPQg%5FroyR%5F%2D1NtPqHN9OyluYGw2hMBP4wx%5FfTZ00hR7EaP21pw%5FugJ0dN67jIzKinx5vai8gS9Eq4tW8LduznPqNAwPgw");
        this.kvCommon("surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2030%2E0%2E0" +
                "%2E113&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy" +
                "=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=1100&ptag=&P2PVer=0&adid=&vurl=http%3A%2F" +
                "%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Frnd%3D978%26rid%3D50F826DD87BE6C8B51ABC30D9050276FBB4110EA" +
                "%26flashver%3D30%2C0%2C0%2C113%26cmd%3D2%26fntick%3D0%26queueStatus%3D0%26host%3Dhttp%253A%252F" +
                "%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Findex%2Ehtml%26flvtype%3D1%26stream%3D2%26livequeue" +
                "%3D1%26cKey%3DDGaBwEvhLWoGa1N9CMxu99mxavGxXdbY6K5jazeM0nGO3qL%2DAhl%5FWohG1u" +
                "%2D2x12aQ6mU1meEDSFPr9bCK9K4b3muyrE0I8yVj0pJ9odY1RFbS5iWGMEAxXozG9%2Dk%5F" +
                "%2DUdXzzsPsObR3fA2yhosZF9U9RccUmEEYQhGKfDwPhz0Zj2kLIpxtS4I5jWecdEkvTGTdA7enjxJiYlhRDQ" +
                "%2DXFjLBXN4M6VAxWjABzjPchI7tPQg%5FroyR%5F%2D1NtPqHN9OyluYGw2hMBP4wx%5FfTZ00hR7EaP21pw" +
                "%5FugJ0dN67jIzKinx5vai8gS9Eq4tW8LduznPqNAwPgw%26system%3D0%26vip%5Fstatus%3D0%26txvjsv%3D2%26defn%3D" +
                "%26guid%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26encryptVer%3D5%2E4%26pla%3D0%26defauto%3D1" +
                "%26browser%3Dchrome%26sdtfrom%3D70202%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26cnlid%3D124236703&val1=0&BossId=3007&val2=0&Pwd=881273072&p2pver=0&sid=124236701&iQQ=408404664&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&val=266&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA");

        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon
                ("vkey=7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&platform=1&cnlID=124236703&Pwd=779660211&ftime="+System.currentTimeMillis());
        this.kvCommon("surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2030%2E0%2E0" +
                "%2E113&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy" +
                "=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=6&ptag=&P2PVer=0&adid=&vurl=http%3A%2F" +
                "%2Fqqlive%2Ehdl%2Elxdns%2Ecom%3A80%2F124236701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time" +
                "%3D"+System.currentTimeMillis()
                /1000+"%26cdn%3Dwangsu%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag" +
                "%3D1%26buname%3Dqqlive%26vkey" +
                "%3D7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&val1=0&BossId=3007&val2=0&Pwd=881273072&p2pver=0&sid=124236701&iQQ=408404664&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&val=473&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA");
        kvCommon("iSta=0&dsip=qqlive%2Ehdl%2Elxdns%2Ecom&sOp=webflash&iTy=1991&cdn=wangsu&adstat=0&RtmfpInfo=0&iFlow" +
                "=0&PeerConnRate=0&sRef=&time="+System.currentTimeMillis()+"&svrCount=0&P2PVer=0&p2pCount=0&playNo" +
                "=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&P2PReDelay=0&loadingTime=156&progid=124236701&SuNodDelay=0" +
                "&blockCount=0&averRemtime=0&blockTime=0&xserverip=&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2018%2Fpc%5Findex%2Ehtml&peerCount=0&errorCode=10000&averPeerMeHealth=0&switch=0&durl=http%3A%2F" +
                "%2Fqqlive%2Ehdl%2Elxdns%2Ecom%3A80%2F124236701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time" +
                "%3D"+System.currentTimeMillis()
                /1000+"%26cdn%3Dwangsu%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag" +
                "%3D1%26buname%3Dqqlive%26vkey%3D7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&pla=1&StartP2P=0&prdLength=3&str%5Fparam2=qqlive%2Ehdl%2Elxdns%2Ecom&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=37&clientip=&fullScreen=0&SuperNodePort=0&maxSpeed=671&CDNAbnormal=0&fullecode=10000&fplayerver=30203007&PeerServerIP=0&cnnTime=317&flashver=WIN%2030%2E0%2E0%2E113&reCnnCount=0&ReqSNBlockOutRange=0&str%5Fparam1=wangsu&type=17&blockHasData=0&playerOnPlayTime=1062&cmd=205&HashNotFinished=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&lookback=0&playAd=0&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&seq=0&sIp=&playtime=0&UDPDownSum=0&isuserpay=0&livepid=53681&iQQ=408404664&ispay=0&UpdataSpeed=0&sBiz=zhibo&UDPUpSum=0&live%5Ftype=8&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnnPS=0");
        this.live_poll();
        this.kvCommon
                ("vkey=7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&platform=1&cnlID=124236703&Pwd=779660211&ftime="+System.currentTimeMillis());
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_index" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=33&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=D488C5027E8170BF911235A40B5D6B35D5EE7601&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&vid=124236701" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124236701" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D50F826DD87BE6C8B51ABC30D9050276FBB4110EA%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6762");
        this.kvCommon("rnd=9696&str2=1%2E4%2E6&int2=0&iSta=7&bid=pcvideo&iTy=2052&str4=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&val2=&val=100&str3=&int1=0&vid=124236701&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_index" +
                ".html&sRef=&sPageId=&sPos=&step=3&val=15&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=D488C5027E8170BF911235A40B5D6B35D5EE7601&pid=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&vid=124236701" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124236701" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D50F826DD87BE6C8B51ABC30D9050276FBB4110EA%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5146");
        kvCommon("rnd=4699&str2=1%2E4%2E6&int2=1&iSta=7&bid=pcvideo&iTy=2052&str4=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&val2=&val=100&str3=&int1=0&vid=124236701&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml");
        try {
            for(int i = 1; i < this.videoTime; i++) {
                this.forEachRequest(i);
            }
        } catch (Exception var3) {
        }

        if (this.videoTime > 0 && this.videoDownSize > 0 && stream != null) {
            stream.stop();
        }

    }

    public void indexPage() {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "no-cache");
        headers1.put("Pragma", " no-cache");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; ts_uid=8358206256; pac_uid=1_125826029; pt2gguin=o0408404664; pgv_info=ssid=s1069950349; ts_last=tga.qq.com/match/2018/pc_index.html; o_cookie=408404664");
        headers1.put("Host", "tga.qq.com");
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(this.uri_index, headers1, this.exceptionStatus, this.timeout);
    }

    public void forEachRequest(int seq) {
        try {
            this.live_poll();
            this.sleep();
            this.kvCommon("rnd=4699&str2=1%2E4%2E6&int2=1&iSta=7&bid=pcvideo&iTy=2052&str4=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&val2=&val=100&str3=&int1=0&vid=124236701&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml");
            this.sleep();
            this.kvCommon("iSta=0&dsip=qqlive%2Ehdl%2Elxdns%2Ecom&sOp=webflash&iTy=1991&cdn=wangsu&adstat=0" +
                    "&RtmfpInfo=0&iFlow=0&PeerConnRate=0&sRef=&time="+System
                    .currentTimeMillis()+"&svrCount=0&P2PVer=0&p2pCount=0&playNo=50F826DD87BE6C8B51ABC30D9050276FBB4110EA&P2PReDelay=0" +
                    "&loadingTime=0&progid=124236701&SuNodDelay=0&blockCount=0&averRemtime=0&blockTime=0&xserverip" +
                    "=&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&peerCount=0&errorCode" +
                    "=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2Fqqlive%2Ehdl%2Elxdns%2Ecom%3A80" +
                    "%2F124236701%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()
                    /1000+"%26cdn%3Dwangsu" +
                    "%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive" +
                    "%26vkey%3D7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&pla=1&StartP2P=0&prdLength=60&str%5Fparam2=qqlive%2Ehdl%2Elxdns%2Ecom&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=131&clientip=&fullScreen=0&SuperNodePort=0&maxSpeed=0&CDNAbnormal=0&switch=0&fplayerver=30203007&PeerServerIP=0&cnnTime=0&flashver=WIN%2030%2E0%2E0%2E113&reCnnCount=0&ReqSNBlockOutRange=0&str%5Fparam1=wangsu&type=17&blockHasData=0&playerOnPlayTime=0&cmd=263&HashNotFinished=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&lookback=0&playAd=0&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&seq="+seq+"&sIp=&playtime=0&UDPDownSum=0&isuserpay=0&livepid=53681&iQQ=408404664&ispay=0&UpdataSpeed=0&sBiz=zhibo&UDPUpSum=0&live%5Ftype=8&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnnPS=0");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon
                    ("vkey=7644A9B5441AC356E6A55D807EA5234C8D22D69E7EA78B1C7B336DD6E9D826B75BE041E84E6F52CB34126E1FD707547B3EED497216FCB1C185D40008DBE3A43F6F5C9CF82FDC1E8B82D75AAEEF1706E099E1C9BD22CABBFC&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&platform=1&cnlID=124236703&Pwd=779660211&ftime="+System.currentTimeMillis());
            this.sleep();
        } catch (InterruptedException var3) {
        }

    }

    private static String cTimeStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss SSS"));
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(2000L);
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
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://112.90.53.167:8080/FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B479ABA9/124208501.flv?cdncode=%2f18907E7BE0798990%2f&time=" + System.currentTimeMillis() / 1000L + "&cdn=zijian&sdtfrom=v210221&platform=70202&butype=21&scheduleflag=1&buname=qqlive&vkey" + "=FAB0FC75C2CBB6F0FD01CC3CD5DD86D8B118E1223" + "D547D071D9B1BD14E7046850699ADC06E6BD3DB6AC4E456DB26A1DEDC96130868DCA0B7F73799B2F16218AC51D75D1933CB9611A60CAE23566E48CEB6E6DAB8B47" + "9ABA9&guid=4622487A6699E4F92E2A083A12D25E5899B7CE21&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2017%2Fpc_index.html&apptype=live", headers, this.exceptionStatus, this.timeout);
    }

    public void kvGetCommon(String uri) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Cache-Control", "no-cache");
        headers.put("Pragma", " no-cache");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pac_uid=1_125826029; pt2gguin=o0408404664; pgv_info=ssid=s1069950349; o_cookie=408404664");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri, headers, this.exceptionStatus, this.timeout);
    }

    public void kvCommon(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Cache-Control", "no-cache");
        headers.put("Pragma", " no-cache");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pac_uid=1_125826029; pt2gguin=o0408404664; pgv_info=ssid=s1069950349; o_cookie=408404664");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Origin", "http://imgcache.qq.com");
        headers.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.post(KV_URL, body, headers, this.exceptionStatus, this.timeout);
    }

    public void live_poll() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Cache-Control", "no-cache");
        headers.put("Pragma", " no-cache");
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pac_uid=1_125826029; pt2gguin=o0408404664; pgv_info=ssid=s1069950349; o_cookie=408404664");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&needmark=1&pollDataKey=pid%3D53681%26type%3D&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_index.html&apptype=live";
            String host = tmpUrl.substring(8);
            host2 = host.substring(0, host.indexOf('/'));
            url = new URL(tmpUrl);
        } catch (Exception var20) {
            if (this.exceptionStatus) {
                var20.printStackTrace();
            }
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
            conn.addRequestProperty("Cache-Control","no-cache");
            conn.addRequestProperty("Pragma", "no-cache");
            conn.addRequestProperty("Host", host2);
            conn.addRequestProperty("Referer", this.uri_index);
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
            conn.addRequestProperty("X-Requested-With", "ShockwaveFlash/26.0.0.151");
            inStream = conn.getInputStream();
            byte[] buffer = new byte[1204];
            int totalSize = this.videoDownSize;
            while((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                if (bytesum >= totalSize) {
                    System.out.println("视频大小上限..." + bytesum + "---" + totalSize);
                    break;
                }
            }
        } catch (Exception var18) {
            if (this.exceptionStatus) {
                var18.printStackTrace();
            }
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException var17) {
            }

        }

    }
}
