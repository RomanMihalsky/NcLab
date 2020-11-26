package com.nc.mihalsky.openers.creators;

public interface CreatorClientFromCsvI<T> {
  T create(String[] values);
}
