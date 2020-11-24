package com.nc.mihalsky.openers.patterns;

public class PatternGender implements TitlePattern{
  public static int indexGender;
  public static final String genderPattern = "man|woman|male|female";
  public static final String genderTitle = "gender";

  @Override
  public String getTitle() {
    return genderTitle;
  }

  @Override
  public int getIndexOfTitle() {
    return indexGender;
  }

  @Override
  public void setIndexOfTitle(int i) {
    this.indexGender = i;
  }
}
