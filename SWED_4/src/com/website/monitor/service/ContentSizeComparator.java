package com.website.monitor.service;

import com.website.monitor.model.Website;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ContentSizeComparator implements WebsiteComparator {

    @Override
    public boolean hasUpdates(Website website) {
        try {
            URL url = new URL(website.getUrl());
            URLConnection connection = url.openConnection();
            int newSize = connection.getContentLength();
            int oldSize = website.getContentSize();
            website.setContentSize(newSize);
            return newSize != oldSize;
        } catch (IOException e) {
            System.out.println("Error checking website content size: " + e.getMessage());
            return false;
        }
    }
}
