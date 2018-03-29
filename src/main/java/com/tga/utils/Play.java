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
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&CheckSum=105821293&progid=124229203&P2PVer=&flashver=WIN&BossId=2583&dc=9204&iQQ=408404664&sRef=");
        this.kvCommon("step=3&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229203&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&pid=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&tpay=0&vurl=");
        this.kvCommon("str3=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int2=0&int1=0&str4=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&itype=50&str1=&rnd=9015&bid=pcvideo&vid=124229203&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str2=1%2E4%2E6&val2=");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=97&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=998DA38077376C352C59C128EA20B1324C05E18C&pid" +
                "=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&vid=124229203&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124229203%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DADA2355AFFA71E8795CC7347B2C17F84551E2AE9%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D%26st%3D0&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=168");
        this.kvCommon("str3=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int2=1&int1=0&str4=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&itype=50&str1=&rnd=2237&bid=pcvideo&vid=124229203&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str2=1%2E4%2E6&val2=");
        this.kvCommon("step=7&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229203&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom" +
                "%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&pid=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&tpay=0&vurl=");
        this.kvCommon("step=4&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229203&val1=0&ctime="+cTimeStr()+"&adid=&val=336&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dhyrz&pid=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&tpay=0&vurl=http%3A%2F%2F222%2E242%2E193" +
                "%2E54%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12%2F124229201%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12");
        this.kvCommon("cts="+System.currentTimeMillis()
                /1000+"&plt=1&avr=TencentPlayerLiveV3%2E2%2E3%2E07&iTy=2595&gid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ftime="+System.currentTimeMillis()+"&dip=zijian&cky" +
                "=HLAEsFs3qBoGa1N9CMxu99mxavGxXdbY6K5jazeM0nH7KWwNtV6Xkz%5Fz2636S8zK3EyS2yPzuZvAGGZeoYHn8SlLleTmqMXaKRlLIVX5uEPWbMQIjf6bONrPvtsMMtZGl8iBUpw8q7lcQlmLKyQif2OKhflKyc4kFlJ6Egj8m94wSNj9ZQV7wZMX36daKBbnWzDDYY5Pg8qe1kyCr%2DSAS5qk6RxGjIHEJ0SSZxK%2DtsnPvK7nHFIOS%5FB2ot6EdPJ9X7Ex7QPsgq%2DiyUtC87ZB5JOmpAgVkGf1Hv5NFgn5a58fgy%5Fu0b8fk4JIiYwYcItLeo8FYw&cip=&sdt=70202&cnl=124229203&uin=408404664&vky=4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&evr=5%2E4");
        this.kvCommon("step=1100&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229201&val1=0&ctime="+cTimeStr()+"&adid=&val=151&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&pid=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&tpay=0&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fstream%3D2%26queueStatus%3D0%26pla%3D0%26flashver%3D29%2C0%2C0%2C113%26guid%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26sdtfrom%3D70202%26defn%3D%26livequeue%3D1%26system%3D0%26cKey%3DHLAEsFs3qBoGa1N9CMxu99mxavGxXdbY6K5jazeM0nH7KWwNtV6Xkz%5Fz2636S8zK3EyS2yPzuZvAGGZeoYHn8SlLleTmqMXaKRlLIVX5uEPWbMQIjf6bONrPvtsMMtZGl8iBUpw8q7lcQlmLKyQif2OKhflKyc4kFlJ6Egj8m94wSNj9ZQV7wZMX36daKBbnWzDDYY5Pg8qe1kyCr%2DSAS5qk6RxGjIHEJ0SSZxK%2DtsnPvK7nHFIOS%5FB2ot6EdPJ9X7Ex7QPsgq%2DiyUtC87ZB5JOmpAgVkGf1Hv5NFgn5a58fgy%5Fu0b8fk4JIiYwYcItLeo8FYw%26txvjsv%3D2%26flvtype%3D1%26rnd%3D971%26encryptVer%3D5%2E4%26fntick%3D0%26vip%5Fstatus%3D0%26cnlid%3D124229203%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dhyrz%26cmd%3D2%26browser%3Dchrome%26defauto%3D1%26rid%3DADA2355AFFA71E8795CC7347B2C17F84551E2AE9%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07");
        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon("BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd=779660211&ftime" +
                "="+System
                .currentTimeMillis()+"&vkey=4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&cnlID=124229203");
        this.kvCommon("step=6&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229201&val1=0&ctime="+cTimeStr()+"&adid=&val=1085&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch" +
                "%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame" +
                "%2Ehtml%3Fgame%3Dhyrz&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml" +
                "%3Fgame%3Dhyrz&pid=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&tpay=0&vurl=http%3A%2F%2F222%2E242%2E193" +
                "%2E54%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12%2F124229201%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12");
        kvCommon("sRef=&app=live&cdn=zijian&progid=124229201&flashver=WIN%2029%2E0%2E0%2E113&transtype=0&adstat=0" +
                "&str%5Fparam1=zijian&HttpDownlandSpeed=0&iQQ=408404664&durl=http%3A%2F%2F222%2E242%2E193%2E54%3A8080" +
                "%2Fvzb%2Etc%2Eqq%2Ecom%2F4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12%2F124229201%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&HttpDownSum=0&videopos=0&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&sIp=&clientip=&time="+System.currentTimeMillis()+"&UDPUpSum=0&xserverip=&UpdataSpeed=0&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str%5Fparam2=222%2E242%2E193%2E54&PeerConnRate=0&iTy=1991&svrCount=0&blockCount=0&UDPDownSum=0&p2pCount=0&viewid=&P2PReDelay=0&fullScreen=0&cmd=205&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=868&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=2&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=162&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=388&isuserpay=0&CDNAbnormal=0&dsip=222%2E242%2E193%2E54&cnnTime=217&livepid=49844&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&playNo=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&P2PVer=0&seq=0&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=1467&cnnPS=0&blockHasData=0&PeerServerPort=0&switch=0");
        this.live_poll();
        this.kvCommon("BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd=779660211&ftime" +
                "="+System
                .currentTimeMillis()+"&vkey=4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&cnlID=124229203");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=26&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=692C6187A056991B80631E64D92A02117A2FDB18&pid" +
                "=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&vid=124229201&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124229201%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3DADA2355AFFA71E8795CC7347B2C17F84551E2AE9%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7992");
        this.kvCommon("str3=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int2=0&int1=0&str4=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&itype=52&str1=&rnd=4979&bid=pcvideo&vid=124229201&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str2=1%2E4%2E6&val2=");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=87&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=692C6187A056991B80631E64D92A02117A2FDB18&pid" +
                "=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&vid=124229201&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124229201%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3DADA2355AFFA71E8795CC7347B2C17F84551E2AE9%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=6110");
        kvCommon("str3=&iSta=7&ver=TencentPlayerLiveV3%2E2%2E3%2E07&val=100&iTy=2052&int2=1&int1=0&str4=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&itype=52&str1=&rnd=4395&bid=pcvideo&vid=124229201&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str2=1%2E4%2E6&val2=");
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
        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; ts_uid=8358206256; pgv_info=ssid=s5038653480; ts_last=tga.qq.com/match/2018/pc_game.html");
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
            this.kvCommon("sRef=&adstat=4&cdn=zijian&progid=124229201&flashver=WIN%2029%2E0%2E0%2E113&switch=0&app" +
                    "=live&str%5Fparam1=zijian&HttpDownlandSpeed=0&iQQ=408404664&durl=http%3A%2F%2F222%2E242%2E193" +
                    "%2E54%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                    "%2F4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12%2F124229201%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&HttpDownSum=0&time="+System.currentTimeMillis()+"&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&UDPUpSum=0&xserverip=&sIp=&RtmfpInfo=0&videopos=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&str%5Fparam2=222%2E242%2E193%2E54&PeerConnRate=0&iTy=1991&iSta=0&blockCount=0&p2pCount=0&viewid=&svrCount=0&P2PReDelay=0&fullScreen=0&cmd=263&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=30&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=337&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&dsip=222%2E242%2E193%2E54&playNo=ADA2355AFFA71E8795CC7347B2C17F84551E2AE9&livepid=49844&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq="+seq+"&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
            this.sleep();
            this.kvCommon("BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd=779660211&ftime" +
                    "="+System
                    .currentTimeMillis()+"&vkey=4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&cnlID=124229203");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon("BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd=779660211&ftime" +
                    "="+System
                    .currentTimeMillis()+"&vkey=4987B1C9D73D32E17518F9E550C54F3855F8EB524512531CAE412C78C5A6831C44E37FA6748B8DCC502A750603AFF89647E8AD62DAFB3CD2AFD5BD0596DCF638005F3CF792FDDF0BA75C5035AFA555996BB7588D647B5D12&cnlID=124229203");
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
        headers.put("Cache-Control", "max-age=0");
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri, headers, this.exceptionStatus, this.timeout);
    }

    public void kvCommon(String body) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&pollDataKey=pid%3D49844%26type%3D&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&qqlog=&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&apptype=live";
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
