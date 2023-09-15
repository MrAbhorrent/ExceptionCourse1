package Seminar03;

import java.util.Date;

public class Contact {

    private String lastName;
    private String name;
    private String surName;
    private Date dateBirth;
    private int phoneNumber;
    private Sex sex;

    public Contact() {
        this(null, null, null, new Date(), 0, Sex.m);
    }

    public Contact(String lastName, String name, String surName, Date dateBirth, int phoneNumber, Sex sex) {
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    @Override
    public String toString() {

        return "<" + lastName + "><" + name + "><" + surName + "><" + dateBirth + "><" + phoneNumber + "><"
                + sex + ">\n";
    }
}
