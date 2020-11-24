package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.simple.SimpleListContract;

public interface Opener {
  SimpleListContract<Contract> readFileToSimpleList(String fileName);
}
