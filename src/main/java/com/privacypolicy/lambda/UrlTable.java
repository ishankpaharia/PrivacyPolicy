package com.privacypolicy.lambda;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "UrlTable")
public class UrlTable {

    @DynamoDBHashKey
    private String username;

    @DynamoDBRangeKey
    private String timestamp;

    @DynamoDBAttribute
    private String websiteUrl;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public UrlTable() {
    }

    public UrlTable(String username, String websiteUrl, String timestamp) {
        this.username = username;
        this.websiteUrl = websiteUrl;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
