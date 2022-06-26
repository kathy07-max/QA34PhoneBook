package tests;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager appManager = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        appManager.init();
    }

    @AfterSuite
    public void tearDown() {
      appManager.stop();
    }

}
