package com.sweetcompany.deary.pages;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Login;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

public class LoginPage implements Login {
    private AndroidDriver appiumDriver;
    private FluentWait<MobileDriver> wait;

    private final String titleId = "register_app_name";
    private final String imgId = "register_app_image";
    private final String denyButtonId = "com.android.packageinstaller:id/permission_deny_button";
    private final String allowButtonId = "com.android.packageinstaller:id/permission_allow_button";
    private final String googleExistingEmailId = "com.google.android.gms:id/account_name";
    private final String signInButtonClassName = "android.widget.Button";
    private final String googleSignInTitleClassName = "android.view.View";

    public LoginPage() {}

    @Inject
    public LoginPage(AppiumDriver appiumDriver, FluentWait wait) {
        this.appiumDriver = (AndroidDriver<MobileElement>) appiumDriver;
        this.wait = wait;
    }

    @Override
    public void selectSignIn() {
        WebElement signInButton = wait.until(mobileDriver -> mobileDriver.findElementByClassName(signInButtonClassName));
        signInButton.click();
    }

    @Override
    public void denyPermissionForFiles() {
        WebElement denyButton = wait.until(mobileDriver -> mobileDriver.findElement(By.id(denyButtonId)));
        denyButton.click();
    }

    @Override
    public void allowPermissionForFiles() {
        WebElement allowButton = wait.until(mobileDriver -> mobileDriver.findElement(By.id(allowButtonId)));
        allowButton.click();
    }

    @Override
    public boolean isGoogleSignInVisible() {
        wait.until(mobileDriver -> ExpectedConditions.invisibilityOf(mobileDriver.findElement(By.className(signInButtonClassName))));
        wait.until(mobileDriver -> mobileDriver.findElement(By.className(googleSignInTitleClassName)));
        List<WebElement> views = wait.until(mobileDriver -> mobileDriver.findElements(By.className(googleSignInTitleClassName)));
        return views.get(0).isDisplayed();
    }

    @Override
    public boolean isGoogleSelectVisible() {
        wait.until(mobileDriver -> ExpectedConditions.invisibilityOf(mobileDriver.findElement(By.className(signInButtonClassName))));
        WebElement gmail = wait.until(mobileDriver -> mobileDriver.findElementById(googleExistingEmailId));
        return gmail.isDisplayed();
    }

    @Override
    public boolean isVisible() {
        wait.until(mobileDriver -> mobileDriver.findElement(By.id(imgId)));
        WebElement title = wait.until(mobileDriver -> mobileDriver.findElement(By.id(titleId)));
        return title.isDisplayed();
    }
}
