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
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&dc=7483&P2PVer=&flashver=WIN&CheckSum=105821293&progid=124234303&BossId=2583&sRef=&iQQ=125826029");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=3&ptag" +
                "=&P2PVer=0&adid=&vurl=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&sid=124234303&iQQ=125826029&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid" +
                "=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("int1=0&int2=0&iTy=2052&bid=pcvideo&val2=&val=100&str4=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124234303&rnd=6889&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str2=1%2E4%2E6&iSta=7");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=49&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=D6956BAA30C9309BECE8704F0193827EDF4075EC&pid" +
                "=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&vid=124234303&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=0&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0%26vid" +
                "%3D124234303%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin" +
                "%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D2107EC266BC90F64B1C94DF9F8F618F076E00FA3%26adaptor%3D2" +
                "%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D%26st%3D0&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=206");
        this.kvCommon("int1=0&int2=1&iTy=2052&bid=pcvideo&val2=&val=100&str4=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124234303&rnd=9444&itype=50&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str2=1%2E4%2E6&iSta=7");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=7&ptag" +
                "=&P2PVer=0&adid=&vurl=&val1=0&BossId=3007&val2=0&val=0&p2pver=0&sid=124234303&iQQ=125826029&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid" +
                "=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=4&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2F175%2E6%2E13%2E139%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA%2F124234301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&val1=0&BossId=3007&val2=0&val=430&p2pver=0&sid=124234303&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=5&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2F218%2E75%2E176%2E181%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F3D679FE7C9F686FA51E48AEDFECC7E3CFE3CBE1A1F8ED5D57F4FD55F10C2248794583D124023F1E5AF019D48B59BB6E41560B1B3559B0A3D00785EF65D447320F2E7DE4DFCB3D415BEB99461040B70A8C2B50D29EA9CCC13%2F124234301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D3D679FE7C9F686FA51E48AEDFECC7E3CFE3CBE1A1F8ED5D57F4FD55F10C2248794583D124023F1E5AF019D48B59BB6E41560B1B3559B0A3D00785EF65D447320F2E7DE4DFCB3D415BEB99461040B70A8C2B50D29EA9CCC13&val1=0&BossId=3007&val2=0&val=256071&p2pver=0&sid=124234303&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=600577557FDB36E1969B996BC38624683B234E31&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        this.kvCommon("avr=TencentPlayerLiveV3%2E2%2E3%2E07&cip=&dip=zijian&vky" +
                "=ADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&gid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&iTy=2595&uin=125826029&cky=SDPk8Q%5F0SFsGa1N9CMxu99mxavGxXdbY6K5jazeM0nH8r8OYs0CziCFFwsTE%2D8fwR60h7LZzrwtolOKwl%2DxkEGtvsq9HnkETMJ0HyNwN9g6oWOcN31x%2DqIlmS73gyNsNFj%2DSJb2GP8kOOJY4uf1MSTwfNgsYK9B1Q%5F2fnR6gwxWBGSTPD5KzOc77cnB7nXj4sy8QPYRs6CxlXjksQp0R8gAilHPVscHvYmuIdc83yzOVcO2T3S%2DRFCnD%2DRO8xVcMxIUBZWYNAOnpBpaUR6LMx%2DNY31Pk5f9ignLdUdGdrDLqxepnOJxsQnv%5FCzsGARNjQK8vzg&cnl=124234303&ftime="+System.currentTimeMillis()+"&evr=5%2E4&cts="+System.currentTimeMillis()/1000+"&plt=1&sdt=70202");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=1100" +
                "&ptag=&P2PVer=0&adid=&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fstream%3D2%26queueStatus" +
                "%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame" +
                "%253Dcfm%26flashver%3D29%2C0%2C0%2C171%26livequeue%3D1%26cmd%3D2%26system%3D0%26vip%5Fstatus%3D0" +
                "%26fntick%3D0%26txvjsv%3D2%26appVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26defn%3D%26guid" +
                "%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26encryptVer%3D5%2E4%26pla%3D0%26defauto%3D1%26browser" +
                "%3Dchrome%26rnd%3D83%26cnlid%3D124234303%26rid%3D2107EC266BC90F64B1C94DF9F8F618F076E00FA3%26flvtype" +
                "%3D1%26sdtfrom%3D70202%26cKey%3DSDPk8Q%5F0SFsGa1N9CMxu99mxavGxXdbY6K5jazeM0nH8r8OYs0CziCFFwsTE" +
                "%2D8fwR60h7LZzrwtolOKwl%2DxkEGtvsq9HnkETMJ0HyNwN9g6oWOcN31x%2DqIlmS73gyNsNFj" +
                "%2DSJb2GP8kOOJY4uf1MSTwfNgsYK9B1Q" +
                "%5F2fnR6gwxWBGSTPD5KzOc77cnB7nXj4sy8QPYRs6CxlXjksQp0R8gAilHPVscHvYmuIdc83yzOVcO2T3S%2DRFCnD" +
                "%2DRO8xVcMxIUBZWYNAOnpBpaUR6LMx%2DNY31Pk5f9ignLdUdGdrDLqxepnOJxsQnv%5FCzsGARNjQK8vzg&val1=0&BossId" +
                "=3007&val2=0&val=216&p2pver=0&sid=124234301&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        Thread stream = null;
        if (this.videoTime > 0 && this.videoDownSize > 0) {
            stream = new Thread(() -> {
                this.httpDownload();
            });
            stream.start();
        }

        this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime="+System.currentTimeMillis()+"&platform=1&Pwd" +
                "=779660211&vkey=ADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&cnlID=124234303");
        this.kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&fplayerver" +
                "=30203007&iTy=3007&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm" +
                "&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&step=6&ptag" +
                "=&P2PVer=0&adid=&vurl=http%3A%2F%2F175%2E6%2E13%2E139%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA%2F124234301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&val1=0&BossId=3007&val2=0&val=883&p2pver=0&sid=124234301&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&ctime="+cTimeStr()+"&sdtfrom=70202&Pwd=881273072&pid=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&flashver=WIN%2029%2E0%2E0%2E171");
        kvCommon("sOp=webflash&iTy=1991&cdn=zijian&playAd=0&iFlow=0&PeerConnRate=0&sRef=&iSta=0&svrCount=0&P2PVer=0" +
                "&time="+System.currentTimeMillis()+"&p2pCount=0&playNo=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&P2PReDelay=0" +
                "&loadingTime=831&xserverip=&SuNodDelay=0&blockCount=0&averRemtime=0&blockTime=0&progid=124234301" +
                "&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&peerCount=0" +
                "&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2F175%2E6%2E13%2E139%3A8080" +
                "%2Fvzb%2Etc%2Eqq%2Ecom%2FADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA%2F124234301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&pla=1&StartP2P=0&prdLength=3&str%5Fparam2=175%2E6%2E13%2E139&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=282&clientip=&flashver=WIN%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=988&fullScreen=0&ReqSNBlockOutRange=0&PeerServerIP=0&str%5Fparam1=zijian&reCnnCount=0&fplayerver=30203007&cnnTime=52&cmd=205&blockHasData=0&type=17&playerOnPlayTime=1413&HashNotFinished=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&lookback=0&seq=0&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&ispay=0&CDNAbnormal=0&playtime=0&UDPDownSum=0&isuserpay=0&livepid=52592&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&UpdataSpeed=0&sIp=&switch=0&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&sBiz=zhibo&adstat=0&dsip=175%2E6%2E13%2E139");
        this.live_poll();
        this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime="+System.currentTimeMillis()+"&platform=1&Pwd" +
                "=779660211&vkey=ADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&cnlID=124234303");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=34&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=FC23329CACD37602ED9EEEC327A54ED7A25E8299&pid" +
                "=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&vid=124234301&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124234301%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D2107EC266BC90F64B1C94DF9F8F618F076E00FA3%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2433");
        this.kvCommon("int1=0&int2=0&iTy=2052&bid=pcvideo&val2=&val=100&str4=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124234301&rnd=2948&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str2=1%2E4%2E6&iSta=7");
        this.kvGetCommon("http://btrace.video.qq" +
                ".com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcfm&sRef=&sPageId=&sPos=&step=3&val=75&val1=2&val2=604" +
                "&val3=&val4=&val5=&apid=FC23329CACD37602ED9EEEC327A54ED7A25E8299&pid" +
                "=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&vid=124234301&platform=1&pversion" +
                "=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla%2F5.0%20" +
                "(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)" +
                "%20Chrome%2F65.0.3325.181%20Safari%2F537.36&adtype=2&vurl=http%3A%2F%2Flivew.l.qq" +
                ".com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124234301%26coverid%3D" +
                "%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0" +
                "%26vptag%3D%26pid%3D2107EC266BC90F64B1C94DF9F8F618F076E00FA3%26adaptor%3D2%26musictxt%3D%26chid%3D0" +
                "%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random" +
                "=6649");
        kvCommon("int1=0&int2=1&iTy=2052&bid=pcvideo&val2=&val=100&str4=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&ver=TencentPlayerLiveV3%2E2%2E3%2E07&str1=&str3=&vid=124234301&rnd=3923&itype=52&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&str2=1%2E4%2E6&iSta=7");
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
        headers1.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; ts_uid=8358206256; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s7434192500; ts_last=tga.qq.com/match/2018/pc_game.html");
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
            this.kvCommon("sOp=webflash&iTy=1991&cdn=zijian&playAd=0&iFlow=0&PeerConnRate=0&sRef=&iSta=0&svrCount=0" +
                    "&P2PVer=0&time="+System
                    .currentTimeMillis()+"&p2pCount=0&playNo=2107EC266BC90F64B1C94DF9F8F618F076E00FA3&P2PReDelay=0" +
                    "&loadingTime=0&xserverip=&SuNodDelay=0&blockCount=0&averRemtime=0&blockTime=0&progid=124234301" +
                    "&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcfm&peerCount=0" +
                    "&errorCode=10000&averPeerMeHealth=0&fullecode=10000&durl=http%3A%2F%2F175%2E6%2E13%2E139%3A8080" +
                    "%2Fvzb%2Etc%2Eqq%2Ecom%2FADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA%2F124234301%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&pla=1&StartP2P=0&prdLength=60&str%5Fparam2=175%2E6%2E13%2E139&PeerServerPort=0&app=live&SuperNodeIP=0&downSpeed=122&clientip=&flashver=WIN%2029%2E0%2E0%2E171&SuperNodePort=0&maxSpeed=0&fullScreen=0&ReqSNBlockOutRange=0&PeerServerIP=0&str%5Fparam1=zijian&reCnnCount=0&fplayerver=30203007&cnnTime=0&cmd=263&blockHasData=0&type=17&playerOnPlayTime=0&HashNotFinished=0&viewid=&transtype=0&returnBitmapErr=0&HttpDownlandSpeed=0&lookback=0&seq="+seq+"&HttpDownSum=0&lookbackseq=0&videopos=0&UDPDownlandSpeed=0&ispay=0&CDNAbnormal=0&playtime=0&UDPDownSum=0&isuserpay=0&livepid=52592&iQQ=125826029&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&UpdataSpeed=0&sIp=&switch=0&UDPUpSum=0&live%5Ftype=8&cnnPS=0&RtmfpInfo=0&sBiz=zhibo&adstat=0&dsip=175%2E6%2E13%2E139");
            this.sleep();
            this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime="+System.currentTimeMillis()+"&platform=1" +
                    "&Pwd" +
                    "=779660211&vkey=ADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&cnlID=124234303");
            this.sleep();
            this.live_poll();
            this.sleep();
            this.kvCommon("guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&BossId=3460&ftime="+System
                    .currentTimeMillis()+"&platform=1&Pwd=779660211&vkey" +
                    "=ADD6FF894BCE5765C5FC98BCE038F7C57EF2F5D5AD5AAFADFA6E9F1FF307763BAB421C057638D25A0693ABD745986DC8B79655FC67032EB2AABE7C88F36C54757FEA79E75A4FCD90D45A719502184901994F126B97D8B1CA&cnlID=124234303");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s7434192500");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s7434192500");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; o_cookie=125826029; pac_uid=1_125826029; luin=o0125826029; lskey=00010000eae3ba92891b3c3a656567c2af61cc2e72567a84fc2b96c4d853300251f3f7ede7bb68ce4a35c90b; main_login=qq; vuserid=218282033; vusession=1b211f03251de6c253fc014f4d0c; pt2gguin=o0408404664; bRankChanged=TRUE; rankv=2018052310; pgv_info=ssid=s7434192500");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", this.uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&pollDataKey=pid%3D52592%26type%3D&qqlog=125826029&needmark=1&markContext=last%3D0", headers, this.exceptionStatus, this.timeout);
    }

    public void httpDownload() {
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        String host2 = null;

        try {
            String tmpUrl = this.videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcfm&apptype=live";
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
