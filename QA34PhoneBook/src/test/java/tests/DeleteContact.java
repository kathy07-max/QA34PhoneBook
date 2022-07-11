package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.Locator;


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
        appManager.contact().deleteContact(By.cssSelector("h2"));
        Assert.assertTrue(appManager.contact().isContactsEmpty());
    }
    @Test
    public void deleteContactByName(){
        if(appManager.contact().isContactAddedByName("Nora")){
            appManager.contact().deleteContact(By.xpath("//*[text()='Nora']"));
        }
        Assert.assertTrue(appManager.contact().isContactsEmpty());
    }
}
