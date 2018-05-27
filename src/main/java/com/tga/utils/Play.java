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
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&P2PVer=&flashver=WIN&progid=124234103&BossId=2583&dc=8818&sRef=&CheckSum=105821293&iQQ=294743258");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=3&ptag" +
                "=&P2PVer=0&adid=&vurl=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&sid=124234103&iQQ=294743258&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid" +
                "=A59A103532C953550DB40565D5627390E9A425C7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        this.kvCommon("rnd=8189&bid=pcvideo&iTy=2052&str1=&val2=&val=100&str4=A59A103532C953550DB40565D5627390E9A425C7&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124234103&str3=&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&int1=0&int2=0&iSta=7");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=50&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=D66A89BDADBCE6C33D32CA51DF067D09600DC07C&pid" +
                "=A59A103532C953550DB40565D5627390E9A425C7&vid=124234103&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417" +
                "%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124234103%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v" +
                "%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D3946%26vptag%3D%26pid" +
                "%3DA59A103532C953550DB40565D5627390E9A425C7%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid" +
                "%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7766");
        this.kvCommon("rnd=779&bid=pcvideo&iTy=2052&str1=&val2=&val=100&str4=A59A103532C953550DB40565D5627390E9A425C7&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124234103&str3=&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&int1=0&int2=1&iSta=7");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=7&ptag" +
                "=&P2PVer=0&adid=&vurl=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&sid=124234103&iQQ=294743258&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid" +
                "=A59A103532C953550DB40565D5627390E9A425C7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=4&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2Fcloud%2Evideo%2Eqq%2Ecom%3A80%2F124234101%2Eflv%3Fcdncode%3D" +
                "%252f18907E7BE0798990%252f%26time%3D"+System
                .currentTimeMillis()/1000+"%26cdn%3Dcloud%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3DE93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&val1=0&BossId=3007&val2=0&val=267&p2pver=0&sid=124234103&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=A59A103532C953550DB40565D5627390E9A425C7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=5&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2Fdnion%2Evideo%2Eqq%2Ecom%3A80%2F124234101%2Eflv%3Fcdncode%3D" +
                "%252f18907E7BE0798990%252f%26time%3D"+System
                .currentTimeMillis()/1000+"%26cdn%3Ddilian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3DD75D494F25A46599D5C5AA25C93F3739D465196266C9CE2943C7148B9D17F657C0DA7B9F6568973273360032C92EC93A0BD648CA4BA2850E4A0584DAE8D618DE93E7D3B5E31E4EA7F2ED17EAD5049F93B45DA92F9F789D2E&val1=0&BossId=3007&val2=0&val=180504&p2pver=0&sid=124234103&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=C139CE9AEFD797B4B887B9A0F2F0BABFA472E309&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        this.kvCommon("evr=5%2E4&iTy=2595&cnl=124234103&dip=cloud&cip=&vky" +
                "=E93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&sdt=70202&plt=1&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&avr=TencentPlayerLiveV3%2E2%2E3%2E07&cky=MpOhU3UUDfkGa1N9CMxu99mxavGxXdbY6K5jazeM0nFJRHasCMjA8zotYqmithKSObg%2DOSIUmEDgMqf96mbTdN2ZvLYJhGJbDo2%2DK0zpua8OkmaROQN1VNIfQO%2DML1B6UCmvabT2VF2C%5F8hM7CJX4dBSfajWGaRCv1%5FLxrj1ckhMzSrnKjX812pQzSLlf43X0Ye4ABwae5XYF5nq1SQofGQNz9wPK8TDGygPLYg6iy0O0uH08yFZ0AzMACxLkw6fHP3fJCmxU54UmnCz9CARK5NZJjeK3egNb4m%5FLQeZci%2DgpROb2U0hWBMWLks%5FRNqAYlYAyQ&ftime="+System.currentTimeMillis()+"&cts="+System.currentTimeMillis()/1000+"&uin=294743258");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=1100" +
                "&ptag=&P2PVer=0&adid=&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Frnd%3D328%26queueStatus" +
                "%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame" +
                "%253Dhyrz%26defn%3D%26livequeue%3D1%26cmd%3D2%26system%3D3%26vip%5Fstatus%3D0%26stream%3D2%26txvjsv" +
                "%3D2%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26encryptVer%3D5%2E4%26pla%3D0%26defauto%3D1" +
                "%26browser%3Dchrome%26flvtype%3D1%26cnlid%3D124234103%26fntick%3D0%26appVer%3DTencentPlayerLiveV3" +
                "%2E2%2E3%2E07%26rid%3DA59A103532C953550DB40565D5627390E9A425C7%26flashver%3D29%2C0%2C0%2C171" +
                "%26sdtfrom%3D70202%26cKey%3DMpOhU3UUDfkGa1N9CMxu99mxavGxXdbY6K5jazeM0nFJRHasCMjA8zotYqmithKSObg" +
                "%2DOSIUmEDgMqf96mbTdN2ZvLYJhGJbDo2%2DK0zpua8OkmaROQN1VNIfQO%2DML1B6UCmvabT2VF2C" +
                "%5F8hM7CJX4dBSfajWGaRCv1" +
                "%5FLxrj1ckhMzSrnKjX812pQzSLlf43X0Ye4ABwae5XYF5nq1SQofGQNz9wPK8TDGygPLYg6iy0O0uH08yFZ0AzMACxLkw6fHP3fJCmxU54UmnCz9CARK5NZJjeK3egNb4m%5FLQeZci%2DgpROb2U0hWBMWLks%5FRNqAYlYAyQ&val1=0&BossId=3007&val2=0&val=128&p2pver=0&sid=124234101&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=A59A103532C953550DB40565D5627390E9A425C7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon("guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&vkey" +
                "=E93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&platform=1&Pwd=779660211&cnlID=124234103&ftime="+ System.currentTimeMillis());
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&step=6&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2Fcloud%2Evideo%2Eqq%2Ecom%3A80%2F124234101%2Eflv%3Fcdncode%3D" +
                "%252f18907E7BE0798990%252f%26time%3D"+System
                .currentTimeMillis()/1000+"%26cdn%3Dcloud%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                "%26scheduleflag%3D1%26buname" +
                "%3Dqqlive%26vkey%3DE93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&val1=0&BossId=3007&val2=0&val=281&p2pver=0&sid=124234101&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=A59A103532C953550DB40565D5627390E9A425C7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&flashver=MAC%2029%2E0%2E0%2E171");
        this.kvCommon("sOp=webflash&iTy=1991&cdn=cloud&playAd=0&iFlow=0&PeerConnRate=0&sRef=&time="+System
                .currentTimeMillis()+"&iSta=0&svrCount=0&P2PVer=0&p2pCount=0&playNo=A59A103532C953550DB40565D5627390E9A425C7" +
                "&P2PReDelay=0&loadingTime=168&xserverip=&SuNodDelay=0&blockCount=0&switch=0&averRemtime=0&blockTime" +
                "=0&progid=124234101&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame" +
                "%3Dhyrz&peerCount=0&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2Fcloud" +
                "%2Evideo%2Eqq%2Ecom%3A80%2F124234101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System
                .currentTimeMillis()/1000
                +"%26cdn%3Dcloud%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DE93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&fullScreen=0&StartP2P=0&prdLength=1&str%5Fparam2=cloud%2Evideo%2Eqq%2Ecom&PeerServerPort=0&CDNAbnormal=0&SuperNodeIP=0&downSpeed=719&pla=1&flashver=MAC%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=6215&app=live&fplayerver=30203007&PeerServerIP=0&str%5Fparam1=cloud&type=17&reCnnCount=0&ReqSNBlockOutRange=0&cnnTime=113&cmd=205&blockHasData=0&playerOnPlayTime=602&lookback=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&HashNotFinished=0&seq=0&clientip=&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&ispay=0&sIp=&playtime=0&UDPDownSum=0&isuserpay=0&livepid=52590&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&UpdataSpeed=0&sBiz=zhibo&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&adstat=0&dsip=cloud%2Evideo%2Eqq%2Ecom");
        this.live_poll();
        this.kvCommon("guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&vkey" +
                "=E93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&platform=1&Pwd=779660211&cnlID=124234103&ftime="+System.currentTimeMillis());
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=12&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=34764D6A301BAE646E89DFC887E961A3813240FA&pid" +
                "=A59A103532C953550DB40565D5627390E9A425C7&vid=124234101&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124234101%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D3946" +
                "%26vptag%3D%26pid%3DA59A103532C953550DB40565D5627390E9A425C7%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9949");
        this.kvCommon("rnd=6814&bid=pcvideo&iTy=2052&str1=&val2=&val=100&str4=A59A103532C953550DB40565D5627390E9A425C7&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124234101&str3=&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&int1=0&int2=0&iSta=7");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&sRef=&sPageId=&sPos=&step=3&val=36&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=34764D6A301BAE646E89DFC887E961A3813240FA&pid" +
                "=A59A103532C953550DB40565D5627390E9A425C7&vid=124234101&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20" +
                "(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124234101%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D3946" +
                "%26vptag%3D%26pid%3DA59A103532C953550DB40565D5627390E9A425C7%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9226");
        this.kvCommon("rnd=164&bid=pcvideo&iTy=2052&str1=&val2=&val=100&str4=A59A103532C953550DB40565D5627390E9A425C7&str2=1%2E4%2E6&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124234101&str3=&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dhyrz&int1=0&int2=1&iSta=7");
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
        headers1.put("Pragma", "no-cache");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        headers1.put("Cache-Control", "no-cache");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s342438960; ts_last=tga.qq.com/match/2018/pc_game.html");
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
            this.kvCommon("guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&vkey" +
                    "=E93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&platform=1&Pwd=779660211&cnlID=124234103&ftime="+System.currentTimeMillis());
            this.sleep();
            this.kvCommon("sOp=webflash&iTy=1991&cdn=cloud&playAd=0&iFlow=0&PeerConnRate=0&sRef=&time="+System
                    .currentTimeMillis()+"&iSta=0&svrCount=0&P2PVer=0&p2pCount=0&playNo=A59A103532C953550DB40565D5627390E9A425C7" +
                    "&P2PReDelay=0&loadingTime=0&xserverip=&SuNodDelay=0&blockCount=0&switch=0&averRemtime=0" +
                    "&blockTime=0&progid=124234101&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame" +
                    "%2Ehtml%3Fgame%3Dhyrz&peerCount=0&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http" +
                    "%3A%2F%2Fcloud%2Evideo%2Eqq%2Ecom%3A80%2F124234101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f" +
                    "%26time%3D"+System.currentTimeMillis()
                    /1000+"%26cdn%3Dcloud%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21" +
                    "%26scheduleflag%3D1%26buname%3Dqqlive%26vkey" +
                    "%3DE93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&fullScreen=0&StartP2P=0&prdLength=60&str%5Fparam2=cloud%2Evideo%2Eqq%2Ecom&PeerServerPort=0&CDNAbnormal=0&SuperNodeIP=0&downSpeed=133&pla=1&flashver=MAC%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=0&app=live&fplayerver=30203007&PeerServerIP=0&str%5Fparam1=cloud&type=17&reCnnCount=0&ReqSNBlockOutRange=0&cnnTime=0&cmd=263&blockHasData=0&playerOnPlayTime=0&lookback=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&HashNotFinished=0&seq="+seq+"&clientip=&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&ispay=0&sIp=&playtime=0&UDPDownSum=0&isuserpay=0&livepid=52590&iQQ=294743258&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&UpdataSpeed=0&sBiz=zhibo&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&adstat=0&dsip=cloud%2Evideo%2Eqq%2Ecom");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon("guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&BossId=3460&vkey" +
                    "=E93DF049B4FA46F02C464801086F0E68122F28FA03CA5918166D369895C5EDDA85478605B91E9AB9A76A3FA914D48785F182F74A6EC2CDC1566BFFECDBF9BE01F58F83264558A1A57FCDD50791BEE9FE9BBE7767DC753CD3&platform=1&Pwd=779660211&cnlID=124234103&ftime="+System.currentTimeMillis());
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
        headers.put("Connection", "keep-alive");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s342438960");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Pragma", "no-cache");
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
        headers.put("Cache-Control", "no-cache");
        headers.put("Content-Length", String.valueOf(body.length()));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s342438960");
        headers.put("Host", "btrace.video.qq.com");
        headers.put("Pragma", "no-cache");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pgv_pvid=672048110; pt2gguin=o0294743258; o_cookie=294743258; pgv_info=ssid=s342438960");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("Pragma", "no-cache");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&pollDataKey=pid%3D52590%26type%3D&needmark=1&qqlog=&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dhyrz&apptype=live";
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
            conn.addRequestProperty("Cache-Control", "no-cache");
            conn.addRequestProperty("Host", host2);
            conn.addRequestProperty("Pragma", "no-cache");
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
