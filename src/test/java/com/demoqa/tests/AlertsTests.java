package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod void precondition() {
        new HomePage(driver).confirmCookie().getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void clickByAlertWithTimer() {
        new AlertsPage(driver).hideIframes();
        new AlertsPage(driver).clickByAlertWithTimer();
    }

    @Test
    public void selectResultTest() {
        new AlertsPage(driver).hideIframes();
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest() {
        new AlertsPage(driver).hideIframes();
        new AlertsPage(driver).sendMessageToAlert("Hello world!").verifyMessage("Hello world!");
    }
}
