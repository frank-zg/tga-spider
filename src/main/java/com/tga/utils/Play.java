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

//        Map<String, String> headers2 = new HashMap<>();
//        headers2.put("Accept", "*/*");
//        headers2.put("Accept-Encoding", "gzip, deflate");
//        headers2.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        headers2.put("Connection", "keep-alive");
//        headers2.put("Content-Length", "164");
//        headers2.put("Content-Type", "application/x-www-form-urlencoded");
//        headers2.put("Cookie", "eas_sid=i1k4S7j7d7T0Z1n8l9c1x4p4k7; tvfe_boss_uuid=99daa20cfcb950ce; pac_uid=1_125826029; ptcz=2073df33296f910c4ebe6386dae0f389046bbcf92fca13397de446872d9c57a3; pt2gguin=o0125826029; pgv_pvi=3250939904; pgv_info=ssid=s4418331160; pgv_pvid=7924958374; o_cookie=125826029");
//        headers2.put("Host", "btrace.video.qq.com");
//        headers2.put("Origin", "http://imgcache.qq.com");
//        headers2.put("Referer", "http://imgcache.qq.com/minivideo_v1/vd/res/TencentPlayerLive.swf?max_age=86400&v=20140714");
//        headers2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
//        headers2.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        kvCommon("flashver=WIN&progid=124223002&P2PVer=&CheckSum=105821293&iQQ=125826029&dc=8993&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&sRef=&BossId=2583");
        kvCommon("sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&step=3&tpay=0&ptag" +
                "=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&vurl=&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val=0&p2pver=0&iQQ=125826029&BossId=3007&adid=&Pwd" +
                "=881273072&pid=36811D88A66F14A63E03302D23EB0510A9784036&sid=124223002&ctime="+cTimeStr()+"&val1=0" +
                "&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017");
        kvCommon("vid=124223002&iSta=7&int1=0&str4=36811D88A66F14A63E03302D23EB0510A9784036&str2=1%2E4%2E6&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&val=100&rnd=4573&val2=&ver=TencentPlayerLiveV3%2E2%2E2%2E03&itype=50&str3=&str1=&bid=pcvideo&int2=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=119&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=C76E1C91FFE2E108C0EC252A9042AD53A92494F7&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D36811D88A66F14A63E03302D23EB0510A9784036%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F%26st%3D0&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=216");
        kvCommon("vid=124223002&iSta=7&int1=0&str4=36811D88A66F14A63E03302D23EB0510A9784036&str2=1%2E4%2E6&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&val=100&rnd=5166&val2=&ver=TencentPlayerLiveV3%2E2%2E2%2E03&itype=50&str3=&str1=&bid=pcvideo&int2=1&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=13&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=C76E1C91FFE2E108C0EC252A9042AD53A92494F7&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D36811D88A66F14A63E03302D23EB0510A9784036%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4583");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=C76E1C91FFE2E108C0EC252A9042AD53A92494F7&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5568");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?reqtime="+System.currentTimeMillis()
                /1000+"&pid2=36811D88A66F14A63E03302D23EB0510A9784036" +
                "&step=1&t=30000&dura=0&pf=out");
        kvCommon("sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&step=7&tpay=0&ptag" +
                "=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&vurl=&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val=0&p2pver=0&iQQ=125826029&BossId=3007&adid=&Pwd" +
                "=881273072&pid=36811D88A66F14A63E03302D23EB0510A9784036&sid=124223002&ctime="+cTimeStr()+"&val1=0" +
                "&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017");
        undefined("http://tga.qq" +
                ".com/2017winter/undefined?reqtime="+System
                .currentTimeMillis()/1000+"&pid2=36811D88A66F14A63E03302D23EB0510A9784036&step=0&t=30000&dura=0&pf" +
                "=out");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=&sBiz=&sOp=&iSta=0&iTy=2590&iFlow=0&sUrl=&sRef=&sPageId=&sPos=&step=0&val=blocked&val1=&val2=&val3=&val4=&val5=&apid=1.4.6&pid=1.4.6&vid=124223002&platform=6&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=&adtype=0&vurl=http://tga.qq.com/2017winter/cfm.htm?from=tga2017&reporttime=&bdua=0&admtype=0&adid=&guid=&ispip=0&random=9268");
        kvCommon("sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&step=4&tpay=0&ptag" +
                "=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&vurl=http%3A" +
                "%2F%2F175%2E6%2E26%2E18%3A8080" +
                "%2FD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val=256&p2pver=0&iQQ=125826029&BossId=3007&adid=&Pwd=881273072&pid=36811D88A66F14A63E03302D23EB0510A9784036&sid=124223002&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017");
        kvCommon("avr=TencentPlayerLiveV3%2E2%2E2%2E03&cts="+ System.currentTimeMillis()/1000+"&dip=zijian&cky=P7G" +
                "%5Fsng2EhgGa1N9CMxu99mxavGxXdbY6K5jazeM0nGeDEZMN8r9" +
                "%5FxkPv7UZ0W6egNCiMSOWOllVQF9SBYE6PVeM0rcSdg8MogJCajP6MIsN1X0kXjKYcYjeuaM7NszBL9" +
                "%5Fl1Dpf5XyUkBMJgC4DmScVSf7I%5F0E7L3E2PNMiZsTEqdG4%5FGrVuAb0" +
                "%5Fkm3SmPY98kBbN3AO40KFpw1qz9SUPWIpMZE61exyK1XtpoiuT9LVOZ9ayzr0NQ9kWLM92gMGvo%5FWiTcJsyGIHPACLP" +
                "%2DR0MltJdeX2FQ9d0GM7rVYGtyoGh6XxCQ0kNtwyA3MjVNVRcFnA&ftime="+System.currentTimeMillis()+"&vky" +
                "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&cnl=124223002&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&uin=125826029&iTy=2595&evr=5%2E4&cip=&plt=1&sdt=70202");
        kvCommon("sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&step=1100&tpay=0&ptag" +
                "=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&vurl=http%3A" +
                "%2F%2Finfo%2Ezb%2Evideo%2Eqq%2Ecom%2F%3Fpla%3D0%26cmd%3D2%26rid" +
                "%3D36811D88A66F14A63E03302D23EB0510A9784036%26queueStatus%3D0%26browser%3Dchrome%26qq%3D125826029" +
                "%26livequeue%3D1%26system%3D3%26defauto%3D1%26rnd%3D209%26flashver%3D27%2C0%2C0%2C183%26sdtfrom" +
                "%3D70202%26guid%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26cKey%3DP7G" +
                "%5Fsng2EhgGa1N9CMxu99mxavGxXdbY6K5jazeM0nGeDEZMN8r9" +
                "%5FxkPv7UZ0W6egNCiMSOWOllVQF9SBYE6PVeM0rcSdg8MogJCajP6MIsN1X0kXjKYcYjeuaM7NszBL9" +
                "%5Fl1Dpf5XyUkBMJgC4DmScVSf7I%5F0E7L3E2PNMiZsTEqdG4%5FGrVuAb0" +
                "%5Fkm3SmPY98kBbN3AO40KFpw1qz9SUPWIpMZE61exyK1XtpoiuT9LVOZ9ayzr0NQ9kWLM92gMGvo%5FWiTcJsyGIHPACLP" +
                "%2DR0MltJdeX2FQ9d0GM7rVYGtyoGh6XxCQ0kNtwyA3MjVNVRcFnA%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom" +
                "%252F2017winter%252Fcfm%2Ehtm%253Ffrom%253Dtga2017%26defn%3D%26vip%5Fstatus%3D0%26fntick%3D0" +
                "%26encryptVer%3D5%2E4%26stream%3D2%26cnlid%3D124223002%26flvtype%3D1%26txvjsv%3D2%26appVer" +
                "%3DTencentPlayerLiveV3%2E2%2E2%2E03&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val=118&p2pver=0" +
                "&iQQ=125826029&BossId=3007&adid=&Pwd=881273072&pid=36811D88A66F14A63E03302D23EB0510A9784036&sid=124223002&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("cnlID=124223002&Pwd=779660211&BossId=3460&ftime="+System.currentTimeMillis()+"&vkey" +
                "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
        kvCommon("sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&step=6&tpay=0&ptag" +
                "=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&P2PVer=0&vurl=http%3A" +
                "%2F%2F175%2E6%2E26%2E18%3A8080" +
                "%2FD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&val=399&p2pver=0&iQQ=125826029&BossId=3007&adid=&Pwd=881273072&pid=36811D88A66F14A63E03302D23EB0510A9784036&sid=124223002&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&iTy=3007&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003&sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017");
        kvCommon("cmd=205&iFlow=0&time="+System.currentTimeMillis()+"&iTy=1991&HttpDownlandSpeed=0&blockHasData=0&cdn=zijian&progid" +
                "=124223002&P2PVer=0&playerOnPlayTime=677&cnnPS=0&loadingTime=295&HttpDownSum=0&progUrl=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&seq=0&PeerServerIP=0&pla=1&playAd=0" +
                "&fullScreen=0&downSpeed=1134&videopos=0&playtime=0&adstat=0&blockCount=0&lookback=0&app=live&ispay=0" +
                "&StartP2P=0&UDPDownSum=0&maxSpeed=5139&isuserpay=0&RtmfpInfo=0&reCnnCount=0&livepid=40924&durl=http" +
                "%3A%2F%2F175%2E6%2E26%2E18%3A8080" +
                "%2FD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&UpdataSpeed=0&UDPDownlandSpeed=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&str%5Fparam1=zijian&str%5Fparam2=175%2E6%2E26%2E18&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&sOp=webflash&ReqSNBlockOutRange=0&xserverip=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sIp=&SuNodDelay=0&type=17&blockTime=0&live%5Ftype=8&averRemtime=0&prdLength=1&transtype=0&iQQ=125826029&SuperNodeIP=0&sBiz=zhibo&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&viewid=&fplayerver=30202003&playNo=36811D88A66F14A63E03302D23EB0510A9784036&dsip=175%2E6%2E26%2E18&cnnTime=104");
        undefined("http://tga.qq.com/2017winter/undefined?pid2=36811D88A66F14A63E03302D23EB0510A9784036&reqtime" +
                "="+System.currentTimeMillis()/1000+"&t=30000");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=C76E1C91FFE2E108C0EC252A9042AD53A92494F7&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=3214");
        live_poll();
        kvCommon("cnlID=124223002&Pwd=779660211&BossId=3460&ftime="+System.currentTimeMillis()+"&vkey" +
                "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
        kvCommon("vid=124223002&iSta=7&int1=0&str4=36811D88A66F14A63E03302D23EB0510A9784036&str2=1%2E4%2E6&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&val=100&rnd=1574&val2=&ver=TencentPlayerLiveV3%2E2%2E2%2E03&itype=52&str3=&str1=&bid=pcvideo&int2=0&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=8&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=03B388843CBA4DDDB0A2DCF5C7D52C26A613995B&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D36811D88A66F14A63E03302D23EB0510A9784036%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5224");
        kvCommon("vid=124223002&iSta=7&int1=0&str4=36811D88A66F14A63E03302D23EB0510A9784036&str2=1%2E4%2E6&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&val=100&rnd=5881&val2=&ver=TencentPlayerLiveV3%2E2%2E2%2E03&itype=52&str3=&str1=&bid=pcvideo&int2=1&iTy=2052");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=110&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=03B388843CBA4DDDB0A2DCF5C7D52C26A613995B&pid=36811D88A66F14A63E03302D23EB0510A9784036&vid=124223002" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124223002" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D36811D88A66F14A63E03302D23EB0510A9784036%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F%26retry%3D1&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2862");
        kvCommon("cmd=263&iFlow=0&time="+System.currentTimeMillis()+"&iTy=1991&HttpDownlandSpeed=0&blockHasData=0&cdn=zijian&progid" +
                "=124223002&P2PVer=0&playerOnPlayTime=0&cnnPS=0&loadingTime=0&HttpDownSum=0&progUrl=http%3A%2F%2Ftga" +
                "%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&seq=1&PeerServerIP=0&pla=1&playAd=0&fullScreen" +
                "=0&downSpeed=579&videopos=0&playtime=0&maxSpeed=0&blockCount=0&lookback=0&app=live&ispay=0&StartP2P" +
                "=0&UDPDownSum=0&UpdataSpeed=0&isuserpay=0&RtmfpInfo=0&reCnnCount=0&livepid=40924&durl=http%3A%2F" +
                "%2F175%2E6%2E26%2E18%3A8080" +
                "%2FD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+ System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&adstat=4&UDPDownlandSpeed=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&str%5Fparam1=zijian&str%5Fparam2=175%2E6%2E26%2E18&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&sOp=webflash&ReqSNBlockOutRange=0&xserverip=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sIp=&SuNodDelay=0&type=17&blockTime=0&live%5Ftype=8&averRemtime=0&prdLength=29&transtype=0&iQQ=125826029&SuperNodeIP=0&sBiz=zhibo&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&viewid=&fplayerver=30202003&playNo=36811D88A66F14A63E03302D23EB0510A9784036&dsip=175%2E6%2E26%2E18&cnnTime=0");
        live_poll();
        kvCommon("cnlID=124223002&Pwd=779660211&BossId=3460&ftime="+System.currentTimeMillis()+"&vkey" +
                "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; pgv_si=s8605507584; ptisp=ctc; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@8YYBrSluq; pt2gguin=o0125826029; ied_rf=mail.qq.com/undefined; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9282895726");
        headers1.put("Host", "tga.qq.com");
        headers1.put("Referer", "https://mail.qq.com/");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; pgv_si=s8605507584; ptisp=ctc; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@8YYBrSluq; pt2gguin=o0125826029; ied_rf=mail.qq.com/undefined; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9282895726");
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
            kvCommon("cnlID=124223002&Pwd=779660211&BossId=3460&ftime="+System.currentTimeMillis()+"&vkey" +
                    "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
            sleep();
            kvCommon("cmd=263&iFlow=0&time="+System
                    .currentTimeMillis()+"&iTy=1991&HttpDownlandSpeed=0&blockHasData=0&cdn=zijian&progid" +
                    "=124223002&P2PVer=0&playerOnPlayTime=0&cnnPS=0&loadingTime=0&HttpDownSum=0&progUrl=http%3A%2F" +
                    "%2Ftga%2Eqq%2Ecom%2F2017winter%2Fcfm%2Ehtm%3Ffrom%3Dtga2017&seq=2&PeerServerIP=0&pla=1&playAd=0" +
                    "&fullScreen=0&downSpeed=191&videopos=0&playtime=0&adstat=0&blockCount=0&lookback=0&app=live" +
                    "&ispay=0&StartP2P=0&UDPDownSum=0&maxSpeed=0&isuserpay=0&RtmfpInfo=0&reCnnCount=0&livepid=40924" +
                    "&durl=http%3A%2F%2F175%2E6%2E26%2E18%3A8080" +
                    "%2FD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6%2F124223002%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3DD5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&UpdataSpeed=0&UDPDownlandSpeed=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&str%5Fparam1=zijian&str%5Fparam2=175%2E6%2E26%2E18&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&sOp=webflash&ReqSNBlockOutRange=0&xserverip=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sIp=&SuNodDelay=0&type=17&blockTime=0&live%5Ftype=8&averRemtime=0&sBiz=zhibo&transtype=0&iQQ=125826029&SuperNodeIP=0&prdLength=60&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&viewid=&fplayerver=30202003&playNo=36811D88A66F14A63E03302D23EB0510A9784036&dsip=175%2E6%2E26%2E18&cnnTime=0");
            sleep();
            live_poll();
            sleep();
            kvCommon("cnlID=124223002&Pwd=779660211&BossId=3460&ftime="+System.currentTimeMillis()+"&vkey" +
                    "=D5E33645D33CC7B4AEAC456AD33A6C99EAA23B8E6A718D5927599092C1462212005D15F90C703936E935FD35AF13CF2DEA948090BFE108D10D9ABB9AD58EE371ACF3D7D63B82BECDFAF9370673A48A021678A705BAB073F6&platform=1&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; pgv_si=s8605507584; ptisp=ctc; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@8YYBrSluq; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9282895726");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; pgv_si=s8605507584; ptisp=ctc; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@8YYBrSluq; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9282895726");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; pgv_si=s8605507584; ptisp=ctc; RK=MdcLCAafNz; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@8YYBrSluq; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s9282895726");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&pollDataKey=pid%3D40924%26type%3D&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&needmark=1&qqlog=125826029&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2F2017winter%2Fcfm.htm%3Ffrom%3Dtga2017&apptype=live";
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


