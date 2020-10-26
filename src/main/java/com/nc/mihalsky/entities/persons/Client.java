package com.nc.mihalsky.entities.persons;

import com.sun.javafx.util.Logging;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.logging.Logger;

public class Client implements Person {
    private  long id;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private long phoneNumber;
    private int passportSeries;
    private int passportNumber;
    private LocalDate dateOfBirthDay;

    public Client (){
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.gender = "";
        this.dateOfBirthDay = new LocalDate(1900,1,1);
    }

    public Client (
                   String name,
                   String surname,
                   String patronymic,
                   String gender,
                   long phoneNumber,
                   int passportSeries,
                   int passportNumber,
                   LocalDate dateOfBirthDay){
        if (name != null){
            this.name = name;
        }else {
            this.name = "";
        }

        if (surname != null){
            this.surname = surname;
        }else {
            this.surname = "";
        }

        if (patronymic != null){
            this.patronymic = patronymic;
        }else {
            this.patronymic = "";
        }

        if (gender != null){
            this.gender = gender;
        }else {
            this.gender = "";
        }

        if (dateOfBirthDay != null){
            this.dateOfBirthDay = dateOfBirthDay;
        }else {
            this.dateOfBirthDay = new LocalDate(1900,1,1);
        }

        this.phoneNumber = phoneNumber;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    public Years getAge(){
        LocalDate now = new LocalDate();
        return Years.yearsBetween(getDateOfBirthDay(), now);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    public void setDateOfBirthDay(LocalDate dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber + '\'' +
                ", dateOfBirthDay=" + dateOfBirthDay +
                '}';
    }
}
