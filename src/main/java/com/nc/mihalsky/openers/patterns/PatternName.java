package com.nc.mihalsky.openers.patterns;

public class PatternName implements TitlePattern{
  public static int indexName;
  public static final String namePattern = "[a-zA-Z]+";
  public static final String nameTitle = "name";

  @Override
  public String getTitle() {
    return nameTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexName;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexName = i;
  }
}
