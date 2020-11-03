package com.nc.mihalsky.factories;

import com.nc.mihalsky.simple.SimpleArray;
/**
 *Класс FactoryContract со свойствами <b>simpleArray</b>,<b>code</b>
 * @author Roman Mihalsky
 */
public class GeneratorID implements Generator{
  /**Список для хранение сгенерированных значений*/
  private SimpleArray<Integer> simpleArray;
  /**Поле с текущем кодом*/
  private int code = 0;

  /**Конструктор для создания нового объекта GeneratorID*/
  public GeneratorID(){
    simpleArray = new SimpleArray<>();
  }

  /**Функция генерирует новый код и возвращает его
   * @return code - код
   */
  @Override
  public int generate() {
    code ++;
    simpleArray.add(code);
    return code;
  }
}
