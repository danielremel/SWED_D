package com.website.monitor.service;

import com.website.monitor.model.Subscription;
import com.website.monitor.model.Website;

import java.util.ArrayList;
import java.util.List;

public class MonitorService implements Subject {
    private List<Observer> observers;
    private List<Subscription> subscriptions;
    private WebsiteComparator comparator;

    public MonitorService(WebsiteComparator comparator) {
        this.observers = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void startPeriodicChecks(int intervalInSeconds) {
        Thread monitorThread = new Thread(() -> {
            while (true) {
                runChecks();
                try {
                    Thread.sleep(intervalInSeconds * 1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Monitor service interrupted.");
                    break;
                }
            }
        });
        monitorThread.start();
    }

    private void runChecks() {
        for (Subscription subscription : subscriptions) {
            Website website = subscription.getWebsite();
            if (comparator.hasUpdates(website)) {
                String content = "Update detected on website: " + subscription.getWebsite().getUrl();
                notifyObservers(content);
            } else {
                System.out.println("No updates found for website: " + website.getUrl());
            }
        }
    }
}
