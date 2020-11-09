package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Класс MobileContract со свойствами <b>id</b>,<b>dateStartOfUse</b>,
 * <b>dateEndOfUse</b>,<b>client</b>,<b>tariff</b>
 * Является наследником абстрактого класса <tt>Contract</tt>.
 * Реализует метод {@link MobileContract#toString()}.
 * @author Roman Mihalsky
 */
public class MobileContract extends Contract{
    /**Поле тариф на мобильную связь*/
    private MobileTariff tariff;

    /**Конструктор для создания контракта на интернет с default значениями*/
    public MobileContract (){
        this.dateStartOfUse = new LocalDate(1900,1,1);
        this.dateEndOfUse = new LocalDate(1900,1,1);
        this.client = FactoryClient.createClient();
        this.tariff = MobileTariff.CHEAP;
    }

    /**Конструкто для создания контракта на мобильную связь с параметрами.
     *Все null аргументы заменяются на default значения
     * @param id - код контракта
     * @param dateStartOfUse - дата создания контракта
     * @param dateEndOfUse - дата заершения контракта
     * @param client - клиент
     * @param tariff - тариф на мобильную связь
     */
    public MobileContract(
            long id,
            LocalDate dateStartOfUse,
            LocalDate dateEndOfUse,
            Client client,
            MobileTariff tariff) {
        this.id = id;

        if(dateStartOfUse != null) {
            this.dateStartOfUse = dateStartOfUse;
        }else {
            this.dateStartOfUse = new LocalDate(1900,1,1);
        }
        if(dateEndOfUse != null) {
            this.dateEndOfUse = dateEndOfUse;
        }else {
            this.dateEndOfUse = new LocalDate(1900,1,1);
        }

        if(client != null) {
            this.client = client;
        }else {
            this.client = FactoryClient.createClient();
        }

        if(tariff != null) {
            this.tariff = tariff;
        }else {
            this.tariff = MobileTariff.CHEAP;
        }
    }

    /**
     * Функция получения значения поля {@link MobileContract#tariff}
     * @return возвращает тариф
     */
    public MobileTariff getTariff() {
        return tariff;
    }

    /**
     * Функция определения тарифа {@link MobileContract#tariff}
     * @param tariff - тариф
     */
    public void setTariff(MobileTariff tariff) {
        this.tariff = tariff;
    }

    /**
     * Функция сравния объектов на равенство.
     * @param o - объект с которым происходит сравние.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileContract that = (MobileContract) o;
        return tariff == that.tariff;
    }

    /**
     * Функция для расчета хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tariff);
    }

    @Override
    public int compareTo(Contract o) {
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
        return "MobileContract{" +
                "tariff=" + tariff +
                ", id=" + id +
                ", dateStartOfUse=" + dateStartOfUse +
                ", dateEndOfUse=" + dateEndOfUse +
                ", client=" + client.getId() +
                '}';
    }
}
