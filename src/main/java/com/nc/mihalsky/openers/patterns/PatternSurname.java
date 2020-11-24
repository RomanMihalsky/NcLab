package com.nc.mihalsky.openers.patterns;

public class PatternSurname implements TitlePattern{
  public static int indexSurname;
  public static final String surnamePattern = "[a-zA-Z]+";
  public static final String surnameTitle = "surname";

  @Override
  public String getTitle() {
    return surnameTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexSurname;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexSurname = i;
  }
}
