package com.nc.mihalsky.simple;

import com.nc.mihalsky.comparators.ByIdContractComparator;
import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.sorters.BubbleSortContract;
import com.nc.mihalsky.sorters.InsertionSortContract;

import java.util.*;
import java.util.function.Predicate;

/**
 *Класс SimpleArrayContract позволяет хранить в себе
 *различные объекты, наследуемые от <tt>Contract</tt>.
 *Имеет параметры: <b>values</b>,<b>size</b>
 *@author Roman Mihalsky
 */
public class SimpleArrayContract<E extends Contract> implements SimpleListContract<E>{
  /**Поле список элементов*/
  private Object[] values;
  /**Поле размер списка {@link SimpleArrayContract#values}*/
  private int size;

  /**Конструктор для создания нового объекта SimpleArrayContract
   *Полю {@link SimpleArrayContract#values} присваивает новый массив
   *типа <tt>Object</tt> размером 1
   */
  public SimpleArrayContract(){
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

  /**Функция проверяет размер списка {@link SimpleArrayContract#values}
   * на возможность добавить новый элемент
   */
  private void checkSize() {
    if(size == values.length){
      changeSize();
    }
  }

  /**Функция увеличевает размер списка {@link SimpleArrayContract#values}
   * на один элемент
   */
  private void changeSize() {
    values = Arrays.copyOf(values,size+1);
  }

  /**Функция удаляет элемент из списка {@link SimpleArrayContract#values}
   * по id элемента
   * @param id - id элемента
   * @return true если удаление прошло успешно
   * @return false если удаление прошло неуспешно
   */
  @Override
  public boolean delete(long id) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        values[i] = null;
        values = Arrays.stream(values).filter(a -> a!=null).toArray();
        return true;
      }
    }
    return false;
  }

  /**Функция для получения элемента по id из писка {@link SimpleArrayContract#values}
   * @param id - id элемента
   * @return Optional E если объект под таким id существует
   * @return Optional.empty если объект под таким id не существует
   */
  @Override
  public Optional<E> get(long id) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        return Optional.of((E)values[i]);
      }
    }
    return Optional.empty();
  }

  /**Функция заменяет элемент под @param id из писка {@link SimpleArrayContract#values}
   * на элемент @param e
   * @param e - элемент
   * @param id - id элемента
   * @return true если замена прошла успешно
   * @return true если замена прошла неуспешно
   */
  @Override
  public boolean set(long id, E e) {
    for (int i = 0;i < values.length;i ++) {
      if (((E)values[i]).getId() == id) {
        values[i] = e;
        return true;
      }
    }
    return false;
  }

  @Override
  public void bubbleSortBy(Comparator comparator) {
    BubbleSortContract<Contract> bubbleSortContract = new BubbleSortContract<>();

    bubbleSortContract.sort(values, comparator);
  }

  @Override
  public void insertionSortBy(Comparator comparator) {
    InsertionSortContract<Contract> insertionSortContract = new InsertionSortContract<>();

    insertionSortContract.sort(values,comparator);
  }

  @Override
  public SimpleArrayContract<Contract> searchBy(Predicate<E> condition) {
    SimpleArrayContract<Contract> simpleArrayContract = new SimpleArrayContract<>();
    for(Object value : values){
      if(condition.test((E)value)){
        simpleArrayContract.add((E)value);
      }
    }
    return simpleArrayContract;
  }

  /**Функция размер списка {@link SimpleArrayContract#values}
   * @return int
   */
  @Override
  public int size() {
    return values.length;
  }

  /**Функция создает новый ArrayIterator с аргументом {@link SimpleArrayContract#values}*/
  @Override
  public Iterator<E> iterator() {
    return new ArrayIterator<>(values);
  }

  /**
   * Функция для приведения списка {@link SimpleArrayContract#values} к строке
   */
  @Override
  public String toString() {
    return Arrays.toString(values);
  }
}
