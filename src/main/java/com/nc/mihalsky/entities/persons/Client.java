package com.nc.mihalsky.entities.persons;

public class Client implements Person {
    private  long id;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private long phoneNumber;
    private int passportSeries;
    private int passportNumber;

    public Client (){
        this.name = "";
        this.surname = "";
        this.surname = "";
        this.gender = "";
    }

    public Client (
                   String name,
                   String surname,
                   String patronymic,
                   String gender,
                   long phoneNumber,
                   int passportSeries,
                   int passportNumber){
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

        this.phoneNumber = phoneNumber;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
