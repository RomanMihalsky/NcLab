package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternCondition2
 * @author Roman Mihalsky
 */
public class PatternCondition2 implements TitlePattern{
  /**Поле позиция поля условие 2 в csv*/
  public static int indexCondition2;
  /**Поле шаблон проверки условия 2*/
  public static final String conditionPattern = "^\\d+$";
  /**Поле название поля в csv*/
  public static final String condition2Title = "condition2";

  /**
   * Функция получения значения поля {@link PatternCondition2#condition2Title}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return condition2Title;
  }

  /**
   * Функция получения значения поля {@link PatternCondition2#indexCondition2}
   * @return возвращает позицию поля условия 2 в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexCondition2;
  }

  /**
   * Функция определения позиции поля условия 2 в csv {@link PatternCondition2#indexCondition2}
   * @param i - indexCondition2
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexCondition2 = i;
  }
}
