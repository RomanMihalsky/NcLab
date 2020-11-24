package com.nc.mihalsky.openers.patterns;

public class PatternPhoneNumber implements TitlePattern{
  public static int indexPhoneNumber;
  public static final String phoneNumberPattern = "^\\d{11}$";
  public static final String phoneNumberTitle = "phoneNumber";

  @Override
  public String getTitle() {
    return phoneNumberTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexPhoneNumber;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexPhoneNumber = i;
  }
}
