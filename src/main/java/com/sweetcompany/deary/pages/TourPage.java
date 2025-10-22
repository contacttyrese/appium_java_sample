package com.sweetcompany.deary.pages;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Tour;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TourPage implements Tour {
    private AndroidDriver appiumDriver;
    private FluentWait<AppiumDriver> wait;

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
        this.appiumDriver = (AndroidDriver) appiumDriver;
        this.wait = wait;
    }

    @Override
    public boolean isFriendsVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(AppiumBy.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(monsterImg1Id)));
        return titles.get(1).isDisplayed() && titles.get(2).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isImportVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(AppiumBy.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(monsterImg2Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isFindVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(AppiumBy.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(monsterImg3Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public boolean isSaveVisible() {
        List<WebElement> titles = wait.until(mobileDriver -> mobileDriver.findElements(AppiumBy.className(titlesClassName)));
        WebElement monsterImg = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(monsterImg4Id)));
        return titles.get(0).isDisplayed() && monsterImg.isDisplayed();
    }

    @Override
    public void selectSkip() {
        WebElement skipButton = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(skipButtonId)));
        skipButton.click();
    }

    @Override
    public void swipeRight() {
//        TouchAction action = new TouchAction(appiumDriver);
//        Point startPoint = new Point(50, 600);
//        Point endPoint = new Point(800, 600);
//        PointOption startPointOption = new PointOption()
//                .withCoordinates(startPoint);
//        PointOption endPointOption = new PointOption()
//                .withCoordinates(endPoint);
//        WaitOptions actionWaitOption = new WaitOptions()
//                .withDuration(Duration.ofSeconds(3L));
//        action.press(startPointOption).moveTo(endPointOption).release().perform();
//        action.waitAction(actionWaitOption);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(971, 1567);
        Point end = new Point (56, 1572);
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(Arrays.asList(swipe));

//        appiumDriver.executeScript("mobile: dragGesture", ImmutableMap.of(
//                "startX", "50",
//                "startY", "600",
//                "endX", "800",
//                "endY", "600"
//        ));
    }

    @Override
    public boolean isVisible() {
        WebElement container = wait.until(mobileDriver -> mobileDriver.findElement(AppiumBy.id(containerId)));
        return container.isDisplayed();
    }
}
