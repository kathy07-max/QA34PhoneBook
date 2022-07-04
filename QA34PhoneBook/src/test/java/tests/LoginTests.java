package tests;
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

        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenko@mail.ru", "020985$Max");
        appManager.getHelperUser().submitLogin();
        Assert.assertTrue(appManager.getHelperUser().isLogged());
    }

    @Test
    public void loginNegativeWrongEmail(){

        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenkomail.ru", "020985$Max");
        appManager.getHelperUser().submitRegistration();
        Assert.assertFalse(appManager.getHelperUser().isLogged());
        Assert.assertTrue(appManager.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(appManager.getHelperUser().isErrorFormatDisplayed());

    }
}
