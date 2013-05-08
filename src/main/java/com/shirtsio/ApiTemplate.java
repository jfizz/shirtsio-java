package com.shirtsio;

import com.shirtsio.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * All api users must handle BadRequestException.
 */
public class ApiTemplate extends RestTemplate {
    protected String baseUrl = "%s%s?api_key=%s";


    public ApiTemplate() {
        super();
        setErrorHandler(new ResponseErrorhandler());
    }

    protected <T> T post(String url, Object data, Class<T> clazz) {
        return this.postForObject(buildRequestUrl(url, null), data, clazz);
    }

    protected <T> T get(String url, Class<T> clazz, Map<String, Object> params) {
        return getForObject(buildRequestUrl(url, params), clazz);
    }

    protected String buildRequestUrl(String urlPartial, Map<String, Object> params) {
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

class ResponseErrorhandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        MediaType contentType = response.getHeaders().getContentType();
        Charset charset = contentType != null ? contentType.getCharSet() : null;
        byte[] body = getResponseBody(response);
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                throw new BadRequestException(new String(body));
            case SERVER_ERROR:
                throw new HttpServerErrorException(statusCode, response.getStatusText(), body, charset);
            default:
                throw new RestClientException("Unknown status code [" + statusCode + "]");
        }
    }

    private byte[] getResponseBody(ClientHttpResponse response) {
        try {
            InputStream responseBody = response.getBody();
            if (responseBody != null) {
                return FileCopyUtils.copyToByteArray(responseBody);
            }
        }
        catch (IOException ex) {
            // ignore
        }
        return new byte[0];
    }
}