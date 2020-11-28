package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternGender
 * @author Roman Mihalsky
 */
public class PatternGender implements TitlePattern{
  /**Поле позиция поля пол в csv*/
  public static int indexGender;
  /**Поле шаблон проверки пола*/
  public static final String genderPattern = "man|woman|male|female";
  /**Поле название поля в csv*/
  public static final String genderTitle = "gender";

  /**
   * Функция получения значения поля {@link PatternGender#genderTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return genderTitle;
  }

  /**
   * Функция получения значения поля {@link PatternGender#indexGender}
   * @return возвращает позицию поля пол в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexGender;
  }

  /**
   * Функция определения позиции поля пол в csv {@link PatternGender#indexGender}
   * @param i - indexGender
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexGender = i;
  }
}
