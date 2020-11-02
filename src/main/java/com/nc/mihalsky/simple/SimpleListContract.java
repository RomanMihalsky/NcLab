package com.nc.mihalsky.simple;

import java.util.Optional;

public interface SimpleListContract<E> extends Iterable<E> {
  boolean add(E e);
  Optional<Boolean> delete(long index);
  Optional<E> get(long index);
  Optional<Boolean> set(long index,E e);
  int size();
}
