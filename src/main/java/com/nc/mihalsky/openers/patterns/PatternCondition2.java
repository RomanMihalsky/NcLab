package com.nc.mihalsky.openers.patterns;

public class PatternCondition2 implements TitlePattern{
  public static int indexCondition2;
  public static final String conditionPattern = "^\\d+$";
  public static final String condition2Title = "condition2";

  @Override
  public String getTitle() {
    return condition2Title;
  }

  @Override
  public int getIndexOfTitle() {
    return indexCondition2;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexCondition2 = i;
  }
}
