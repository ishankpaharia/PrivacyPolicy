package com.privacypolicy.lambda;

public class Request {

    private UrlTable urlTable;


    public UrlTable getUrlTable() {
        return urlTable;
    }

    public void setUrlTable(UrlTable urlTable) {
        this.urlTable = urlTable;
    }



    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
