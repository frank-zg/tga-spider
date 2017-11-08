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
    }

    /*@Override
    public void run() {
        autoIndex.incrementAndGet();
        System.out.println(autoIndex.get());
        indexPage();

        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&progid=124222802&P2PVer=&flashver=WIN&sRef=&BossId=2583&CheckSum=105821293&iQQ=125826029&dc=2558");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm" +
                "%3Ffrom%3Dtga2017&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom" +
                "%3Dtga2017&P2PVer=0&val=0&p2pver=0&iQQ=125826029&BossId=3007&adid=&pid" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&Pwd=881273072&sid=124222802&vurl=&ctime="+cTimeStr()+"&val1=0" +
                "&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&step=3&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003");
        kvCommon("str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&bid=pcvideo&itype=50&rnd=202&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str2=1%2E4%2E6&int2=0&str4=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&int1=0&val2=&iTy=2052&val=100&vid=124222802&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=55&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=DA460327B91ACCC8268EA0B4C08468E10EB09F74&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222802" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq" +
                ".com%2F%26st%3D0&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1041");
        kvCommon("str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&bid=pcvideo&itype=50&rnd=8243&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str2=1%2E4%2E6&int2=1&str4=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&int1=0&val2=&iTy=2052&val=100&vid=124222802&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=18&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=DA460327B91ACCC8268EA0B4C08468E10EB09F74&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DLD%7CKB%26rfid" +
                "%3Dcda3fd3fb56ec93cea30628740cc9612_1509265417%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222802" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F%26st%3D0%26retry%3D1&reporttime="+cTimeStr()
                +"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=2166");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=6&val=0&val1=1&val2=5&val3=&val4=&val5=&apid" +
                "=DA460327B91ACCC8268EA0B4C08468E10EB09F74&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=0&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=7561");
        undefined("http://tga.qq.com/2017winter/undefined?step=1&pid2=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&pf" +
                "=out&dura=0&t=30000&reqtime="+System.currentTimeMillis()/1000);
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm" +
                "%3Ffrom%3Dtga2017&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom" +
                "%3Dtga2017&P2PVer=0&val=0&p2pver=0&iQQ=125826029&BossId=3007&adid=&pid" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&Pwd=881273072&sid=124222802&vurl=&ctime="+cTimeStr()
                +"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&step=7&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003");
        undefined("http://tga.qq.com/2017winter/undefined?step=0&pid2=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&pf" +
                "=out&dura=0&t=30000&reqtime="+System.currentTimeMillis()/1000);
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm" +
                "%3Ffrom%3Dtga2017&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom" +
                "%3Dtga2017&P2PVer=0&val=274&p2pver=0&iQQ=125826029&BossId=3007&adid=&pid" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&Pwd=881273072&sid=124222802&vurl=http%3A%2F%2F218%2E75" +
                "%2E177%2E104%3A8080%2F5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5%2F124222802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&step=4&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003");
        kvCommon("plt=1&sdt=70202&avr=TencentPlayerLiveV3%2E2%2E2%2E03&cip=&dip=zijian&cky" +
                "=GSCkEl6nCLgGa1N9CMxu99mxavGxXdbY6K5jazeM0nFBuf9gNsSKpBzdhjaDB6MsTs1ZGFqS%2DM%2Dbpp3ln%5FoJ1%5FuES" +
                "%5FHQLPe3TpMzasOE%2Dq1Rke6DFNTWnt7a2rQj2yYjU5zbe6pcD20UyWKhRPwXPHfS3Of0UpePHUpF" +
                "%5F8OpsuCjOiJsll1kGj3ihhIYjJy%5F4MiaeIjQ88%5F9DlC%2DeQowgy0RGTIZQ8zJID8RATDsKlwQWoV29qRYSr2" +
                "%5F16D1WtwokYy2Ynp8%2D6clUMDx9uuHDobGtoNu4uCwlOWd0qhwJXZezfWpCkb2MLI%5FXt7atBZRA0luiw&ftime="+System.currentTimeMillis()
                +"&vky=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&cnl=124222802&gid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&evr=5%2E4&iTy=2595&cts="+System.currentTimeMillis()/1000+"&uin=125826029");
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm" +
                "%3Ffrom%3Dtga2017&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom" +
                "%3Dtga2017&P2PVer=0&val=124&p2pver=0&iQQ=125826029&BossId=3007&adid=&pid" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&Pwd=881273072&sid=124222802&vurl=http%3A%2F%2Finfo%2Ezb" +
                "%2Evideo%2Eqq%2Ecom%2F%3Fflvtype%3D1%26browser%3Dchrome%26queueStatus%3D0%26pla%3D0%26cmd%3D2%26rid" +
                "%3D959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932%26host%3Dhttp%253A%252F%252Ftga%2Eqq%2Ecom" +
                "%252F2017winter%252Flive%2Ehtm%253Ffrom%253Dtga2017%26rnd%3D222%26system%3D3%26appVer" +
                "%3DTencentPlayerLiveV3%2E2%2E2%2E03%26livequeue%3D1%26defn%3D%26guid" +
                "%3D92F883CEAC9A894B6D821E26C42D6B02E5ACE25B%26flashver%3D27%2C0%2C0%2C183%26sdtfrom%3D70202%26cnlid" +
                "%3D124222802%26cKey%3DGSCkEl6nCLgGa1N9CMxu99mxavGxXdbY6K5jazeM0nFBuf9gNsSKpBzdhjaDB6MsTs1ZGFqS%2DM" +
                "%2Dbpp3ln%5FoJ1%5FuES%5FHQLPe3TpMzasOE%2Dq1Rke6DFNTWnt7a2rQj2yYjU5zbe6pcD20UyWKhRPwXPHfS3Of0UpePHUpF" +
                "%5F8OpsuCjOiJsll1kGj3ihhIYjJy%5F4MiaeIjQ88%5F9DlC%2DeQowgy0RGTIZQ8zJID8RATDsKlwQWoV29qRYSr2" +
                "%5F16D1WtwokYy2Ynp8%2D6clUMDx9uuHDobGtoNu4uCwlOWd0qhwJXZezfWpCkb2MLI%5FXt7atBZRA0luiw%26stream%3D2" +
                "%26defauto%3D1%26vip%5Fstatus%3D0%26fntick%3D0%26encryptVer%3D5%2E4%26qq%3D125826029%26txvjsv%3D2&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&step=1100&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003");

//        executorService.execute(() -> {
        //下载视频线程
        Thread stream = null;

        if (videoTime > 0 && videoDownSize > 0) {
            stream = new Thread(() -> httpDownload());
            stream.start();
        }

        //开始有规律播放进度
        kvCommon("BossId=3460&platform=1&cnlID=124222802&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B" +
                "&vkey=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ftime="+System.currentTimeMillis());
        kvCommon("sUrl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&iTy=3007&guid" +
                "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&sref=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm" +
                "%3Ffrom%3Dtga2017&tpay=0&ptag=&sRef=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom" +
                "%3Dtga2017&P2PVer=0&val=428&p2pver=0&iQQ=125826029&BossId=3007&adid=&pid" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&Pwd=881273072&sid=124222802&vurl=http%3A%2F%2F218%2E75" +
                "%2E177%2E104%3A8080%2F5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5%2F124222802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ctime="+cTimeStr()+"&val1=0&flashver=MAC%2027%2E0%2E0%2E183&sdtfrom=70202&val2=0&step=6&surl=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&fplayerver=30202003");
        kvCommon("cdn=zijian&cnnTime=124&cmd=205&iFlow=0&reCnnCount=0&iTy=1991&playNo" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&HttpDownlandSpeed=0&blockHasData=0&progid=124222802" +
                "&HttpDownSum=0&playerOnPlayTime=723&time="+System.currentTimeMillis()+"&cnnPS=0&loadingTime=304&fullScreen=0&progUrl" +
                "=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&seq=0&P2PVer=0&PeerServerIP" +
                "=0&pla=1&playAd=0&downSpeed=1242&videopos=0&playtime=0&adstat=0&UDPDownlandSpeed=0&lookback=0&app" +
                "=live&ispay=0&StartP2P=0&UDPDownSum=0&maxSpeed=4897&isuserpay=0&str%5Fparam1=zijian&type=17&livepid" +
                "=40922&durl=http%3A%2F%2F218%2E75%2E177%2E104%3A8080" +
                "%2F5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5%2F124222802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&UpdataSpeed=0&blockCount=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=218%2E75%2E177%2E104&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&sBiz=zhibo&SuNodDelay=0&iQQ=125826029&SuperNodeIP=0&prdLength=1&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=218%2E75%2E177%2E104&viewid=&fplayerver=30202003");
        undefined("http://tga.qq.com/2017winter/undefined?t=30000&pid2=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932" +
                "&reqtime="+ System.currentTimeMillis()/1000);
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=7&val=30000&val1=5&val2=&val3=&val4=&val5=&apid" +
                "=DA460327B91ACCC8268EA0B4C08468E10EB09F74&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=30000&bt=30000&idx=0&appid=0&ua" +
                "=Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=0&vurl=" +
                ".block&reporttime="+cTimeStr()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=5237");
        live_poll();
        kvCommon("BossId=3460&platform=1&cnlID=124222802&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B" +
                "&vkey=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ftime="+System.currentTimeMillis());
        kvCommon("str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&bid=pcvideo&itype=52&rnd=2909&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str2=1%2E4%2E6&int2=0&str4=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&int1=0&val2=&iTy=2052&val=100&vid=124222802&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=8&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=03DEEDFD54467CF4D9BE6F5E79053BE45BD9A5C7&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=0&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222802" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=4560");
        kvCommon("str3=&url=http%3A%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&bid=pcvideo&itype=52&rnd=5159&iSta=7&ver=TencentPlayerLiveV3%2E2%2E2%2E03&str2=1%2E4%2E6&int2=1&str4=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&int1=0&val2=&iTy=2052&val=100&vid=124222802&str1=");
        kvGetCommon("http://btrace.video.qq.com/kvcollect?sIp=&iQQ=125826029&sBiz=&sOp=&iSta=0&iTy=2481&iFlow=0&sUrl" +
                "=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%3Ffrom%3Dtga2017&sRef=&sPageId=&sPos=&step=3&val=114&val1=2&val2=604&val3=&val4=&val5=&apid" +
                "=03DEEDFD54467CF4D9BE6F5E79053BE45BD9A5C7&pid=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&vid=124222802" +
                "&platform=1&pversion=TencentPlayerLiveV3.2.2.03&version=1.4.6&bi=1&bt=0&idx=1&appid=0&ua=Mozilla" +
                "%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_12_5)%20AppleWebKit%2F537.36%20" +
                "(KHTML%2C%20like%20Gecko)%20Chrome%2F61.0.3163.100%20Safari%2F537.36&adtype=2&vurl=http%3A%2F" +
                "%2Flivew.l.qq.com%2Flivemsg%3Fty%3Dweb%26ad_type%3DTP%26pf%3Dout%26pt%3D0%26pc%3D0%26vid%3D124222802" +
                "%26coverid%3D%26live%3D1%26from%3D0%26pu%3D0%26v%3DTencentPlayerLiveV3.2.2.03%26plugin%3D1.4.6" +
                "%26speed%3D3946%26vptag%3D%26pid%3D959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932%26adaptor%3D2%26musictxt" +
                "%3D%26chid%3D0%26mbid%3D%26guid%3D%26url%3Dhttp%3A%2F%2Ftga.qq.com%2F2017winter%2Flive" +
                ".htm%26refer%3Dhttps%3A%2F%2Fmail.qq.com%2F%26retry%3D1&reporttime="+cTimeStr
                ()+"&bdua=0&admtype=0&adid=&guid=&ispip=0&random=1830");
        kvCommon("cdn=zijian&time="+System.currentTimeMillis()/1000+"&cmd=263&iFlow=0&reCnnCount=0&iTy=1991&playNo" +
                "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&HttpDownlandSpeed=0&blockHasData=0&progid=124222802" +
                "&HttpDownSum=0&playerOnPlayTime=0&cnnTime=0&cnnPS=0&loadingTime=0&fullScreen=0&progUrl=http%3A%2F" +
                "%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&seq=1&P2PVer=0&PeerServerIP=0&pla=1" +
                "&playAd=0&downSpeed=579&videopos=0&playtime=0&maxSpeed=0&UDPDownlandSpeed=0&lookback=0&app=live" +
                "&ispay=0&StartP2P=0&UDPDownSum=0&UpdataSpeed=0&isuserpay=0&str%5Fparam1=zijian&UDPUpSum=0&livepid" +
                "=40922&durl=http%3A%2F%2F218%2E75%2E177%2E104%3A8080" +
                "%2F5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5%2F124222802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&adstat=4&blockCount=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=218%2E75%2E177%2E104&type=17&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&sBiz=zhibo&SuNodDelay=0&iQQ=125826029&SuperNodeIP=0&prdLength=29&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=218%2E75%2E177%2E104&viewid=&fplayerver=30202003");
        live_poll();
        kvCommon("BossId=3460&platform=1&cnlID=124222802&Pwd=779660211&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B" +
                "&vkey=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ftime="+ System.currentTimeMillis());
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
    }*/

    public void indexPage() {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Accept", "*/*");
        headers1.put("Accept-Encoding", "gzip, deflate");
        headers1.put("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
//        headers1.put("Cache-Control", "max-age=0");
        headers1.put("Connection", "keep-alive");
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s2941552394");
        headers1.put("Host", "ac.o2.qq.com");
        headers1.put("Referer", uri_index);
//        headers1.put("Upgrade-Insecure-Requests", "1");
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
        headers1.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; ts_uid=9440516329; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; pgv_si=s7071211520; ptisp=ctc; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@nEqN2RDSD; pt2gguin=o0125826029; ied_rf=mail.qq.com/undefined; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s6894691328");
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
            kvCommon("BossId=3460&platform=1&cnlID=124222802&Pwd=779660211&guid" +
                    "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey" +
                    "=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ftime="+System.currentTimeMillis());
            sleep();
            kvCommon("cdn=zijian&time="+System.currentTimeMillis()+"&cmd=263&iFlow=0&reCnnCount=0&iTy=1991&playNo" +
                    "=959515E55DBCFCBAE611D4D1C2D32D4B8BDDC932&HttpDownlandSpeed=0&blockHasData=0&progid=124222802" +
                    "&HttpDownSum=0&playerOnPlayTime=0&cnnTime=0&cnnPS=0&loadingTime=0&fullScreen=0&progUrl=http%3A" +
                    "%2F%2Ftga%2Eqq%2Ecom%2F2017winter%2Flive%2Ehtm%3Ffrom%3Dtga2017&seq="+seq+"&P2PVer=0" +
                    "&PeerServerIP=0" +
                    "&pla=1&playAd=0&app=live&videopos=0&playtime=0&adstat=0&UDPDownlandSpeed=0&lookback=0&downSpeed" +
                    "=211&ispay=0&StartP2P=0&UDPDownSum=0&maxSpeed=0&isuserpay=0&str%5Fparam1=zijian&type=17&livepid" +
                    "=40922&durl=http%3A%2F%2F218%2E75%2E177%2E104%3A8080" +
                    "%2F5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5%2F124222802%2Eflv%3Fcdncode%3D%252f18907E7BE0798990%252f%26time%3D"+System.currentTimeMillis()/1000+"%26cdn%3Dzijian%26sdtfrom%3Dv210221%26platform%3D70202%26butype%3D21%26scheduleflag%3D1%26buname%3Dqqlive%26vkey%3D5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&UpdataSpeed=0&blockCount=0&errorCode=10000&svrCount=0&SuperNodePort=0&PeerConnRate=0&fullecode=10000&p2pCount=0&RtmfpInfo=0&str%5Fparam2=218%2E75%2E177%2E104&UDPUpSum=0&P2PReDelay=0&CDNAbnormal=0&clientip=&sRef=&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&ReqSNBlockOutRange=0&xserverip=&live%5Ftype=8&sIp=&sOp=webflash&transtype=0&blockTime=0&averRemtime=0&prdLength=60&SuNodDelay=0&iQQ=125826029&SuperNodeIP=0&sBiz=zhibo&iSta=0&PeerServerPort=0&lookbackseq=0&peerCount=0&flashver=MAC%2027%2E0%2E0%2E183&HashNotFinished=0&switch=0&averPeerMeHealth=0&returnBitmapErr=0&dsip=218%2E75%2E177%2E104&viewid=&fplayerver=30202003");
            sleep();
            live_poll();
            sleep();
            kvCommon("BossId=3460&platform=1&cnlID=124222802&Pwd=779660211&guid" +
                    "=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&vkey" +
                    "=5A1D12D66A649864D9A17496D8BB23A5E761ACA5A7607B591CEC4BE2929ADCA718E5488EBB645E25DDEBD61EF5C5C8DA276D7B31F4BD30DA988F907EF40C32D9FD1BE5C30A97018A1F7E9A9D1BE2B58823B0E159340E7AB5&ftime="+ System.currentTimeMillis());
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; pgv_si=s7071211520; ptisp=ctc; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@nEqN2RDSD; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s6894691328");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; pgv_si=s7071211520; ptisp=ctc; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@nEqN2RDSD; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s6894691328");
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
        headers.put("Cookie", "eas_sid=T1t5m0v8H5q5F2H6z2W394W7o8; tvfe_boss_uuid=2698b2b110e66b71; mobileUV=1_15f3f287fb0_59e7d; pgv_pvi=3028362240; RK=MdcLCAafNz; o_cookie=125826029; pgv_si=s7071211520; ptisp=ctc; ptcz=56bf8aab87390c4b9a8e70945fe3c68ec025be0fb4cf7c6d2f26a42b2970465a; uin=o0125826029; skey=@nEqN2RDSD; pt2gguin=o0125826029; pgv_pvid=672048110; pgv_info=pgvReferrer=&ssid=s6894691328");
        headers.put("Host", "live.mobile.video.qq.com");
        headers.put("Referer", uri_index);
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        headers.put("X-Requested-With", "ShockwaveFlash/26.0.0.151");
        HttpUtil.get("http://live.mobile.video.qq.com/fcgi-bin/live_poll?otype=json&qqlog=125826029&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&pollDataKey=pid%3D40922%26type%3D&needmark=1&markContext=last%3D0", headers, exceptionStatus, timeout);
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
            String tmpUrl = videoUri + "&guid=92F883CEAC9A894B6D821E26C42D6B02E5ACE25B&refer=http%3A%2F%2Ftga.qq.com%2F2017winter%2Flive.htm%3Ffrom%3Dtga2017&apptype=live";
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


