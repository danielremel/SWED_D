package com.website.monitor.model;

import java.util.Date;

public class Subscription {
    private int subscriptionID;
    private String frequency;
    private String preferredChannel;
    private Date lastCheckedDate;
    private User user;
    private Website website;

    public Subscription(int subscriptionID, String frequency, String preferredChannel, User user, Website website) {
        this.subscriptionID = subscriptionID;
        this.frequency = frequency;
        this.preferredChannel = preferredChannel;
        this.user = user;
        this.website = website;
        this.lastCheckedDate = new Date();
    }

    public void modifySubscription(String frequency, String preferredChannel) {
        this.frequency = frequency;
        this.preferredChannel = preferredChannel;
        System.out.println("com.website.monitor.model.Subscription modified for website: " + website.getUrl());
    }

    public void cancelSubscription() {
        user.removeSubscription(this);
        System.out.println("com.website.monitor.model.Subscription cancelled for website: " + website.getUrl());
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getPreferredChannel() {
        return preferredChannel;
    }

    public Date getLastCheckedDate() {
        return lastCheckedDate;
    }

    public User getUser() {
        return user;
    }

    public Website getWebsite() {
        return website;
    }
}
