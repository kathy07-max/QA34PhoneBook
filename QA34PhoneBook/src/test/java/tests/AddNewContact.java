package tests;

import models.Contact;
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
        Contact contact = Contact.builder().name("Nora").lastName("Red").phone("6543-8675533")
                .email("noraR@mail.com").address("BeerSheva").description("university friend").build();
        appManager.contact().openAddForm();
        appManager.contact().fillAddForm(contact);
        //appManager.contact().submit();

    }

    @AfterMethod
    public void postCondition(){

    }
}
