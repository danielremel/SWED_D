package com.website.monitor.service;

import com.website.monitor.model.Website;

public interface WebsiteComparator {
    boolean hasUpdates(Website website);
}
