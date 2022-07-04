package com.sweetcompany.deary.config;

/**
 * The interface for storing immutable variables
 * @author Tyrese Thomas
 */
public interface Constants {

    String configPath = "./src/main/resources/sample.json";
    String androidDeviceId = "insert_id_here";
    String androidDeviceName = "insert_name_here";
    String nexusEmulatorName = "Android Emulator";
    String nexusEmulatorId = "emulator-5554";
    String waitErrorMsg = "Time expired to locate mobile element";
    String espressoDriverFix = "{ \"additionalAppDependencies\": [ \"com.google.android.material:material:1.0.0\", \"androidx.lifecycle:lifecycle-extensions:2.1.0\" ] }"
}
