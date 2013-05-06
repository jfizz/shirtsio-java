package com.shirtsio;

import com.shirtsio.model.DetailedProduct;
import com.shirtsio.model.ProductResult;
import com.shirtsio.model.Result;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;

public class ApiTemplate {
    private ObjectMapper mapper = new ObjectMapper();
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "%s%s?api_key=%s";

    public <T> T[] getObjects(String url, Class<T> clazz) {
        Result result =
                restTemplate.getForObject(buildRequestUrl(url, null), Result.class);

        try {
            return (T[]) mapper.readValue(
                    result.getResult(), Array.newInstance(clazz, 0).getClass());
        } catch (IOException e) {
            // ignore
        }

        return null;
    }


    public <T> T getObject(String url, Class<T> clazz, Map<String, String> params) {
        Result result = restTemplate.getForObject(buildRequestUrl(url, params), Result.class);

        try {
            return mapper.readValue(result.getResult(), clazz);
        } catch (IOException e) {
            // ignore
        }

        return null;
    }

    public DetailedProduct getProductResult(String url, Map<String, String> params) {
        return restTemplate.getForObject(buildRequestUrl(url, params), ProductResult.class)
                           .getResult();
    }

    private String buildRequestUrl(String urlPartial, Map<String, String> params) {
        String requestUrl = String.format(baseUrl,
                                          Shirtsio.API_BASE, urlPartial, Shirtsio.apiKey);

        StringBuilder sb = new StringBuilder();
        if(params != null && !params.isEmpty()) {
            for(String key:params.keySet()) {
                sb.append("&").append(key).append("=").append(params.get(key));
            }
        }

        return requestUrl + sb.toString();
    }
}
