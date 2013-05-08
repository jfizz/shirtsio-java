package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class WebHooks {
    @JsonProperty("listener_url")
    private String[] listenerUrl;

    public String[] getListenerUrl() {
        return listenerUrl;
    }

    public void setListenerUrl(String[] listenerUrl) {
        this.listenerUrl = listenerUrl;
    }
}
