package tests;

import models.Contact;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){
       appManager.getHelperUser().loggedIn();
    }


    @Test
    public void addNewContactSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3800;
        Contact contact = Contact.builder().name("Nora").lastName("Red").phone("6543-867"+i+"5533")
                .email("noraR"+i+"@mail.com").address("BeerSheva").description("university friend").build();
        appManager.contact().openAddForm();
        appManager.contact().fillAddForm(contact);
       // appManager.getHelperUser().zoomToDecrease();
        //appManager.contact().submit();

    }

    @AfterMethod
    public void postCondition(){

    }
}
