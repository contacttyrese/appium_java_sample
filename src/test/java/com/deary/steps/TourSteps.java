package com.deary.steps;

import com.google.inject.Inject;
import com.sweetcompany.deary.contracts.Tour;
import cucumber.api.java8.En;

import static org.junit.Assert.assertTrue;

public class TourSteps implements En {

    @Inject
    public Tour tour;

    public TourSteps() {
        Given("^user is on landing tour$", () -> {
            String errMsg = "Landing tour was not visible";
            boolean actual = tour.isVisible();
            assertTrue(errMsg, actual);
        });

        Given("^user is on friends on landing tour$", () -> {
            String errMsg = "Friends was not visible on landing tour";
            boolean actual = tour.isFriendsVisible();
            assertTrue(errMsg, actual);
        });

        Given("^user is on import on landing tour$", () -> {
            String errMsg = "Import was not visible on landing tour";
            boolean actual = tour.isImportVisible();
            assertTrue(errMsg, actual);
        });

        Given("^user is on find on landing tour$", () -> {
            String errMsg = "Find was not visible on landing tour";
            boolean actual = tour.isFindVisible();
            assertTrue(errMsg, actual);
        });

        Then("^user is on save on landing tour$", () -> {
            String errMsg = "Save was not visible on landing tour";
            boolean actual = tour.isSaveVisible();
            assertTrue(errMsg, actual);
        });

        When("^user selects skip$", () -> {
            tour.selectSkip();
        });

        When("^user swipes right$", () -> {
            tour.swipeRight();
        });
    }

}
