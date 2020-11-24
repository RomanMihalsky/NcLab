package com.nc.mihalsky.openers.patterns;

public class PatternPassportSeries implements TitlePattern{
  public static int indexPassportSeries;
  public static final String passportSeriesPattern = "^\\d{4}$";
  public static final String passportSeriesTitle = "passportSeries";

  @Override
  public String getTitle() {
    return passportSeriesTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexPassportSeries;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexPassportSeries = i;
  }
}
