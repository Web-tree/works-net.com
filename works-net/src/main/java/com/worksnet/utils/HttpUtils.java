package com.worksnet.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
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

    public static String getPostResult(String url, Map<String, String> params) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> preparedParams = new ArrayList<>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            preparedParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(preparedParams, defaultEncoding));
        HttpResponse response = httpClient.execute(httpPost);
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
