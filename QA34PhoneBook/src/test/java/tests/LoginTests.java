package tests;
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
    public void loginaSuccess(){

        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenko@mail.ru", "020985$Max");
        appManager.getHelperUser().submitLogin();

    }

    @Test
    public void loginNegativeWrongEmail(){

        appManager.getHelperUser().openLoginRegForm();
        appManager.getHelperUser().fillLogRegForm("shevchenkomail.ru", "020985$Max");
        appManager.getHelperUser().submitRegistration();

    }
}
