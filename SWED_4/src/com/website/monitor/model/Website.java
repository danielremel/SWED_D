package com.website.monitor.model;

public class Website {
    private int websiteID;
    private String url;
    private int contentSize;
    private String htmlContent;
    private String textContent;

    public Website(int websiteID, String url) {
        this.websiteID = websiteID;
        this.url = url;
        this.contentSize = -1;
        this.htmlContent = "";
        this.textContent = "";
    }

    public String getUrl() {
        return url;
    }

    public int getContentSize() {
        return contentSize;
    }

    public void setContentSize(int contentSize) {
        this.contentSize = contentSize;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
