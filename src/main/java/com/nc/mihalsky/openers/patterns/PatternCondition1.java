package com.nc.mihalsky.openers.patterns;

public class PatternCondition1 implements TitlePattern{
  private int indexCondition1;
  public static final String conditionPattern = "^\\d+$";
  public static final String condition1Title = "condition1";

  @Override
  public String getTitle() {
    return condition1Title;
  }

  @Override
  public int getIndexOfTitle() {
    return indexCondition1;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexCondition1 = i;
  }
}
