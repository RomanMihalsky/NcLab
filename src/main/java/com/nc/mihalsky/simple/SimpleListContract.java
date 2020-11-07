package com.nc.mihalsky.simple;

import java.util.Optional;

/**
 *interface SimpleListContract для реализации списков
 *Использует index типа long
 *@author Roman Mihalsky
 */
public interface SimpleListContract<E> extends Iterable<E> {
  /**Функция для добавления элемента
   * @param e - элемент
   */
  boolean add(E e);

  /**Функция для удаления элемента по индексу
   * @param index - индекс элемента
   * @return true если удаление прошло успешно
   * @return false если удаление прошло неуспешно
   */
  boolean delete(long index);

  /**Функция для получения элемента по индексу
   * @param index - индекс элемента
   * @return Optional E если объект под таким индексом существует
   * @return Optional.empty если объект под таким индексом не существует
   */
  Optional<E> get(long index);

  /**Функция для замены элемента по индексу
   * @param e - элемент
   * @param index - индекс элемента
   * @return true если замена прошла успешно
   * @return false если замена прошла неуспешно
   */
   boolean set(long index,E e);

  /**Функция для получения размера списка
   * @return int
   */
  int size();
}
