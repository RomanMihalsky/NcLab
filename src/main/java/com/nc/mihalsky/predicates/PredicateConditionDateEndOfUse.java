package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import org.joda.time.LocalDate;

import java.util.function.Predicate;

public class PredicateConditionDateEndOfUse {
  private LocalDate dateEndOfUse;

  public PredicateConditionDateEndOfUse(LocalDate dateEndOfUse){
    this.dateEndOfUse = dateEndOfUse;
  }

  public Predicate<Contract> dateEndOfUsePredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getDateEndOfUse().equals(dateEndOfUse);
    }
  };

  public void setDateEndOfUse(LocalDate dateEndOfUse) {
    this.dateEndOfUse = dateEndOfUse;
  }
}
