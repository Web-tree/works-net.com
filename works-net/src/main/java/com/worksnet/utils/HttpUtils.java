package com.worksnet.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Max Levicky
 *         Date: 13.04.13
 *         Time: 23:07
 */
public class HttpUtils {

    protected enum METHOD {POST, GET}

    protected static final String defaultEncoding = "UTF-8";

    public static Map<String, String> parseHttpParams(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public static String buildHttpParams(Map<String, String> params) {
        String result = "";
        for (Map.Entry entity : params.entrySet()) {
            result += "&" + entity.getKey() + "=" + entity.getValue();
        }
        return result.substring(1);
    }

    public static String sendGetRequest(String url, Map<String, String> params) throws IOException {
        return sendRequest(METHOD.GET, url, params);
    }

    public static String sendPostRequest(String url, Map<String, String> params) throws IOException {
        return sendRequest(METHOD.POST, url, params);
    }

    protected static String sendRequest(METHOD method, String url, Map<String, String> params) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpRequestBase httpRequest;

        switch (method) {
            case POST:
                httpRequest = new HttpPost(url);
                List<NameValuePair> preparedParams = new ArrayList<>();
                for (Map.Entry<String, String> param : params.entrySet()) {
                    preparedParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
                }
                ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(preparedParams, defaultEncoding));
                break;
            case GET:
                String uri = url + "?" + buildHttpParams(params);
                httpRequest = new HttpGet(uri);
                break;
            default:
                throw new Error("Not supported method");
        }

        HttpResponse response = httpClient.execute(httpRequest);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream inputStream = entity.getContent()) {
                StringWriter writer = new StringWriter();
                IOUtils.copy(inputStream, writer, defaultEncoding);
                return writer.toString();
            }
        }
        throw new IOException();
    }
}
