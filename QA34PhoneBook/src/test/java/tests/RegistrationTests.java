package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(appManager.getHelperUser().isLogged()){
            appManager.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3800;
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shev"+i+"@mail.ru","020985$Max");
        appManager.getHelperUser().submitRegistration();
        Assert.assertTrue(appManager.getHelperUser().isLogged());
        Assert.assertFalse(appManager.contact().isContactHere());
    }


    @Test(dataProvider = "registrationCSV",dataProviderClass = MyDataProvider.class)
    public void registrationSucCSV(User user){
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm(user);
        appManager.getHelperUser().submitRegistration();
        Assert.assertTrue(appManager.getHelperUser().isLogged());
    }
}
