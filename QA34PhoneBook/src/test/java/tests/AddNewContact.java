package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!appManager.getHelperUser().isLogged()){
       appManager.getHelperUser().loggedIn();
    }}

    @Test
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contact contact = Contact.builder().name("Nora"+i).lastName("Red").phone("6543-867"+i+"5533")
                .email("noraR"+i+"@mail.com").address("BeerSheva").description("university friend").build();
        appManager.contact().openAddForm();
        appManager.contact().fillAddForm(contact);
       // appManager.getHelperUser().zoomToDecrease();
        appManager.contact().saveContact2();
        Assert.assertTrue(appManager.contact().isContactAddedByName(contact.getName(),By.cssSelector("h2")));
        Assert.assertTrue(appManager.contact().isContactAddedByName(contact.getPhone(),By.cssSelector("h3")));


    }
    @Test
    public void addNewContactSuccess2(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contact contact = Contact.builder().name("Nora"+i).lastName("Red").phone("6543-867"+i+"5533")
                .email("noraR"+i+"@mail.com").address("BeerSheva").description("university friend").build();
        appManager.contact().openAddForm();
        appManager.contact().fillAddForm(contact);
        appManager.contact().saveContact2();
        Assert.assertTrue(appManager.contact().isContactAddedByName(contact.getName(), By.cssSelector("h2")));
        Assert.assertTrue(appManager.contact().isContactAddedByName(contact.getPhone(),By.cssSelector("h3")));

    }
    @AfterMethod
    public void postCondition(){

    }
}
