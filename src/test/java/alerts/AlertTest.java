package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.*;

public class AlertTest extends BaseTest {
    @Test
    void testAcceptAlert(){
        final AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alertClickToAccept();

        assertEquals(alertsPage.getAlertResult(), "You successfuly clicked an alert");
    }

    @Test
    void testGetTextFromAlert(){
        final AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();

        final String alertText = alertsPage.alertGetText();
        alertsPage.alertClickToDismiss();

        assertEquals(alertText, "I am a JS Confirm");
        assertEquals(alertsPage.getAlertResult(), "You clicked: Cancel");
    }

    @Test
    void testSetInputInAlert(){
        final AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPromptButton();

        final String text = "Life is beautiful you just have to see it";
        alertsPage.alertSetInput(text);
        alertsPage.alertClickToAccept();

        assertEquals(alertsPage.getAlertResult(), "You entered: " + text);
    }
}
