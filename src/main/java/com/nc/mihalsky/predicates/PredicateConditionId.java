package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.function.Predicate;

public class PredicateConditionId {
  private long id;

  public PredicateConditionId(long id){
    this.id = id;
  }

  public Predicate<Contract> idPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getId() == id;
    }
  };

  public void setId(long id) {
    this.id = id;
  }
}
