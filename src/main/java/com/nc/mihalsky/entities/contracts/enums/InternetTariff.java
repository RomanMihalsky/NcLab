package com.nc.mihalsky.entities.contracts.enums;

/**
 * Перечисление InternetTariff со значениями <b>MEGAS(75)</b>,<b>MEGAM(100)</b>,
 * <b>MEGAL(250)</b>,<b>MEGAXL(500)</b> и свойством b>internetSpeed</b>.
 * @author Roman Mihalsky
 */
public enum InternetTariff {
  /**Перечисление названия тарифов со значением скорости интернета*/
  MEGAS(75),MEGAM(100),MEGAL(250),MEGAXL(500);

  /**Поле скорость интернета*/
  private int internetSpeed;

  /**Приватный конструктор для создания тарифов на интернет
   * @param internetSpeed - скорость интернета
   */
  private InternetTariff(int internetSpeed){
    this.internetSpeed = internetSpeed;
  }

  /**
   * Функция получения значения поля {@link InternetTariff#internetSpeed}
   * @return возвращает скорость интернета
   */
  public int getInternetSpeed() {
    return internetSpeed;
  }

  /**
   * Функция для приведения объекта к строке
   */
  @Override
  public String toString() {
    return "InternetTariff{" +
            "internetSpeed=" + internetSpeed +
            '}';
  }
}
