package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternSurname
 * @author Roman Mihalsky
 */
public class PatternSurname implements TitlePattern{
  /**Поле позиция поля фамилия в csv*/
  public static int indexSurname;
  /**Поле шаблон проверки фамилии*/
  public static final String surnamePattern = "[a-zA-Z]+";
  /**Поле название поля в csv*/
  public static final String surnameTitle = "surname";

  /**
   * Функция получения значения фамилии {@link PatternSurname#surnameTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return surnameTitle;
  }

  /**
   * Функция получения значения поля {@link PatternSurname#indexSurname}
   * @return возвращает позицию поля фамилия в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexSurname;
  }

  /**
   * Функция определения позиции поля фамилия в csv {@link PatternSurname#indexSurname}
   * @param i - indexSurname
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexSurname = i;
  }
}
