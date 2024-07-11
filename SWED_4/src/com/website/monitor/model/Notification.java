package com.website.monitor.model;

import com.website.monitor.service.Observer;

import java.util.Date;

public class Notification implements Observer {
    private int notificationID;
    private Date timestamp;
    private String content;
    private String channel;
    private User user;

    public Notification(int notificationID, String content, String channel, User user) {
        this.notificationID = notificationID;
        this.timestamp = new Date();
        this.content = content;
        this.channel = channel;
        this.user = user;
    }

    @Override
    public void update(String message) {
        this.content = message;
        send();
    }

    public void send() {
        System.out.println("Notification sent to " + user.getName() + " via " + channel + ": " + content);
    }
}
