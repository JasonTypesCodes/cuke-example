package com.ociweb.cuke.example2;


import org.junit.runner.RunWith;

import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"html:target/cucumber-html-report"}, monochrome=true)
public class CucumberRunner { }
