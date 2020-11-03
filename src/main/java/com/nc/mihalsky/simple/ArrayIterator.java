package com.nc.mihalsky.simple;

import java.util.Iterator;

/**Класс ArrayIterator для прохода по колекции с парметрами <b>index</b>,<b>values</b>*/
public class ArrayIterator<E> implements Iterator<E> {
  /**Поле индекс текущего элемента*/
  private int index = 0;
  /**Поле список элементов*/
  private Object[] values;

  /**Конструктор для создания ArrayIterator
   * @param values - список элементов
   */
  public ArrayIterator(Object[] values){
    this.values = values;
  }

  /**Функция проверяет есть ли ещё объекты в списке {@link ArrayIterator#values}
   * после объекта под индексом {@link ArrayIterator#index}
   */
  @Override
  public boolean hasNext() {
    return index < values.length;
  }

  /**Функция возвращает елемент из списка {@link ArrayIterator#values}
   * следующего после объекта под индексом {@link ArrayIterator#index}
   */
  @Override
  public E next() {
    return (E)values[index ++];
  }
}
