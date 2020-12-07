package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternDateEndOfUse
 * @author Roman Mihalsky
 */
public class PatternDateOfBirthDay implements TitlePattern{
  /**Поле позиция поля дата рождения в csv*/
  public static int indexDateOfBirthDay;
  /**Поле шаблон проверки даты рождения*/
  public static final String dateOfBirthDayPattern = "^\\d{2,4}\\-\\d{2}\\-\\d{2}$";
  /**Поле название поля в csv*/
  public static final String dateOfBirthDayTitle = "dateOfBirthDay";

  /**
   * Функция получения значения поля {@link PatternDateOfBirthDay#dateOfBirthDayTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return dateOfBirthDayTitle;
  }

  /**
   * Функция получения значения поля {@link PatternDateOfBirthDay#indexDateOfBirthDay}
   * @return возвращает позицию поля дата рождения в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexDateOfBirthDay;
  }

  /**
   * Функция определения позиции поля даты рождения в csv {@link PatternDateOfBirthDay#indexDateOfBirthDay}
   * @param i - indexDateOfBirthDay
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateOfBirthDay = i;
  }
}
