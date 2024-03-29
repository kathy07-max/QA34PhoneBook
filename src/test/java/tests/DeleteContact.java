package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DeleteContact extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!appManager.getHelperUser().isLogged()){
            appManager.getHelperUser().loggedIn();
        }
        appManager.contact().addContactS();
        appManager.contact().pause(700);

   }

    @Test
    public void deleteContact(){
       Assert.assertEquals(appManager.contact().deleteContact(),1);
    }

    @Test
    public void removeAllContact(){
        while (appManager.contact().isContactHere()) {
            appManager.contact().deleteAllContacts();
        }
        Assert.assertFalse(appManager.contact().isContactHere());
    }

}
