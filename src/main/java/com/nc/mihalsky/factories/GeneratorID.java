package com.nc.mihalsky.factories;

import com.nc.mihalsky.simple.SimpleArray;

public class GeneratorID implements Generator{
  private SimpleArray<Integer> simpleArray;
  private int code = 0;

  public GeneratorID(){
    simpleArray = new SimpleArray<>();
  }

  @Override
  public int generate() {
    code ++;
    simpleArray.add(code);
    return code;
  }
}
