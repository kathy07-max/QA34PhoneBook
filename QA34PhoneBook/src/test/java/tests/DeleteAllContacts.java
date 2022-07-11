package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAllContacts extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!appManager.getHelperUser().isLogged()){
            appManager.getHelperUser().loggedIn();
        }
        if(appManager.contact().isContactsEmpty()){
            appManager.contact().addContact2();
        }
    }

    @Test
    public void deleteAllContact(){
        while (!appManager.contact().isContactsEmpty()) {
            appManager.contact().deleteContact(By.cssSelector("h2"));
        }
        Assert.assertTrue(appManager.contact().isContactsEmpty());
    }
}
