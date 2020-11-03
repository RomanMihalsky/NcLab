package com.nc.mihalsky.entities.contracts.enums;

/**
 * Перечисление TvTariff со значениями <b>SMALL(10)</b>,<b>MEDIUM(20)</b>,
 * <b>BIG(30)</b> и свойством b>channelsAmount</b>.
 * @author Roman Mihalsky
 */
public enum TvTariff {
  /**Перечисление названия тарифов со значением кол-ва каналов*/
  SMALL(10),MEDIUM(20),BIG(30);

  /**Поле кол-во каналов*/
  private int channelsAmount;

  /**Приватный конструктор для создания тарифов на телевидение
   * @param channelsAmount - кол-во каналов
   */
  private  TvTariff(int channelsAmount){
    this.channelsAmount = channelsAmount;
  }

  /**
   * Функция получения значения поля {@link TvTariff#channelsAmount}
   * @return возвращает кол-во каналов
   */
  public int getChannelsAmount() {
    return channelsAmount;
  }

  /**
   * Функция для приведения объекта к строке
   */
  @Override
  public String toString() {
    return "TvTariff{" +
            "channelsAmount=" + channelsAmount +
            '}';
  }
}
