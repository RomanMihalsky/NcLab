package com.nc.mihalsky.factories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorIDTest {
  GeneratorID generatorID;

  @BeforeEach
  void init (){
    generatorID = new GeneratorID();
  }

  @Test
  void generate() throws NoSuchFieldException, IllegalAccessException {
    Field field = generatorID.getClass().getDeclaredField("code");
    field.setAccessible(true);
    field.set(generatorID,2);

    assertEquals(3,generatorID.generate(),"Fields didn't match");
  }
}