package com.deary.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources" },
        glue = { "com.deary.steps", "com.sweetcompany.deary.config" },
        dryRun = false,
        monochrome = true,
        tags = "@emulator",
        plugin = { "pretty", "html:report/reportrunner.html" }
)
public class CukesTest { }
