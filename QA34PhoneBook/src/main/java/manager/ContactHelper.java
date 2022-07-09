package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void submit() {
        click(By.xpath("//b[text()='Save']"));
    }
}
