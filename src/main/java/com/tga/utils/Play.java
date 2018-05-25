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
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&P2PVer=&dc=2252&progid=124233603&CheckSum=105821293&BossId=2583&flashver=WIN&sRef=&iQQ=125826029");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=3&ptag=&P2PVer=0&adid=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&vurl=&sid=124233603&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2011%3A19%3A02%20212&sdtfrom=70202&Pwd=881273072&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("int2=0&iTy=2052&rnd=5932&val2=&val=100&str4=F842772E5579184235F3EEBF2A360CABABCFDB74&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124233603&int1=0&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&bid=pcvideo&str2=1%2E4%2E6&iSta=7");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=14&val1=2&val2=604&val3=&val4=&val5=&apid=0EAABBDC9BA50D1FF6411FC94CB1412B5B167F7F&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&vid=124233603&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124233603%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DF842772E5579184235F3EEBF2A360CABABCFDB74%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D%26st%3D0%26retry%3D1&reporttime=2018-05-25%2011:19:02%20380&bdua=0&admtype=0&adid=&guid=&ispip=0&random=104");
        this.kvCommon("int2=1&iTy=2052&rnd=5314&val2=&val=100&str4=F842772E5579184235F3EEBF2A360CABABCFDB74&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124233603&int1=0&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&bid=pcvideo&str2=1%2E4%2E6&iSta=7");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=7&ptag=&P2PVer=0&adid=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&vurl=&sid=124233603&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2011%3A19%3A02%20708&sdtfrom=70202&Pwd=881273072&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=4&ptag=&P2PVer=0&adid=&val1=0&BossId=3007&val2=0&val=385&p2pver=0&vurl=http%3A%2F%2F222%2E242%2E193%2E41%3A8080%2Fvzb%2Etc%2Eqq%2Ecom%2FFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74%2F124233601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1527218342%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74&sid=124233603&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2011%3A19%3A02%20824&sdtfrom=70202&Pwd=881273072&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&step=5&ptag=&P2PVer=0&adid=&val1=0&vurl=http%3A%2F%2F175%2E6%2E26%2E46%3A8080%2Fvzb%2Etc%2Eqq%2Ecom%2F0FE5B6EB3CC0EF5DA09B647BD9255E4DE4B8CAB0ED97826FFCA6DDFBFE08C4A24A9007D2F02A712F27C03DC059E124648CAA8C612ADDE7E1124912A40989CAA48AAA2EA40367A11CDC326906C106E492C68AF1E7188E53A0%2F124227301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1527216524%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D0FE5B6EB3CC0EF5DA09B647BD9255E4DE4B8CAB0ED97826FFCA6DDFBFE08C4A24A9007D2F02A712F27C03DC059E124648CAA8C612ADDE7E1124912A40989CAA48AAA2EA40367A11CDC326906C106E492C68AF1E7188E53A0&val2=0&val=225817&p2pver=0&BossId=3007&sid=124227303&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2010%3A48%3A44%20513&sdtfrom=70202&Pwd=881273072&pid=754538D33433C6DA0CF42E9F558B82440882A334&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Findex%2Ehtml&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("cip=&iTy=2595&evr=5%2E4&dip=zijian&plt=1&uin=125826029&cnl=124233603&avr=TencentPlayerLiveV3%2E2%2E3%2E07&ftime=1527218342918&cts=1527218342&cky=FCIbOlOlt5AGa1N9CMxu99mxavGxXdbY6K5jazeM0nHc5kNmiSdroRAxeoozpHgIIZvoUc%5FtqqEX7D9tWCn%5FOFBuyXtCXoKIfYB09bdZDcE7979wd1qMOPeA%5FQCOm5r4cZ89MvpbJgticaFBkrvIW9T0CxGYnJpDWrEjGC%5Fn6c5rmsfeKuxg2eB7UUe6C93Y5N8xMcIP8COlaH4UvNO7ds%5FdgA1%2DsmB3XKtGQZYfCknei2%2DjNeVgdXmZTcW9eih44ZVwEJm6rD0eF6afd4%2DJXo3jsC6zhTfc5qd%2DPHszrJICnm4i2yRrfnwUkmagI7UGb9oSug&vky=FADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74&gid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&sdt=70202");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=1100&ptag=&P2PVer=0&adid=&val1=0&BossId=3007&val2=0&val=150&p2pver=0&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fstream%3D2%26queueStatus%3D0%26defauto%3D1%26rnd%3D310%26livequeue%3D1%26cKey%3DFCIbOlOlt5AGa1N9CMxu99mxavGxXdbY6K5jazeM0nHc5kNmiSdroRAxeoozpHgIIZvoUc%5FtqqEX7D9tWCn%5FOFBuyXtCXoKIfYB09bdZDcE7979wd1qMOPeA%5FQCOm5r4cZ89MvpbJgticaFBkrvIW9T0CxGYnJpDWrEjGC%5Fn6c5rmsfeKuxg2eB7UUe6C93Y5N8xMcIP8COlaH4UvNO7ds%5FdgA1%2DsmB3XKtGQZYfCknei2%2DjNeVgdXmZTcW9eih44ZVwEJm6rD0eF6afd4%2DJXo3jsC6zhTfc5qd%2DPHszrJICnm4i2yRrfnwUkmagI7UGb9oSug%26fntick%3D0%26system%3D0%26vip%5Fstatus%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26rid%3DF842772E5579184235F3EEBF2A360CABABCFDB74%26guid%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26txvjsv%3D2%26pla%3D0%26defn%3D%26browser%3Dchrome%26sdtfrom%3D70202%26cnlid%3D124233603%26encryptVer%3D5%2E4%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dwzry%26flashver%3D29%2C0%2C0%2C171%26cmd%3D2%26flvtype%3D1&sid=124233601&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2011%3A19%3A02%20928&sdtfrom=70202&Pwd=881273072&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2029%2E0%2E0%2E171");
        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime=1527218343140&platform=1&Pwd=779660211&cnlID=124233603&vkey=FADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&fplayerver=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&step=6&ptag=&P2PVer=0&adid=&val1=0&BossId=3007&val2=0&val=844&p2pver=0&vurl=http%3A%2F%2F222%2E242%2E193%2E41%3A8080%2Fvzb%2Etc%2Eqq%2Ecom%2FFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74%2F124233601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1527218342%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74&sid=124233601&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime=2018%2D05%2D25%2011%3A19%3A03%20772&sdtfrom=70202&Pwd=881273072&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("sOp=webflash&iTy=1991&cdn=zijian&playAd=0&iFlow=0&PeerConnRate=0&sRef=&iSta=0&svrCount=0&P2PVer=0&time=1527218343816&p2pCount=0&playNo=F842772E5579184235F3EEBF2A360CABABCFDB74&P2PReDelay=0&loadingTime=782&xserverip=&SuNodDelay=0&blockCount=0&averRemtime=0&blockTime=0&progid=124233601&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&peerCount=0&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2F222%2E242%2E193%2E41%3A8080%2Fvzb%2Etc%2Eqq%2Ecom%2FFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74%2F124233601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1527218342%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74&pla=1&StartP2P=0&prdLength=5&str%5Fparam2=222%2E242%2E193%2E41&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=158&clientip=&flashver=WIN%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=999&fullScreen=0&ReqSNBlockOutRange=0&PeerServerIP=0&str%5Fparam1=zijian&reCnnCount=0&fplayerver=30203007&cnnTime=62&cmd=205&blockHasData=0&type=17&playerOnPlayTime=1331&lookback=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&CDNAbnormal=0&seq=0&HttpDownSum=0&lookbackseq=0&switch=0&UDPDownlandSpeed=0&ispay=0&sIp=&playtime=0&UDPDownSum=0&videopos=0&livepid=52585&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&UpdataSpeed=0&sBiz=zhibo&isuserpay=0&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&HashNotFinished=0&adstat=0&dsip=222%2E242%2E193%2E41");
        this.live_poll();
        this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime=1527218374531&platform=1&Pwd=779660211&cnlID=124233603&vkey=FADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=35&val1=2&val2=604&val3=&val4=&val5=&apid=945DD733DEC50C5EFB9FC072A452940A01825931&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&vid=124233601&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124233601%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DF842772E5579184235F3EEBF2A360CABABCFDB74%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D&reporttime=2018-05-25%2011:19:48%20983&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3625");
        this.kvCommon("int2=0&iTy=2052&rnd=7762&val2=&val=100&str4=F842772E5579184235F3EEBF2A360CABABCFDB74&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124233601&int1=0&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&bid=pcvideo&str2=1%2E4%2E6&iSta=7");
        this.kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dwzry&sRef=&sPageId=&sPos=&step=3&val=35&val1=2&val2=604&val3=&val4=&val5=&apid=945DD733DEC50C5EFB9FC072A452940A01825931&pid=F842772E5579184235F3EEBF2A360CABABCFDB74&vid=124233601&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124233601%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DF842772E5579184235F3EEBF2A360CABABCFDB74%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D&reporttime=2018-05-25%2011:19:48%20983&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3625");
        this.kvCommon("int2=1&iTy=2052&rnd=8798&val2=&val=100&str4=F842772E5579184235F3EEBF2A360CABABCFDB74&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124233601&int1=0&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&bid=pcvideo&str2=1%2E4%2E6&iSta=7");
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
        headers1.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; ts_uid=8358206256; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; pt2gguin=o0408404664; ts_last=tga.qq.com/match/2018/pc_index.html; pgv_info=ssid=s8297247590&pgvReferrer=");
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
            this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime=1527218497117&platform=1&Pwd=779660211&cnlID=124233603&vkey=FADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74");
            this.sleep();
            this.kvCommon("sOp=webflash&iTy=1991&cdn=zijian&playAd=0&iFlow=0&PeerConnRate=0&sRef=&iSta=0&svrCount=0&P2PVer=0&time=1527218523945&p2pCount=0&playNo=F842772E5579184235F3EEBF2A360CABABCFDB74&P2PReDelay=0&loadingTime=0&xserverip=&SuNodDelay=0&blockCount=0&averRemtime=0&blockTime=0&progid=124233601&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dwzry&peerCount=0&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2F222%2E242%2E193%2E41%3A8080%2Fvzb%2Etc%2Eqq%2Ecom%2FFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74%2F124233601%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D1527218342%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DFADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74&pla=1&StartP2P=0&prdLength=60&str%5Fparam2=222%2E242%2E193%2E41&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=133&clientip=&flashver=WIN%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=0&fullScreen=0&ReqSNBlockOutRange=0&PeerServerIP=0&str%5Fparam1=zijian&reCnnCount=0&fplayerver=30203007&cnnTime=0&cmd=263&blockHasData=0&type=17&playerOnPlayTime=0&lookback=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&CDNAbnormal=0&seq=3&HttpDownSum=0&lookbackseq=0&switch=0&UDPDownlandSpeed=0&ispay=0&sIp=&playtime=0&UDPDownSum=0&videopos=0&livepid=52585&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&UpdataSpeed=0&sBiz=zhibo&isuserpay=0&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&HashNotFinished=0&adstat=0&dsip=222%2E242%2E193%2E41");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime=1527218527822&platform=1&Pwd=779660211&cnlID=124233603&vkey=FADEBFA8E7F4C0B93270D0660AAEEEC5CE3EFFDA491225A36FA92699FFA13D19A0D745F528830392D4EECECA78F55D2CC491A427DF07EE14FE3938D1F0D10A8EA316E188CB7CF629F3DB7C9DA87CF484B5AD8FABFEA90A74");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s8297247590&pgvReferrer=http://tiem-cdn.qq.com/html/mms/nativeads/game_rank.html");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s8297247590&pgvReferrer=http://tiem-cdn.qq.com/html/mms/nativeads/game_rank.html");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s8297247590&pgvReferrer=http://tiem-cdn.qq.com/html/mms/nativeads/game_rank.html");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("Pragma", "no-cache");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&needmark=1&qqlog=125826029&pollDataKey=pid%3D52585%26type%3D&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dwzry&apptype=live";
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
