package com.nc.mihalsky.openers.patterns;

public class PatternPassportNumber implements TitlePattern{
  public static int indexPassportNumber;
  public static final String passportNumberPattern = "^\\d{6}$";
  public static final String passportNumberTitle = "passportNumber";

  @Override
  public String getTitle() {
    return passportNumberTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexPassportNumber;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexPassportNumber = i;
  }
}
