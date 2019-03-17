package com.sweetcompany.deary.contracts;

public interface Login extends PageContract {

    void selectSignIn();

    void denyPermissionForFiles();

    void allowPermissionForFiles();

    boolean isGoogleSignInVisible();

    boolean isGoogleSelectVisible();

}
