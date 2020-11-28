package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternPhoneNumber
 * @author Roman Mihalsky
 */
public class PatternPhoneNumber implements TitlePattern{
  /**Поле позиция поля номер телефона в csv*/
  public static int indexPhoneNumber;
  /**Поле шаблон проверки номера телефона*/
  public static final String phoneNumberPattern = "^\\d{11}$";
  /**Поле название поля в csv*/
  public static final String phoneNumberTitle = "phoneNumber";

  /**
   * Функция получения значения номера телефона {@link PatternPhoneNumber#phoneNumberTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return phoneNumberTitle;
  }

  /**
   * Функция получения значения поля {@link PatternPhoneNumber#indexPhoneNumber}
   * @return возвращает позицию поля номер телефона в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexPhoneNumber;
  }

  /**
   * Функция определения позиции поля номер телефона в csv {@link PatternPhoneNumber#indexPhoneNumber}
   * @param i - indexPhoneNumber
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexPhoneNumber = i;
  }
}
