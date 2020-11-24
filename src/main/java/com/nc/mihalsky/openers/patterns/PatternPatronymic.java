package com.nc.mihalsky.openers.patterns;

public class PatternPatronymic implements TitlePattern{
  public static int indexPatronymic;
  public static final String patronymicPattern = "[a-zA-Z]+";
  public static final String patronymicTitle = "patronymic";

  @Override
  public String getTitle() {
    return patronymicTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexPatronymic;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexPatronymic = i;
  }
}
