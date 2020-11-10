package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.function.Predicate;

public class PredicateConditionClientId {
  private long clientId;

  public PredicateConditionClientId(long clientId){
    this.clientId = clientId;
  }

  public Predicate<Contract> clientIdPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getClient().getId() == clientId;
    }
  };

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }
}
