package tests;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{



    @Test
    public void successLogin(){

        openLoginRegForm();

        fillLogRegForm("shevchenko@mail.ru", "020985$Max");

        submitLogin();

    }

    @Test
    public void loginNegativeWrongEmail(){

        openLoginRegForm();

        fillLogRegForm("shevchenkomail.ru", "020985$Max");

        submitRegistration();

    }
}
