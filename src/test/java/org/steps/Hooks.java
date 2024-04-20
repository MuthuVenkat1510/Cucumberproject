package org.steps;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {
	
	@Before
	public void beforeSenario() {
		launchBrowser();
	}

	@After
	public void afterSenario() {
		toQuit();
	}
}
