package com.nc.mihalsky.openers.creators;

public interface CreatorFromCsv<T> {
  T create(String[] values);
}
