package com.nc.mihalsky.entities.persons;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Objects;

/**
 *Класс Клиент со свойствами <b>id</b>,<b>name</b>,<b>surname</b>,<b>patronymic</b>,
 * <b>phoneNumber</b>,<b>passportSeries</b>,<b>passportNumber</b>,<b>dateOfBirthDay</b>,
 * @author Roman Mihalsky
 */

public class Client implements Person,Comparable<Client> {
    /**Поле id*/
    private  long id;
    /**Поле имя*/
    private String name;
    /**Поле фамилия*/
    private String surname;
    /**Поле отчество*/
    private String patronymic;
    /**Поле пол*/
    private String gender;
    /**Поле номер телефона*/
    private long phoneNumber;
    /**Поле серия паспорта*/
    private int passportSeries;
    /**Поле номер паспорта*/
    private int passportNumber;
    /**Поле дата рождения*/
    private LocalDate dateOfBirthDay;

    /**Конструктор для создания клиента с default значениями*/
    public Client (){
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.gender = "";
        this.dateOfBirthDay = new LocalDate(1900,1,1);
    }

    /**Конструкто для создания клиента с параметрами.
     *Все null аргументы заменяются на default значения
     * @param id - код клиента
     * @param name - имя клиента
     * @param surname - фамилия клиента
     * @param patronymic - отчество клиента
     * @param gender - пол клиента
     * @param phoneNumber - номер телефона клиента
     * @param passportSeries - серия паспорта клиента
     * @param passportNumber - номер паспорта клиента
     * @param dateOfBirthDay - дата рождения клиента клиента
     */
    public Client (long id,
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
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    /**
     * Функция получения возраста клиента
     * @return возвращает возраст клиента
     */
    public Years getAge(){
        LocalDate now = new LocalDate();
        return Years.yearsBetween(getDateOfBirthDay(), now);
    }

    /**
     * Функция получения значения поля {@link Client#id}
     * @return возвращает код клиента
     */
    public long getId() {
        return id;
    }

    /**
     * Функция определения кода клиента {@link Client#id}
     * @param id - код клиента
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link Client#name}
     * @return возвращает имя клиента
     */
    public String getName() {
        return name;
    }

    /**
     * Функция определения имени клиента {@link Client#name}
     * @param name - имя клиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Client#surname}
     * @return возвращает фамилию клиента
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Функция определения фамилии клиента {@link Client#surname}
     * @param surname - фамилия клиента
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Функция получения значения поля {@link Client#patronymic}
     * @return возвращает отчество клиента
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Функция определения отчества клиента {@link Client#patronymic}
     * @param patronymic - отчесвто клиента
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Функция получения значения поля {@link Client#gender}
     * @return возвращает пол клиента
     */
    public String getGender() {
        return gender;
    }

    /**
     * Функция определения пола клиента {@link Client#gender}
     * @param gender - пол клиента
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Функция получения значения поля {@link Client#phoneNumber}
     * @return возвращает номер телефона клиента
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Функция определения номера телефона клиента {@link Client#phoneNumber}
     * @param phoneNumber - номер телефона клиента
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Функция получения значения поля {@link Client#passportSeries}
     * @return возвращает серию паспорта клиента
     */
    public int getPassportSeries() {
        return passportSeries;
    }

    /**
     * Функция определения серии паспорта клиента {@link Client#passportSeries}
     * @param passportSeries - серия паспорта клиента
     */
    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    /**
     * Функция получения значения поля {@link Client#passportNumber}
     * @return возвращает номер паспорта клиента
     */
    public int getPassportNumber() {
        return passportNumber;
    }

    /**
     * Функция определения номера паспорта клиента {@link Client#passportNumber}
     * @param passportNumber - номер паспорта клиента
     */
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Функция получения значения поля {@link Client#dateOfBirthDay}
     * @return возвращает дату рождения клиента
     */
    public LocalDate getDateOfBirthDay() {
        return dateOfBirthDay;
    }

    /**
     * Функция определения даты рождения клиента {@link Client#dateOfBirthDay}
     * @param dateOfBirthDay - дата рождения клиента
     */
    public void setDateOfBirthDay(LocalDate dateOfBirthDay) {
        this.dateOfBirthDay = dateOfBirthDay;
    }

    /**
     * Функция сравния объектов на равенство
     * @param o - объект с которым происходит сравние
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                phoneNumber == client.phoneNumber &&
                passportSeries == client.passportSeries &&
                passportNumber == client.passportNumber &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(patronymic, client.patronymic) &&
                Objects.equals(gender, client.gender) &&
                Objects.equals(dateOfBirthDay, client.dateOfBirthDay);
    }

    /**
     * Функция для расчета хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(id,
                name,
                surname,
                patronymic,
                gender,
                phoneNumber,
                passportSeries,
                passportNumber,
                dateOfBirthDay);
    }

    @Override
    public int compareTo(Client o) {
        if(this.getId() > o.getId()){
            return 1;
        }else if(this.getId() < o.getId()){
            return -1;
        }else {
            return 0;
        }
    }

    /**
     * Функция для приведения объекта к строке
     */
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
