package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\97254\\DocQA34\\GitHub\\QA34PhoneBook\\QA34PhoneBook\\src\\test\\resources\\registr_log.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        int i = (int)(System.currentTimeMillis()/1000)%3800;
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\97254\\DocQA34\\GitHub\\QA34PhoneBook\\QA34PhoneBook\\src\\test\\resources\\registr_log.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new User().setEmail(i+split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> newContactCSV() throws IOException {
        int i = (int)(System.currentTimeMillis()/1000)%3800;
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\97254\\DocQA34\\GitHub\\QA34PhoneBook\\QA34PhoneBook\\src\\test\\resources\\contacts.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{Contact.builder().name(split[0]).lastName(split[1]).phone(split[2]+i)
                   .email(i+split[3]).address(split[4]).description(split[5]).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
