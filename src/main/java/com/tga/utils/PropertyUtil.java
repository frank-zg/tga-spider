package com.tga.utils;


import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class PropertyUtil {

    private static Properties props;

    private PropertyUtil() {
    }

    static {
        props = new Properties();
        FileInputStream fis = null;

        try {
            String path = "";
            if (System.getProperty("os.name").toLowerCase().indexOf("wind") > -1) {
                path = "D:\\conf.properties";
            } else {
                path = "/usr/tga/conf.properties";
            }
            File file = new File(path);
            fis = new FileInputStream(file);
            props.load(fis);
            System.out.println("配置文件加载完成!!!");
        } catch (Exception e) {
            System.out.println("配置文件读取异常!!!");
            System.out.println("开始读取默认配置文件!!!");
            try {
                InputStreamReader reader = new InputStreamReader(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("conf.properties"), "utf-8");
                props.load(reader);
            } catch (IOException e1) {
                System.out.println("默认配置文件读取失败!!!");
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("文件关闭失败!!!");
            }
        }
    }

    public static String getString(String key) {
        return props.getProperty(key);
    }

    public static Integer getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    public static Double getDouble(String key) {
        return Double.parseDouble(getString(key));
    }

    public static Boolean getBoolean(String key) {
        try {
            return Boolean.parseBoolean(getString(key));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String json = "{\"code\":0,\"success\":true,\"msg\":\"0\",\"data\":[{\"ip\":\"171.44.76.82\",\"port\":7838,\"expire_time\":\"2017-09-02 22:02:08\",\"city\":\"十堰市\",\"isp\":\"电信\"},{\"ip\":\"114.227.150.3\",\"port\":9287,\"expire_time\":\"2017-09-02 22:02:15\",\"city\":\"常州市\",\"isp\":\"电信\"},{\"ip\":\"144.123.70.56\",\"port\":9937,\"expire_time\":\"2017-09-02 22:00:05\",\"city\":\"济南市\",\"isp\":\"电信\"},{\"ip\":\"119.115.20.12\",\"port\":8943,\"expire_time\":\"2017-09-02 21:53:14\",\"city\":\"辽阳市\",\"isp\":\"联通\"},{\"ip\":\"182.111.89.16\",\"port\":7817,\"expire_time\":\"2017-09-02 21:54:07\",\"city\":\"宜春市\",\"isp\":\"电信\"},{\"ip\":\"49.68.187.193\",\"port\":6590,\"expire_time\":\"2017-09-02 21:48:14\",\"city\":\"徐州市\",\"isp\":\"电信\"},{\"ip\":\"183.167.178.39\",\"port\":6436,\"expire_time\":\"2017-09-02 21:45:04\",\"city\":\"池州市二\",\"isp\":\"电信\"},{\"ip\":\"182.118.98.170\",\"port\":9481,\"expire_time\":\"2017-09-02 21:48:08\",\"city\":\"许昌市\",\"isp\":\"联通\"},{\"ip\":\"125.123.123.75\",\"port\":7828,\"expire_time\":\"2017-09-02 21:50:07\",\"city\":\"嘉兴市\",\"isp\":\"电信\"},{\"ip\":\"121.234.115.239\",\"port\":3456,\"expire_time\":\"2017-09-02 21:48:04\",\"city\":\"盐城市\",\"isp\":\"电信\"},{\"ip\":\"182.35.26.216\",\"port\":7889,\"expire_time\":\"2017-09-02 22:01:07\",\"city\":\"泰安市\",\"isp\":\"电信\"},{\"ip\":\"27.220.127.243\",\"port\":8878,\"expire_time\":\"2017-09-02 22:03:13\",\"city\":\"菏泽市\",\"isp\":\"联通\"},{\"ip\":\"222.141.93.92\",\"port\":8991,\"expire_time\":\"2017-09-02 21:45:18\",\"city\":\"鹤壁市\",\"isp\":\"联通\"},{\"ip\":\"220.177.172.42\",\"port\":9756,\"expire_time\":\"2017-09-02 22:03:04\",\"city\":\"吉安市\",\"isp\":\"电信\"},{\"ip\":\"180.119.197.201\",\"port\":6882,\"expire_time\":\"2017-09-02 21:46:08\",\"city\":\"扬州市\",\"isp\":\"电信\"},{\"ip\":\"114.233.70.163\",\"port\":7998,\"expire_time\":\"2017-09-02 21:50:14\",\"city\":\"泰州市\",\"isp\":\"电信\"},{\"ip\":\"49.89.110.58\",\"port\":6413,\"expire_time\":\"2017-09-02 22:00:14\",\"city\":\"宿迁市\",\"isp\":\"电信\"},{\"ip\":\"42.177.53.183\",\"port\":8943,\"expire_time\":\"2017-09-02 22:02:15\",\"city\":\"辽阳市\",\"isp\":\"联通\"},{\"ip\":\"183.153.236.48\",\"port\":6936,\"expire_time\":\"2017-09-02 21:54:14\",\"city\":\"台州市\",\"isp\":\"电信\"},{\"ip\":\"220.186.156.249\",\"port\":7145,\"expire_time\":\"2017-09-02 22:02:13\",\"city\":\"温州市\",\"isp\":\"电信\"},{\"ip\":\"180.111.65.62\",\"port\":9669,\"expire_time\":\"2017-09-02 21:54:08\",\"city\":\"南京市\",\"isp\":\"电信\"},{\"ip\":\"114.103.69.164\",\"port\":8852,\"expire_time\":\"2017-09-02 22:01:21\",\"city\":\"淮北市\",\"isp\":\"电信\"},{\"ip\":\"49.68.184.239\",\"port\":6590,\"expire_time\":\"2017-09-02 21:52:08\",\"city\":\"徐州市\",\"isp\":\"电信\"},{\"ip\":\"115.216.227.129\",\"port\":6936,\"expire_time\":\"2017-09-02 21:53:14\",\"city\":\"台州市\",\"isp\":\"电信\"},{\"ip\":\"123.152.36.143\",\"port\":6382,\"expire_time\":\"2017-09-02 21:49:04\",\"city\":\"宁波市\",\"isp\":\"联通\"}]}";

        String data = JsonUtil.filter(json, "data");
        System.out.println(JsonUtil.jsonToObject(data, new TypeReference<ArrayList<ProxyIpRepository.IpBean>>() {
        }));
    }

}
