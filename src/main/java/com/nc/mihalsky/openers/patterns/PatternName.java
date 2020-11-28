package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternName
 * @author Roman Mihalsky
 */
public class PatternName implements TitlePattern{
  /**Поле позиция поля имя в csv*/
  public static int indexName;
  /**Поле шаблон проверки имени*/
  public static final String namePattern = "[a-zA-Z]+";
  /**Поле название поля в csv*/
  public static final String nameTitle = "name";

  /**
   * Функция получения значения имени {@link PatternName#nameTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return nameTitle;
  }

  /**
   * Функция получения значения поля {@link PatternName#indexName}
   * @return возвращает позицию поля имя в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexName;
  }

  /**
   * Функция определения позиции поля имя в csv {@link PatternName#indexName}
   * @param i - indexName
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexName = i;
  }
}
