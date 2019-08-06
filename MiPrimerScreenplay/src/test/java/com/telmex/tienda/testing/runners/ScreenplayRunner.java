package com.telmex.tienda.testing.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/com/telmex/tienda/testing/features/",
				 glue = "com.telmex.tienda.testing.stepsdefinitions",
				 snippets = SnippetType.CAMELCASE)
public class ScreenplayRunner {
	
}
