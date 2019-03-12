package com.sweetcompany.deary.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.sweetcompany.deary.config.modules.AndroidModule;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class MyInjector implements InjectorSource {

    @Override
    public Injector getInjector() {
        AbstractModule platformModule = new AndroidModule();
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), platformModule);
    }
}
