package com.nc.mihalsky.entities.contracts;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Класс InternetContract со свойствами <b>id</b>,<b>dateStartOfUse</b>,
 * <b>dateEndOfUse</b>,<b>client</b>,<b>tariff</b>
 * Является наследником абстрактого класса <tt>Contract</tt>.
 * Реализует метод {@link InternetContract#toString()}.
 * @author Roman Mihalsky
 */
public class InternetContract extends Contract{
  /**Поле тариф на интренет*/
  private InternetTariff tariff;

  /**Конструктор для создания контракта на интернет с default значениями*/
  public InternetContract (){
    this.dateStartOfUse = new LocalDate(1900,1,1);
    this.dateEndOfUse = new LocalDate(1900,1,1);
    this.client = FactoryClient.createClient();
    this.tariff = InternetTariff.MEGAS;
  }

  /**Конструкто для создания контракта на интернет с параметрами.
   *Все null аргументы заменяются на default значения
   * @param id - код контракта
   * @param dateStartOfUse - дата создания контракта
   * @param dateEndOfUse - дата заершения контракта
   * @param client - клиент
   * @param tariff - тариф на интернет
   */
  public InternetContract(
          long id,
          LocalDate dateStartOfUse,
          LocalDate dateEndOfUse,
          Client client,
          InternetTariff tariff){
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
      this.tariff = InternetTariff.MEGAS;
    }
  }

  /**
   * Функция получения значения поля {@link InternetContract#tariff}
   * @return возвращает тариф
   */
  public InternetTariff getTariff() {
    return tariff;
  }

  /**
   * Функция определения тарифа {@link InternetContract#tariff}
   * @param tariff - тариф
   */
  public void setTariff(InternetTariff tariff) {
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
    InternetContract that = (InternetContract) o;
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
    return "InternetContract{" +
            "tariff=" + tariff +
            ", id=" + id +
            ", dateStartOfUse=" + dateStartOfUse +
            ", dateEndOfUse=" + dateEndOfUse +
            ", client=" + client.getId() +
            '}';
  }
}
