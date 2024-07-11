package com.website.monitor.main;

import com.website.monitor.model.Notification;
import com.website.monitor.model.Subscription;
import com.website.monitor.model.User;
import com.website.monitor.model.Website;
import com.website.monitor.service.ContentSizeComparator;
import com.website.monitor.service.MonitorService;
import com.website.monitor.service.WebsiteComparator;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Daniel Remel", "danielremel@outlook.de", "1234567890");
        user.register();

        Website website = new Website(1, "https://google.com");

        Subscription subscription = new Subscription(1, "secondly", "email", user, website);

        user.addSubscription(subscription);

        WebsiteComparator comparator = new ContentSizeComparator();
        // WebsiteComparator comparator = new HtmlContentComparator();
        // WebsiteComparator comparator = new TextContentComparator();

        MonitorService monitorService = new MonitorService(comparator);

        Notification notification = new Notification(1, "Update detected", "email", user);
        monitorService.registerObserver(notification);

        monitorService.addSubscription(subscription);

        monitorService.startPeriodicChecks(1);
    }
}
