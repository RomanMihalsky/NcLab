package com.nc.mihalsky.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayTest {
  SimpleArray<Integer> simpleArray;

  @BeforeEach
  void init(){
    simpleArray = new SimpleArray<>();
  }

  @Test
  void add() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
    simpleArray.add(10);

    Class<SimpleArray> simpleArrayClass = SimpleArray.class;
    SimpleArray <Integer> simpleArrayTest = simpleArrayClass.newInstance();
    Field field = simpleArrayTest.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {10};
    field.set(simpleArrayTest,result);
    assertEquals(simpleArrayTest.toString(),simpleArray.toString(),"Fields didn't match");
  }

  @Test
  void checkSize() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method method = simpleArray.getClass().getDeclaredMethod("checkSize");
    method.setAccessible(true);
    assertEquals(null,method.invoke(simpleArray),"Fields didn't match");
  }

  @Test
  void changeSize() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Field field = simpleArray.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {1,2,3};
    field.set(simpleArray,result);

    Field fieldSize = simpleArray.getClass().getDeclaredField("size");
    fieldSize.setAccessible(true);
    int size = 3;
    fieldSize.set(simpleArray,size);

    Method method = simpleArray.getClass().getDeclaredMethod("changeSize");
    method.setAccessible(true);
    method.invoke(simpleArray);

    assertEquals("[1, 2, 3, null]",simpleArray.toString(),"Fields didn't match");
  }

  @Test
  void delete() throws NoSuchFieldException, IllegalAccessException {
    Field field = simpleArray.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {1,2,3};
    field.set(simpleArray,result);

    Field fieldSize = simpleArray.getClass().getDeclaredField("size");
    fieldSize.setAccessible(true);
    int size = 3;
    fieldSize.set(simpleArray,size);

    simpleArray.delete(1);
    assertEquals("[1, 3]",simpleArray.toString(),"Fields didn't match");
  }

  @Test
  void get() throws NoSuchFieldException, IllegalAccessException {
    Field field = simpleArray.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {1,2,3};
    field.set(simpleArray,result);

    Field fieldSize = simpleArray.getClass().getDeclaredField("size");
    fieldSize.setAccessible(true);
    int size = 3;
    fieldSize.set(simpleArray,size);

    assertEquals(3,simpleArray.get(2).get(),"Fields didn't match");
  }

  @Test
  void set() throws NoSuchFieldException, IllegalAccessException {
    Field field = simpleArray.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {1,2,3};
    field.set(simpleArray,result);

    Field fieldSize = simpleArray.getClass().getDeclaredField("size");
    fieldSize.setAccessible(true);
    int size = 3;
    fieldSize.set(simpleArray,size);

    simpleArray.set(1,10);

    assertEquals("[1, 10, 3]",simpleArray.toString(),"Fields didn't match");
  }

  @Test
  void size() throws NoSuchFieldException, IllegalAccessException {
    Field field = simpleArray.getClass().getDeclaredField("size");
    field.setAccessible(true);
    field.set(simpleArray,3);
    Object result = field.get(simpleArray);
    field.set(simpleArray,result);

    assertEquals(3,simpleArray.size(),"Fields didn't match");
  }

  @Test
  void iterator() {
    Iterator iterator = simpleArray.iterator();
    assertEquals(true,(ArrayIterator)iterator instanceof ArrayIterator ,"Fields didn't match");
  }

  @Test
  void testToString() throws NoSuchFieldException, IllegalAccessException {
    Field field = simpleArray.getClass().getDeclaredField("values");
    field.setAccessible(true);
    Integer [] result = {1,2,3};
    field.set(simpleArray,result);
    assertEquals("[1, 2, 3]",simpleArray.toString(),"Fields didn't match");
  }
}