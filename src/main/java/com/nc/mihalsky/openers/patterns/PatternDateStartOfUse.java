package com.nc.mihalsky.openers.patterns;

public class PatternDateStartOfUse implements TitlePattern{
  public static int indexDateStartOfUse;
  public static final String dateStartOfUsePattern = "^\\d{2}\\.\\d{2}\\.\\d{2,4}$";
  public static final String dateStartOfUseTitle = "dateStartOfUse";

  @Override
  public String getTitle() {
    return dateStartOfUseTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexDateStartOfUse;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateStartOfUse = i;
  }
}
