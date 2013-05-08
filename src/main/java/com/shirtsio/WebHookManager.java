package com.shirtsio;

import com.shirtsio.model.WebHookAddResponse;
import com.shirtsio.model.WebHooks;
import com.shirtsio.model.WebHooksResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class WebHookManager extends ApiTemplate {

    private String registerUrl = "webhooks/register/";
    private String deleteUrl = "webhooks/delete/";
    private String listUrl = "webhooks/list/";

    public WebHooks getWebHooks() {
        return get(listUrl, WebHooksResponse.class, null).getResult();
    }

    public boolean addWebHook(String url) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("url", url);
        params.add("api_key", Shirtsio.apiKey);
        return post(registerUrl, params, WebHookAddResponse.class).getResult().isSuccess();
    }

    public boolean deleteWebHook(String url) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("url", url);
        params.add("api_key", Shirtsio.apiKey);
        return post(deleteUrl, params, WebHookAddResponse.class).getResult().isSuccess();
    }

    public static void main(String[] args) {
        WebHookManager webHookManager = new WebHookManager();
        String webHook = "http://127.0.0.1:8000/shirtsio_shopify/harrisonfirststore/webhook/";
        System.out.println(webHookManager.addWebHook(webHook));

        String[] urls = webHookManager.getWebHooks().getListenerUrl();
        if(urls != null) {
            for(String url: urls) {
                System.out.println(url);
            }
        }

        webHookManager.deleteWebHook(webHook);

        urls = webHookManager.getWebHooks().getListenerUrl();
        if(urls != null) {
            for(String url: urls) {
                System.out.println(url);
            }
        }
    }
}
