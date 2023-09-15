package Seminar03;

import java.io.BufferedReader;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        Contact contact = new Contact();
        View viewContact = new View();
        Presenter p = new Presenter(contact, viewContact);
        p.run();
    }
}
