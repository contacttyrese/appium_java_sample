# Mobile Test Automation Framework
**This example Appium project has been created for anyone who needs a sample Java project to use.**

The Appium client uses:
* Java 8
* Gradle
* Google Guice for Dependency Injection
* Deary App is the sample android apk for this framework (this app no longer receives updates) (Search on Google Deary Apk
* Junit4 Runner

The Appium server uses:
* Appium 3
* Node v24
* UiAutomator2 driver

To run this project from cli:
* You must have an Android Emulator/Device setup
* You must have Appium server setup
* You must have the configurations setup
* Successfully runs with the Node v24 and UiAutomator2 driver

If all is done, **try this command:**

`./gradlew test -Dcucumber.filter.tags="@emulator"'`

For any questions, you can contact me via:
* LinkedIn - https://www.linkedin.com/in/contacttyrese/
* Telegram - https://t.me/appiumautomation
