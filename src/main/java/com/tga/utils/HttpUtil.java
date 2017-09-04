package com.tga.utils;

import org.asynchttpclient.*;
import org.asynchttpclient.proxy.ProxyServer;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by frank_zhao on 2017/8/22.
 */
public class HttpUtil {

    private static final AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();


    public static String getOrReturn(String uri, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            return asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS).getResponseBody();
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String getOrReturn(String uri, Map<String, String> headers,
                                     ProxyServer proxy, boolean exceptionStatus, int timeout) {
        try {
            return asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .setProxyServer(proxy)
                    .execute().get(timeout, TimeUnit.SECONDS).getResponseBody();
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void get(String uri, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }

    public static Response getRes(String uri,  boolean exceptionStatus, int timeout) {
        try {
            return asyncHttpClient.prepareGet(uri)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void post(String url, String body, Map<String, String> headers, boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.preparePost(url)
                    .setBody(body)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }


    public static void get(String uri, Map<String, String> headers, ProxyServer proxy,
                           boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .setProxyServer(proxy)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }


    public static void post(String url, String body, Map<String, String> headers, ProxyServer proxy,
                            boolean exceptionStatus, int timeout) {
        try {
            asyncHttpClient.preparePost(url)
                    .setBody(body)
                    .setProxyServer(proxy)
                    .setSingleHeaders(headers)
                    .execute().get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
        }
    }

    public static void downStream(String uri, Map<String, String> headers, ProxyServer proxy,
                                  long downSize, boolean exceptionStatus, int timeout) {

        try {
            asyncHttpClient.prepareGet(uri)
                    .setSingleHeaders(headers)
                    .setProxyServer(proxy)
                    .execute(new AsyncHandler() {
                        long downBytes = 0;

                        @Override
                        public void onThrowable(Throwable throwable) {

                        }

                        @Override
                        public State onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
                            if (downBytes >= downSize || httpResponseBodyPart.isLast()) {
                                System.out.println(downSize + " KB,已下载完成");
                                return State.ABORT;
                            }
                            downBytes += httpResponseBodyPart.getBodyPartBytes().length;
                            System.out.println(downSize + "---");
                            return State.CONTINUE;
                        }

                        @Override
                        public State onStatusReceived(HttpResponseStatus httpResponseStatus) throws Exception {
                            return null;
                        }

                        @Override
                        public State onHeadersReceived(HttpResponseHeaders httpResponseHeaders) throws Exception {
                            return null;
                        }

                        @Override
                        public Object onCompleted() throws Exception {
                            return null;
                        }
                    }).get(timeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            if (exceptionStatus) {
                e.printStackTrace();
            }
            System.out.println("视频下载超时...");
        }

    }
}
