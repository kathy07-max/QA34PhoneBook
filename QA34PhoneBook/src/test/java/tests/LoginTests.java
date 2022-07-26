package tests;
import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(appManager.getHelperUser().isLogged()){
            appManager.getHelperUser().logout();
        }
    }
    @Test
    public void loginASuccess(){
        User user = new User().setEmail("shevchenko@mail.ru").setPassword("020985$Max");
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm(user);
        appManager.getHelperUser().submitLogin();
        Assert.assertTrue(appManager.getHelperUser().isLogged());
    }

    @Test
    public void loginNegativeWrongEmail(){
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenkomail.ru", "020985$Max");
        appManager.getHelperUser().submitLogin();
        Assert.assertFalse(appManager.getHelperUser().isLogged());
        Assert.assertTrue(appManager.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(appManager.getHelperUser().isErrorFormatDisplayed());

    }

    @Test(dataProvider = "loginCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessCSV(User user){
        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm(user);
        appManager.getHelperUser().submitLogin();
        Assert.assertTrue(appManager.getHelperUser().isLogged());
    }
}
