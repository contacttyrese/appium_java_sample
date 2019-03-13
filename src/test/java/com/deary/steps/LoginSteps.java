package com.deary.steps;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Login;
import cucumber.api.java8.En;

import static org.junit.Assert.assertTrue;

public class LoginSteps implements En {

    @Inject
    private Login login;

    @Inject
    public LoginSteps() {
        Then("^user is on login screen$", () -> {
            String errMsg = "login was not visible";
            boolean actual = login.isVisible();
            assertTrue(errMsg, actual);
        });

    }

}
