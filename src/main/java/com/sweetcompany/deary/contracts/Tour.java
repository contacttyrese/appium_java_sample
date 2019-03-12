package com.sweetcompany.deary.contracts;

public interface Tour extends PageContract {

    boolean isFriendsVisible();

    boolean isImportVisible();

    boolean isFindVisible();

    boolean isSaveVisible();

    void selectSkip();
}
