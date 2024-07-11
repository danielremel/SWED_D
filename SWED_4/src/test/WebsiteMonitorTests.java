package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.website.monitor.model.*;
import com.website.monitor.service.*;

public class WebsiteMonitorTests {

    private User validUser;
    private User invalidUser;
    private Website website;
    private Subscription validSubscription;
    private MonitorService monitorService;

    @BeforeEach
    void setUp() {
        validUser = new User(1, "Daniel Remel", "danielremel@outlook.de", "1234567890");
        invalidUser = new User(2, "Max Mustermann", "invalidemail", "1234567890");
        website = new Website(1, "https://google.com");
        validSubscription = new Subscription(1, "secondly", "email", validUser, website);
        monitorService = new MonitorService(new ContentSizeComparator());
    }

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> validUser.register());
    }


    @Test
    void testAddSubscription() {
        validUser.addSubscription(validSubscription);
        assertTrue(validUser.getSubscriptions().contains(validSubscription));
    }

    @Test
    void testRemoveSubscription() {
        validUser.addSubscription(validSubscription);
        validUser.removeSubscription(validSubscription);
        assertFalse(validUser.getSubscriptions().contains(validSubscription));
    }


}
