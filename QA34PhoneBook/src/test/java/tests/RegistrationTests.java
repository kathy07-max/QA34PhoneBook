package tests;

import models.User;
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
        int i = (int)System.currentTimeMillis()/1000;
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenko"+i+"@mail.ru","020985$Max");
        appManager.getHelperUser().submitRegistration();
    }

    @Test
    public void registrationSuccessModel(){
        int i = (int)System.currentTimeMillis()/1000;
        User user1 = new User().setEmail("shevchenko"+i+"@gmail.com").setPassword("020985$Max");
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm(user1);
        appManager.getHelperUser().submitRegistration();
    }
}
