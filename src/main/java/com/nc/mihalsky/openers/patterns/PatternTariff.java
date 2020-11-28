package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternTariff
 * @author Roman Mihalsky
 */
public class PatternTariff implements TitlePattern{
  /**Поле позиция поля тариф в csv*/
  public static int indexTariff;
  /**Поле шаблон проверки тарифа интернет*/
  public static final String internetTariffPattern = "internet";
  /**Поле шаблон проверки тарифа мобильная связь*/
  public static final String mobileTariffPattern = "mobile";
  /**Поле шаблон проверки телевидения*/
  public static final String tvTariffPattern = "tv";
  /**Поле название поля в csv*/
  public static final String tariffTitle = "tariff";

  /**
   * Функция получения значения тарифа {@link PatternTariff#tariffTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return tariffTitle;
  }

  /**
   * Функция получения значения поля {@link PatternTariff#indexTariff}
   * @return возвращает позицию поля тариф в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexTariff;
  }

  /**
   * Функция определения позиции поля тариф в csv {@link PatternTariff#indexTariff}
   * @param i - indexTariff
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexTariff = i;
  }
}
