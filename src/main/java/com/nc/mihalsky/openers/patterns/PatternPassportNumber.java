package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternPassportNumber
 * @author Roman Mihalsky
 */
public class PatternPassportNumber implements TitlePattern{
  /**Поле позиция поля номер паспорта в csv*/
  public static int indexPassportNumber;
  /**Поле шаблон проверки номера паспорта*/
  public static final String passportNumberPattern = "^\\d{6}$";
  /**Поле название поля в csv*/
  public static final String passportNumberTitle = "passportNumber";

  /**
   * Функция получения значения номера паспорта {@link PatternPassportNumber#passportNumberTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return passportNumberTitle;
  }

  /**
   * Функция получения значения поля {@link PatternPassportNumber#indexPassportNumber}
   * @return возвращает позицию поля номер паспорта в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexPassportNumber;
  }

  /**
   * Функция определения позиции поля номер паспорта в csv {@link PatternPassportNumber#indexPassportNumber}
   * @param i - indexPassportNumber
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexPassportNumber = i;
  }
}
