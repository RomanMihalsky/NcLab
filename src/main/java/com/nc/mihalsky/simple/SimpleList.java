package com.nc.mihalsky.simple;

import java.util.Optional;

public interface SimpleList<E> extends Iterable<E>{
  boolean add(E e);
  Optional<Boolean> delete(int index);
  Optional<E> get(int index);
  Optional<Boolean> set(int index,E e);
  int size();
}
