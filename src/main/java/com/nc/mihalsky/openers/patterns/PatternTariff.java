package com.nc.mihalsky.openers.patterns;

public class PatternTariff implements TitlePattern{
  public static int indexTariff;
  public static final String internetTariffPattern = "internet";
  public static final String mobileTariffPattern = "mobile";
  public static final String tvTariffPattern = "tv";
  public static final String tariffTitle = "tariff";

  @Override
  public String getTitle() {
    return tariffTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexTariff;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexTariff = i;
  }
}
