package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.function.Predicate;

public class PredicateConditionClient {
  private Client client;

  public PredicateConditionClient(Client client){
    this.client = client;
  }

  public Predicate<Contract> clientPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getClient().equals(client);
    }
  };

  public void setClient(Client client) {
    this.client = client;
  }
}
