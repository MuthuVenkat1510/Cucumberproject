package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\LoginFeature", glue = "org.steps",
monochrome = true, strict = true, snippets = SnippetType.UNDERSCORE,dryRun=false)
public class RunnerClass {

}
