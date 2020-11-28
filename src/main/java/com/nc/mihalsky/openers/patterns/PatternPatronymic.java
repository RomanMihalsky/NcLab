package com.nc.mihalsky.openers.patterns;

/**
 *Класс PatternPatronymic
 * @author Roman Mihalsky
 */
public class PatternPatronymic implements TitlePattern{
  /**Поле позиция поля отчество в csv*/
  public static int indexPatronymic;
  /**Поле шаблон проверки отчества*/
  public static final String patronymicPattern = "[a-zA-Z]+";
  /**Поле название поля в csv*/
  public static final String patronymicTitle = "patronymic";

  /**
   * Функция получения значения отчества {@link PatternPatronymic#patronymicTitle}
   * @return возвращает название поля в csv*
   */
  @Override
  public String getTitle() {
    return patronymicTitle;
  }

  /**
   * Функция получения значения поля {@link PatternPatronymic#indexPatronymic}
   * @return возвращает позицию поля отчества в csv
   */
  @Override
  public int getIndexOfTitle() {
    return indexPatronymic;
  }

  /**
   * Функция определения позиции поля отчество в csv {@link PatternPatronymic#indexPatronymic}
   * @param i - indexPatronymic
   */
  @Override
  public void setIndexOfTitle(int i) {
    this.indexPatronymic = i;
  }
}
