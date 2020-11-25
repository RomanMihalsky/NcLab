package com.nc.mihalsky.simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

/**
 *Класс SimpleArray позволяет хранить в себе различные объекты.
 *Имеет параметры: <b>values</b>,<b>size</b>
 *@author Roman Mihalsky
 */
public class SimpleArray<E> implements SimpleList<E> {
  /**Поле список элементов*/
  private Object[] values;
  /**Поле размер списка {@link SimpleArray#values}*/
  private int size;

  /**Конструктор для создания нового объекта SimpleArray
   *Полю {@link SimpleArray#values} присваивает новый массив
   *типа <tt>Object</tt> размером 1
   */
  public SimpleArray(){
    this.values = new Object [1];
  }

  /**Функция для добавления элемента
   * @param e - элемент
   * @return true если добавление прошло успешно
   * @return false если добавление прошло неуспешно
   */
  @Override
  public boolean add(E e) {
    checkSize();
    values[size] = e;
    size++;
    return true;
  }

  /**Функция проверяет размер списка {@link SimpleArray#values}
   * на возможность добавить новый элемент
   */
  private void checkSize() {
    if(size == values.length){
      changeSize();
    }
  }

  /**Функция увеличевает размер списка {@link SimpleArray#values}
   * на один элемент
   */
  private void changeSize() {
    values = Arrays.copyOf(values,size+1);
  }

  /**Функция удаляет элемент из списка {@link SimpleArray#values}
   * по индексу
   * @param index - индекс элемента
   * @return true если удаление прошло успешно
   * @return false если удаление прошло неуспешно
   */
  @Override
  public boolean delete(int index) {
    if((index<0) || (index>size)){
      return false;
    }

    values[index] = null;
    values = Arrays.stream(values).filter(a -> a!=null).toArray();
    return true;
  }

  /**Функция для получения элемента по индексу из писка {@link SimpleArray#values}
   * @param index - индекс элемента
   * @return Optional E если объект под таким индексом существует
   * @return Optional.empty если объект под таким индексом не существует
   */
  @Override
  public Optional<E> get(int index) {
    if((index<0) || (index>size)){
      return Optional.empty();
    }
    return Optional.of((E)values[index]);
  }

  /**Функция заменяет элемент под @param index из писка {@link SimpleArray#values}
   * на элемент @param e
   * @param e - элемент
   * @param index - индекс элемента
   * @return true если замена прошла успешно
   * @return false если замена прошла неуспешно
   */
  @Override
  public boolean set(int index, E e) {
    if((index<0) || (index>size)){
      return false;
    }
    values[index] = e;
    return true;
  }

  /**Функция размер списка {@link SimpleArray#values}
   * @return int
   */
  @Override
  public int size() {
    return size;
  }

  /**Функция создает новый ArrayIterator с аргументом {@link SimpleArray#values}*/
  @Override
  public Iterator<E> iterator() {
    return new ArrayIterator<>(values);
  }

  /**
   * Функция для приведения списка {@link SimpleArray#values} к строке
   */
  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}
