package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {

   public HelperUser(WebDriver wd) {
      super(wd);
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

   public boolean isLogged() {
      List<WebElement> list =  wd.findElements(By.xpath("//button[text()='Sing Out']"));
      return list.size()>0;
   }
   public void logout() {
      click(By.xpath("//button[text()='Sing Out']"));
   }
}
