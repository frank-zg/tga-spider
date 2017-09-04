package com.tga.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by frank_zhao on 2017/9/2.
 */
public class ProxyIpRepository {

    private static LinkedBlockingQueue<IpBean> IP_QUEUE = new LinkedBlockingQueue<IpBean>();
    private static final String IP_URI;

    static {
        IP_URI = PropertyUtil.getString("proxy.ips.uri");
    }


    public static final Optional<IpBean> takeIp() {
        Optional<IpBean> ipOpl = Optional.empty();
        try {
            while (IP_QUEUE.isEmpty()) {
                Thread.sleep(200);
            }
            ipOpl = Optional.of(IP_QUEUE.take());
        } catch (InterruptedException e) {
            System.out.println("reload ips...");
        }
        return ipOpl;
    }


    public static class IpThread implements Runnable {
        @Override
        public void run() {
            String json = HttpUtil.getOrReturn(IP_URI, new HashMap<>(), false, 30);
            try {
                Optional<List<IpBean>> ipBeans = Optional.ofNullable(JsonUtil.jsonToObject(json, new
                        TypeReference<ArrayList<IpBean>>() {
                        }));
                ipBeans.ifPresent(ip -> {
                    IP_QUEUE.addAll(ip);
                    System.out.println("get ip size:" + ip.size());
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static class IpBean implements Serializable {
        private String host;
        private int port;
        private String expire_time;


        public IpBean() {
        }


        public IpBean(String host, int port, String expire_time) {
            this.host = host;
            this.port = port;
            this.expire_time = expire_time;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }

        public String toString() {
            try {
                return JsonUtil.objectToJson(this);
            } catch (JsonProcessingException e) {
            }
            return null;
        }


    }

}
