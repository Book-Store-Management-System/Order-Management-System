package com.stepdef;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/BMS/ViewOrderFeature.feature",
glue="com.stepdef")
public class TestRunner2 {

}
