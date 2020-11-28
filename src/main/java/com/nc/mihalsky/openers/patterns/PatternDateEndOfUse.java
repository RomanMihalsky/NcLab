package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternDateEndOfUse
 * @author Roman Mihalsky
 */
public class PatternDateEndOfUse implements TitlePattern{
  /**Поле позиция поля дата завершения контракта в csv*/
  public static int indexDateEndOfUse;
  /**Поле шаблон проверки даты завершения контракта*/
  public static final String dateEndOfUsePattern = "^\\d{2}\\.\\d{2}\\.\\d{2,4}$";
  /**Поле название поля в csv*/
  public static final String dateEndOfUseTitle = "dateEndOfUse";

  /**
   * Функция получения значения поля {@link PatternDateEndOfUse#dateEndOfUseTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return dateEndOfUseTitle;
  }

  /**
   * Функция получения значения поля {@link PatternDateEndOfUse#indexDateEndOfUse}
   * @return возвращает позицию поля дата завершения контракта в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexDateEndOfUse;
  }

  /**
   * Функция определения позиции поля дата завершения контракта в csv {@link PatternDateEndOfUse#indexDateEndOfUse}
   * @param i - indexDateEndOfUse
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateEndOfUse = i;
  }
}
