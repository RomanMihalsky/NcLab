package com.nc.mihalsky.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

  ArrayIterator<String> arrayIterator;

  @BeforeEach
  void init (){
    String [] array = {"1","2","3"};
    arrayIterator = new ArrayIterator<>(array);
  }

  @Test
  void hasNext() {
    assertTrue(arrayIterator.hasNext(),"Fields didn't match");
  }

  @Test
  void next() {
    assertEquals("1",arrayIterator.next(),"Fields didn't match");
  }
}