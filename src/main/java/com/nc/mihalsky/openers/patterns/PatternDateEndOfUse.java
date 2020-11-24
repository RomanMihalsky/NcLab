package com.nc.mihalsky.openers.patterns;

public class PatternDateEndOfUse implements TitlePattern{
  public static int indexDateEndOfUse;
  public static final String dateEndOfUsePattern = "^\\d{2}\\.\\d{2}\\.\\d{2,4}$";
  public static final String dateEndOfUseTitle = "dateEndOfUse";

  @Override
  public String getTitle() {
    return dateEndOfUseTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexDateEndOfUse;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexDateEndOfUse = i;
  }
}
