package com.sweetcompany.deary.pages;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Login;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage implements Login {
    private AndroidDriver appiumDriver;
    private FluentWait<MobileDriver> wait;

    private final String containerId = "register_app_name";
    private final String denyButtonId = "com.android.packageinstaller:id/permission_deny_button";

    public LoginPage() {}

    @Inject
    public LoginPage(AppiumDriver appiumDriver, FluentWait wait) {
        this.appiumDriver = (AndroidDriver<MobileElement>) appiumDriver;
        this.wait = wait;
    }

    @Override
    public void selectSignIn() {

    }

    @Override
    public boolean isVisible() {
        WebElement denyButton = wait.until(mobileDriver -> mobileDriver.findElement(By.id(denyButtonId)));
        denyButton.click();
        WebElement container = wait.until(mobileDriver -> mobileDriver.findElement(By.id(containerId)));
        return container.isDisplayed();
    }
}
