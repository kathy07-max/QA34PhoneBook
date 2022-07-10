package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!appManager.getHelperUser().isLogged()){
            appManager.getHelperUser().loggedIn();
        }
        if(appManager.contact().isContactsEmpty()){
            appManager.contact().addContact();
        }
    }

    @Test
    public void removeContact(){
        appManager.contact().deleteContact();


    }
    @Test
    public void deleteContact2(){
        appManager.getHelperUser().click(By.cssSelector("h2"));
        appManager.getHelperUser().click(By.xpath("//button[2]"));
    }
}
