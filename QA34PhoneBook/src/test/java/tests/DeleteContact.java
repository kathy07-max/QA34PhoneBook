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
        if(appManager.contact().isContactsEmpty()){
            appManager.contact().addContact2();
            appManager.contact().pause(500);
        }
   }

    @Test
    public void removeContact(){
       Assert.assertEquals(appManager.contact().deleteContact(),1);
    }

    @Test
    public void deleteAllContact(){
        while (!appManager.contact().isContactsEmpty()) {
            appManager.contact().deleteAllContacts();
        }
        Assert.assertTrue(appManager.contact().isContactsEmpty());
    }

}
