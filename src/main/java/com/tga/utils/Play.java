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

        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&CheckSum=105821293&progid=124228403&P2PVer=&flashver=WIN&dc=4880&BossId=2583&iQQ=408404664&sRef=");
        kvCommon("step=3&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&vurl" +
                "=&sid=124228403&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq" +
                "%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&tpay=0");
        kvCommon("str4=AB461DEF47BFFDD3E3256A85A970D462B427513D&int2=0&iSta=7&bid=pcvideo&str2=1%2E4%2E6&str3=&itype=50&val=100&str1=&int1=0&vid=124228403&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&iTy=2052&rnd=2531&val2=&ver=TencentPlayerLiveV3%2E2%2E3%2E07");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dpg&sRef=&sPageId=&sPos=&step=3&val=56&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=C9C573A339EED9D2505ADB20E6206FA56664512F&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&vid=124228403" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124228403%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3DAB461DEF47BFFDD3E3256A85A970D462B427513D%26adaptor%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=8798");
        kvCommon("str4=AB461DEF47BFFDD3E3256A85A970D462B427513D&int2=1&iSta=7&bid=pcvideo&str2=1%2E4%2E6&str3=&itype=50&val=100&str1=&int1=0&vid=124228403&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&iTy=2052&rnd=575&val2=&ver=TencentPlayerLiveV3%2E2%2E3%2E07");
        kvCommon("step=7&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&vurl" +
                "=&sid=124228403&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&tpay=0");
        kvCommon("step=4&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&vurl" +
                "=http%3A%2F%2F218%2E75%2E177%2E102%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F%2F124228401%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&sid=124228403&val1=0&ctime="+cTimeStr()+"&adid=&val=349&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&tpay=0");
        kvCommon("cnl=124228403&ftime="+System
                .currentTimeMillis()+"&gid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&evr=5%2E4&iTy=2595&cts="+System
                .currentTimeMillis()/1000
                +"&sdt" +
                "=70202&avr" +
                "=TencentPlayerLiveV3%2E2%2E3%2E07&cip=&dip=zijian&cky=0V32TJbaWuYGa1N9CMxu99mxavGxXdbY6K5jazeM0nFOVxMEMAtfsC4OOqIok7btNDIUVphA9u3Awa12qpVNaXq2P6CKLmRwH4J8swBAPFuTJbl0ja%5FJ%2D0FjO08EWCfj7Ro%5Fbs2IHxu5b%5FoTBGFApNQ5RYLrO0JsN1pC6TuwnMW1mVTAHpkGbEDLJ5SREvTcycnFsJ7PEoCJ5gUmmNBC%5FqAey5oSPNy1aFYmBEzs1WecXWGrKWigVQssV52%5F9vsBDw%2DnkDHQOCNlZV1p2i%2Dy4TrxACBOcgZVHioZK%5FSDeJ67KmlWQy4pA5IKI3bJk%5FLuJ1xiwA&uin=408404664&vky=44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&plt=1");
        kvCommon
                ("step=1100&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                        "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0" +
                        "&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3FappVer%3DTencentPlayerLiveV3%2E2%2E3" +
                        "%2E07%26queueStatus%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc" +
                        "%5Fgame%2Ehtml%253Fgame%253Dpg%26pla%3D0%26flashver%3D29%2C0%2C0%2C113%26guid" +
                        "%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26stream%3D2%26livequeue%3D1%26flvtype%3D1" +
                        "%26txvjsv%3D2%26defn%3D%26cKey%3D0V32TJbaWuYGa1N9CMxu99mxavGxXdbY6K5jazeM0nFOVxMEMAtfsC4OOqIok7btNDIUVphA9u3Awa12qpVNaXq2P6CKLmRwH4J8swBAPFuTJbl0ja%5FJ%2D0FjO08EWCfj7Ro%5Fbs2IHxu5b%5FoTBGFApNQ5RYLrO0JsN1pC6TuwnMW1mVTAHpkGbEDLJ5SREvTcycnFsJ7PEoCJ5gUmmNBC%5FqAey5oSPNy1aFYmBEzs1WecXWGrKWigVQssV52%5F9vsBDw%2DnkDHQOCNlZV1p2i%2Dy4TrxACBOcgZVHioZK%5FSDeJ67KmlWQy4pA5IKI3bJk%5FLuJ1xiwA%26sdtfrom%3D70202%26browser%3Dchrome%26defauto%3D1%26system%3D0%26vip%5Fstatus%3D0%26cnlid%3D124228403%26cmd%3D2%26rnd%3D46%26fntick%3D0%26encryptVer%3D5%2E4%26rid%3DAB461DEF47BFFDD3E3256A85A970D462B427513D&sid=124228401&val1=0&ctime="+cTimeStr()+"&adid=&val=144&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&tpay=0");
        //kvCommon("sid=124209001&adid=&iQQ=0&ctime=" + cTimeStr() +
        //        "&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
        //        "%5Fgame%2Ehtml%3Fgame%3Dlol&sdtfrom=70202&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc" +
        //        "%5Fgame%2Ehtml%3Fgame%3Dlol&flashver=WIN%2026%2E0%2E0%2E151&sref=http%3A%2F%2Ftga%2Eqq%2Ecom" +
        //        "%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&fplayerver=30201000&iTy=3007&p2pver=0&val=353&ptag" +
        //        "=&tpay=0&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2017%2Fpc%5Fgame%2Ehtml%3Fgame%3Dlol&step=1100" +
        //        "&pid=40A69A3E214B35258876B5DA01B5FADC3702ED76&vurl=http%3A%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F" +
        //        "%3Flivequeue%3D1%26rid%3D40A69A3E214B35258876B5DA01B5FADC3702ED76%26flvtype%3D1%26defn%3D%26host" +
        //        "%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2017%252Fpc%5Fgame%2Ehtml%253Fgame%253Dlol" +
        //        "%26cnlid%3D124209001%26system%3D0%26appVer%3DTencentPlayerLiveV3%2E2%2E1%2E00%26guid" +
        //        "%3D3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B%26cKey
        // %3DTCvnbQusS8cGa1N9CMxu99mxavGxXdbY6K5jazeM0nFv7F%5FZRmcwLdOfYhte%2DmsJXACH5w1AijuX0Tsn0R5sDxjVTlCSV%2DabIkepag0IsRXdPRGh4jdA8H6QOfMd70k1ONRdszlMdj5L73Ari79TFsEay8IZ9lI2bMY%5F36POohluRLzZDidQXT9%2D%5FBp%2DvmTnrKhVyeVvlSTUE3knpwmrAX744LYQ58xdQre3cD7p679pvW8RU2qkyTjWC29zzJhZcfEIR8F883uAP0VSvMDD%5FtPgRHXg33RM6xD4Dl0xdushdofqBl4IYYoHbMU%2DSW0UF%5FoYtQ%26browser%3Dchrome%26vip%5Fstatus%3D0%26cmd%3D2%26flashver%3D26%2C0%2C0%2C151%26queueStatus%3D0%26sdtfrom%3D70202%26defauto%3D1%26fntick%3D0%26encryptVer%3D5%2E4%26rnd%3D78%26pla%3D0%26txvjsv%3D2%26stream%3D2&P2PVer=0&BossId=3007&Pwd=881273072&val1=0&guid=3659F00A089BC7B5EA7869D3F15EB9B5A108ED2B&val2=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("Pwd=779660211&ftime="+System.currentTimeMillis()+"&BossId=3460&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnlID" +
                "=124228403&vkey=44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&platform=1");
        kvCommon("step=6&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&vurl" +
                "=http%3A%2F%2F218%2E75%2E177%2E102%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2F44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F%2F124228401%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&sid=124228401&val1=0&ctime="+cTimeStr()+"&adid=&val=2291&sdtfrom=70202&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&tpay=0");
        kvCommon("sRef=&app=live&cdn=zijian&progid=124228401&flashver=WIN%2029%2E0%2E0%2E113&adstat=0&str%5Fparam1" +
                "=zijian&HttpDownlandSpeed=0&cnnPS=0&iQQ=408404664&durl=http%3A%2F%2F218%2E75%2E177%2E102%3A8080" +
                "%2Fvzb%2Etc%2Eqq%2Ecom%2F44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F%2F124228401%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&HttpDownSum=0&videopos=0&str%5Fparam2=218%2E75%2E177%2E102&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&time="+System.currentTimeMillis()+"&sOp=webflash&xserverip=&switch=0&RtmfpInfo=0&iSta=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&PeerConnRate=0&sIp=&svrCount=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&P2PReDelay=0&fullScreen=0&cmd=205&iTy=1991&SuNodDelay=0&lookback=0&averRemtime=0&live%5Ftype=8&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=2134&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=3&playtime=0&PeerServerIP=0&UDPDownSum=0&downSpeed=221&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=344&isuserpay=0&CDNAbnormal=0&dsip=218%2E75%2E177%2E102&peerCount=0&livepid=49793&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&cnnTime=157&P2PVer=0&seq=0&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=2680&playNo=AB461DEF47BFFDD3E3256A85A970D462B427513D&blockHasData=0&PeerServerPort=0&transtype=0");
        live_poll();
        kvCommon("Pwd=779660211&ftime="+System.currentTimeMillis()+"&BossId=3460&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnlID" +
                "=124228403&vkey=44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&platform=1");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dpg&sRef=&sPageId=&sPos=&step=3&val=30&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A9AE814C248BB365231EAC27B48A78ED8D7859B7&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&vid=124228401" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124228401" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DAB461DEF47BFFDD3E3256A85A970D462B427513D%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9908");
        kvCommon("str4=AB461DEF47BFFDD3E3256A85A970D462B427513D&int2=0&iSta=7&bid=pcvideo&str2=1%2E4%2E6&str3=&itype=52&val=100&str1=&int1=0&vid=124228401&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&iTy=2052&rnd=4743&val2=&ver=TencentPlayerLiveV3%2E2%2E3%2E07");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dpg&sRef=&sPageId=&sPos=&step=3&val=85&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=A9AE814C248BB365231EAC27B48A78ED8D7859B7&pid=AB461DEF47BFFDD3E3256A85A970D462B427513D&vid=124228401" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124228401" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3DAB461DEF47BFFDD3E3256A85A970D462B427513D%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9419");
        kvCommon("str4=AB461DEF47BFFDD3E3256A85A970D462B427513D&int2=1&iSta=7&bid=pcvideo&str2=1%2E4%2E6&str3=&itype=52&val=100&str1=&int1=0&vid=124228401&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&iTy=2052&rnd=7275&val2=&ver=TencentPlayerLiveV3%2E2%2E3%2E07");
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
        headers1.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; ts_uid=8358206256; pgv_info=ssid=s5038653480; ts_last=tga.qq.com/match/2018/pc_game.html");
        headers1.put("Host", "tga.qq.com");
        headers1.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
        headers1.put("Upgrade-Insecure-Requests", "1");
        headers1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        HttpUtil.get(uri_index, headers1, exceptionStatus, timeout);
    }

    public void forEachRequest(int seq) {
        try {
            live_poll();
            sleep();
            kvCommon("sRef=&adstat=4&cdn=zijian&progid=124228401&flashver=WIN%2029%2E0%2E0%2E113&app=live&str" +
                    "%5Fparam1=zijian&HttpDownlandSpeed=0&iQQ=408404664&durl=http%3A%2F%2F218%2E75%2E177%2E102%3A8080" +
                    "%2Fvzb%2Etc%2Eqq%2Ecom%2F44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F%2F124228401%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&HttpDownSum=0&UDPDownSum=0&str%5Fparam2=218%2E75%2E177%2E102&UDPDownlandSpeed=0&sBiz=zhibo&sIp=&clientip=&videopos=0&sOp=webflash&xserverip=&switch=0&RtmfpInfo=0&time="+System.currentTimeMillis()+"&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dpg&PeerConnRate=0&UpdataSpeed=0&iSta=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&svrCount=0&P2PReDelay=0&fullScreen=0&cmd=263&iTy=1991&SuNodDelay=0&lookback=0&averRemtime=0&live%5Ftype=8&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=32&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=326&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&dsip=218%2E75%2E177%2E102&playNo=AB461DEF47BFFDD3E3256A85A970D462B427513D&livepid=49793&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq="+seq+"&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
            sleep();
            kvCommon("Pwd=779660211&ftime="+System
                    .currentTimeMillis()+"&BossId=3460&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnlID" +
                    "=124228403&vkey=44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&platform=1");
            sleep();
            live_poll();
            sleep();
            kvCommon("Pwd=779660211&ftime=1522325366919&BossId=3460&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&cnlID=124228403&vkey=44A89432B47D5A32E81792931E8FE6C320B1508E702A1D58275BC05C8B571DEFEEAC7131E3CE8EC78A34D4B893EC4B06140D6C082D9F212883DE87C4A43BB337566410C2E28585D49F492542A9764DD1468AF515CA21D97F&platform=1");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
        headers.put("Host", "btrace.video.qq.com");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
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
        headers.put("Cookie", "pgv_pvi=4159748096; pgv_pvid=8973725298; pt2gguin=o0408404664; RK=+WdyWLxrOq; ptcz=d788c7d71128384a6ce3c951e9fd1f0cb9d13e449dc71dd437d0217ad527b551; o_cookie=408404664; pac_uid=1_408404664; tvfe_boss_uuid=f71311ddd95cbc74; mobileUV=1_160ddc2bc24_5dc0f; eas_sid=5upy8qYu2kVKdKzKYgLeEtWj0U; pgv_info=ssid=s5038653480");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&needmark=1&qqlog=&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&pollDataKey=pid%3D49793%26type%3D&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dpg&apptype=live";
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


