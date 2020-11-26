package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;

public interface CreatorContractFromCsvI<T extends Contract> {
  T create(String[] values, Client client);
}
