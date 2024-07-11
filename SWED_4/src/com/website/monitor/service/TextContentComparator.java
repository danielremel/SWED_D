package com.website.monitor.service;

import com.website.monitor.model.Website;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class TextContentComparator implements WebsiteComparator {

    @Override
    public boolean hasUpdates(Website website) {
        try {
            URL url = new URL(website.getUrl());
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder newTextContent = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                newTextContent.append(inputLine.replaceAll("\\<.*?\\>", ""));
            }
            in.close();

            String oldTextContent = website.getTextContent();
            website.setTextContent(newTextContent.toString());
            return !newTextContent.toString().equals(oldTextContent);
        } catch (IOException e) {
            System.out.println("Error checking website text content: " + e.getMessage());
            return false;
        }
    }
}
