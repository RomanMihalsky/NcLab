package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternDateStartOfUse
 * @author Roman Mihalsky
 */
public class PatternDateStartOfUse implements TitlePattern{
  /**Поле позиция поля дата создания контракта в csv*/
  public static int indexDateStartOfUse;
  /**Поле шаблон проверки даты создания контракта*/
  public static final String dateStartOfUsePattern = "^\\d{2,4}\\-\\d{2}\\-\\d{2}$";
  /**Поле название поля в csv*/
  public static final String dateStartOfUseTitle = "dateStartOfUse";

  /**
   * Функция получения значения поля {@link PatternDateStartOfUse#dateStartOfUseTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return dateStartOfUseTitle;
  }

  /**
   * Функция получения значения поля {@link PatternDateStartOfUse#indexDateStartOfUse}
   * @return возвращает позицию поля дата создания контракта в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexDateStartOfUse;
  }

  /**
   * Функция определения позиции поля дата создания контракта в csv {@link PatternDateStartOfUse#indexDateStartOfUse}
   * @param i - indexDateStartOfUse
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateStartOfUse = i;
  }
}
