package com.website.monitor.service;

import com.website.monitor.model.Website;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlContentComparator implements WebsiteComparator {

    @Override
    public boolean hasUpdates(Website website) {
        try {
            URL url = new URL(website.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder newHtmlContent = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                newHtmlContent.append(inputLine);
            }
            in.close();

            String oldHtmlContent = website.getHtmlContent();
            website.setHtmlContent(newHtmlContent.toString());
            return !newHtmlContent.toString().equals(oldHtmlContent);
        } catch (IOException e) {
            System.out.println("Error checking website HTML content: " + e.getMessage());
            return false;
        }
    }
}
