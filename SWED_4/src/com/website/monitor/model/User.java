package com.website.monitor.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String name;
    private String email;
    private String phone;
    private List<Subscription> subscriptions;

    public User(int userID, String name, String email, String phone) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subscriptions = new ArrayList<>();
    }

    public void register() {
        System.out.println("User registered: " + name);
    }

    public void manageSubscriptions() {
        System.out.println("Managing subscriptions for user: " + name);
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
        System.out.println("Subscription added for website: " + subscription.getWebsite().getUrl());
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
        System.out.println("Subscription removed for website: " + subscription.getWebsite().getUrl());
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
