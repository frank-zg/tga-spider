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

        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=&BossId=2583&dc=6861&flashver=WIN&progid=124229103&CheckSum=105821293&iQQ=408404664&sRef=");
        kvCommon("step=3&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229103&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&vurl=&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&tpay=0");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&rnd=5889&iSta=7&str4=9CB56171348BB011D6EBE095ED21E6B07DE64775&int1=0&iTy=2052&int2=0&str3=&itype=50&val=100&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124229103&bid=pcvideo&val2=&str2=1%2E4%2E6");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=126&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=34AF0C106A31E060F405F98FE6B80AC3DCA99E84&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&vid=124229103" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124229103%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07" +
                "%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D9CB56171348BB011D6EBE095ED21E6B07DE64775%26adaptor" +
                "%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=692");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&rnd=5889&iSta=7&str4=9CB56171348BB011D6EBE095ED21E6B07DE64775&int1=0&iTy=2052&int2=0&str3=&itype=50&val=100&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124229103&bid=pcvideo&val2=&str2=1%2E4%2E6");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=10&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=34AF0C106A31E060F405F98FE6B80AC3DCA99E84&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&vid=124229103" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid%3D%26pf%3Dout%26pt%3D0%26pc%3D0" +
                "%26vid%3D124229103%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07" +
                "%26plugin%3D1.4.6%26speed%3D0%26vptag%3D%26pid%3D9CB56171348BB011D6EBE095ED21E6B07DE64775%26adaptor" +
                "%3D2%26musictxt%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq" +
                ".com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26st%3D0%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0" +
                "&random=6374");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&rnd=6720&iSta=7&str4=9CB56171348BB011D6EBE095ED21E6B07DE64775&int1=0&iTy=2052&int2=1&str3=&itype=50&val=100&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124229103&bid=pcvideo&val2=&str2=1%2E4%2E6");
        kvCommon("step=7&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229103&val1=0&ctime="+cTimeStr()+"&adid=&val=0&sdtfrom=70202&iTy=3007&vurl=&surl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&tpay=0");
        kvCommon("step=4&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229103&val1=0&ctime="+cTimeStr()+"&adid=&val=410&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2Fdnion" +
                "%2Evideo%2Eqq%2Ecom%3A80%2F124229101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D" +
                ""+System.currentTimeMillis()/1000+"%26cdn%3Ddilian%26sdtfrom%3Dv210221%26platform%3D70202%26butype" +
                "%3D21" +
                "%26scheduleflag%3D1" +
                "%26buname%3Dqqlive%26vkey%3D4BE53621DD557C98DF5A80B2EC8DFBD1AB95AF3039DF146D78F0ABF14FB782EA6E9DE8E0FE0EF65226B354577346A3CBAA8F23EA4A05F9CA7F2E6B2D3B918F4FF5F3AE364BC9EB1607C962E3D6DDB788D1A761A68B59F351&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&tpay=0");
        kvCommon("ptag=&iQQ=408404664&step=5&BossId=3007&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&flashver=WIN" +
                "%2029%2E0%2E0%2E113&Pwd=881273072&fplayerver=30203007&adid=&sid=124229103&p2pver=0&ctime="+cTimeStr()
                +"&val2=0&val=150503&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2F175%2E6%2E40%2E221%3A8080%2Fvzb%2Etc" +
                "%2Eqq%2Ecom%2F44B14CD4AA21584BFE2E01F5800ED8BF5E7491A76BE13E39DADED3A0E2495DED7771176F39FA50F2D4C766930E590AA057D5F0D02E72FD81A6C7021B2F6334DFF46956E5248F59FD8C2EAE6590750E457E9D809331DBA434%2F124229101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D44B14CD4AA21584BFE2E01F5800ED8BF5E7491A76BE13E39DADED3A0E2495DED7771176F39FA50F2D4C766930E590AA057D5F0D02E72FD81A6C7021B2F6334DFF46956E5248F59FD8C2EAE6590750E457E9D809331DBA434&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=04FBEA88A78FFFEBDE44D35026682ECF0B8338DD&tpay=0&val1=0");
        kvCommon("cnl=124229103&ftime="+System
                .currentTimeMillis()+"&gid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&evr=5%2E4&iTy=2595&cts="+System
                .currentTimeMillis()/1000
                +"&sdt=70202&avr" +
                "=TencentPlayerLiveV3%2E2%2E3%2E07&cip=&dip=zijian&cky=Q1ejwATQD2rROq78sNqEOG6t5QAkte5DeA00NEjfJWxt30G%2DGkmciWuYwdQo6ljLDnf0KvQviFn97s1D5pDbFOUP3KIyMCzO%5FRD4W1nUSO3RQBkA5yuPOhxontVrTJEex9evtEuFjBs9YPOgcn9H464FNd8iFbi91qc5%2DSV2oXrJ5lof1hJnbrXyG7MKyuOPq8zrWuXGK3aBm8A92KuvwG7JrJNCj%5FyRQlNN64ce5jUvSqzPYW1wqGJMuisOj73jMlY4Y3s%2DZS%5FDiTrTnyvGKkATEMAMGuRypiWzP4aZF%2DAKcQJxY0H47c90%2D0%5FL8y4vC81kcg&uin=408404664&vky=B5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&plt=1");
        kvCommon("step=1100&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229101&val1=0&ctime="+cTimeStr()+"&adid=&val=157&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2Finfo%2Ezb" +
                "%2Evideo%2Eqq%2Ecom%2F%3FappVer%3DTencentPlayerLiveV3%2E2%2E3%2E07%26rnd%3D494%26pla%3D0%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom%252Fmatch%252F2018%252Fpc%5Fgame%2Ehtml%253Fgame%253Dcf%26guid%3DCC85A8B2B63469304FB594CCF649B47EC46F8BC6%26stream%3D2%26queueStatus%3D0%26system%3D0%26flashver%3D29%2C0%2C0%2C113%26cKey%3DQ1ejwATQD2rROq78sNqEOG6t5QAkte5DeA00NEjfJWxt30G%2DGkmciWuYwdQo6ljLDnf0KvQviFn97s1D5pDbFOUP3KIyMCzO%5FRD4W1nUSO3RQBkA5yuPOhxontVrTJEex9evtEuFjBs9YPOgcn9H464FNd8iFbi91qc5%2DSV2oXrJ5lof1hJnbrXyG7MKyuOPq8zrWuXGK3aBm8A92KuvwG7JrJNCj%5FyRQlNN64ce5jUvSqzPYW1wqGJMuisOj73jMlY4Y3s%2DZS%5FDiTrTnyvGKkATEMAMGuRypiWzP4aZF%2DAKcQJxY0H47c90%2D0%5FL8y4vC81kcg%26sdtfrom%3D70202%26browser%3Dchrome%26livequeue%3D1%26encryptVer%3D5%2E4%26fntick%3D1522323980%26vip%5Fstatus%3D0%26cnlid%3D124229103%26cmd%3D3%26flvtype%3D1%26txvjsv%3D2%26livepid%3D49843%26rid%3D9CB56171348BB011D6EBE095ED21E6B07DE64775%26defn%3Dhd&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&tpay=0");


