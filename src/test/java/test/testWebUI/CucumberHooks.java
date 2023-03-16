package test.testWebUI;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import test.BaseTest;


public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest() {
        getDriver();
    }

    @After
    public void afterTest() {
        driver.close();
    }
}
