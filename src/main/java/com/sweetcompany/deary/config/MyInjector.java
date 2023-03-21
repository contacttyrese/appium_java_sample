package com.sweetcompany.deary.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.sweetcompany.deary.config.modules.AndroidModule;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyInjector implements InjectorSource {
    private final Logger log = LogManager.getLogger(MyInjector.class.getName());

    @Override
    public Injector getInjector() {
        log.debug("Preparing Android Module...");
        AbstractModule platformModule = new AndroidModule();
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), platformModule);
    }
}
