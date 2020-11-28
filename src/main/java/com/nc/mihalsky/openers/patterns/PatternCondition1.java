package com.nc.mihalsky.openers.patterns;

import com.nc.mihalsky.entities.persons.Client;

/**
 *Класс PatternCondition1
 * @author Roman Mihalsky
 */
public class PatternCondition1 implements TitlePattern{
  /**Поле позиция поля условие 1 в csv*/
  private int indexCondition1;
  /**Поле шаблон проверки условия 1*/
  public static final String conditionPattern = "^\\d+$";
  /**Поле название поля в csv*/
  public static final String condition1Title = "condition1";

  /**
   * Функция получения значения поля {@link PatternCondition1#condition1Title}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return condition1Title;
  }

  /**
   * Функция получения значения поля {@link PatternCondition1#indexCondition1}
   * @return возвращает позицию поля условия 1 в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexCondition1;
  }

  /**
   * Функция определения позиции поля условия 1 в csv {@link PatternCondition1#indexCondition1}
   * @param i - indexCondition1
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexCondition1 = i;
  }
}
