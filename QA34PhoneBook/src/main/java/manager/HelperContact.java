package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        click(By.xpath("//*[text()='ADD']"));
    }

    public void fillAddForm(Contact contact){
        type(By.xpath("//input"), contact.getName());
        type(By.xpath("//input[2]"), contact.getLastName());
        type(By.xpath("//input[3]"), contact.getPhone());
        type(By.xpath("//input[4]"), contact.getEmail());
        type(By.xpath("//input[5]"), contact.getAddress());
        type(By.xpath("//input[6]"), contact.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//b[text()='Save']"));
    }

    public void saveContact2() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).sendKeys(Keys.ENTER);
    }

    public boolean isContactAddByName(String name) {
        List<WebElement> names = wd.findElements(By.cssSelector("h2"));
        for(WebElement el:names){
            if(el.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean isContactAddByPhone(String phone) {
        List<WebElement> phones = wd.findElements(By.cssSelector("h3"));
        for(WebElement el:phones){
            if(el.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }

    public void addContact() {
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Contact contact = Contact.builder().name("Nora").lastName("Red").phone("6543-867"+i+"5533")
                .email("noraR"+i+"@mail.com").address("BeerSheva").description("university friend").build();
        openAddForm();
        fillAddForm(contact);
        saveContact2();
    }
    public int deleteContact(){
        int countB = countOfContacts();
        logger.info("Count before remove is " + countB);
        if(isContactHere()) {
            logger.info("List of contact is not empty");
            click(By.cssSelector("h2"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
        int countA = countOfContacts();
        logger.info("Count after remove is " + countA);
        return countB-countA;
    }
    public void deleteAllContacts(){
        click(By.cssSelector("h2"));
        click(By.xpath("//button[text()='Remove']"));
        pause(500);
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public boolean isContactHere() {
        return wd.findElements(By.xpath("//h1[text()=' No Contacts here!']")).isEmpty();
    }

    public void addContact2() {
        Random random = new Random();
        if (!isContactHere()) {
            for (int i = 0; i < 4; i++) {
                int r = random.nextInt(1000) + 1000;
                Contact contact = Contact.builder().name("Nora" + r).lastName("Red").phone("6543-867" + r + "5533")
                        .email("noraR" + r + "@mail.com").address("BeerSheva").description("university friend").build();
                openAddForm();
                fillAddForm(contact);
                saveContact2();
            }
        }
    }
}
