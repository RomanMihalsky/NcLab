package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import org.joda.time.LocalDate;

import java.util.function.Predicate;

public class PredicateConditionDateStartOfUse {
  private LocalDate dateStartOfUse;

  public PredicateConditionDateStartOfUse(LocalDate dateStartOfUse){
    this.dateStartOfUse = dateStartOfUse;
  }

  public Predicate<Contract> dateStartOfUsePredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getDateStartOfUse().equals(dateStartOfUse);
    }
  };

  public void setDateStartOfUse(LocalDate dateStartOfUse) {
    this.dateStartOfUse = dateStartOfUse;
  }
}
