package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        //open browser
        wd = new ChromeDriver();
        //open www
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void openLoginRegForm() {
        WebElement loginTab = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[1]")).click();
    }

    public void submitRegistration() {
        wd.findElement(By.xpath("//button[2]")).click();
    }

    public void fillLogRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

}
