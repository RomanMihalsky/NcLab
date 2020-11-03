package com.nc.mihalsky.simple;

import java.util.Optional;
/**
 *interface SimpleList для реализации списков
 *@author Roman Mihalsky
 */
public interface SimpleList<E> extends Iterable<E>{
  /**Функция для добавления элемента
   * @param e - элемент
   */
  boolean add(E e);

  /**Функция для удаления элемента по индексу
   * @param index - индекс элемента
   * @return Optional true если удаление прошло успешно
   * @return Optional.empty если удаление прошло неуспешно
   */
  Optional<Boolean> delete(int index);

  /**Функция для получения элемента по индексу
   * @param index - индекс элемента
   * @return Optional E если объект под таким индексом существует
   * @return Optional.empty если объект под таким индексом не существует
   */
  Optional<E> get(int index);

  /**Функция для замены элемента по индексу
   * @param e - элемент
   * @param index - индекс элемента
   * @return Optional true если замена прошла успешно
   * @return Optional.empty Optional true если удаление прошло неуспешно
   */
  Optional<Boolean> set(int index,E e);

  /**Функция для получения размера списка
   * @return int
   */
  int size();
}
