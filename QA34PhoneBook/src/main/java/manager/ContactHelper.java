package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;

import java.util.List;
import java.util.Random;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
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

    public boolean isContactAddedByName(String name) {
        List<WebElement> names = wd.findElements(By.cssSelector("h2"));
        for(WebElement el:names){
            if(el.getText().equals(name)){
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
    public void deleteContact(By locator){
        click(locator);
        click(By.xpath("//button[2]"));
    }

    public boolean isContactsEmpty() {
        List<WebElement> list = wd.findElements(By.xpath("//h1[text()=' No Contacts here!']"));
        return list.size()>0;

    }

    public void addContact2() {
        for(int i = 0; i < 5; i++){
            Random random = new Random();
            int r = random.nextInt(1000)+1000;
            Contact contact = Contact.builder().name("Nora"+r).lastName("Red").phone("6543-867"+r+"5533")
                    .email("noraR"+r+"@mail.com").address("BeerSheva").description("university friend").build();
            openAddForm();
            fillAddForm(contact);
            saveContact2();
        }
    }
}
