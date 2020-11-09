package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Класс TvContract со свойствами <b>id</b>,<b>dateStartOfUse</b>,
 * <b>dateEndOfUse</b>,<b>client</b>,<b>tariff</b>
 * Является наследником абстрактого класса <tt>Contract</tt>.
 * Реализует метод {@link TvContract#toString()}.
 * @author Roman Mihalsky
 */
public class TvContract extends Contract{
  /**Поле тариф на телевидение*/
  private TvTariff tariff;

  /**Конструктор для создания контракта на телевидение с default значениями*/
  public TvContract (){
    this.dateStartOfUse = new LocalDate(1900,1,1);
    this.dateEndOfUse = new LocalDate(1900,1,1);
    this.client = FactoryClient.createClient();
    this.tariff = TvTariff.SMALL;
  }

  /**Конструкто для создания контракта на телевидение с параметрами.
   *Все null аргументы заменяются на default значения
   * @param id - код контракта
   * @param dateStartOfUse - дата создания контракта
   * @param dateEndOfUse - дата заершения контракта
   * @param client - клиент
   * @param tariff - тариф на телевидение
   */
  public TvContract (
          long id,
          LocalDate dateStartOfUse,
          LocalDate dateEndOfUse,
          Client client,
          TvTariff tariff){
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
      this.tariff = TvTariff.SMALL;
    }
  }

  /**
   * Функция получения значения поля {@link TvContract#tariff}
   * @return возвращает тариф
   */
  public TvTariff getTariff() {
    return tariff;
  }

  /**
   * Функция определения тарифа {@link TvContract#tariff}
   * @param tariff - тариф
   */
  public void setTariff(TvTariff tariff) {
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
    TvContract that = (TvContract) o;
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
    return "TvContract{" +
            "tariff=" + tariff +
            ", id=" + id +
            ", dateStartOfUse=" + dateStartOfUse +
            ", dateEndOfUse=" + dateEndOfUse +
            ", client=" + client.getId() +
            '}';
  }
}
