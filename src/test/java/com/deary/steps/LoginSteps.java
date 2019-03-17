package com.deary.steps;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Login;
import cucumber.api.java8.En;

import static org.junit.Assert.assertTrue;

public class LoginSteps implements En {

    @Inject
    private Login login;

    public LoginSteps() {
        Then("^user is on login screen$", () -> {
            String errMsg = "login was not visible";
            boolean actual = login.isVisible();
            assertTrue(errMsg, actual);
        });

        When("^user denies permission on login screen$", () -> {
            login.denyPermissionForFiles();
        });

        When("^user allows permission on login screen$", () -> {
            login.allowPermissionForFiles();
        });

        When("^user selects sign in on login screen$", () -> {
            login.selectSignIn();
        });

        Then("^Google sign in screen is displayed$", () -> {
            String errMsg = "Google sign in did not display";
            boolean actual = login.isGoogleSignInVisible();
            assertTrue(errMsg, actual);
        });

        Then("^Google select account screen is displayed$", () -> {
            String errMsg = "Google select account(s) did not display";
            boolean actual = login.isGoogleSelectVisible();
            assertTrue(errMsg, actual);
        });

    }

}
