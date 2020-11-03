package com.nc.mihalsky.entities.contracts.enums;

/**
 * Перечисление MobileTariff со значениями <b>CHEAP(4,15)</b>,<b>MEDIUM(20,100)</b>,
 * <b>EXPENSIVE(40,200)</b> и свойствами <b>gigabytes</b> и <b>smsAmount</b>.
 * @author Roman Mihalsky
 */
public enum MobileTariff {
    /**Перечисление названия тарифов со значениями кол-ва гигабайтов и кол-ва sms*/
    CHEAP(4,15),MEDIUM(20,100),EXPENSIVE(40,200);

    /**Поле кол-во гигабайт*/
    private int gigabytes;
    /**Поле кол-во sms*/
    private int smsAmount;

    /**Приватный конструктор для создания тарифов на мобильную связь
     * @param gigabytes - кол-во гигабайт
     * @param smsAmount - кол-во sms
     */
    private MobileTariff(int gigabytes,int smsAmount){
        this.gigabytes = gigabytes;
        this.smsAmount = smsAmount;
    }

    /**
     * Функция получения значения поля {@link MobileTariff#gigabytes}
     * @return возвращает кол-во гигабайт
     */
    public int getGigabytes() {
        return gigabytes;
    }

    /**
     * Функция получения значения поля {@link MobileTariff#smsAmount}
     * @return возвращает кол-во sms
     */
    public int getSmsAmount() {
        return smsAmount;
    }

    /**
     * Функция для приведения объекта к строке
     */
    @Override
    public String toString() {
        return "MobileTariff{" +
                "gigabytes=" + gigabytes +
                ", smsAmount=" + smsAmount +
                '}';
    }
}
