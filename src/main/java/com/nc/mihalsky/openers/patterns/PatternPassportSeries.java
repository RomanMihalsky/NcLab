package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternPassportSeries
 * @author Roman Mihalsky
 */
public class PatternPassportSeries implements TitlePattern{
  /**Поле позиция поля серия паспорта в csv*/
  public static int indexPassportSeries;
  /**Поле шаблон проверки серии паспорта*/
  public static final String passportSeriesPattern = "^\\d{4}$";
  /**Поле название поля в csv*/
  public static final String passportSeriesTitle = "passportSeries";

  /**
   * Функция получения значения серии паспорта {@link PatternPassportSeries#passportSeriesTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return passportSeriesTitle;
  }

  /**
   * Функция получения значения поля {@link PatternPassportSeries#indexPassportSeries}
   * @return возвращает позицию поля серия паспорта в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexPassportSeries;
  }

  /**
   * Функция определения позиции поля номер паспорта в csv {@link PatternPassportSeries#indexPassportSeries}
   * @param i - indexPassportSeries
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexPassportSeries = i;
  }
}
