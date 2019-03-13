package com.sweetcompany.deary.pages;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Tour;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class TourPage implements Tour {
    private AndroidDriver appiumDriver;
    private FluentWait<MobileDriver> wait;

    private final String titlesClassName = "android.widget.TextView";
    private final String monsterImg1Id = "ivMonster1_T_1";
    private final String monsterImg2Id = "ivMonster1_T_2";
    private final String monsterImg3Id = "ivMonster1_T_3";
    private final String monsterImg4Id = "ivMonster1_T_4";
    private final String skipButtonId = "tvSkip";
    private final String containerId = "viewPager";

    public TourPage() {}

    @Inject
    public TourPage(AppiumDriver appiumDriver, FluentWait wait) {
        this.appiumDriver = (AndroidDriver<MobileElement>) appiumDriver;
        this.wait = wait;
    }

    @Override
    public boolean isFriendsVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(By.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(MobileBy.id(monsterImg1Id)));
        return titles.get(1).isDisplayed() && titles.get(2).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isImportVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(By.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(MobileBy.id(monsterImg2Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isFindVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(By.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(MobileBy.id(monsterImg3Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isSaveVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(By.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(MobileBy.id(monsterImg4Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public void selectSkip() {
        WebElement skipButton = wait.until(mobileDriver -> mobileDriver.findElement(MobileBy.id(skipButtonId)));
        skipButton.click();
    }

    @Override
    public void swipeRight() {
        TouchAction action = new TouchAction(appiumDriver);
        Point startPoint = new Point(50, 600);
        Point endPoint = new Point(800, 600);
        PointOption startPointOption = new PointOption()
                .withCoordinates(startPoint);
        PointOption endPointOption = new PointOption()
                .withCoordinates(endPoint);
        WaitOptions actionWaitOption = new WaitOptions()
                .withDuration(Duration.ofSeconds(3L));
        action.press(startPointOption).moveTo(endPointOption).release().perform();
        action.waitAction(actionWaitOption);
    }

    @Override
    public boolean isVisible() {
        WebElement container = wait.until(mobileDriver -> mobileDriver.findElementById(containerId));
        return container.isDisplayed();
    }
}
