package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
      List<WebElement> list =  wd.findElements(By.xpath("//*[text()='Sign Out']"));
      return list.size()>0;
   }
   public void logout() {
      click(By.xpath("//*[text()='Sign Out']"));
   }

   public void loggedIn(){
      openLoginRegForm();
      fillLogRegForm("shevchenko@mail.ru", "020985$Max");
      submitLogin();
   }

   public boolean isAlertDisplayed() {
   Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
   if(alert==null){
      return false;
   }else {
      return true;
   }
      }

   public boolean isErrorFormatDisplayed() {
      Alert alert = wd.switchTo().alert();
//      alert.getText();
//      alert.sendKeys("hello");//type text
//      alert.accept();//click "OK" button
//      alert.dismiss();// click "cancel" button
      String errorText = alert.getText();
      System.out.println(errorText);
      alert.accept();

      return errorText.contains("Wrong email or password format");
   }

   public void fillLogRegForm(User user1) {
      type(By.xpath("//input[1]"), user1.getEmail());
      type(By.xpath("//input[2]"), user1.getPassword());
   }
}