//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("step=6&ptag=&iQQ=408404664&flashver=WIN%2029%2E0%2E0%2E113&BossId=3007&guid" +
                "=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&p2pver=0&Pwd=881273072&fplayerver=30203007&val2=0&sid" +
                "=124229101&val1=0&ctime="+cTimeStr()+"&adid=&val=2676&sdtfrom=70202&iTy=3007&vurl=http%3A%2F%2F175%2E6" +
                "%2E44%2E56%3A8080%2Fvzb%2Etc%2Eqq%2Ecom" +
                "%2FB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0%2F124229101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&P2PVer=0&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&tpay=0");
        kvCommon("sRef=&app=live&cdn=zijian&progid=124229101&flashver=WIN%2029%2E0%2E0%2E113&adstat=0&str%5Fparam1" +
                "=zijian&HttpDownlandSpeed=0&iQQ=408404664&durl=http%3A%2F%2F175%2E6%2E44%2E56%3A8080%2Fvzb%2Etc%2Eqq" +
                "%2Ecom%2FB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0%2F124229101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&HttpDownSum=0&videopos=0&sOp=webflash&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&time="+System.currentTimeMillis()+"&switch=124229101&xserverip=&sIp=&RtmfpInfo=0&UDPDownSum=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&str%5Fparam2=175%2E6%2E44%2E56&PeerConnRate=0&iTy=1991&iSta=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&svrCount=0&P2PReDelay=0&fullScreen=0&cmd=205&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=2516&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=3&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=324&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=373&isuserpay=0&CDNAbnormal=0&dsip=175%2E6%2E44%2E56&cnnTime=160&livepid=49843&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&playNo=9CB56171348BB011D6EBE095ED21E6B07DE64775&P2PVer=0&seq=1&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=2683&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
        live_poll();
        kvCommon("ftime="+System.currentTimeMillis()+"&BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd" +
                "=779660211&vkey=B5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&cnlID=124229103");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=31&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=FBC8A4A578B816A1C7EC273E604DF467AABB7B94&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&vid=124229101" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124229101" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D9CB56171348BB011D6EBE095ED21E6B07DE64775%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3545");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&rnd=3097&iSta=7&str4=9CB56171348BB011D6EBE095ED21E6B07DE64775&int1=0&iTy=2052&int2=0&str3=&itype=52&val=100&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124229101&bid=pcvideo&val2=&str2=1%2E4%2E6");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl=http%3A" +
                "%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%3Fgame%3Dcf&sRef=&sPageId=&sPos=&step=3&val=80&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=FBC8A4A578B816A1C7EC273E604DF467AABB7B94&pid=9CB56171348BB011D6EBE095ED21E6B07DE64775&vid=124229101" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.3.07&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Windows%20NT%2010.0%3B%20Win64%3B%20x64)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F63.0.3239.108%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124229101" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.3.07%26plugin%3D1.4.6" +
                "%26speed%3D0%26vptag%3D%26pid%3D9CB56171348BB011D6EBE095ED21E6B07DE64775%26adaptor%3D2%26musictxt%3D" +
                "%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game" +
                ".html%26refer%3D%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7170");
        kvCommon("url=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&rnd=9082&iSta=7&str4=9CB56171348BB011D6EBE095ED21E6B07DE64775&int1=0&iTy=2052&int2=1&str3=&itype=52&val=100&str1=&ver=TencentPlayerLiveV3%2E2%2E3%2E07&vid=124229101&bid=pcvideo&val2=&str2=1%2E4%2E6");
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
            kvCommon("ftime="+System.currentTimeMillis()+"&BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd" +
                    "=779660211&vkey=B5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&cnlID=124229103");
            sleep();
            kvCommon("sRef=&adstat=4&cdn=zijian&progid=124229101&flashver=WIN%2029%2E0%2E0%2E113&app=live&str" +
                    "%5Fparam1=zijian&HttpDownlandSpeed=0&iQQ=408404664&durl=http%3A%2F%2F175%2E6%2E44%2E56%3A8080" +
                    "%2Fvzb%2Etc%2Eqq%2Ecom%2FB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0%2F124229101%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DB5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&HttpDownSum=0&time="+System.currentTimeMillis()+"&str%5Fparam2=175%2E6%2E44%2E56&UDPDownlandSpeed=0&sBiz=zhibo&UpdataSpeed=0&clientip=&UDPDownSum=0&switch=124229101&xserverip=&sIp=&RtmfpInfo=0&videopos=0&progUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2Fmatch%2F2018%2Fpc%5Fgame%2Ehtml%3Fgame%3Dcf&sOp=webflash&PeerConnRate=0&iTy=1991&iSta=0&blockCount=0&UDPUpSum=0&p2pCount=0&viewid=&svrCount=0&P2PReDelay=0&fullScreen=0&cmd=263&live%5Ftype=8&SuNodDelay=0&lookback=0&averRemtime=0&pla=1&type=17&blockTime=0&StartP2P=0&errorCode=10000&loadingTime=0&SuperNodeIP=0&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&fullecode=10000&SuperNodePort=0&fplayerver=30203007&prdLength=35&playtime=0&PeerServerIP=0&peerCount=0&downSpeed=359&ispay=0&iFlow=0&averPeerMeHealth=0&maxSpeed=0&isuserpay=0&CDNAbnormal=0&dsip=175%2E6%2E44%2E56&playNo=9CB56171348BB011D6EBE095ED21E6B07DE64775&livepid=49843&ReqSNBlockOutRange=0&playAd=0&lookbackseq=0&HashNotFinished=0&cnnTime=0&P2PVer=0&seq="+seq+"&returnBitmapErr=0&reCnnCount=0&playerOnPlayTime=0&cnnPS=0&blockHasData=0&PeerServerPort=0&transtype=0");
            sleep();
            live_poll();
            sleep();
            kvCommon("ftime="+System.currentTimeMillis()+"&BossId=3460&platform=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&Pwd" +
                    "=779660211&vkey=B5090F24AE1928C099BB234B0E750E60879173A4ECB6193C11B4A1944BE2AC69AC3B789D5FE5FD87D332280E8F42BA6E99C9E4AE68729127FA08DE655F4E95FB96F78868317AEE9A2D98353A5D0C5649F360FC631C8737B0&cnlID=124229103");
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
        headers.put("Referer", uri_index);
        headers.put("If-Modified-Since", LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss 'GMT'")));
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
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=&pollDataKey=pid%3D49843%26type%3D&needmark=1&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=CC85A8B2B63469304FB594CCF649B47EC46F8BC6&refer=http%3A%2F%2Ftga.qq.com%2Fmatch%2F2018%2Fpc_game.html%3Fgame%3Dcf&apptype=live";
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


