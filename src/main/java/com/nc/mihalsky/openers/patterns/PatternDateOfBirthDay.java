package com.nc.mihalsky.openers.patterns;

public class PatternDateOfBirthDay implements TitlePattern{
  public static int indexDateOfBirthDay;
  public static final String dateOfBirthDayPattern = "^\\d{2}\\.\\d{2}\\.\\d{2,4}$";
  public static final String dateOfBirthDayTitle = "dateOfBirthDay";

  @Override
  public String getTitle() {
    return dateOfBirthDayTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexDateOfBirthDay;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateOfBirthDay = i;
  }
}
