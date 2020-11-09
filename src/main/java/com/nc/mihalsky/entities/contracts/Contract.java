package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Абстрактный класс Контракт со свойствами <b>id</b>,<b>dateStartOfUse</b>,
 * <b>dateEndOfUse</b>,<b>client</b>.
 * Классы наследуемые от Contact имеют доступ к полям <b>id</b>,<b>dateStartOfUse</b>,
 * <b>dateEndOfUse</b>,<b>client</b> и методам <tt>get</tt>,<tt>set</tt>.
 * Классы наследуемые от Contact должны реализововать метод {@link Contract#toString()}
 * @author Roman Mihalsky
 */
public abstract class Contract implements Comparable<Contract>{
    /**Поле код контракта*/
    protected long id;
    /**Поле дата создания контракта*/
    protected LocalDate dateStartOfUse;
    /**Поле дата завершения контракта*/
    protected LocalDate dateEndOfUse;
    /**Поле клиент*/
    protected Client client;

    /**
     * Функция получения значения поля {@link Contract#id}
     * @return возвращает код контракта
     */
    public long getId() {
        return id;
    }

    /**
     * Функция определения кода контракта {@link Contract#id}
     * @param id - код контракта
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link Contract#dateStartOfUse}
     * @return возвращает дату создания контракта
     */
    public LocalDate getDateStartOfUse() {
        return dateStartOfUse;
    }

    /**
     * Функция определения даты создания контракта {@link Contract#dateStartOfUse}
     * @param dateStartOfUse - дата создания контракта
     */
    public void setDateStartOfUse(LocalDate dateStartOfUse) {
        this.dateStartOfUse = dateStartOfUse;
    }

    /**
     * Функция получения значения поля {@link Contract#dateEndOfUse}
     * @return возвращает дату завершения контракта
     */
    public LocalDate getDateEndOfUse() {
        return dateEndOfUse;
    }

    /**
     * Функция определения даты завершения контракта{@link Contract#dateEndOfUse}
     * @param dateEndOfUse - дата завершения контракта
     */
    public void setDateEndOfUse(LocalDate dateEndOfUse) {
        this.dateEndOfUse = dateEndOfUse;
    }

    /**
     * Функция получения значения поля {@link Contract#client}
     * @return возвращает клиента
     */
    public Client getClient() {
        return client;
    }

    /**
     * Функция определения клиента{@link Contract#client}
     * @param client - клиент
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Функция для приведения объекта к строке
     * Необходимо реализовать в классах наследниках
     */
    abstract public String toString();

    /**
     * Функция сравния объектов на равенство
     * @param o - объект с которым происходит сравние
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                Objects.equals(dateStartOfUse, contract.dateStartOfUse) &&
                Objects.equals(dateEndOfUse, contract.dateEndOfUse) &&
                Objects.equals(client, contract.client);
    }

    /**
     * Функция для расчета хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, dateStartOfUse, dateEndOfUse, client);
    }
}
