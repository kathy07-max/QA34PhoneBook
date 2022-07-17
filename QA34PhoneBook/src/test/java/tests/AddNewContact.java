package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContact extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!appManager.getHelperUser().isLogged()){
       appManager.getHelperUser().loggedIn();
       logger.info("User: ");
     }
    }

    @Test
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contact contact = Contact.builder().name("Nora"+i).lastName("Red").phone("6543-867"+i+"5533")
                .email("noraR"+i+"@mail.com").address("BeerSheva").description("university friend").build();
        logger.info("Contact is --> " + contact.toString());
        appManager.contact().openAddForm();
        appManager.contact().fillAddForm(contact);
        appManager.contact().saveContact2();
        Assert.assertTrue(appManager.contact().isContactAddByName(contact.getName()));
        logger.info("Check name: " + contact.getName());
        Assert.assertTrue(appManager.contact().isContactAddByPhone(contact.getPhone()));
        logger.info("Check phone: " + contact.getPhone());
    }
}
